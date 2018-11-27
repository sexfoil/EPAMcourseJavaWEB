package part02;

public class RunnerPart2 implements Runnable {

    private int value = 0;
    private boolean isStart = false;

    @Override
    public void run() {

        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                //if (isStart) {
                //    notify();
                //}
                isStart = true;
                value++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {

                System.out.println(value);
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                notify();


            }
        }).start();
    }
}
