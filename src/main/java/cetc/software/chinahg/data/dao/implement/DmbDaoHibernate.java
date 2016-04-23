package cetc.software.chinahg.data.dao.implement;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.data.dataobject.ExamDmb;

@Component("dmbDao")
public class DmbDaoHibernate extends BaseHibernateDAO implements DmbDao {

	@Override
	public List<String> dmmsList(int lx) {
		String sql = "select DMMS from PUB_DMB where LX = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, lx);
		@SuppressWarnings("unchecked")
		List<String> dmmsList = query.list();
		return dmmsList;
	}

	@Override
	public List<ExamDmb> dmbList(int lx) {
		String sql = "select * from PUB_DMB where LX = ?";
		Query query = getMySession().createSQLQuery(sql).addEntity(
				ExamDmb.class);
		query.setInteger(0, lx);
		@SuppressWarnings("unchecked")
		List<ExamDmb> dmmsList = query.list();
		return dmmsList;
	}

	@Override
	public String getDmms(int lx, int dmbh) {
		String sql = "select DMMS from PUB_DMB where LX = ? and DMBH = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, lx);
		query.setInteger(1, dmbh);
		if (query.list().size() == 0)
			return "";
		@SuppressWarnings("unchecked")
		List<String> dmmsList = query.list();
		return dmmsList.get(0);
	}

	@Override
	public boolean insertDmb(int lx, int dmbh, String dmms) {
		String sql = "insert into PUB_DMB values(?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, lx);
		query.setInteger(1, dmbh);
		query.setString(2, dmms);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean updateDmb(int lx, int dmbh, String dmms) {
		String sql = "update PUB_DMB set DMMS = ? where LX = ? and DMBH = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(1, lx);
		query.setInteger(2, dmbh);
		query.setString(0, dmms);
		return query.executeUpdate() == 1;
	}

	@Override
	public boolean deleteDmb(int lx, int dmbh) {
		String sql = "delete from PUB_DMB where LX = ? and DMBH = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, lx);
		query.setInteger(1, dmbh);
		return query.executeUpdate() == 1;
	}

	@Override
	public int getMaxDmbhByLx(int lx) {
		String sql = "select MAX(DMBH) from PUB_DMB where LX = ?";
		Query query = getMySession().createSQLQuery(sql);
		query.setInteger(0, lx);
		return (int) query.list().get(0);
	}

}
