import java.util.Random;

import model.exceptions.DomainException;

public class Banco {
	private int number;
	private String holder;
	private Double balance;
	private double withdrawLimit;

	public Banco(int number, String holder, double balance, double saque) throws DomainException {
		if (saque > balance) {
			throw new DomainException("Limite de saque acima do saldo disponível");
		}

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = saque;

	}

	public void deposito(double valor) {
		this.balance += valor;
	}

	public void withdraw(double valor) throws DomainException  {
		validateWithdraw(valor);
		this.balance -= valor;
	}
	
	public void validateWithdraw(double valor) throws DomainException{
		if(valor > this.getWithdrawLimit()) {
			throw new DomainException("Valor do Saque acima do limite disponível");
		}		
		if (valor > this.getBalance()) {
			throw new DomainException("Valor do Saque acima do saldo disponível");
		}	
	}
	
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	@Override
	public String toString() {
		return "Conta Bancaria [n" + number + ", holder=" + holder + ", balance=" + balance + ", withdrawLimit="
				+ withdrawLimit + "]";
	}

}
