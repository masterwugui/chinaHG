package cetc.software.chinahg.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author storm
 * 
 */
public class DateFormatUtil {
	public static String getDateString() {
		String path = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(path);
		String time = format.format(new Date());
		return time;
	}

	public static String getDatetimeString() {
		String path = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(path);
		String time = format.format(new Date());
		return time;
	}
	public static String getTimeString() {
		String path = "HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(path);
		String time = format.format(new Date());
		return time;
	}

	public static String getFormatDateString(Date date) {
		String time;
		if (date != null) {
			String path = "yyyy-MM-dd";
			SimpleDateFormat format = new SimpleDateFormat(path);
			time = format.format(date);
		} else {
			time = "0000-00-00";
		}
		return time;
	}

	public static String getFormatTimeString(Date date) {
		String time;
		if (date != null) {
			String path = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(path);
			time = format.format(date);
		} else {
			time = "0000-00-00 00:00:00";
		}
		return time;
	}
	
	public static String getFormatTimeStringChn(Date date) {
		String time;
		if (date != null) {
			String path = "yyyy年MM月dd日 HH时mm分ss秒";
			SimpleDateFormat format = new SimpleDateFormat(path);
			time = format.format(date);
		} else {
			time = "0000-00-00 00:00:00";
		}
		return time;
	}
	
	public static String getDateStringBeforeSixDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -6);
		String time = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
		return time;
	}

	public static String getDateStringMonday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String time = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
		return time;
	}

	public static String StringToTimestamp(Timestamp timestamp) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �����ʽ
		Timestamp now = timestamp;// ��ȡϵͳ��ǰʱ��
		String str = df.format(now);
		return str;
	}

	public static Date StringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = (Date) sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		System.out.println(getTimeString());
	}
}
