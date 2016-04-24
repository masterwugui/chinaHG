package cetc.software.chinahg.data.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.CheckDao;
import cetc.software.chinahg.util.DateFormatUtil;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;
import cetc.software.ksxt.web.service.model.zghgUserModel;

@Component("checkDao")
public class CheckDaoHibernate extends BaseHibernateDAO implements CheckDao {

	@Override
	public boolean insertNewCheck(int ck_ctlb, int ck_ywlb, int ck_jcyq,
			String ck_zxra_status, String ck_zxrb_status, String ck_scsj,
			int ck_zxra, String ck_zxra_name, int ck_zxrb, String ck_zxrb_name,
			int ck_scr, String ck_scr_name) {
		String sql = "insert into hg_check(ck_cdlb, ck_ywlb,ck_jcyq,  ck_zxra_status, ck_zxrb_status,ck_scsj, ck_zxra_yhbh, ck_zxra_name,ck_zxrb_yhbh, ck_zxrb_name, ck_scr_yhbh, ck_scr_name) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, ck_ctlb);
		query.setInteger(1, ck_ywlb);
		query.setInteger(2, ck_jcyq);
		query.setString(3, ck_zxra_status);
		query.setString(4, ck_zxrb_status);
		query.setString(5, ck_scsj);
		query.setInteger(6, ck_zxra);
		query.setString(7, ck_zxra_name);
		query.setInteger(8, ck_zxrb);
		query.setString(9, ck_zxrb_name);
		query.setInteger(10, ck_scr);
		query.setString(11, ck_scr_name);
		return query.executeUpdate() == 1;
	}

