
/**
 * User 정보 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */
public class User
{
    private String stID;
    private String name;
    private int resultUser;

    /**
     * User 객체 생성
     *
     * @param stID 이용자 고유 ID
     * @param name 이용자 이름
     */
    public User(String stID, String name)
    {
        this.stID = stID;
        this.name = name;
        this.resultUser = 0;
    }

    /**
     * User가 도서를 더 대출할 수 있는지 확인(상한 3)
     *
     * @return 대출가능:True, 불가능:False
     */
    public boolean canBorrow()
    {
        return resultUser <= 3;
    }

    /**
     * 대출 건수 1 증가시키는 메소드
     *
     */
    public void increaseLoanCount()
    {
        if (canBorrow())
        {
            resultUser++;
        }
        else
        {
            System.out.println("최대 3권까지만 대출할 수 있습니다.");
        }
    }

    /**
     * User 고유 ID 반환
     *
     * @return stID 이용자 고유 ID
     */
    public String getstID()
    {
        return stID;
    }

    /**
     * User 고유 Name 반환
     *
     * @return name 이용자 고유 이름
     */
    public String getName()
    {
        return name;
    }

    /**
     * User 현재 대출 건수 반환
     *
     * @return User 현재 대출 건수
     */
    public int getresultUser()
    {
        return resultUser;
    }

}