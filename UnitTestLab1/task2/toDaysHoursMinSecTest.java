package task2;

import org.junit.jupiter.api.Test;
import task2.toDaysHoursMinSec;

import static org.junit.jupiter.api.Assertions.*;

class toDaysHoursMinSecTest extends toDaysHoursMinSec {

    @Test
    public void testIfZeroSecs() {
        int[] actual = {0, 0, 0};
        assertArrayEquals(actual, fromSecsToDHMS(0));
        System.out.println("Тест пройден.");
    }

    @Test
    public void testForMinutesOnly() {
        int[] actual = {0, 0, 0};
        for(int i = 60; i < 3600; i += 60) {
            actual[0] = i/60;
            assertArrayEquals(actual, fromSecsToDHMS(i));
        }
    }

    @Test
    public void testForHoursAndDaysOnly() {
        int[] actual = {0, 0, 0};
        int days = 0;
        int dayToHour = 24;
        for(int sec = 3600; sec < 3600*60; sec += 3600) {
            actual[1] = sec /60/60;
            if(actual[1] >= dayToHour) {
                days++;
                actual[2] = days;
                dayToHour *= 2;
            }
            assertArrayEquals(actual, fromSecsToDHMS(sec));
        }
    }

}