import Controllers.TextToolsController;

public class TextToolsMain {

    public static void main(String[] args) {

        String t = "asd2--as3---as4----as5-----as6------as7-------as8--------as9---------as------------------";
        t = t.replace("---", "-");
        System.out.println(t);
        t = t.replace("---", "-");
        System.out.println(t);
        t = t.replace("--", "-");
        System.out.println(t);
        //new TextToolsController().run();
    }
}
