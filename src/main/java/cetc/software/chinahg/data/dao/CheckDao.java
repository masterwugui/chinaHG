package cetc.software.chinahg.data.dao;

import java.util.List;

import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

public interface CheckDao {

	boolean insertNewCheck(int ck_ctlb, int ck_ywlb, int ck_jcyq,
			String ck_zxra_status, String ck_zxrb_status, String ck_scsj,
			int ck_zxra, String ck_zxra_name, int ck_zxrb, String ck_zxrb_name,
			int ck_scr, String ck_scr_name);

	List<checkModel> getCheckList();

	checkModel getCheckByCheckBh(int ck_bh);

	List<userCheckModel> getCheckAListByYhAndStatus(int yhbh, String status);

	List<userCheckModel> getCheckAListByYhAndStatus(int yhbh, int cd, int ywlb,
			int jcyq, String startScsj, String endScsj, String startWcsj,
			String endWcsj);

	List<userCheckModel> getCheckBListByYhAndStatus(int yhbh, int cd, int ywlb,
			int jcyq, String startScsj, String endScsj, String startWcsj,
			String endWcsj);
	
	List<userCheckModel> getCheckBListByYhAndStatus(int yhbh, String status);

	boolean confirmACheckStatus(int yhbh, int checkBh, String status,
			String qrsj);

	boolean finishACheckStatus(int yhbh, int checkBh, String status, String wcsj);

	boolean confirmBCheckStatus(int yhbh, int checkBh, String status,
			String qrsj);

	boolean finishBCheckStatus(int yhbh, int checkBh, String status, String wcsj);
}
