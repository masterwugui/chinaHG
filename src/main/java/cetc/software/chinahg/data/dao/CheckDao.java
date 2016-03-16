package cetc.software.chinahg.data.dao;

public interface CheckDao {

	boolean insertNewCheck(String ck_ctlb, String ck_ywlb, String ck_jcyq,
			String ck_zxra_status, String ck_zxrb_status, String ck_scsj,
			String ck_zxra, String ck_zxra_name, String ck_zxrb,
			String ck_zxrb_name, String ck_scr, String ck_scr_name);
}
