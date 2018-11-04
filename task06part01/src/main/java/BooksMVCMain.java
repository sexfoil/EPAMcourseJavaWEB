
import Controllers.BooksController;

/**
 * Main class of program.
 * Creates and starts {@code BooksController} to launch program working.
 *
 * @author Slava Poliakov
 * @version 1.0
 */
public class BooksMVCMain {
    public static void main(String[] args) {
        new BooksController().run();
    }
}
