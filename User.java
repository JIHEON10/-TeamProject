
/**
 * User 정보 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.26)
 */
public class User
{
    private String stID;
    private String name;

    /**
     * User 객체 생성
     *
     * @param stID 이용자 학번
     * @param name 이용자 이름
     */
    public User(String stID, String name)
    {
        this.stID = stID;
        this.name = name;
    }

    /**
     * 이용자 학번 반환
     *
     * @return stID 이용자 학번
     */
    public String getstID()
    {
        return stID;
    }

    /**
     * 이용자 정보 출력
     */
    public void display()
    {
        System.out.println("=== 이용자 정보 ===");
        System.out.println("학번: " + stID);
        System.out.println("이름: " + name);
    }
}