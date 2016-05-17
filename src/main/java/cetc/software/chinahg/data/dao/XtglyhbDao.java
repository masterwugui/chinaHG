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

	boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum);
	
	boolean updateHgUser(int yhbh, String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum);
	
	boolean updateHgUser(int yhbh, String yhkl);
	
	boolean updateHgUserSelected(int yhbh, int yh_selected);

	boolean insertNewHgUser(String yhdm, String yhkl);

	boolean deleteXtglyhb(Integer yhbh);

	List<zghgUserModel> getUserList();
	
	List<zghgUserModel> getUserList(int permission);

	zghgUserModel getUser(int yhbh);

	List<Integer> getUserToBeChooseList();

}
