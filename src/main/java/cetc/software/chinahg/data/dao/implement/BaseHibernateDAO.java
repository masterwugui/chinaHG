package cetc.software.chinahg.data.dao.implement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseHibernateDAO extends HibernateDaoSupport {
	protected HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	protected Session getMySession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
}
