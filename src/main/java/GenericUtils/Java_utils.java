package GenericUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * @author Kartik
 *
 */
public class Java_utils {
	/**
	 * this method is used to get the random number
	 * @param set
	 * @return 
	 */
	public int random(int set)
	{
		return new Random().nextInt(set);
	}
	/**
	 * this method is used to get the date by using simple date format class
	 * @param pattern
	 * @return 
	 * @return s55
	 */
	public String getsimpleDate()
	{	
		return new SimpleDateFormat("dd-MMMM-yyyy").format(new Date());
		
	}
	/**
	 * this method is used to get the date by passing day
	 * @param pattern
	 * @param date
	 * @return 
	 */
	public String getsimpleDate(int day)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, day);
		return sdf.format(cal.getTime());
	}
	/**
	 * this method will get the date based on the user conviniance
	 * @param start_date
	 * @param day
	 * @return 
	 */
	public String getsimpleDate(String startdate,int day)
	{
		String date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(startdate));
			cal.add(Calendar.DAY_OF_MONTH, day);
			date = sdf.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * this method is use to split the data 
	 * @param data
	 * @param pattern
	 * @return
	 */
	public String[] split(String data,String pattern)
	{		
		return data.split(pattern);
	}
	/**
	 * this method is used to convert string into integer formet
	 * @param data
	 * @return
	 */
	public int parseNumber(String data)
	{
		return Integer.parseInt(data);
	}
	/**
	 * this method is used to decode the data
	 * @param data
	 * @return
	 */
	public String decoder(String data)
	{
		return	new String(Base64.getDecoder().decode(data.getBytes()));
	}
	/**
	 * this method is used to encode the data
	 * @param data
	 * @return
	 */
	public String encoder(String data)
	{
		return	new String(Base64.getEncoder().encode(data.getBytes()));
	}
	/**
	 * this method is used to get the systemdate
	 * @return system date
	 */
	public String systemDate()
	{
		Date date=new Date();
		String datetime = date.toString();
		//System.out.println(datetime);
		String yyyy = datetime.split(" ")[5];
		String dd = datetime.split(" ")[2];
		String time = datetime.split(" ")[3];
		int mm = date.getMonth()+1;
		return dd+"-"+mm+"-"+yyyy+":"+time;
	}
	/**
	 * this method is used to convert month into number by passing the required month
	 * @param month
	 * @return
	 */
	public int convertMonthToNumber(String month)
	{
	return DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(month).get(ChronoField.MONTH_OF_YEAR);
	}
	/**
	 * 
	 */
	
	public String rashiDate()
	{
		String date=new SimpleDateFormat("dd MMMM, yyyy").format(new Date());
		return date+" Today's Rashifal";
	}
}

