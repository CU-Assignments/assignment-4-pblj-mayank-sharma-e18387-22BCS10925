import java.util.*;

class Seat {
    private boolean isBooked = false;

    public synchronized boolean bookSeat() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }
}

class BookingThread extends Thread {
    private Seat seat;
    private String customerName;

    public BookingThread(Seat seat, String customerName, int priority) {
        this.seat = seat;
        this.customerName = customerName;
        setPriority(priority);
    }

    @Override
    public void run() {
        if (seat.bookSeat()) {
            System.out.println(customerName + " successfully booked the seat.");
        } else {
            System.out.println(customerName + " could not book the seat (already booked)." );
        }
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        Seat seat = new Seat();

        BookingThread vip1 = new BookingThread(seat, "VIP Customer 1", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(seat, "VIP Customer 2", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(seat, "Regular Customer 1", Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(seat, "Regular Customer 2", Thread.NORM_PRIORITY);

        System.out.println("Starting Ticket Booking System...");

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();

        try {
            vip1.join();
            vip2.join();
            regular1.join();
            regular2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ticket booking process completed.");
    }
}
