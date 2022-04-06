import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locacao {
	private String carModel;
	private Date checkIn;
	private Date checkOut;
	private Double valorHora;
	private Double valorDia;
	
	
	public Locacao(String carModel, Date checkIn, Date checkOut, Double valorHora, Double valorDia) {
		this.carModel = carModel;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
	}
	
	public void notaFiscal() {
		System.out.println("NOTA FISCAL");
		long duracao = (this.getCheckOut().getTime() -  this.getCheckIn().getTime()) / 1000;

	}
	
	
	
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}
	public Double getValorDia() {
		return valorDia;
	}
	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}

	@Override
	public String toString() {
		return "Locacao [carModel=" + carModel + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", valorHora="
				+ valorHora + ", valorDia=" + valorDia + "]";
	}
	
	
	
	
	
}
