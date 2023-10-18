package programs.complex.ticketreservation;

public class Customer implements Runnable {
    private final int customerID;
    private static int lastCustomerID = 1;

    private final TicketCounter counter;

    private int tickets;

    public Customer(TicketCounter ticketCounter) {
        customerID = lastCustomerID++;
        counter = ticketCounter;
    }

    @Override
    public void run() {
        int tickets = (int)(Math.random() * 4) + 1;
        String ticketString = tickets > 1 ? " tickets." : " ticket.";
        String attempt = counter.reserveTicket(tickets) ? " reserved " : " couldn't reserve ";
        System.out.println("Customer " + customerID + attempt + tickets + ticketString);
    }
}
