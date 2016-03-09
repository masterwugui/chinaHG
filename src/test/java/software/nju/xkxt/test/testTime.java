package software.nju.xkxt.test;

import java.util.Calendar;
import java.util.Date;

import cetc.software.chinahg.util.DateFormatUtil;

public class testTime {
	public static boolean isEalier(){
		int y,m,d,h;  
		Calendar cal=Calendar.getInstance();    
		y=cal.get(Calendar.YEAR);    
		m=cal.get(Calendar.MONTH);
		System.out.println(m);
		d=cal.get(Calendar.DATE);    
		h=cal.get(Calendar.HOUR_OF_DAY);    
		String s=Integer.toString(y)+"-"+Integer.toString(m)+"-"+Integer.toString(d) ;
		System.out.println(s);
		return false;
	}
	public static void main(String[] args) {
		//isEalier();
		
		System.out.println(DateFormatUtil.getDateString());
		System.out.println(DateFormatUtil.getTimeString());
	}

}
