import java.util.*;
/**
 * Loan 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */

public class LoanDB
{
    private ArrayList<Loan> loanDB;
    private boolean removeResult;

    /**
     * loanDB 객체 생성
     */
    public LoanDB()
    {
        loanDB = new ArrayList<>();
    }

    /**
     * 새 대출 기록 저장
     *
     * @param loan 저장할 대출 객체
     */
    public void save(Loan loan)
    {
        loanDB.add(loan);
    }

    /**
     * 책에 연결된 대출 정보 검색
     *
     * @param book 검색할 책
     * @return 해당 책의 대출 정보, 없으면 null
     */
    public Loan findLoan(Book book)
    {
        if (book == null)
        {
            return null;
        }

        for (Loan loan : loanDB)
        {
            Book borrowedBook = loan.getBorrowedBook();
            if (borrowedBook != null && borrowedBook.getBookID().equals(book.getBookID()))
            {
                return loan;
            }
        }
        return null;
    }

    /**
     * 이용자가 현재 대출 중인 책 권수
     *
     * @param user 확인할 이용자
     * @return 대출 중인 권수
     */
    public int countLoan(User user)
    {
        int count = 0;
        for (Loan loan : loanDB)
        {
            User borrower = loan.getBorrower();
            if (borrower != null && borrower.getstID().equals(user.getstID()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * 대출 정보 삭제
     *
     * @param loan 삭제할 대출 객체
     */
    public void removeLoan(Loan loan)
    {
        if (loan == null)
        {
            removeResult = false;
        }
        else
        {
            removeResult = loanDB.remove(loan);
        }
    }

    /**
     * 마지막 대출 삭제 결과 반환
     *
     * @return 삭제 성공 시 true, 실패 시 false
     */
    public boolean returnResult()
    {
        return removeResult;
    }
}