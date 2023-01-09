package tasks.task11;

import java.util.ArrayList;
import java.util.List;

public class WaitingRoom {
    public static List<Person> personList;

    public WaitingRoom() {
        personList = new ArrayList<>(40);
    }

    public void start() {
        for(int i = 0; i < 20; i++)
            personList.add(new Person("Женщина " + i, true));
        for(int i = 20; i < 40; i++)
            personList.add(new Person("Мужчина " + i, false));
        personList.forEach(Thread::start);
    }

}