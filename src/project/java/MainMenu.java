package project.java;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner;
    private TicketSales ticketSalesSystem;

    public MainMenu(TicketSales ticketSalesSystem) {
        this.scanner = new Scanner(System.in);
        this.ticketSalesSystem = ticketSalesSystem;
    }

    public void startMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n**** SISTEMA DE VENTA DE BOLETOS ****");
            System.out.println("1. Ver eventos disponibles");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        ticketSalesSystem.SeeAvailableEvents();
                        break;
                    case 2:
                        ticketSalesSystem.buyTickets();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        ticketSalesSystem.saveStatus();
        System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
        scanner.close();
    }
}