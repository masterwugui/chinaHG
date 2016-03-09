package cetc.software.chinahg.data.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.XtglyhbDao;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;

@Component("xtglyhbDao")
public class XtglyhbDaoHibernate extends BaseHibernateDAO implements XtglyhbDao {

	@SuppressWarnings("unchecked")
	@Override
	public PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl) {
		// String hql = "from PubXtglYhb where YHDM=? and YHKL=?";

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
	public boolean updatePermission(int id, String permission) {
		String sql = "UPDATE RMPSY_MANAGER SET permission = ? where yhbh = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, permission);
		query.setInteger(1, id);

		int result = query.executeUpdate();
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public String getPermission(int id) {
		String sql = "SELECT permission FROM RMPSY_MANAGER WHERE YHBH = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);

		return null;
	}

	@Override
	public List<PubXtglYhb> getUserByFydm(String fydm) {
		String sql = "SELECT * FROM RMPSY_MANAGER WHERE FYDM = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, fydm);
		@SuppressWarnings("unchecked")
		List<PubXtglYhb> xtglyhbList = query.list();
		return xtglyhbList == null ? new ArrayList<PubXtglYhb>() : xtglyhbList;
	}

	@Override
	public boolean insertUser(String yhdm, String yhmc, String yhkl,
			String fydm, String permission) {
		String sql = "insert into RMPSY_MANAGER (YHDM, YHMC, YHKL, FYDM, permission) values (?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, yhdm);
		query.setString(1, yhmc);
		query.setString(2, yhkl);
		query.setString(3, fydm);
		query.setString(4, permission);

		int result = query.executeUpdate();
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public List<PubXtglYhb> getRealUser() {
		String sql = "SELECT * FROM RMPSY_MANAGER WHERE permission like '_______________1%'";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		@SuppressWarnings("unchecked")
		List<PubXtglYhb> xtglyhbList = query.list();
		return xtglyhbList == null ? new ArrayList<PubXtglYhb>() : xtglyhbList;
	}

	@Override
	public PubXtglYhb getXtglyhbByYhdmFydm(String yhdm, String fydm) {
		String sql = "SELECT * FROM RMPSY_MANAGER WHERE YHDM = ? and FYDM = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, yhdm);
		query.setString(1, fydm);

		@SuppressWarnings("unchecked")
		List<PubXtglYhb> xtglyhbList = query.list();
		if (xtglyhbList == null) {
			xtglyhbList = new ArrayList<PubXtglYhb>();
		}
		return xtglyhbList.isEmpty() ? (null) : xtglyhbList.get(0);
	}

	@Override
	public List<PubXtglYhb> getAllUser() {
		String sql = "SELECT * FROM RMPSY_MANAGER";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		@SuppressWarnings("unchecked")
		List<PubXtglYhb> xtglyhbList = query.list();
		return xtglyhbList == null ? new ArrayList<PubXtglYhb>() : xtglyhbList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PubXtglYhb getXtglyhbByYhdmYhklFydm(String yhdm, String yhkl,
			String fydm) {
		String sql = "SELECT * FROM pub_xtglyhb WHERE YHDM = ? AND YHKL = ? AND FYDM=?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				PubXtglYhb.class);
		query.setString(0, yhdm);
		query.setString(1, yhkl);
		query.setString(2, fydm);
		List<PubXtglYhb> xtglyhbList = new ArrayList<PubXtglYhb>();
		xtglyhbList =query.list();
		return xtglyhbList.isEmpty() ? (null) : xtglyhbList.get(0);
	}

}
