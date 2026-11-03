import java.util.*;
/**
 * Loan 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */

public class LoanDB
{
    private HashMap<String, Loan> loans;

    /**
     * 새 대출 기록 저장
     *
     * @param loan 저장할 대출 객체
     */
    public void save(Loan loan)
    {
        loans.put(loan.getLoanID(), loan);
    }

    /**
     * 대출 정보 출력
     *
     * @param loan 대출 정보
     */
    public void display(Loan loan)
    {
        System.out.println("대출 객체 정보 출력");
    }
}