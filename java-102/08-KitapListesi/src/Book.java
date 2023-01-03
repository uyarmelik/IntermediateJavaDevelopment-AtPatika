public class Book {

    private String bookName;
    private String authorName;
    private int pageNumber;
    private int relaseDate;

    public Book(String bookName, String authorName, int pageNumber, int relaseDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.relaseDate = relaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(int relaseDate) {
        this.relaseDate = relaseDate;
    }
}
