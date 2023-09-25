import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Main3029_경고2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String from = sc.next();
		String to = sc.next();
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
	
		try {			
			Date date2 = format.parse(to);
			Date date1 = format.parse(from);
			long time = date2.getTime() - date1.getTime();
			if (time==0) {
				System.out.println("24:00:00");
			} else {
				System.out.println(format.format(time));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}
