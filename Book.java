
/**
 * Book 정보 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */
public class Book
{
    private String bookID;
    private String title;
    private String author;
    private boolean IsAvailable;

    /**
     * Book 객체 생성
     *
     * @param bookID 책 고유 ID
     * @param title 책 제목
     * @param author 책 저자
     */
    public Book(String bookID, String title, String author)
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.IsAvailable = true;
    }
    
    //검토 필요, 클래스 다이어그램에는 없는 메소드인데 구현을 위해 일단 생성
    public boolean isAvailable()
    {
        return IsAvailable;
    }

    /**
     * Book 상태를 대출중으로 변경
     *
     */
    public void markAsBorrowed()
    {
        //book 상태를 대출중으로 변경하는 메소드, isAvailable 사용해야 할듯
    }

    /**
     * Book 고유 ID 반환
     *
     * @return bookID 책 고유 ID
     */
    public String getBookID()
    {
        return bookID;
    }

    /**
     * Book 제목 반환
     *
     * @return title 책 제목
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Book 저자 반환
     *
     * @return author 책 저자
     */
    public String getAuthor()
    {
        return author;
    }
}
