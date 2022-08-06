package hometasks.task2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        for (int i = 1; i < 4; i++)
            new MThread("MThread " + i).start();
        System.out.println("Main thread finished...");

    }

}

class MThread extends Thread {

    MThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}