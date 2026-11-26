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
    private User borrower;
    private Book borrowedBook;
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
        this.borrower = user;
        this.borrowedBook = book;
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
     * 대출자 반환
     *
     * @return borrower 이 대출의 이용자
     */
    public User getBorrower()
    {
        return borrower;
    }

    /**
     * 대출된 책 반환
     *
     * @return borrowedBook 이 대출의 책
     */
    public Book getBorrowedBook()
    {
        return borrowedBook;
    }

    /**
     * User–Loan 링크 해제
     */
    public void removeBorrower()
    {
        borrower = null;
    }

    /**
     * Loan–Book 링크 해제
     */
    public void removeBorrowedBook()
    {
        borrowedBook = null;
    }

    /**
     * 대출 정보 출력
     *
     */
    public void display()
    {
        System.out.println("=== 대출 정보 ===");
        System.out.println("대출 번호: " + loanID);
        System.out.println("이용자 ID: " + borrower.getstID());
        System.out.println("대출일: " + borrowDate);
        System.out.println("반납 예정일: " + dueDate);
    }
}