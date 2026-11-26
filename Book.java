
/**
 * Book 정보 관리 클래스
 *
 * @author (2022320010 임연택)
 * @version (2026.11.26)
 */
public class Book implements Comparable<Book>
{
    private String bookID;
    private String title;
    private String author;

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
     * TreeSet 정렬 및 중복 판단 기준 (bookID 순)
     *
     * @param other
     * @return bookID가 앞서면 -, 같으면 0, 뒤면 +
     */
    public int compareTo(Book other)
    {
        return this.bookID.compareTo(other.bookID);
    }

    /**
     * 책 정보 출력
     *
     */
    public void display()
    {
        System.out.println("=== 도서 정보 ===");
        System.out.println("도서 ID(ISBN): " + bookID);
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
    }
}
