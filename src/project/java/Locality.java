package project.java;

import java.io.Serializable;

public class Locality implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private int totalCapacity;
    private int ticketsSold;

    public Locality(String name, double price, int capacity) {
        this.name = name;
        this.price = price;
        this.totalCapacity = capacity;
        this.ticketsSold = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailable() {
        return totalCapacity - ticketsSold;
    }

    public boolean sellTickets(int quantity) {
        if (quantity > 0 && getAvailable() >= quantity) {
            this.ticketsSold += quantity;
            return true;
        }
        return false;
    }
}