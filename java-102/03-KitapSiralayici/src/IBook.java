import java.util.TreeSet;

public class IBook implements Comparable<IBook>  {
    private String bookName;
    private int pageNumber;
    private String authorName;
    private int relaseDate;

    public IBook(String bookName, int pageNumber, String authorName, int relaseDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.relaseDate = relaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }


    public String getAuthorName() {
        return authorName;
    }

    public int getRelaseDate() {
        return relaseDate;
    }

    @Override
    public int compareTo(IBook o) {
        return getBookName().compareTo(o.getBookName());
    }

    public void printBookData(){
        System.out.println(String.format(
                "%37s %2s %16s %2s %23s %2s %17s",
                getBookName(), "|",
                getPageNumber(), "|",
                getAuthorName(), "|",
                getRelaseDate()
        ));
    }

}