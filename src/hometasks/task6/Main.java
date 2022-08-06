package hometasks.task6;

public class Main {

    public static void main(String[] args) {

        MyThreadOne t1 = new MyThreadOne();
        MyThreadTwo t2 = new MyThreadTwo();

        t1.setThread2(t2);
        t2.setThread1(t1);

        t1.start();
        t2.start();

    }

}

class MyThreadOne extends Thread {

    private Thread t1;

    MyThreadOne() {
        System.out.println("MyThreadOne создан");
    }

    public void setThread2(Thread t) {
        this.t1 = t;
    }

    @Override
    public void run() {
        System.out.println("MyThreadOne запущен");

        try {
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("MyThreadOne прерывает MyThreadTwo для завершения…");

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThreadOne остановлен");
    }
}

class MyThreadTwo extends Thread {

    private Thread t2;

    MyThreadTwo() {
        System.out.println("MyThreadTwo создан");
    }

    public void setThread1(Thread t) {
        this.t2 = t;
    }

    @Override
    public void run() {
        System.out.println("MyThreadTwo запущен");

        System.out.println("MyThreadTwo прерывает MyThreadOne для завершения…");

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThreadTwo остановлен");
    }
}