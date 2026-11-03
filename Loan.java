import java.time.*;
/**
 * 대출 정보 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */

public class Loan
{
    private String loanID;
    private User user;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    /**
     * Loan 객체 생성
     *
     * @param Loan 고유 ID
     * @param User 객체
     * @param Book 객체
     * @param borrowDate 책 대출일
     * @param dueDate 책 반납 예정일
     */
    public Loan(String loanID, User user, Book book,
    LocalDate borrowDate, LocalDate dueDate)
    {
        this.loanID = loanID;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    /**
     * 대출 고유 ID 반환
     *
     * @return 대출 고유 ID
     */
    public String getLoanID()
    {
        return loanID;
    }

    /**
     * 책 대출한 User 반환
     *
     * @return 책 대출한 User 객체
     */
    public User getUser()
    {
        return user;
    }

    /**
     * 대출된 책 객체 반환
     *
     * @return 대출된 책 객체
     */
    public Book getBook()
    {
        return book;
    }

    /**
     * 도서 대출일 반납
     *
     * @return 도서 대출일
     */
    public LocalDate getBorrowDate()
    {
        return borrowDate;
    }

    /**
     * 도서 반납일 반환
     *
     * @return 도서 반납일
     */
    public LocalDate getDueDate()
    {
        return dueDate;
    }
    
        /**
     * 대출 정보 출력
     *
     */
    public void display()
    {
        System.out.println("대출 객체 정보 출력");
    }
}