package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//code used from AlarmSystem
public class EventLog implements Iterable<Event> {

    private static EventLog theLog;
    private Collection<Event> events;


    //EFFECTS: Prevents external construction (Singleton Design Pattern)
    private EventLog() {
        events = new ArrayList<Event>();
    }

    //MODIFIES: this
    //EFFECTS:instance of EventLog (Singleton design Pattern)
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    //MODIFIES: this
    //EFFECTS: adds an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    //EFFECTS: Clears the event log and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
