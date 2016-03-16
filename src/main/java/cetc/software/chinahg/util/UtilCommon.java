package cetc.software.chinahg.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class UtilCommon {
	public static String getSerial(Date date, int index) {
		long msel = date.getTime();
		SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");
		msel += index;
		date.setTime(msel);
		String serials = fm.format(date);
		return serials;
	}

	// 检查是否是图片格式
	public static boolean checkIsImage(String imgStr) {
		boolean flag = false;
		if (imgStr != null) {
			if (imgStr.equalsIgnoreCase(".gif")
					|| imgStr.equalsIgnoreCase(".jpg")
					|| imgStr.equalsIgnoreCase(".jpeg")
					|| imgStr.equalsIgnoreCase(".png")) {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * m : the length of the user arrary, n : the number of users we need to
	 * select from array
	 */
	public HashSet<Integer> randomSelect(int m, int n) {
		HashSet<Integer> userSet = new HashSet<Integer>();
		if (m < n)
			return userSet;
		Random random = new Random();
		while (userSet.size() < n) {
			userSet.add((random.nextInt(m)));
		}
		return userSet;

	}
}
