import java.time.*;
import java.util.*;
/**
 * 도서관관리시스템의 주요 기능을 수행
 *
 * @author (2022320010 임연택)
 * @version (2026.11.26)
 */

public class NewLibMS
{
    private String libname;
    private UserDB userDB;
    private BookDB bookDB;
    private LoanDB loanDB;

    /**
     * 사용자, 도서, 대출 DB 초기화
     *
     * @param name 도서관관리시스템 이름
     */
    public NewLibMS(String name)
    {
        this.libname = name;
        this.userDB = new UserDB();
        this.bookDB = new BookDB();
        this.loanDB = new LoanDB();
    }

    /**
     * Use Case 1: BorrowBook, 책 빌리는 작업 수행
     *
     * @param bookID 책 ID
     * @param stID 사용자 ID
     */
    public void borrowBook(String bookID, String stID)
    {
        // 1. 책 검색
        Book book = bookDB.search(bookID);

        // 2. 사용자 검색
        User user = userDB.search(stID);

        // 3. 사용자가 등록되어 있는지 확인
        if (user != null)
        {
            user.display();
        }
        else
        {
            System.out.println("이용자를 찾을 수 없음!");
        }

        // 4. 책이 등록되어 있는지 확인
        if (book != null)
        {
            book.display();
        }
        else
        {
            System.out.println("책을 찾을 수 없음!");
        }

        // 5. 책의 대출 가능 여부 확인
        boolean resultBook = (loanDB.findLoan(book) == null);

        // 6. 사용자 대출 가능 여부 확인
        boolean resultUser = (loanDB.countLoan(user) < 3);

        // 7. 대출 가능 여부에 따른 조건 분기
        if (!resultBook && !resultUser)
        {
            System.out.println("책 대출 불가능! & 이용자 대출 불가능!");
        }
        else if (resultBook && !resultUser)
        {
            System.out.println("책 대출 가능! & 이용자 대출 불가능!");
        }
        else if (!resultBook && resultUser)
        {
            System.out.println("책 대출 불가능! & 이용자 대출 가능!");
        }
        else
        {
            // 8. 대출 객체 생성
            LocalDate borrowDate = LocalDate.now();
            LocalDate dueDate = borrowDate.plusDays(14);

            Loan loan = new Loan(bookID + "-" + stID, user, book, borrowDate, dueDate);

            // 9. 객체 정보를 화면에 출력
            loan.display();

            // 10. 대출 기록 저장
            loanDB.save(loan);
        }
    }

    /**
     * Use Case 2: RegisterNewBorrower
     *
     * @param stID 등록할 이용자 학번
     * @param name 등록할 이용자 이름
     */
    public void registerNewBorrower(String stID, String name)
    {
        // 1. 기존 이용자 검색
        User user = userDB.search(stID);

        // 2. [user != null]
        if (user != null)
        {
            System.out.println("이미 등록된 이용자입니다!");
            return;
        }

        // [user == null]
        // 3. 신규 이용자 객체 생성
        user = new User(stID, name);

        // 4. 이용자 정보 저장
        boolean userUpdateResult = userDB.update(user);

        // 5. 저장된 stID와 name을 화면에 출력
        user.display();

        // 6. 저장 결과에 따른 조건 분기
        if (userUpdateResult == false)
        {
            // [userUpdateResult == false]
            System.out.println("등록 실패!");
            return;
        }

        // [userUpdateResult == true]
        System.out.println("이용자 등록 완료!");
    }

    /**
     * Use Case 3: RegisterNewBook
     *
     * @param bookID 등록할 책 ID
     * @param title 등록할 책 제목
     * @param author 등록할 책 저자
     */
    public void registerNewBook(String bookID, String title, String author)
    {
        // 1. 기존 도서 검색
        Book book = bookDB.search(bookID);

        if (book != null)
        {
            System.out.println("이미 등록된 책입니다!");
            return;
        }

        // 2. 신규 도서 객체 생성
        book = new Book(bookID,title,author);

        // 3. 도서 정보 저장
        bookDB.update(book);

        // 4. 도서 정보 출력
        book.display();

        // 5. 저장 결과 확인
        boolean bookUpdateResult = bookDB.bookUpdateResult();

        // 6. 저장 결과에 따른 조건 분기
        if (bookUpdateResult == false)
        {
            // [bookUpdateResult == false]
            System.out.println("등록 실패!");
            return;
        }

        // [bookUpdateResult == true]
        System.out.println("도서 등록 완료!");
    }

    /**
     * Use Case 4: ReturnBook
     *
     * @param bookID 반납할 책 ID (ISBN)
     */
    public void returnBook(String bookID)
    {
        // 1. 반납할 책 검색
        Book book = bookDB.search(bookID);
        if (book == null)
        {
            System.out.println("등록되지 않은 책입니다!");
            return;
        }

        // 2. 책에 연결된 대출 정보 검색
        Loan loan = loanDB.findLoan(book);

        // 3. [loan == null]
        if (loan == null)
        {
            System.out.println("대출 중인 책이 아닙니다!");
            return;
        }

        // [loan != null]
        // 4. 대출자 확인
        User user = loan.getBorrower();

        // 5. 대출 정보와 이용자 정보 출력
        loan.display();
        user.display();

        // 6. 링크 해제 1 : User–Loan
        loan.removeBorrower();

        // 7. 링크 해제 2 : Loan–Book
        loan.removeBorrowedBook();

        // 8. LoanDB에서 대출 정보 삭제
        loanDB.removeLoan(loan);

        // 9. 삭제 결과 확인
        boolean returnResult = loanDB.returnResult();

        if (returnResult == false)
        {
            // [returnResult == false]
            System.out.println("반납 실패!");
            return;
        }

        // 10. 반납된 책 정보 출력 및 완료 메시지
        book.display();
        System.out.println("반납 완료!");
    }
}