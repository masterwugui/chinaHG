package cetc.software.chinahg.web.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.XtglyhbDao;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.chinahg.web.service.XtglyhbService;
import cetc.software.ksxt.web.service.model.zghgUserModel;

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
		PubXtglYhb pubXtglYhb = xtglyhbDao.getXtglyhbByYhdmYhkl(yhdm, yhkl);
		return pubXtglYhb;
	}

	@Override
	public boolean insertNewHgUser(String yhdm, String yhkl, String yhmc,
			Integer permission, String yh_duty, String yh_jobNum,
			String yh_lineNum, String yh_phoneNum, String yh_email,
			String yh_address) {
		return xtglyhbDao.insertNewHgUser(yhdm, yhkl, yhmc, permission,
				yh_duty, yh_jobNum, yh_lineNum, yh_phoneNum, yh_email,
				yh_address);
	}

	@Override
	public boolean deleteXtglyhb(Integer yhbh) {
		return xtglyhbDao.deleteXtglyhb(yhbh);
	}

	@Override
	public List<zghgUserModel> getUserList() {
		return xtglyhbDao.getUserList();
	}

	@Override
	public boolean insertNewHgUser(String yhdm, String yhkl) {
		return xtglyhbDao.insertNewHgUser(yhdm, yhkl);
	}

}
