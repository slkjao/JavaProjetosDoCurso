import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

	public static void main(String args[]) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Informação do Aluguel");
		System.out.println("Modelo do Carro:");
		String model = sc.nextLine();
		System.out.println("Data de Aluguel: (dd/MM/yyyy HH:mm)");
		Date ent = sdf.parse(sc.nextLine());
		System.out.println("Data de Devolucao: (dd/MM/yyyy HH:mm)");
		Date dev = sdf.parse(sc.nextLine());
		System.out.println("Preco por Hora: ");
		double valHora = sc.nextDouble();
		System.out.println("Preco por Dia: ");
		double valDia = sc.nextDouble();
		
		Locacao l1 = new Locacao(model, ent, dev, valHora, valDia);
		l1.notaFiscal();
		System.out.println(l1.toString());
		
	}
}
