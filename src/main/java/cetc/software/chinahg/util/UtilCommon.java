package cetc.software.chinahg.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

	// 从一个题目内码数组中随即抽取n道题目
	public static HashSet<Integer> randomSelectQue(List<Integer> queArray, int n) {
		HashSet<Integer> result = new HashSet<Integer>();
		Random rand = new Random();
		int maxNum = queArray.size();
		int index = 0;
		if (n == 0) {
		} else if (n > maxNum) {
			for(int queId : queArray){
				result.add(queId);
			}
		} else {
			while (result.size() < n) {
				index = rand.nextInt(maxNum);
				result.add(queArray.get(index));
			}
		}
		return result;
	}

	public static HashSet<Integer> mergeSet(HashSet<Integer> jobSet,
			HashSet<Integer> publicSet) {
		HashSet<Integer> reSet = new HashSet<Integer>();
		for (Iterator<Integer> it = jobSet.iterator(); it.hasNext();) {
			reSet.add(it.next());
		}
		for (Iterator<Integer> it = publicSet.iterator(); it.hasNext();) {
			reSet.add(it.next());
		}
		return reSet;
	}

	public static void putScore(Map<String, Integer> test, String kTip,
			int perPoint) {
		if (test.containsKey(kTip)) {
			int tmpPoint = test.get(kTip) + perPoint;
			test.put(kTip, tmpPoint);
		} else {
			test.put(kTip, perPoint);
		}
	}

}
