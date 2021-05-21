package Threads.ConcurrentPackage.AtomicClasses;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1361 {

    /**
     * Еще раз отрефакторите код банка. Уберите все слова
     * synchronized из кода и «заставьте» его работать правильно
     * с использованием класса AtomicInteger.
     */

    public static void main(String[] args) throws InterruptedException {
        ModifiedBank bank = new ModifiedBank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(500);
        }
    }
}

class ModifiedBank {

    protected AtomicInteger money = new AtomicInteger(3000);

    AtomicInteger getMoney() {
        return money;
    }

    void take(AtomicInteger money) {
        this.money.getAndDecrement();
    }

    void repay(AtomicInteger money) {
        this.money.getAndIncrement();
    }

    class ModifiedClient extends Thread {
        @Override
        public void run() {
            while (true) {
                take(new AtomicInteger(1000));
                repay(new AtomicInteger(1000));
            }
        }
    }

    public ModifiedBank() {
        new ModifiedBank.ModifiedClient().start();
        new ModifiedBank.ModifiedClient().start();
        new ModifiedBank.ModifiedClient().start();
        new ModifiedBank.ModifiedClient().start();
        new ModifiedBank.ModifiedClient().start();
    }
}