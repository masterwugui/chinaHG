package cetc.software.chinahg.dynamicds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author YZJ
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	 * determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// System.out.println("数据源切换determineCurrentLookupKey: "
		// + CustomerContextHolder.getCustomerType());
		return CustomerContextHolder.getCustomerType();
	}

}
