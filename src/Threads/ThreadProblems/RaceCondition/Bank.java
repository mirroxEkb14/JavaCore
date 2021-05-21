package Threads.ThreadProblems.RaceCondition;

public class Bank {

    /**
     * We have three clients who take and repay money
     * to the bank. There shouldn`t be a situation when
     * a client can 'take()' money without having money
     * in the account(when the 'money' variable equals to 0)
     * because then we have a negative value(-1000). In this
     * program such a situation takes place
     *
     * It happens when the 'money' variable equals to 0 and
     * two threads in the 'take()' method takes the 'money' value(0),
     * then these threads execute the 'repay()' method and we have
     * '-1000' value
     *
     * This situation can be saved by adding 'if' block in the
     * synchronized method 'take()':
     *
     *             if (this.money >= 1000) {
     *                 this.money -= money;
     *             }
     */

    private int money = 3000;
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(500);
        }
    }

    int getMoney() {
        return money;
    }

    void take(int money) {
        synchronized (lock) {
            this.money -= money;
        }
    }

    void repay(int money) {
        synchronized (lock) {
            this.money += money;
        }
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
        new Client().start();
        new Client().start();
    }
}