	@Override
	public List<checkModel> getCheckList() {
		String sql = "select * from hg_check";
		Query query = getMySession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<checkModel> modelList = new ArrayList<checkModel>();
		for (Object[] oa : reList) {
			checkModel model = new checkModel();
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScsj(DateFormatUtil.getFormatDateString((Date) oa[4]));
			model.setZxra_name((String) oa[8]);
			model.setZxrb_name((String) oa[12]);
			model.setZxra_status((String) oa[16]);
			model.setZxrb_status((String) oa[17]);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public checkModel getCheckByCheckBh(int ck_bh) {
		String sql = "select * from hg_check where ck_bh =?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, ck_bh);
		Object[] oa = (Object[]) query.list().get(0);
		checkModel model = new checkModel();
		model.setCk_bh((int) oa[0]);
		model.setCd((int) oa[1]);
		model.setJcyq((int) oa[2]);
		model.setYwlb((int) oa[3]);
		model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
		model.setScrName((String) oa[6]);
		model.setZxra_bh((int) oa[7]);
		model.setZxrb_bh((int) oa[11]);
		model.setZxra_name((String) oa[8]);
		model.setZxra_qrsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[9]));
		model.setZxra_wcsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[10]));
		model.setZxrb_name((String) oa[12]);
		model.setZxrb_qrsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[13]));
		model.setZxrb_wcsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[14]));
		model.setZxra_status((String) oa[16]);
		model.setZxrb_status((String) oa[17]);
		return model;
	}

	@Override
	public List<userCheckModel> getCheckAListByYhAndStatus(int yhbh,
			String status) {
		String sql = "select * from hg_check where ck_zxra_yhbh = ? and ck_zxra_status = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		query.setString(1, status);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScr_name((String) oa[6]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setCheckId((int) oa[0]);
			model.setZxr_name((String) oa[8]);
			model.setZxr_qrsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[9]));
			model.setZxr_wcsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[10]));
			model.setZxr_yhbh((int) oa[7]);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public List<userCheckModel> getCheckBListByYhAndStatus(int yhbh,
			String status) {
		String sql = "select * from hg_check where ck_zxrb_yhbh = ? and ck_zxrb_status = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		query.setString(1, status);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScr_name((String) oa[6]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setCheckId((int) oa[0]);
			model.setZxr_name((String) oa[12]);
			model.setZxr_qrsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[13]));
			model.setZxr_wcsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[14]));
			model.setZxr_yhbh((int) oa[11]);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public boolean confirmACheckStatus(int yhbh, int checkBh, String status,
			String qrsj) {
		String sql = "update hg_check set ck_zxra_qrsj = ?, ck_zxra_status = ? where ck_zxra_yhbh = ? and ck_bh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, qrsj);
		query.setString(1, status);
		query.setInteger(2, yhbh);
		query.setInteger(3, checkBh);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean finishACheckStatus(int yhbh, int checkBh, String status,
			String wcsj) {
		String sql = "update hg_check set ck_zxra_wcsj = ?, ck_zxra_status = ? where ck_zxra_yhbh = ? and ck_bh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, wcsj);
		query.setString(1, status);
		query.setInteger(2, yhbh);
		query.setInteger(3, checkBh);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean confirmBCheckStatus(int yhbh, int checkBh, String status,
			String qrsj) {
		String sql = "update hg_check set ck_zxrb_qrsj = ?, ck_zxrb_status = ? where ck_zxrb_yhbh = ? and ck_bh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, qrsj);
		query.setString(1, status);
		query.setInteger(2, yhbh);
		query.setInteger(3, checkBh);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean finishBCheckStatus(int yhbh, int checkBh, String status,
			String wcsj) {
		String sql = "update hg_check set ck_zxrb_wcsj = ?, ck_zxrb_status = ? where ck_zxrb_yhbh = ? and ck_bh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, wcsj);
		query.setString(1, status);
		query.setInteger(2, yhbh);
		query.setInteger(3, checkBh);
		return query.executeUpdate() == 1;
	}

	@Override
	public List<userCheckModel> getCheckAListByYhAndStatus(int yhbh, int cd,
			int ywlb, int jcyq, String startScsj, String endScsj,
			String startWcsj, String endWcsj) {
		Query query;
		String sql = "select * from hg_check where ck_scsj > ? and ck_scsj < ? and ck_zxra_wcsj > ? and ck_zxra_wcsj < ? and ck_zxra_status = '已完成'";
		List<Integer> obj = new ArrayList<Integer>();

		if (yhbh > 0) {
			obj.add(yhbh);
			sql += " and ck_zxra_yhbh = ?";
		}

		if (cd > 0) {
			obj.add(cd);
			sql += " and ck_cdlb = ?";
		}

		if (ywlb > 0) {
			obj.add(ywlb);
			sql += " and ck_ywlb = ?";
		}

		if (jcyq > 0) {
			obj.add(jcyq);
			sql += " and ck_jcyq = ?";
		}
		query = getMySession().createSQLQuery(sql);
		query.setString(0, startScsj);
		query.setString(1, endScsj);
		query.setString(2, startWcsj);
		query.setString(3, endWcsj);
		for (int i = 0; i < obj.size(); i++) {
			query.setInteger(i + 4, obj.get(i));
		}
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScr_name((String) oa[6]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setCheckId((int) oa[0]);
			model.setZxr_name((String) oa[8]);
			model.setZxr_qrsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[9]));
			model.setZxr_wcsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[10]));
			model.setZxr_yhbh((int) oa[7]);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public List<userCheckModel> getCheckBListByYhAndStatus(int yhbh, int cd,
			int ywlb, int jcyq, String startScsj, String endScsj,
			String startWcsj, String endWcsj) {
		Query query;
		String sql = "select * from hg_check where ck_scsj > ? and ck_scsj < ? and ck_zxrb_wcsj > ? and ck_zxrb_wcsj < ? and ck_zxrb_status = '已完成'";
		List<Integer> obj = new ArrayList<Integer>();

		if (yhbh > 0) {
			obj.add(yhbh);
			sql += " and ck_zxrb_yhbh = ?";
		}

		if (cd > 0) {
			obj.add(cd);
			sql += " and ck_cdlb = ?";
		}

		if (ywlb > 0) {
			obj.add(ywlb);
			sql += " and ck_ywlb = ?";
		}

		if (jcyq > 0) {
			obj.add(jcyq);
			sql += " and ck_jcyq = ?";
		}
		query = getMySession().createSQLQuery(sql);
		query.setString(0, startScsj);
		query.setString(1, endScsj);
		query.setString(2, startWcsj);
		query.setString(3, endWcsj);
		for (int i = 0; i < obj.size(); i++) {
			query.setInteger(i + 4, obj.get(i));
		}
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScr_name((String) oa[6]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setCheckId((int) oa[0]);
			model.setZxr_name((String) oa[12]);
			model.setZxr_qrsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[13]));
			model.setZxr_wcsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[14]));
			model.setZxr_yhbh((int) oa[11]);
			modelList.add(model);
		}
		return modelList;
	}
}
