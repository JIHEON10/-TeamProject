import java.time.*;
import java.util.*;
/**
 * 도서관관리시스템의 주요 기능을 수행
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
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
     * @param userID 사용자 ID
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
        boolean resultBook = book.isAvailable();

        // 6. 사용자 대출 가능 여부 확인
        boolean resultUser = user.canBorrow();

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

            Loan loan = new Loan("-", user, book, borrowDate, dueDate);

            // 9. 객체 정보를 화면에 출력
            loan.display();

            // 10. 대출 기록 저장
            loanDB.save(loan);

            // 11. 도서와 사용자 상태 갱신
            book.markAsBorrowed();
            user.increaseLoanCount();
        }
    }

    /**
     * Use Case 2: RegisterNewBorrower
     *
     * @param userID 등록할 사용자 ID
     * @param name 등록할 사용자 이름
     */
    public void registerNewBorrower(String stID, String name)
    {
        // 1. 기존 이용자 검색
        User user = userDB.search(stID);

        // 2. 등록 여부에 따른 조건 분기
        if (user != null)
        {
            System.out.println("이미 등록된 이용자입니다!");
        }
        else
        {
            // 3. 신규 이용자 객체 생성 및 정보 설정
            user = new User(stID, name);

            // 4. 이용자 정보 저장
            userDB.update(user);

            // 5. 객체 정보를 화면에 출력
            user.display();

            // 6. 등록 완료 메시지
            System.out.println("이용자 등록 완료!");
        }
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

        // 2. 등록 여부에 따른 조건 분기
        if (book != null)
        {
            System.out.println("이미 등록된 책입니다!");
        }
        else
        {
            // 3. 신규 도서 객체 생성 및 정보 설정
            book = new Book(bookID, title, author);

            // 4. 도서 정보 저장
            bookDB.update(book);

            // 5. 객체 정보를 화면에 출력
            book.display();

            // 6. 등록 완료 메시지
            System.out.println("도서 등록 완료!");
        }
    }

}