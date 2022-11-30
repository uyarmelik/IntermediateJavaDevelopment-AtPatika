import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<IBook> booksByName = new TreeSet<>();

        booksByName.add(new IBook("Simyacı",184,"Paulo Coelho",1988));
        booksByName.add(new IBook("Gece Yarısı Kütüphanesi",283,"Matt Haig",2020));
        booksByName.add(new IBook("Zahir",320,"Paulo Coelho",2005));
        booksByName.add(new IBook("Bir Mûsikî Alpereni Yusuf Ömürlü", 416, "İbrahim Melik Uyar", 2022));
        booksByName.add(new IBook("Günden Kalanlar", 208, "Kazuo Ishiguro", 1989));

        printBookHeader();
        for(IBook b: booksByName){
            b.printBookData();
        }

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------\n");

        TreeSet<IBook> booksByPageNumber = new TreeSet<>(Comparator.comparingInt(IBook::getPageNumber));

        booksByPageNumber.add(new IBook("Simyacı",184,"Paulo Coelho",1988));
        booksByPageNumber.add(new IBook("Gece Yarısı Kütüphanesi",283,"Matt Haig",2020));
        booksByPageNumber.add(new IBook("Zahir",320,"Paulo Coelho",2005));
        booksByPageNumber.add(new IBook("Bir Mûsikî Alpereni Yusuf Ömürlü", 416, "İbrahim Melik Uyar", 2022));
        booksByPageNumber.add(new IBook("Günden Kalanlar", 208, "Kazuo Ishiguro", 1989));

        printBookHeader();
        for(IBook b: booksByPageNumber){
            b.printBookData();
        }

    }

    public static void printBookHeader(){
        System.out.println(String.format(
                "%37s %2s %16s %2s %23s %2s %17s",
                "Book Name", "|",
                "Page Number", "|",
                "Author Name", "|",
                "Relase Date"
        ));
        System.out.println();
    }


}