package cetc.software.chinahg.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

public class ServerDialect extends SQLServerDialect {
	public ServerDialect() {
		super();
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
		registerHibernateType(Types.LONGVARCHAR, Hibernate.LONG.getName());
		registerHibernateType(Types.LONGVARBINARY, Hibernate.BLOB.getName());
	}
}
