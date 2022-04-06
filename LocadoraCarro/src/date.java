import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class date {
	public static void main(String args[]) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM");
		
		String d1 = "29/08/2022 19:56";
		String d2 = "30/08/2022 22:47";
		
		Date data1 = sdf.parse(d1);
		Date data2 = sdf.parse(d2);
		
		long diff = data1.getTime() - data2.getTime();
		System.out.println(TimeUnit.HOURS.convert(diff, TimeUnit.MINUTES));
	}
}
