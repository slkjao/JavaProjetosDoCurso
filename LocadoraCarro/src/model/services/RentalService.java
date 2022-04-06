package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double priceHour;
	private Double priceDay;
	
	private TaxService bts;
	
	
	
	public RentalService(Double priceHour, Double priceDay, TaxService bts) {
		this.priceHour = priceHour;
		this.priceDay = priceDay;
		this.bts = bts;
	}

	
	public void processInvoice(CarRental cr) {
		long t1 = cr.getStart().getTime();		
		long t2 = cr.getFinish().getTime();
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double valor;
		System.out.println("horas = "+ horas);
		if(horas <= 12.0) {
			valor = Math.ceil(horas) * priceHour;
			System.out.println("valor = "+valor);
		} else {
			valor = Math.ceil(horas / 24) * priceDay;
			System.out.println("valor = "+valor);
		}
		
		double tax = bts.tax(valor);
		
		cr.setInvoice(new Invoice(valor, tax));
	}
}
