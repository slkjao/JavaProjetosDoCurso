package model.entities;

import java.util.Date;

import model.services.InterfaceParcela;
import model.services.Parcelas;

public class Contrato {
	private int num;
	private Date data;
	private double valor;
	private InterfaceParcela parcelas;
	
	public Contrato(int num, Date data, double valor, InterfaceParcela parcela) {
		this.num = num;
		this.data = data;
		this.valor = valor;
		this.parcelas = parcela;
	}


	public int getNum() {
		return num;
	}

	
	public InterfaceParcela getParcelas() {
		return parcelas;
	}


	public void setParcelas(InterfaceParcela parcelas) {
		this.parcelas = parcelas;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
