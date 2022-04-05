import java.util.Scanner;

import model.exceptions.DomainException;

public class ProgramaBanco {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);

		try {
			System.out.println("Informações da Conta Bancária");
			System.out.println("Numero: ");
			int num = sc.nextInt();
			System.out.println("Titular da Conta");
			String holder = scS.nextLine();
			System.out.println("Balanço Inicial: ");
			double saldo = sc.nextDouble();
			System.out.println("Limite de Saque");
			double saque = sc.nextDouble();
			
			Banco c2 = new Banco(num, holder, saldo, saque);
			
			System.out.println("Digite o valor para o saque:");
			c2.withdraw(sc.nextDouble());
			System.out.println("Saldo Atual: "+c2.getBalance());
		}
		
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
}
