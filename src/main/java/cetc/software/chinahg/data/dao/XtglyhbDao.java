package cetc.software.chinahg.data.dao;

import java.util.List;

import cetc.software.chinahg.data.dataobject.PubXtglYhb;

public interface XtglyhbDao {
	PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl);
	PubXtglYhb getXtglyhbByYhdmYhklFydm(String yhdm, String yhkl,String fydm);
	PubXtglYhb getXtglyhbByYhdmFydm(String yhdm, String fydm);

	List<PubXtglYhb> getUserByFydm(String fydm);

	boolean updatePermission(int id, String permission);

	String getPermission(int id);

	boolean insertUser(String yhdm, String yhmc, String yhkl, String fydm,
			String permission);

	List<PubXtglYhb> getRealUser();

	List<PubXtglYhb> getAllUser();
}
