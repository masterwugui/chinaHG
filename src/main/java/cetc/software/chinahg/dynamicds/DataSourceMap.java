package cetc.software.chinahg.dynamicds;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YZJ
 *
 */
public class DataSourceMap {
	public static final String NotDefined = "NotDefined";
	public static final String Tjgy = "Tjgy";
	public static final String Tjyzy = "Tjyzy";
	public static final String Tjezy = "Tjezy";
	
	
	private static final Map<String,String> dataSourceMap = new HashMap<String, String>();
	
	static{
		EnumSet<DataSourceEnum> enums = EnumSet.allOf(DataSourceEnum.class);
		for(DataSourceEnum dataSource:enums){
			dataSourceMap.put(dataSource.getFydm(), dataSource.getSource());
//			dataSourceMap.put("000000", value)
		}
	}
	
	
	public static String getDataSourceKey(String fydm){
//		if (fydm.equals("120000 200"))
//			return DataSourceMap.Tjgy;
//		else if (fydm.equals("120100 210"))
//			return DataSourceMap.Tjyzy;
//		else if (fydm.equals("120200 220"))
//			return DataSourceMap.Tjezy;
		
		return dataSourceMap.get(fydm);
	}
	
}
