package Utility;

import Views.BooksView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private static final String BASE_DIRECTORY = "src/main/resources/";
    private Path pathToFile;
    private BooksView view;
    private List<String> booksData;

    public FileManager(BooksView view) {
        this.view = view;
    }

    public List<String> getDataFromTextFile(String path) {

        pathToFile = Paths.get(BASE_DIRECTORY + path);

        if (Files.exists(pathToFile)) {
            try {
                booksData = Files.readAllLines(pathToFile);
                return booksData;
            } catch (IOException e) {
                e.printStackTrace();
                view.printMessage("Can't read data from file: " + pathToFile.getFileName());
            }
        } else {
            view.printMessage("File not found! Wrong path or filename.");
        }
        return null;
    }

    public boolean saveDataToTextFile(String path, List<String> booksData) {

        pathToFile = Paths.get(BASE_DIRECTORY + path);

        boolean success = false;
        if (!Files.exists(pathToFile)) {
            Path directory = pathToFile.getParent();
            if (!Files.exists(directory)) {
                try {
                    Files.createDirectories(directory);
                    try (BufferedWriter writer = Files.newBufferedWriter(pathToFile, Charset.forName("UTF-8"))) {
                        for (String bookStr : booksData) {
                            writer.write(bookStr);
                            success = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        view.printMessage("Can't write data to file: " + pathToFile.getFileName());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    view.printMessage("Can't create directory: " + directory);
                }
            }
        } else {
            view.printMessage("File with such name is already exists!");
        }
        return success;
    }
}
