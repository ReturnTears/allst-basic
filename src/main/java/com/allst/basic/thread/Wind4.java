package com.allst.basic.thread;

/**
 * 同步方法解决线程安全问题
 *
 * @author YiYa
 * @since 2020-03-21 下午 11:37
 */
public class Wind4 {

    public static void main(String[] args) {
        Winds4 w1 = new Winds4();
        Winds4 w2 = new Winds4();
        Winds4 w3 = new Winds4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Winds4 extends Thread {

    private static int ticket = 22;

    @Override
    public void run() {
        while (true) {
            edit();
            if (ticket == 0) {
                break;
            }
        }
    }

    private static synchronized void edit() {
        if (ticket > 0) {
            if (ticket > 0) {
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 买票， 票号: " + ticket);
                ticket--;
            }
        }
    }
}