import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookCreator {
    static ArrayList<Book> bookList = new ArrayList<>();
    static Map<String, String> bookMap = new HashMap<>();

    static{
        bookList.add(new Book("Alpine Willow", "Fina MacDuff", 654, 1986));
        bookList.add(new Book("Shrubby Toothedthread", "Vaughn Licciardiello", 352, 2017));
        bookList.add(new Book("Oriental Poppy", "Frederique Locksley", 198, 1980));
        bookList.add(new Book("Fullstem", "Cathi Demetr", 522, 1972));
        bookList.add(new Book("Desert Almond", "Torry Tregoning", 88, 2001));
        bookList.add(new Book("Alpine Snow Lichen", "Phillida Pywell", 416, 2020));
        bookList.add(new Book("Zarzabacoa De Monte", "Stu Noddle", 98, 2017));
        bookList.add(new Book("Jones' Lupine", "Phillida Pywell", 56, 2003));
        bookList.add(new Book("Onosma", "Gracia Robertot", 144, 1962));
        bookList.add(new Book("Arctic Brome", "Fina MacDuff", 500, 1999));
    }
    
}