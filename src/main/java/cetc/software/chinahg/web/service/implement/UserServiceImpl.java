package cetc.software.chinahg.web.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.CheckDao;
import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.web.service.UserService;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

@Component("userService")
public class UserServiceImpl implements UserService {

	private static int CDLX1 = 1, CDLX2 = 2, CDLX3 = 3, JCNR = 4, JCYQ = 5,
			YWLB = 6;
	private CheckDao checkDao;

	public CheckDao getcheckDao() {
		return checkDao;
	}

	@Resource(name = "checkDao")
	public void setcheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	private DmbDao dmbDao;

	public DmbDao getDmbDao() {
		return dmbDao;
	}

	@Resource(name = "dmbDao")
	public void setDmbDao(DmbDao dmbDao) {
		this.dmbDao = dmbDao;
	}

	@Override
	public List<userCheckModel> getCheckListByYhAndStatus(int yhbh,
			String status) {
		List<userCheckModel> modelList = checkDao.getCheckListByYhAndStatus(
				yhbh, status);
		for (userCheckModel model : modelList) {
			model.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
			model.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
			model.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
		}
		return modelList;
	}

	@Override
	public userCheckModel updateCheckStatus(int check_bh, int yhbh,
			String status, String qrsj) {
		
		if (status.equals("已确认")) {
			checkDao.confirmCheckStatus(yhbh, check_bh, status, qrsj);
		} else if (status.equals("已完成")) {
			checkDao.finishCheckStatus(yhbh, check_bh, status, qrsj);
		}
		
		userCheckModel remodel = checkDao.getCheckByCheckBhAndYhbh(yhbh, check_bh);
		remodel.setCheckId(check_bh);
		remodel.setCdChn(dmbDao.getDmms(CDLX1, remodel.getCd()));
		remodel.setJcyqChn(dmbDao.getDmms(JCYQ, remodel.getJcyq()));
		remodel.setYwlbChn(dmbDao.getDmms(YWLB, remodel.getYwlb()));
		return remodel;
	}

	@Override
	public userCheckModel getUserCheckInfoByUserBhAndCheckBh(int yhbh,
			int checkId) {
		return checkDao.getCheckByCheckBhAndYhbh(yhbh, checkId);
	}
}
