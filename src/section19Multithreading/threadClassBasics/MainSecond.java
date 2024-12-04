package section19Multithreading.threadClassBasics;

class MyThread2 extends Thread {

    @Override
    public void run() {
        int count = 1;

        while (count < Integer.MAX_VALUE) {
            System.out.println("count: " + count + ", entered");

            count++;

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}

public class MainSecond {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.setDaemon(true);

        myThread2.start();

        Thread mainThread = Thread.currentThread();
        System.out.println("mainThread.getName(): " + mainThread.getName());

        try {
            mainThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
