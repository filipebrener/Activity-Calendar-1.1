package io.github.filipebrenner.activitycalendar.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void compareToEqual() {
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        activity1.setData("05/08/2021");
        activity2.setData("05/08/2021");
        int actual = activity1.compareTo(activity2);
        assertEquals(-1,actual);
    }

    @Test
    void compareToAfter() {
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        activity1.setData("05/08/2021");
        activity2.setData("04/08/2021");
        int actual = activity1.compareTo(activity2);
        assertEquals(1,actual);
    }

    @Test
    void compareToBefore() {
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        activity1.setData("04/08/2021");
        activity2.setData("05/08/2021");
        int actual = activity1.compareTo(activity2);
        assertEquals(-1,actual);
    }

}