package programs.complex.ticketreservation;

public class Program {
    public static void main(String[] args) {
        TicketCounter theaterTickets = new TicketCounter(10);

        for (int i = 0; i < 15; i++) {
            Thread customer = new Thread(new Customer(theaterTickets));
            customer.start();
        }
    }
}