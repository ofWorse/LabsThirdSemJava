package tasks.task11;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ShowerRoom {

    public static Queue<Person> cabin = new ArrayBlockingQueue<>(10);
    public static String[] table = {"Свободно", "Душевая занята женщинами",
            "Душевая занята мужчинами"};
    public static Situation situation = Situation.FREE;

    public synchronized static void wantsToEnter(Person person) {
        if(person.isWoman)
            womanWantsToEnter(person);
        else manWantsToEnter(person);
    }

    public synchronized static void womanWantsToEnter(Person person) {
        while (!(cabin.size() < 10 && (situation.equals(Situation.BUSY_BY_WOMAN) || situation.equals(Situation.FREE)))) {
            try {
                ShowerRoom.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        cabin.add(person);
        person.washing = true;
        System.out.println(person.name + " вошла в кабинку (" + cabin.size() + "/" + 10 + ")");
        situation = Situation.BUSY_BY_WOMAN;
        System.out.println(person.name + " моется...");
    }

    public synchronized static void manWantsToEnter(Person person) {
        while (!(cabin.size() < 10 && (situation.equals(Situation.BUSY_BY_MAN) || situation.equals(Situation.FREE)))) {
            try {
                ShowerRoom.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        cabin.add(person);
        person.washing = true;
        System.out.println(person.name + " вошел в кабинку (" + cabin.size() + "/" + 10 + ")");
        situation = Situation.BUSY_BY_MAN;
        System.out.println(person.name + " моется...");
    }

    public synchronized static void leaves(Person person) {
        if(person.isWoman)
            womanLeaves(person);
        else manLeaves(person);
    }

    public synchronized static void womanLeaves(Person person) {
        cabin.remove(person);
        person.washing = false;
        System.out.println(person.name + " вышла из кабинки.");
        ShowerRoom.class.notify();
        if (cabin.isEmpty()) {
            situation = Situation.FREE;
            ShowerRoom.class.notifyAll();
            System.out.println(table[0]);
        }
    }

    public synchronized static void manLeaves(Person person) {
        cabin.remove(person);
        person.washing = false;
        System.out.println(person.name + " вышел из кабинки.");
        if (cabin.isEmpty()) {
            situation = Situation.FREE;
            ShowerRoom.class.notifyAll();
            System.out.println(table[0]);
        }
    }
}
