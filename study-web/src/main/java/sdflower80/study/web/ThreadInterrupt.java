package sdflower80.study.web;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(taskThatFinishesEarlyOnInterruption());
        taskThread.start();      // requirement 3
        Thread.sleep(3_000);     // requirement 4
        taskThread.interrupt();  // requirement 5
        taskThread.join(1_000);  // requirement 6
    }
    private static Runnable taskThatFinishesEarlyOnInterruption() {
        return () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + "=>" + Thread.interrupted());      // requirement 1
                try {
                    Thread.sleep(2_000);  // requirement 2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;                // requirement 7
                }
            }
        };
    }
}
