package tasks.task9;

import java.util.ArrayList;
import java.util.List;

public class Dinner {
    private final List<EatingPhilosophersProblem.PhilosopherEating> philosophers = new ArrayList<>();

    public void startDinner() {
        setPhilosophers();
        philosophers.forEach(Thread::start);
    }

    private void setPhilosophers() {
        String[] names = {"Санек", "Сашенька", "Александр", "Алехандро", "Шурик", "Саша", "Санчо"};

        for(int i = 0; i < 7; i++)
            philosophers.add(new EatingPhilosophersProblem.PhilosopherEating(names[i], i, i + 1 >= 7 ? 0 : i + 1));
    }
}
