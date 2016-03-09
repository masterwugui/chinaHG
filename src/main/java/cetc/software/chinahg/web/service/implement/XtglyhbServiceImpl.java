package cetc.software.chinahg.web.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.XtglyhbDao;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.chinahg.dynamicds.DataSourceEnum;
import cetc.software.chinahg.dynamicds.DataSourceRouter;
import cetc.software.chinahg.web.service.XtglyhbService;


@Component("xtglyhbService")
public class XtglyhbServiceImpl implements XtglyhbService {
	private XtglyhbDao xtglyhbDao;

	public XtglyhbDao getXtglyhbDao() {
		return xtglyhbDao;
	}

	@Resource(name = "xtglyhbDao")
	public void setXtglyhbDao(XtglyhbDao xtglyhbDao) {
		this.xtglyhbDao = xtglyhbDao;
	}

	@Override
	public PubXtglYhb getXtglyhbByYhdmYhkl(String yhdm, String yhkl) {
		DataSourceRouter.routerTo(DataSourceEnum.DEFAULT.getFydm());
		PubXtglYhb pubXtglYhb  = xtglyhbDao.getXtglyhbByYhdmYhkl(yhdm, yhkl);
		return pubXtglYhb;
	}

	@Override
	public List<PubXtglYhb> getUserByFydm(String fydm) {
		return xtglyhbDao.getUserByFydm(fydm);
	}

}
