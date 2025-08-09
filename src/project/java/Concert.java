package project.java;

import java.time.LocalDate;

public class Concert extends Event {
    private static final long serialVersionUID = 1L;
    String MainBand;

    public Concert(String name, LocalDate date, String place, String MainBand) {
        super(name, date, place);
        this.MainBand = MainBand;
    }

    @Override
    public void showDetails() {
        System.out.printf("--- CONCIERTO (ID: %d) ---\n", id);
        System.out.printf("Evento: %s\nArtista Principal: %s\nFecha: %s\nLugar: %s\n",
                name, MainBand, date, place);
    }
}