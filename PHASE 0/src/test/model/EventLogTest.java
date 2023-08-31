package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EventLogTest {
    private Event e1;
    private Event e2;
    private Event e3;
    private Date date;

    @BeforeEach
    public void loadEvents() {
        e1 = new Event("response1");
        e2 = new Event("response2");
        e3 = new Event("response3");
        date = Calendar.getInstance().getTime();
        EventLog el = EventLog.getInstance();
        el.logEvent(e1);
        el.logEvent(e2);
        el.logEvent(e3);
    }

    @Test
    public void testLogEvent() {
        List<Event> eventList = new ArrayList<>();
        EventLog el = EventLog.getInstance();
        for (Event e : el) {
            eventList.add(e);
        }

        assertTrue(eventList.contains(e1));
        assertTrue(eventList.contains(e2));
        assertTrue(eventList.contains(e3));
    }

    @Test
    public void testGetDescription(){
        assertEquals("response1", e1.getDescription());
        assertEquals("response2", e2.getDescription());
        assertEquals("response3", e3.getDescription());
    }

    @Test
    public void testGetDate(){
        assertEquals(date, e1.getDate());
    }

    @Test
    public void testClear() {
        EventLog el = EventLog.getInstance();
        el.clear();
        Iterator<Event> itr = el.iterator();
        assertTrue(itr.hasNext());
        assertEquals("Event log cleared.", itr.next().getDescription());
        assertFalse(itr.hasNext());
    }
}
