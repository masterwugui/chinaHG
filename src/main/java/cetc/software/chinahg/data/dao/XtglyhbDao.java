package cetc.software.chinahg.data.dao;

import java.util.List;

import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.ksxt.web.service.model.zghgUserModel;

public interface XtglyhbDao {
	PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl);

	boolean isXtglyhbExistsByYhdm(String yhdm);

	boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum,
			String yh_lineNum, String yh_phoneNum, String yh_email,
			String yh_address);

	boolean deleteXtglyhb(Integer yhbh);

	List<zghgUserModel> getUserList();

}
