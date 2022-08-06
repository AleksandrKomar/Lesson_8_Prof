package hometasks.task4;

public class Main {

    static First vfirst;
    static Second mSecond;

    public static void main(String[] args) {
        System.out.println("Старт потоков...");

        vfirst = new First("Первый", 6);    //Создание потока
        vfirst.start();            //Запуск потока

        mSecond = new Second("Второй", 6);    //Создание потока
        mSecond.start();            //Запуск потока

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);        //Приостанавливает поток на 1 секунду
            } catch (InterruptedException e) {
            }

        }

        if (vfirst.isAlive()) {
            try {
                vfirst.join();    //Подождать .
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Вывод закончен!");
    }
}


class First extends Thread {
    private String name;
    private int age;

    public First(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);        //Приостанавливает поток на 1 секунду
            } catch (InterruptedException e) {
            }

            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "First{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}

class Second extends Thread {

    private String name;
    private int age;

    public Second(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "Second{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

