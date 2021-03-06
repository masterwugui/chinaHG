package cetc.software.chinahg.data.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.XtglyhbDao;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.ksxt.web.service.model.zghgUserModel;

@Component("xtglyhbDao")
public class XtglyhbDaoHibernate extends BaseHibernateDAO implements XtglyhbDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean isXtglyhbExistsByYhdm(String yhdm) {
		String sql = "SELECT * FROM pub_xtglyhb WHERE yhdm = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, yhdm);

		List<PubXtglYhb> xtglyhbList = query.list();
		if (xtglyhbList == null) {
			xtglyhbList = new ArrayList<PubXtglYhb>();
		}
		return xtglyhbList.isEmpty() ? false : true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl) {
		String sql = "SELECT * FROM pub_xtglyhb WHERE yhdm = ? AND yhkl = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, yhdm);
		query.setString(1, yhkl);

		List<PubXtglYhb> xtglyhbList = query.list();
		if (xtglyhbList == null) {
			xtglyhbList = new ArrayList<PubXtglYhb>();
		}
		return xtglyhbList.isEmpty() ? (null) : xtglyhbList.get(0);
	}

	@Override
	public boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum,
			String yh_lineNum, String yh_phoneNum, String yh_email,
			String yh_address) {
		String sql = "insert into pub_xtglyhb(yhdm, yhmc, yhkl, permission, yh_duty, yh_jobNum, yh_lineNum, yh_phoneNum, yh_email, yh_address) values(?,?,?,?,?,?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhdm);
		query.setString(1, yhkl);
		query.setString(2, yhmc);
		query.setInteger(3, permission);
		query.setString(4, yh_duty);
		query.setString(5, yh_jobNum);
		query.setString(6, yh_lineNum);
		query.setString(7, yh_phoneNum);
		query.setString(8, yh_email);
		query.setString(9, yh_address);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean deleteXtglyhb(Integer yhbh) {
		String sql = "delete from pub_xtglyhb where yhbh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		return query.executeUpdate() == 1;
	}

	@Override
	public List<zghgUserModel> getUserList() {
		String sql = "select yhbh, yhdm, yhmc, yhkl, permission, yh_duty, yh_jobNum, yh_lineNum, yh_phoneNum, yh_email, yh_address, yh_isSelected from pub_xtglyhb where permission <> 3";
		Query query = getMySession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<zghgUserModel> modelList = new ArrayList<zghgUserModel>();
		for (Object[] oa : reList) {
			zghgUserModel model = new zghgUserModel();
			model.setYhbh((Integer) oa[0]);
			model.setYhdm((String) oa[1]);
			model.setYhmc((String) oa[2]);
			model.setYhkl((String) oa[3]);
			model.setPermission((String) oa[4]);
			model.setYh_duty((String) oa[5]);
			model.setYh_jobNum((String) oa[6]);
			model.setYh_lineNum((String) oa[7]);
			model.setYh_phoneNum((String) oa[8]);
			model.setYh_email((String) oa[9]);
			model.setYh_address((String) oa[10]);
			model.setYh_isSelected((int) oa[11]);
			if (model.getPermission().equals("1")) {
				model.setPerChn("高级用户");
			} else {
				model.setPerChn("普通用户");
			}
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public boolean insertNewHgUser(String yhdm, String yhkl) {
		String sql = "insert into pub_xtglyhb(yhdm, yhkl, permission) values(?,?,'2')";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhdm);
		query.setString(1, yhkl);
		return query.executeUpdate() == 1;
	}

	@Override
	public List<Integer> getUserToBeChooseList() {
		String sql = "select yhbh from pub_xtglyhb where permission = 2 and yh_isSelected = 1 and yh_status = 0";
		Query query = getMySession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Integer> reList = query.list();
		return reList;
	}

	@Override
	public zghgUserModel getUser(int yhbh) {
		String sql = "select yhbh, yhdm, yhmc, yhkl, permission, yh_duty, yh_jobNum, yh_lineNum, yh_phoneNum, yh_email, yh_address from pub_xtglyhb where yhbh = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yhbh);
		Object[] oa = (Object[]) query.list().get(0);
		zghgUserModel model = new zghgUserModel();
		model.setYhbh((Integer) oa[0]);
		model.setYhdm((String) oa[1]);
		model.setYhmc((String) oa[2]);
		model.setYhkl((String) oa[3]);
		model.setPermission((String) oa[4]);
		model.setYh_duty((String) oa[5]);
		model.setYh_jobNum((String) oa[6]);
		model.setYh_lineNum((String) oa[7]);
		model.setYh_phoneNum((String) oa[8]);
		model.setYh_email((String) oa[9]);
		model.setYh_address((String) oa[10]);
		return model;
	}

	@Override
	public boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum) {
		String sql = "insert into pub_xtglyhb(yhdm, yhmc, yhkl, permission, yh_duty, yh_jobNum) values(?,?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhdm);
		query.setString(1, yhmc);
		query.setString(2, yhkl);
		query.setInteger(3, permission);
		query.setString(4, yh_duty);
		query.setString(5, yh_jobNum);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean updateHgUser(int yhbh, String yhdm, String yhkl,
			String yhmc, Integer permission, String yh_duty, String yh_jobNum) {
		String sql = "update pub_xtglyhb set yhdm = ? , yhmc=?, yhkl=?, permission=?, yh_duty=?, yh_jobNum=? where yhbh=?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhdm);
		query.setString(1, yhmc);
		query.setString(2, yhkl);
		query.setInteger(3, permission);
		query.setString(4, yh_duty);
		query.setString(5, yh_jobNum);
		query.setInteger(6, yhbh);
		return query.executeUpdate() == 1;
	}
	
	@Override
	public boolean updateHgUserSelected(int yhbh, int yh_selected) {
		String sql = "update pub_xtglyhb set yh_isSelected=? where yhbh=?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, yh_selected);
		query.setInteger(1, yhbh);
		return query.executeUpdate() == 1;
	}
	
	@Override
	public List<zghgUserModel> getUserList(int permission) {
		String sql = "select yhbh, yhdm, yhmc, yhkl, permission, yh_duty, yh_jobNum, yh_lineNum, yh_phoneNum, yh_email, yh_address from pub_xtglyhb where permission = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, permission);
		@SuppressWarnings("unchecked")
		List<Object[]> reList = query.list();
		List<zghgUserModel> modelList = new ArrayList<zghgUserModel>();
		for (Object[] oa : reList) {
			zghgUserModel model = new zghgUserModel();
			model.setYhbh((Integer) oa[0]);
			model.setYhdm((String) oa[1]);
			model.setYhmc((String) oa[2]);
			model.setYhkl((String) oa[3]);
			model.setPermission((String) oa[4]);
			model.setYh_duty((String) oa[5]);
			model.setYh_jobNum((String) oa[6]);
			model.setYh_lineNum((String) oa[7]);
			model.setYh_phoneNum((String) oa[8]);
			model.setYh_email((String) oa[9]);
			model.setYh_address((String) oa[10]);
			if (model.getPermission().equals("1")) {
				model.setPerChn("高级用户");
			} else {
				model.setPerChn("普通用户");
			}
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public boolean updateHgUser(int yhbh, String yhkl) {
		String sql = "update pub_xtglyhb set yhkl=? where yhbh=?";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhkl);
		query.setInteger(1, yhbh);
		return query.executeUpdate() == 1;
	}

}
