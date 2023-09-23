package ticketreservation;

public class TicketCounter {
    private final int ticketCapacity;
    private int ticketsSold = 0;

    public TicketCounter(int ticketCapacity) {
        this.ticketCapacity = ticketCapacity;
    }

    public synchronized boolean reserveTicket(int amount) {
        if(ticketsSold + amount > ticketCapacity) {
            return false;
        } else {
            ticketsSold++;
            return true;
        }
    }
}
