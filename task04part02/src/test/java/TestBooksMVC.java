import static org.junit.Assert.*;

import Models.BooksSet;
import Models.Entity.Book;
import Utility.Tools;
import org.junit.Before;
import org.junit.Test;


public class TestBooksMVC {
    BooksSet model;
    Tools tools;

    @Before
    public void initialized() {
        model = new BooksSet();
        tools = new Tools(model);
        createTestData();
    }

    @Test
    public void testSearchingByAuthor(){
        Book[] expected = new Book[] {model.getBooks()[4], model.getBooks()[5]};
        assertArrayEquals(expected, tools.searchByAuthor("author3"));
        assertEquals(2, tools.searchByAuthor("author2").length);
        assertEquals(0, tools.searchByAuthor("unknown").length);
    }

    @Test
    public void testSearchingByPublisher(){
        Book[] expected = new Book[] {model.getBooks()[1], model.getBooks()[4], model.getBooks()[7]};
        assertArrayEquals(expected, tools.searchByPublisher("publisher2"));
        assertEquals(4, tools.searchByPublisher("publisher1").length);
        assertEquals(0, tools.searchByPublisher("unknown").length);
    }

    @Test
    public void testSearchingByYear(){
        Book[] expected = new Book[] {model.getBooks()[7], model.getBooks()[8], model.getBooks()[9]};
        assertArrayEquals(expected, tools.searchByYear(2007));
        assertEquals(7, tools.searchByYear(2003).length);
        assertEquals(0, tools.searchByYear(2019).length);

    }

    @Test
    public void testSortingByPublisher(){
        Book[] expected = new Book[] {model.getBooks()[0],
                model.getBooks()[3], model.getBooks()[6], model.getBooks()[9],
                model.getBooks()[1], model.getBooks()[4], model.getBooks()[7],
                model.getBooks()[2], model.getBooks()[5], model.getBooks()[8]};
        assertArrayEquals(expected, tools.sortByPublisher());
    }

    private void createTestData() {
        model.setBooks(new Book[] {
                new Book("name0", "author1", "publisher1", 2000, 100, 10.0),
                new Book("name1", "author1", "publisher2", 2001, 200, 20.0),
                new Book("name2", "author2", "publisher3", 2002, 300, 30.0),
                new Book("name3", "author2", "publisher1", 2003, 400, 40.0),
                new Book("name4", "author3", "publisher2", 2004, 500, 10.0),
                new Book("name5", "author3", "publisher3", 2005, 600, 20.0),
                new Book("name6", "author4", "publisher1", 2006, 500, 30.0),
                new Book("name7", "author4", "publisher2", 2007, 400, 40.0),
                new Book("name8", "author5", "publisher3", 2008, 300, 50.0),
                new Book("name9", "author5", "publisher1", 2009, 200, 50.0)
        });
    }
}
