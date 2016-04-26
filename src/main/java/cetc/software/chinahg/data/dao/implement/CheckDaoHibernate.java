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
	public boolean insertNewCheckYH(int ckbh, int yhbh, String status) {
		String sql = "insert into hg_ck_yh(ckbh, yhbh,status) values(?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, ckbh);
		query.setInteger(1, yhbh);
		query.setString(2, status);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean insertNewCheck(int ck_cdlb, int ck_ywlb, int ck_jcyq,
			String ck_scsj, int ck_scr) {
		String sql = "insert into hg_check(ck_cdlb, ck_ywlb,ck_jcyq,ck_scsj,ck_scr_yhbh) values(?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, ck_cdlb);
		query.setInteger(1, ck_ywlb);
		query.setInteger(2, ck_jcyq);
		query.setString(3, ck_scsj);
		query.setInteger(4, ck_scr);
		return query.executeUpdate() == 1;
	}

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
	public List<userCheckModel> getCheckListNew() {
		String sql = "select A.ck_bh, A.ck_cdlb, A.ck_jcyq, A.ck_ywlb, A.ck_scsj, B.status,B.yhbh, C.yhmc from hg_check A, hg_ck_yh B, pub_Xtglyhb C where A.ck_bh = B.ckbh and B.yhbh = C.yhbh and A.ck_bh in(select ckbh from hg_ck_yh where status='未开始')";
		Query query = getMySession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCheckId((int) oa[0]);
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScsj(DateFormatUtil.getFormatDateString((Date) oa[4]));
			model.setZxr_status((String) oa[5]);
			model.setZxr_yhbh((int) oa[6]);
			model.setZxr_name((String) oa[7]);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public userCheckModel getCheckByCheckBhAndYhbh(int yhbh, int ck_bh) {
		String sql = "select A.ck_bh, A.ck_cdlb, A.ck_jcyq, A.ck_ywlb, A.ck_scsj, A.ck_scr_yhbh, C.yhmc, B.yhbh, D.yhmc, "
				+ "B.qrsj, B.wcsj, B.clyj from hg_check A, hg_ck_yh B, pub_xtglyhb C, pub_xtglyhb D "
				+ " where B.yhbh = ? and B.ckbh = ? and A.ck_bh = B.ckbh and A.ck_scr_yhbh = C.yhbh and B.yhbh = D.yhbh";
		;
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		query.setInteger(1, ck_bh);
		Object[] oa = (Object[]) query.list().get(0);
		userCheckModel model = new userCheckModel();
		model.setCheckId((int) oa[0]);
		model.setCd((int) oa[1]);
		model.setJcyq((int) oa[2]);
		model.setYwlb((int) oa[3]);
		model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
		model.setScr_name((String) oa[6]);
		model.setZxr_yhbh((int) oa[7]);
		model.setZxr_name((String) oa[8]);
		model.setZxr_qrsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[9]));
		model.setZxr_wcsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[10]));
		model.setClyj((String) oa[11]);
		return model;
	}

	@Override
	public List<userCheckModel> getCheckListByYhAndStatus(int yhbh,
			String status) {
		String sql = "select A.ck_bh, A.ck_cdlb, A.ck_jcyq, A.ck_ywlb, A.ck_scsj, A.ck_scr_yhbh, C.yhmc, B.yhbh, D.yhmc, "
				+ "B.qrsj, B.wcsj from hg_check A, hg_ck_yh B, pub_xtglyhb C, pub_xtglyhb D "
				+ " where B.yhbh = ? and b.status = ? and A.ck_bh = B.ckbh and A.ck_scr_yhbh = C.yhbh and B.yhbh = D.yhbh";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		query.setString(1, status);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<userCheckModel> modelList = new ArrayList<userCheckModel>();
		for (Object[] oa : reList) {
			userCheckModel model = new userCheckModel();
			model.setCheckId((int) oa[0]);
			model.setCd((int) oa[1]);
			model.setJcyq((int) oa[2]);
			model.setYwlb((int) oa[3]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setScr_name((String) oa[6]);
			model.setZxr_yhbh((int) oa[7]);
			model.setZxr_name((String) oa[8]);
			model.setZxr_qrsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[9]));
			model.setZxr_wcsj(DateFormatUtil
					.getFormatTimeStringChn((Date) oa[10]));

			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public boolean confirmCheckStatus(int yhbh, int checkBh, String status,
			String qrsj) {
		String sql = "update hg_ck_yh set qrsj = ?, status = ? where yhbh = ? and ckbh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, qrsj);
		query.setString(1, status);
		query.setInteger(2, yhbh);
		query.setInteger(3, checkBh);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean finishCheckStatus(int yhbh, int checkBh, String status,
			String wcsj, String clyj) {
		String sql = "update hg_ck_yh set wcsj = ?, status = ?, clyj=? where yhbh = ? and ckbh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, wcsj);
		query.setString(1, status);
		query.setInteger(3, yhbh);
		query.setInteger(4, checkBh);
		query.setString(2, clyj);
		return query.executeUpdate() == 1;
	}

	@Override
	public List<userCheckModel> getCheckListByYhAndStatus(int yhbh, int cd,
			int ywlb, int jcyq, String startScsj, String endScsj,
			String startWcsj, String endWcsj) {
		Query query;
		String sql = "select A.ck_bh, A.ck_cdlb, A.ck_jcyq, A.ck_ywlb, A.ck_scsj, A.ck_scr_yhbh, A.ck_scr_yhbh, B.yhbh, B.yhbh, "
				+ " B.qrsj, B.wcsj from hg_check A, hg_ck_yh B, pub_xtglyhb C, pub_xtglyhb D "
				+ " where A.ck_scsj > ? and A.ck_scsj < ? and B.wcsj > ? and B.wcsj < ? and B.status = '已完成' "
				+ " and A.ck_scr_yhbh = C.yhbh and A.ck_bh = B.ckbh and B.yhbh = D.yhbh";
		List<Integer> obj = new ArrayList<Integer>();

		if (yhbh > 0) {
			obj.add(yhbh);
			sql += " and B.yhbh = ? ";
		}

		if (cd > 0) {
			obj.add(cd);
			sql += " and A.ck_cdlb = ?";
		}

		if (ywlb > 0) {
			obj.add(ywlb);
			sql += " and A.ck_ywlb = ?";
		}

		if (jcyq > 0) {
			obj.add(jcyq);
			sql += " and A.ck_jcyq = ?";
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
			model.setScr_bh((int) oa[5]);
			//model.setScr_name((String) oa[6]);
			model.setScsj(DateFormatUtil.getFormatTimeStringChn((Date) oa[4]));
			model.setCheckId((int) oa[0]);
			//model.setZxr_name((String) oa[8]);
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
	public int getMaxCheckId() {
		String sql = "select MAX(ck_bh) from hg_check";
		Query query = getMySession().createSQLQuery(sql);
		return (int) query.list().get(0);
	}
}
