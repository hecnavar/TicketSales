package project.java;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger contadorIds = new AtomicInteger(0);

    final int id;
    String name;
    LocalDate date;
    String place;
    Map<String, Locality> localitys;

    public Event(String name, LocalDate date, String place) {
        this.id = contadorIds.incrementAndGet();
        this.name = name;
        this.date = date;
        this.place = place;
        this.localitys = new HashMap<>();
    }

    public void addLocation(String name, double price, int capacity) {
        this.localitys.put(name.toUpperCase(), new Locality(name, price, capacity));
    }

    public abstract void showDetails();

    public boolean sellTickets(String seccion, int quantity) {
        Locality loc = localitys.get(seccion.toUpperCase());
        if (loc != null && loc.getAvailable() >= quantity) {
            loc.sellTickets(quantity);
            return true;
        }
        return false;
    }
}
