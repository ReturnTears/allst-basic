package com.allst.basic.thread;

/**
 * 同步方法解决线程安全问题
 *
 * @author YiYa
 * @since 2020-03-21 下午 11:25
 */
public class Wind3 {

    public static void main(String[] args) {
        Winds3 w3 = new Winds3();

        Thread t1 = new Thread(w3);
        Thread t2 = new Thread(w3);
        Thread t3 = new Thread(w3);

        t1.setName("窗口1");
        t1.setName("窗口2");
        t1.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Winds3 implements Runnable {

    private int ticket = 22;

    @Override
    public void run() {
        while (true) {
            edit();
            if (ticket == 0) {
                break;
            }
        }
    }

    private synchronized void edit() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 买票， 票号: " + ticket);
            --ticket;
        }
    }
}