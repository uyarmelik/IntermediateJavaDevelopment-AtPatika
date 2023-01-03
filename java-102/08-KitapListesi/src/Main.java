public class Main {
    public static void main(String[] args) {

        BookCreator.bookList.forEach(b -> BookCreator.bookMap.put(b.getBookName(),b.getAuthorName()));

        System.out.printf("\n%-30s %-30s", "Book Name:", "Author Name:");
        BookCreator.bookMap.forEach((b1, b2) -> System.out.printf("\n%-30s %-30s", b1, b2));

        System.out.println("\n\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        System.out.println("\nFILTERED LIST");
        System.out.printf("\n%-30s %-30s", "Book Name:", "Author Name:");
        BookCreator.bookList.stream().filter(b -> b.getPageNumber()>100).forEach(b -> System.out.printf("\n%-30s %-30s", b.getBookName(), b.getAuthorName()));
    }
}