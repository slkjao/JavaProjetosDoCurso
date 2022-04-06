package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String args[]) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		

		System.out.println("Informacoes do Aluguel");
		System.out.println("Modelo do carro: ");
		String model = sc.nextLine();
		System.out.println("Data de inicio: (dd/MM/yyyy hh:MM)");
		Date dataIn = sdf.parse(sc.nextLine());
		System.out.println("Data de retorno: (dd/MM/yyyy hh:MM)");
		Date dataOut = sdf.parse(sc.nextLine());
		

		CarRental cr = new CarRental(dataIn, dataOut, new Vehicle(model));
		
		System.out.println("Preco do Aluguel - Hora:");
		double precoHora = sc.nextDouble();
		System.out.println("Preco do Aluguel - Dia:");
		double precoDia = sc.nextDouble();
		

		RentalService rs = new RentalService(precoHora, precoDia, new BrazilTaxService());
		rs.processInvoice(cr);
		
		
		System.out.println();
		System.out.println("NOTA FISCAL");
		System.out.println("Valor do Aluguel: "+ String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Taxa: "+ String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Valor Total: "+ String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
	}

}
