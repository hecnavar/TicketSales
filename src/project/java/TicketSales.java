package project.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicketSales {

    private List<Event> events;

    public TicketSales() {
        this.events = new ArrayList<>();
        createSampleData();
    }

    private void createSampleData() {
        Event concert1 = new Concert("The Rockers", LocalDate.of(2025, 12, 10), "Auditorio Nacional", "The Rockers");
        concert1.localitys.put("VIP", new Locality("VIP", 1500.00, 100));
        concert1.localitys.put("General", new Locality("General", 500.00, 500));
        events.add(concert1);
    }

    public void SeeAvailableEvents() {
        System.out.println("\n--- CARTELERA DE EVENTOS ---");
        if (events.isEmpty()) {
            System.out.println("No hay eventos disponibles en este momento.");
            return;
        }
        for (Event event : events) {
            event.showDetails();
            System.out.println("Localidades Disponibles:");
            for (Map.Entry<String, Locality> entry : event.localitys.entrySet()) {
                Locality loc = entry.getValue();
                System.out.printf("  - %s: %d disponibles | Precio: $%.2f\n",
                        loc.getName(), loc.getAvailable(), loc.getPrice());
            }
            System.out.println();
        }
    }

    public void buyTickets() {
        System.out.println("Aquí iniciaría el proceso de compra de boletos.");
    }

    public void saveStatus() {
        System.out.println("Guardando datos antes de salir...");
    }

    public static void main(String[] args) {
        TicketSales salesSystem = new TicketSales();
        MainMenu menu = new MainMenu(salesSystem);
        menu.startMenu();
    }
}