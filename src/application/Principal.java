package src.application;

import src.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {
      Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room number: ");
        int number = input.nextInt();
        System.out.println(" Check-In date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(input.next());
        System.out.println(" Check-Out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());

        if(checkOut.before(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(number,checkIn, checkOut);
            System.out.println("Reserva "+ reservation);

            System.out.println("\nEnter a new date to update to update the reservation");
            System.out.println("Enter the Check-In date (dd/MM/yyyy):");
            checkIn = sdf.parse(input.next());
            System.out.println("Enter the Check-Out date (dd/MM/yyyy):");
            checkOut = sdf.parse(input.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                //Some wrong mannn
            }else if(checkOut.before(checkIn)){
                //also some wrong
            }else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reserva "+ reservation);
            }
        }
    }
}
