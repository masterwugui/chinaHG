package cetc.software.chinahg.dynamicds;

import org.apache.commons.dbcp.BasicDataSource;

import cetc.software.chinahg.util.StringUtil;

/**
 * ���ܵ����Դ
 * 
 * @author zym
 * 
 */
public class EncryptDataSource extends BasicDataSource {

	@Override
	public void setPassword(String password) {

		password = encryptPassword(password);
		super.setPassword(password);
	}

	/**
	 * ������ݿ�����Ĺ���
	 * 
	 * @param password
	 * @return
	 */
	private String encryptPassword(String password) {

		String result = password;
		if (StringUtil.isBlank(password) && password.indexOf(",") < 0) {
			// if(StringUtil.indexOf(password, ",")<0){
			return result;
		}
		String[] separate = password.split(",");
		String fydm = separate[0];
		String xlh = separate[1];
		if (StringUtil.equals(fydm, "000000")) {
			result = xlh;
		} else {
		}

		return result;
	}
}
