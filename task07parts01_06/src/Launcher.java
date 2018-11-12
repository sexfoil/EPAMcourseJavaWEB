import p01reflection1.Part01Runner;
import p02reflection2.Part02Runner;
import p03lambda1.Part03Runner;
import p04lambda2.Part04Runner;
import p05lambdaAndFunc.Part05Runner;
import p06streams.Part06Runner;
import utility.UserInterface;

public class Launcher {

    public void start() {
        application:
        while (true) {
            System.out.println(UserInterface.MENU);
            int command = UserInterface.inputCommand();
            switch (command) {
                case 1:
                    new Part01Runner().run();
                    break;
                case 2:
                    new Part02Runner().run();
                    break;
                case 3:
                    new Part03Runner().run();
                    break;
                case 4:
                    new Part04Runner().run();
                    break;
                case 5:
                    new Part05Runner().run();
                    break;
                case 6:
                    new Part06Runner().run();
                    break;
                case 0:
                    break application;
            }
        }
    }
}
