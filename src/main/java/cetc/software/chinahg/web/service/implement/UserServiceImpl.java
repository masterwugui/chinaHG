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
		List<userCheckModel> modelList = checkDao.getCheckAListByYhAndStatus(
				yhbh, status);
		List<userCheckModel> modelList1 = checkDao.getCheckBListByYhAndStatus(
				yhbh, status);
		modelList.addAll(modelList1);
		for (userCheckModel model : modelList) {
			model.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
			model.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
			model.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
		}
		return modelList;
	}

	@Override
	public userCheckModel updateCheckStatus(int check_bh, int yhbh, String status,
			String qrsj) {
		checkModel model = checkDao.getCheckByCheckBh(check_bh);
		if (yhbh == model.getZxra_bh()) {
			if (status.equals("已确认")) {
				checkDao.confirmACheckStatus(yhbh, check_bh, status, qrsj);
			} else if (status.equals("已完成")) {
				checkDao.finishACheckStatus(yhbh, check_bh, status, qrsj);
			}
		} else if (yhbh == model.getZxrb_bh()) {
			if (status.equals("已确认")) {
				checkDao.confirmBCheckStatus(yhbh, check_bh, status, qrsj);
			} else if (status.equals("已完成")) {
				checkDao.finishBCheckStatus(yhbh, check_bh, status, qrsj);
			}
		}
		userCheckModel remodel = getUserCheckInfoByUserBhAndCheckBh(yhbh, check_bh);
		remodel.setCheckId(check_bh);
		remodel.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
		remodel.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
		remodel.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
		return remodel;
	}

	@Override
	public userCheckModel getUserCheckInfoByUserBhAndCheckBh(int yhbh, int ck_bh) {
		checkModel model = checkDao.getCheckByCheckBh(ck_bh);
		userCheckModel reModel = new userCheckModel();
		reModel.setScr_name(model.getScrName());
		reModel.setScsj(model.getScsj());
		reModel.setZxr_yhbh(yhbh);
		if (model.getZxra_bh() == yhbh) {
			reModel.setZxr_name(model.getZxra_name());
			reModel.setZxr_qrsj(model.getZxra_qrsj());
			reModel.setZxr_wcsj(model.getZxra_wcsj());
		} else if (model.getZxrb_bh() == yhbh) {
			reModel.setZxr_name(model.getZxrb_name());
			reModel.setZxr_qrsj(model.getZxrb_qrsj());
			reModel.setZxr_wcsj(model.getZxrb_wcsj());
		}
		return reModel;
	}
}
