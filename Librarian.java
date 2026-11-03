
/**
 * 사서 입력부
 *
 * @author (2022320010 임연택)
 * @version (2026.11.02)
 */
public class Librarian
{
    private String name;
    private String librarianID;
    private NewLibMS system;

    public Librarian(String name, NewLibMS system)
    {
        this.name = name;
        this.librarianID = librarianID;
        this.system = system;
    }

    public void registerNewBorrower(String stID, String userName)
    {
        system.registerNewBorrower(stID, userName);
    }

    public void registerNewBook(String bookID, String title, String author)
    {
        system.registerNewBook(bookID, title, author);
    }

    public void receiveRequest(String bookID, String stID)
    {
        system.borrowBook(bookID, stID);
    }

    public void deliverDueDateInfo(Loan loan)
    {
        System.out.println("반납 예정일: " + loan.getDueDate());
    }
}