import java.util.*;
/**
 * User 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */

public class UserDB
{
    private ArrayList<User> users;

    /**
     * UserDB 객체 생성
     *
     */
    public UserDB()
    {
        users = new ArrayList<>();
    }

    /**
     * userID를 이용해 사용자를 검색
     *
     * @param userID 검색할 이용자의 userID
     * @return 검색된 userID
     */
    public User search(String userID)
    {
        for (User user : users)
        {
            if (user.getstID().equals(userID))
            {
                return user;
            }
        }
        return null;
    }

    /**
     * 새 대출자 userDB에 등록
     *
     * @param user 등록할 이용자
     */
    public void update(User user)
    {
        users.add(user);
    }

    /**
     * 이용자 정보 출력
     *
     * @param user 이용자 정보
     */
    public void display(User user)
    {
        System.out.println("이용자 객체 정보 출력");
    }

}