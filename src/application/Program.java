package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import motel.entities.Reservation;

public class Program {
	public static void main(String args[]) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Reservation> listaReservas = new ArrayList<>();

		System.out.println("Room Number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("DATA ERRADA TA SAINDO ANTES DE ENTRAR");
		} else {
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
			
			String erro = reserva.updateDates(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro na reserva! " + erro);
			} else {
				System.out.println("Reserva confirmada!");
				System.out.println(reserva.toString());
			}
			

		}
	}
}
