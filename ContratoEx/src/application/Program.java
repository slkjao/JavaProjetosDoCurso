package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

import model.entities.Contrato;
import model.services.Parcelas;

public class Program {
	
	public static void main(String args[]) throws ParseException {
		Scanner sc= new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Date datinha = sdf.parse("29/08/2022");
		Contrato c = new Contrato(29093, datinha, 800.0, new Parcelas(4));		
		
		System.out.println("INFORMAÇÕES DO CONTRATO");
		System.out.println("Numero:");
		int num = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy):");
		Date data = sdf.parse(sc2.nextLine());
		System.out.println("Valor do Contrato:");
		double valor = sc.nextDouble();
		System.out.println("Digite o número de parcelas:");
		int parc = sc.nextInt();
		Contrato c2 = new Contrato(num, data, valor, new Parcelas(parc));
		
		c2.getParcelas().calcParcelas(c2);
		
	}
}
