package Models.Entity;


public class Book {
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private double price;

    public Book() {
    }

    public Book(String name, String author, String publisher, int year, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getYear() != book.getYear()) return false;
        if (getPages() != book.getPages()) return false;
        if (Double.compare(book.getPrice(), getPrice()) != 0) return false;
        if (!getName().equals(book.getName())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        return getPublisher().equals(book.getPublisher());
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getPublisher().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getPages();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("| %15s | %-20s | %-10s | %4d year | %4d pages. | $%8.2f |", author, name, publisher, year, pages, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
