package cetc.software.chinahg.data.dao;

import java.util.List;

import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

public interface CheckDao {

	
	//aborted
	boolean insertNewCheck(int ck_ctlb, int ck_ywlb, int ck_jcyq,
			String ck_zxra_status, String ck_zxrb_status, String ck_scsj,
			int ck_zxra, String ck_zxra_name, int ck_zxrb, String ck_zxrb_name,
			int ck_scr, String ck_scr_name);

	boolean insertNewCheck(int ck_cdlb, int ck_ywlb, int ck_jcyq,
			String ck_scsj, int ck_scr);
	
	int getMaxCheckId();
	
	boolean insertNewCheckYH(int ckbh, int yhbh, String status);

	List<userCheckModel> getCheckListNew();

	userCheckModel getCheckByCheckBhAndYhbh(int yhbh, int ck_bh);

	List<userCheckModel> getCheckListByYhAndStatus(int yhbh, String status);
	
	List<userCheckModel> getCheckListByYhAndStatus(int yhbh, int cd, int ywlb,
			int jcyq, String startScsj, String endScsj, String startWcsj,
			String endWcsj);

	boolean confirmCheckStatus(int yhbh, int checkBh, String status,
			String qrsj);

	boolean finishCheckStatus(int yhbh, int checkBh, String status, String wcsj, String clyj);

}
