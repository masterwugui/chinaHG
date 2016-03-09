package cetc.software.chinahg.dynamicds;

public class DataSourceRouter {

	/**
	 * 切换数据源
	 * 
	 * @param fydm
	 */
	public static void routerTo(String fydm) {
		// CustomerContextHolder.setCustomerType(fydm);
		if (CustomerContextHolder.getCustomerType() == null
				|| !CustomerContextHolder.getCustomerType().equals(fydm)) {
			// System.out
			// .println("数据源切换: " + DataSourceMap.getDataSourceKey(fydm));
			CustomerContextHolder.setCustomerType(DataSourceMap
					.getDataSourceKey(fydm));
		}
	}

}
