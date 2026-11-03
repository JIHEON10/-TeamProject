import java.util.*;
/**
 * Book 데이터베이스 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */

public class BookDB
{
    private ArrayList<Book> books;

    /**
     * bookDB 객체 생성
     */
    public BookDB()
    {
        books = new ArrayList<>();
    }

    /**
     * bookID를 이용해 사용자를 검색
     *
     * @param bookID 검색할 이용자의 bookID
     * @return 검색된 bookID
     */
    public Book search(String bookID)
    {
        for (Book book : books)
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
     */        
    public void update(Book book)
    {
        books.add(book);
    }

}