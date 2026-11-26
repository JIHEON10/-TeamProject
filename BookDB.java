import java.util.*;
/**
 * Book 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.26)
 */

public class BookDB
{
    private TreeSet<Book> bookDB;
    private boolean updateResult;

    /**
     * bookDB 객체 생성
     */
    public BookDB()
    {
        bookDB = new TreeSet<>();
        updateResult = false;
    }

    /**
     * bookID를 이용해 책 검색
     *
     * @param bookID 검색할 이용자의 bookID
     * @return 검색된 bookID
     */
    public Book search(String bookID)
    {
        for (Book book : bookDB)
        {
            if (book.getBookID().equals(bookID))
            {
                return book;
            }
        }
        return null;
    }

    /**
     * 새 책 bookDB에 등록
     *
     * @param book 등록할 책
     * @return 등록 성공 시 true, 실패 시 false
     */
    public boolean update(Book book)
    {
        if (book == null)
        {
            updateResult = false;
        }
        else
        {
            updateResult = bookDB.add(book);   // 중복 시 false
        }
        return updateResult;
    }

    /**
     * 마지막 책 저장 결과 반환
     *
     * @return 마지막 update() 성공 시 true, 실패 시 false
     */
    public boolean bookUpdateResult()
    {
        return updateResult;
    }
}