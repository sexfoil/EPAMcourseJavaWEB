package Models.Entity;

import java.io.Serializable;

/**
 * This class represents entity of book.
 *
 * @author Slava Poliakov
 * @version 1.0
 *
 */
public class Book implements Serializable {
    /**
     * Name of book.
     */
    private String name;
    /**
     * Name of book.
     */
    private String author;
    /**
     * Name of book.
     */
    private String publisher;
    /**
     * Name of book.
     */
    private int year;
    /**
     * Name of book.
     */
    private int pages;
    /**
     * Name of book.
     */
    private double price;


    /**
     * Default constructor.
     */
    public Book() {
    }

    /**
     * Constructs book with initial parameters.
     *
     * @param name initial name of book
     * @param author initial author of book
     * @param publisher initial publisher of book
     * @param year initial year of publication of book
     * @param pages initial amount of pages of book
     * @param price initial price of book
     */
    public Book(String name, String author, String publisher, int year, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }


    /**
     * Indicates whether some other toy is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
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

    /**
     * Returns a hash code value for the toy.
     *
     * @return a hash code value for this object.
     */
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

    /**
     * Returns a string representation of the book. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this book.
     * <p>
     * The {@code toString} method for class {@code Book}
     * returns a string consisting of the name, author, publisher, year of publication,
     * amount of pages and price of book
     *
     * @return a string representation of the toy.
     */
    @Override
    public String toString() {
        return String.format("| %15s | %-20s | %-10s | %4d year | %4d pages. | $%8.2f |",
                author, name, publisher, year, pages, price);
    }

    /**
     * Returns name of book.
     *
     * @return name of book
     */
    public String getName() {
        return name;
    }

    /**
     * Set name to book.
     *
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns author of book.
     *
     * @return author of book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author to book.
     *
     * @param author author to be set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns publisher of book.
     *
     * @return publisher of book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Set publisher to book.
     *
     * @param publisher publisher to be set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Returns year of book.
     *
     * @return year of book
     */
    public int getYear() {
        return year;
    }

    /**
     * Set year to book.
     *
     * @param year year to be set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns pages of book.
     *
     * @return pages of book
     */
    public int getPages() {
        return pages;
    }

    /**
     * Set pages to book.
     *
     * @param pages pages to be set
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Returns price of book.
     *
     * @return price of book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price to book.
     *
     * @param price price to be set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
