package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.entities.Contrato;

public class Parcelas implements InterfaceParcela{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private int quant;
	
	
	public Parcelas(int i) {
		this.quant = i;
	}

	@Override
	public void calcParcelas(Contrato c) {
		System.out.println("PARCELAMENTO:");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(c.getData());
		double valorMensal = c.getValor() / quant;
		for (int i = 0; i < quant; i++) {
			calendar.add(calendar.MONTH, 1);
			double newValor = valorMensal * 1.01 * (i+1) - valorMensal  * (i+1);
			double newValor2 = (valorMensal + newValor) * 1.02;
			System.out.println(sdf.format(calendar.getTime()) + " - " + String.format("%.2f", newValor2));
		}
	
	
	}
}
