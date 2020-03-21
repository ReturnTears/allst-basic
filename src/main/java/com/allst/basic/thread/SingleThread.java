package com.allst.basic.thread;

/**
 * 单例模式~懒汉式修改为线程安全的
 * @author YiYa
 * @since 2020-03-21 下午 11:59
 */
public class SingleThread {

    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
class Bank {}