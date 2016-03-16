package cetc.software.chinahg.data.dao.implement;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.CheckDao;

@Component("checkDao")
public class CheckDaoHibernate extends BaseHibernateDAO implements CheckDao {

	@Override
	public boolean insertNewCheck(String ck_ctlb, String ck_ywlb,
			String ck_jcyq, String ck_zxra_status, String ck_zxrb_status,
			String ck_scsj, String ck_zxra, String ck_zxra_name,
			String ck_zxrb, String ck_zxrb_name, String ck_scr,
			String ck_scr_name) {
		String sql = "insert into hg_check(ck_ctlb, ck_ywlb,ck_jcyq,  ck_zxra_status, ck_zxrb_status,ck_scsj, ck_zxra, ck_zxra_name,ck_zxrb, ck_zxrb_name, ck_scr,ck_scr_name) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Query query = getMySession().createSQLQuery(sql);
		query.setString(0, ck_ctlb);
		query.setString(1, ck_ywlb);
		query.setString(2, ck_jcyq);
		query.setString(3, ck_zxra_status);
		query.setString(4, ck_zxrb_status);
		query.setString(5, ck_scsj);
		query.setString(6, ck_zxra);
		query.setString(7, ck_zxra_name);
		query.setString(8, ck_zxrb);
		query.setString(9, ck_zxrb_name);
		query.setString(10, ck_scr);
		query.setString(11, ck_scr_name);
		return query.executeUpdate() == 1;
	}

}
