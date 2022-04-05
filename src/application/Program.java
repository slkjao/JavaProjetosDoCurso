package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.exceptions.DomainException;
import motel.entities.Reservation;

public class Program {
	public static void main(String args[]){

		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Reservation> listaReservas = new ArrayList<>();
	
			System.out.println("Room Number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			listaReservas.add(reserva);
			System.out.println("Reserva confirmada com sucesso!");
			System.out.println(reserva.toString());
			System.out.println();
	
			System.out.println("Atualizar reserva");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
	
	
			System.out.println("Reserva confirmada!");
			System.out.println(reserva.toString());
		}
		
		catch(ParseException e) {
			System.out.println("Invalid Date Format!");
		}
		
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected Error");
		}

	}
}
