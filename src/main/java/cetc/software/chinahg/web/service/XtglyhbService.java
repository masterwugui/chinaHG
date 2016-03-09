package cetc.software.chinahg.web.service;

import java.util.List;

import cetc.software.chinahg.data.dataobject.PubXtglYhb;

public interface XtglyhbService {

	PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl);

	List<PubXtglYhb> getUserByFydm(String fydm);
}
