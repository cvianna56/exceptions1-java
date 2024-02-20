package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Program
{

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc;
        sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // reservation
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtf);
        
        if (checkIn.isAfter(checkOut))
        {
            System.out.println("Error in reservation: Check-out date must be after check-in date\n");
        }
        else
        {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation); // output
            
            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf);
            
            // tratamento das exceções
            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now))
            {
                System.out.println("Error in reservation: Reservation dates for update must be future dates\n");
            }
            else if (checkIn.isAfter(checkOut))
            {
                System.out.println("Error in reservation: Check-out date must be after check-in date\n");
            }
            else
            {
                // update reservation
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation); // output
            }
        }
        
        
        sc.close();
    }

}
