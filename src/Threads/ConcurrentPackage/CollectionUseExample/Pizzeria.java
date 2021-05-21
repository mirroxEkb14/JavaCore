package Threads.ConcurrentPackage.CollectionUseExample;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {

    /**
     * Пицеррия «Секунду в секунду» вышла на новый уровень. Любая пицца здесь теперь доставляется за 10 минут.
     * Такой скорости пиццерия достигла за счет того, что пицца готовится одновременно с доставкой, к клиенту
     * отправляется вагончик с кухней. Правда, у пиццерии пока всего два таких вагончика.
     *
     * Смоделируйте работу этой пиццерии.
     *
     * Напишите класс Pizzeria, у которого есть метод:
     *          void order(String pizzaName);
     * Как только есть свободный вагончик, он начинает работу по приготовлению и доставке, которая заканчивается
     * через 500 ms, ведь в тестирующей системе время течет во много раз быстрее(Thread.sleep(500)).
     *
     * Как только доставка заканчивается, на консоль нужно выдать фразу:
     *          PizzaName was delivered
     * После этого вагончик может немедленно начать новую доставку.
     *
     * Но клиенты не любят ждать, если ожидать приходится более 15 минут (в тестирующей системе 750 ms), заказ
     * отменяется. Для того чтобы понять, сколько клиент ждет, можно пользоваться System.currentTimeMillis().
     *
     * В этом случае на консоль выводится надпись:
     *          PizzaName was NOT delivered
     * Таким образом, на консоли появляется информация о всех заказах в порядке их обработки. Каждый заказ либо доставлен, либо нет.
     */

    // here we store our orders ('Order' objects)
    public LinkedBlockingDeque<Order> orders = new LinkedBlockingDeque<>();

    // this variable is needed to calculate how long the program will work(87 string)
    public final long START_TIME;

    public static void main(String[] args) throws InterruptedException {
        Pizzeria pizzeria = new Pizzeria(); // create the object of the 'Pizzeria' class

        // make orders
        pizzeria.order("Margarita");
        Thread.sleep(100);
        pizzeria.order("Pepperoni");
        Thread.sleep(100);
        pizzeria.order("Sicilian");
        Thread.sleep(100);
        pizzeria.order("Greek");
    }

    // here everything is clear
    static class Order {

        public String pizzaName;

        // the time when an order is made(when we call 'order' method like in 42nd string)
        public long orderTime;

        public Order(String pizzaName, long orderTime) {
            this.pizzaName = pizzaName;
            this.orderTime = orderTime;
        }
    }

    class PizzaCar extends Thread {

        @Override
        public void run() {

            // this loop determines the working time (1 sec)
            while (System.currentTimeMillis() - START_TIME < 1000) {
                Order order = null;

                // try to take an order from 'orders'
                try {
                    order = orders.poll(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // if successful
                if (order != null) {

                    // following the task, the order will be delivered only if
                    // less than 750ms have passed since making the order
                    // '+500' here just for example, so that the message 'PizzaName was NOT delivered' appears
                    if (System.currentTimeMillis() + 500 - order.orderTime <= 750) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(order.pizzaName + " was delivered");

                    // if passed more than 750ms
                    } else {
                        System.out.println(order.pizzaName + " was NOT delivered");
                    }
                }
            }
        }
    }

    // just put 'Order' object in 'orders'
    public void order(String pizzaName) {
        try {
            orders.put(new Order(pizzaName, System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // following the task, we have two pizza cars(two threads) and the time pizzeria started working
    public Pizzeria() {
        START_TIME = System.currentTimeMillis();
        new PizzaCar().start();
        new PizzaCar().start();
    }
}
