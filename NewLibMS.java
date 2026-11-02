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
    private String name;
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
        this.name = name;
        this.userDB = new UserDB();
        this.bookDB = new BookDB();
        this.loanDB = new LoanDB();
    }

    /**
     * Use Case 1: RegisterNewBorrower
     *
     * @param userID 등록할 사용자의 id
     * @param name 등록할 사용자의 이름
     * @return 등록된 사용자
     */
    public User registerNewBorrower(String stID, String name)
    {
        User user = new User(stID, name);
        userDB.update(user);
        return user;
    }

    /**
     * Use Case 2: RegisterNewBook
     *
     * @param bookID 등록할 책 id
     * @param title 등록할 책 제목
     * @param author 등록할 책 저자
     * @return 등록된 책
     */
    public Book registerNewBook(String bookID, String title, String author)
    {
        Book book = new Book(bookID, title, author);
        bookDB.update(book);
        return book;
    }

    /**
     * Use Case 3: BorrowBook
     *
     * @param bookID 책 ID
     * @param userID 사용자 ID
     * @return 대출 객체
     */
    public Loan borrowBook(String bookID, String stID)
    {
        // 1. 사용자 검색
        User user = userDB.search(stID);
    
        // 2. 책 검색
        Book book = bookDB.search(bookID);

        // 3. 대출 기록 생성
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);

        Loan loan = new Loan("-",user,book,borrowDate,dueDate);

        // 4. 대출 기록 저장
        loanDB.save(loan);

        // 5. 도서와 사용자 상태 갱신
        book.markAsBorrowed();
        user.increaseLoanCount();

        return loan;
    }

}