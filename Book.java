
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
    private boolean resultBook;

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
        this.resultBook = true;
    }

    /**
     * 책 대출 가능 여부 확인
     *
     * @return 대출가능:True, 불가능:False
     */
    public boolean isAvailable()
    {
        return resultBook;
    }

    /**
     * Book 상태를 대출중으로 변경
     *
     */
    public void markAsBorrowed()
    {
        if (isAvailable())
        {
            resultBook = false;
        }
        else
        {
            System.out.println("이미 대출중인 도서입니다.");
        }
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
     * 책 정보 출력
     *
     */
    public void display()
    {
        System.out.println("책 객체 정보 출력");
    }
}
