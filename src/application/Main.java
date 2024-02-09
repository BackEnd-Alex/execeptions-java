package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner leia = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Room number: ");
        int roomNumber = leia.nextInt();

        System.out.print("Check-in date(dd/MM/yyyy) : ");
        leia.nextLine();
        Date checkin = sdf.parse(leia.next());
        System.out.print("Check-out date(dd/MM/yyyy) : ");
        leia.nextLine();
        Date checkout = sdf.parse(leia.next());

        if (!checkout.after(checkin)){
            System.out.println("Erro na reserva, data de saída menor que a de entrada.");
        }
        else {
            Reservation reservation = new Reservation(roomNumber,checkin,checkout);
            System.out.println("Reservation: " + reservation);
        }
        Reservation reservation = new Reservation(roomNumber,checkin,checkout);
        System.out.println();
        System.out.println("Enter data to update the reservation: ");

        System.out.print("Check-in date(dd/MM/yyyy) : ");
        checkin = sdf.parse(leia.next());

        System.out.print("Check-out date(dd/MM/yyyy) : ");
        checkout = sdf.parse(leia.next());

       String error = reservation.upDates(checkin, checkout);
       if (error != null){
           System.out.println("Erro in reservation: " + error);
       }
       else {
           System.out.println("Reservation: " + reservation);
       }
    }

}