package cetc.software.chinahg.web.service;

import java.util.List;

import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.ksxt.web.service.model.zghgUserModel;

public interface XtglyhbService {

	PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl);

	boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum,
			String yh_lineNum, String yh_phoneNum, String yh_email,
			String yh_address);

	boolean insertNewHgUser(String yhdm, String yhkl);

	boolean updateUser(String yhbh, String yhdm, String yhxm, String yhkl,
			String yhzw, String yh_jobNum, int yh_permission);

	boolean deleteXtglyhb(Integer yhbh);

	List<zghgUserModel> getUserList();
	
	List<zghgUserModel> getUserList(int permission);
	
	zghgUserModel getUser(Integer yhbh);
}
