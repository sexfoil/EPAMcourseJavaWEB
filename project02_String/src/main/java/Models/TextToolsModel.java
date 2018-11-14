package Models;

import java.util.ArrayList;
import java.util.List;

public class TextToolsModel {

    private List<String> textLines;

    public TextToolsModel() {
        this(new ArrayList<String>());
    }

    public TextToolsModel(List<String> textLines) {
        this.textLines = textLines;
    }

    public List<String> getTextLines() {
        return textLines;
    }

    public void setTextLines(List<String> textLines) {
        this.textLines = textLines;
    }
}
