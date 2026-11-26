import java.util.*;
/**
 * User 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.26)
 */

public class UserDB
{
    private ArrayList<User> userDB;

    /**
     * UserDB 객체 생성
     *
     */
    public UserDB()
    {
        userDB = new ArrayList<>();
    }

    /**
     * stID를 이용해 이용자를 검색
     *
     * @param stID 검색할 이용자의 학번
     * @return 검색된 이용자(User), 없으면 null
     */
    public User search(String stID)
    {
        for (User user : userDB)
        {
            if (user.getstID().equals(stID))
            {
                return user;
            }
        }
        return null;
    }

    /**
     * 새 대출자를 userDB에 등록
     *
     * @param user 등록할 이용자
     * @return 등록 성공 시 true, 실패 시 false
     */
    public boolean update(User user)
    {
        if (user == null)
        {
            return false;
        }

        return userDB.add(user);
    }

}