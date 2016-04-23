package cetc.software.chinahg.web.service.implement;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.web.service.DmbService;

@Component("dmbService")
public class DmbServiceImpl implements DmbService {

	private DmbDao dmbDao;

	public DmbDao getDmbDao() {
		return dmbDao;
	}

	@Resource(name = "dmbDao")
	public void setDmbDao(DmbDao dmbDao) {
		this.dmbDao = dmbDao;
	}

	@Override
	public int getMaxDmbh(int lx) {
		int maxDmbh = dmbDao.getMaxDmbhByLx(lx) + 1;
		return maxDmbh;
	}

	@Override
	public void updateDmbh(int lx, int dmbh, String dmms) {
		dmbDao.deleteDmb(lx, dmbh);
		dmbDao.insertDmb(lx, dmbh, dmms);
	}

	@Override
	public void deleteDmbh(int lx, int dmbh) {
		dmbDao.deleteDmb(lx, dmbh);
	}
}
