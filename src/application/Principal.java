package src.application;

import src.model.entities.Reservation;
import src.model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int number = input.nextInt();
            System.out.println(" Check-In date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(input.next());
            System.out.println(" Check-Out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(input.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva " + reservation);

            System.out.println("\nEnter a new date to update to update the reservation");
            System.out.println("Enter the Check-In date (dd/MM/yyyy):");
            checkIn = sdf.parse(input.next());
            System.out.println("Enter the Check-Out date (dd/MM/yyyy):");
            checkOut = sdf.parse(input.next());
            reservation.updateDates(checkIn,checkOut);
        }
        catch (ParseException e){
            System.out.println(e.getMessage());
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
    }
}
