
import Controllers.ToysController;

/**
 * Playroom main class.
 *
 * @author Slava Poliakov
 * @version 1.0
 *
 * @see ToysController
 */
public class ToysMVCMain {

    /**
     * Starts the program, create {@code ToysController} and launch its run method.
     *
     * @param args no params requirements
     */
    public static void main(String[] args) {
        new ToysController().run();
    }
}
