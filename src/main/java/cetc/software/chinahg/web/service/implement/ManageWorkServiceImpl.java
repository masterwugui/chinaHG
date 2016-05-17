package cetc.software.chinahg.web.service.implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cetc.software.chinahg.data.dao.CheckDao;
import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.data.dao.XtglyhbDao;
import cetc.software.chinahg.util.UtilCommon;
import cetc.software.chinahg.web.service.ManageWorkService;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;
import cetc.software.ksxt.web.service.model.zghgUserModel;

@Component("manageWorkService")
public class ManageWorkServiceImpl implements ManageWorkService {

	private DmbDao dmbDao;

	public DmbDao getDmbDao() {
		return dmbDao;
	}

	@Resource(name = "dmbDao")
	public void setDmbDao(DmbDao dmbDao) {
		this.dmbDao = dmbDao;
	}

	private XtglyhbDao xtglyhbDao;

	public XtglyhbDao getXtglyhbDao() {
		return xtglyhbDao;
	}

	@Resource(name = "xtglyhbDao")
	public void setXtglyhbDao(XtglyhbDao xtglyhbDao) {
		this.xtglyhbDao = xtglyhbDao;
	}

	private CheckDao checkDao;

	public CheckDao getcheckDao() {
		return checkDao;
	}

	@Resource(name = "checkDao")
	public void setcheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	@Override
	public checkModel cqUser(int cd, int ywlb, int jcyq, String scrYhmc,
			int scrYhbh, String scsj) {
		List<Integer> userToBeChooseList = xtglyhbDao.getUserToBeChooseList();
		HashSet<Integer> zxrSet = UtilCommon.randomSelectQue(
				userToBeChooseList, 2);
		List<zghgUserModel> modelList = new ArrayList<zghgUserModel>();
		Iterator<Integer> iterator = zxrSet.iterator();
		while (iterator.hasNext()) {
			modelList.add(xtglyhbDao.getUser(iterator.next()));
		}
		zghgUserModel zxrA = modelList.get(0);
		zghgUserModel zxrB = modelList.get(1);

		String NotStarted = "未开始";
		int hasBeenSelected = 1;
		// aborted
		// checkDao.insertNewCheck(cd, ywlb, jcyq, NotStarted, NotStarted, scsj,
		// zxrA.getYhbh(), zxrA.getYhmc(), zxrB.getYhbh(), zxrB.getYhmc(),
		// scrYhbh, scrYhmc);

		checkDao.insertNewCheck(cd, ywlb, jcyq, scsj, scrYhbh);
		int checkId = checkDao.getMaxCheckId();
		checkDao.insertNewCheckYH(checkId, zxrA.getYhbh(), NotStarted);
		checkDao.insertNewCheckYH(checkId, zxrB.getYhbh(), NotStarted);
		checkDao.updateYhStatus(zxrA.getYhbh(), hasBeenSelected);
		checkDao.updateYhStatus(zxrB.getYhbh(), hasBeenSelected);
		

		checkModel model = new checkModel();
		model.setCk_bh(checkId);
		model.setJcyq(jcyq);
		model.setYwlb(ywlb);
		model.setCd(cd);
		model.setZxra_name(zxrA.getYhmc());
		model.setZxra_status(NotStarted);
		model.setZxrb_name(zxrB.getYhmc());
		model.setZxrb_status(NotStarted);

		return model;
	}

	private static int CDLX1 = 1, CDLX2 = 2, CDLX3 = 3, JCNR = 4, JCYQ = 5,
			YWLB = 6;

	@Override
	public List<checkModel> getCheckList() {
		List<userCheckModel> modelList = checkDao.getCheckListNew();
		List<checkModel> reModelList = new ArrayList<checkModel>();
		List<Integer> reList = new ArrayList<Integer>();
		for (userCheckModel model1 : modelList) {
			for (userCheckModel model2 : modelList) {
				int checkId = model1.getCheckId();
				if (checkId == model2.getCheckId()
						&& model1.getZxr_yhbh() != model2.getZxr_yhbh()) {
					if (!reList.contains(checkId)) {
						reList.add(checkId);
						checkModel reModel = new checkModel();
						reModel.setCk_bh(checkId);
						reModel.setCd(model1.getCd());
						reModel.setJcyq(model1.getJcyq());
						reModel.setYwlb(model1.getYwlb());
						reModel.setZxra_name(model1.getZxr_name());
						reModel.setZxrb_name(model2.getZxr_name());
						reModel.setZxra_status(model1.getZxr_status());
						reModel.setZxrb_status(model2.getZxr_status());

						reModel.setCdChn(dmbDao.getDmms(CDLX1, reModel.getCd()));
						reModel.setJcyqChn(dmbDao.getDmms(JCYQ,
								reModel.getJcyq()));
						reModel.setYwlbChn(dmbDao.getDmms(YWLB,
								reModel.getYwlb()));

						reModelList.add(reModel);
					}
				}
			}
		}
		return reModelList;
	}

	@Override
	public List<userCheckModel> searchChecks(int yhbh, int cd, int ywlb,
			int jcyq, String startScsj, String endScsj, String startWcsj,
			String endWcsj) {
		List<userCheckModel> modelList = checkDao.getCheckListByYhAndStatus(
				yhbh, cd, ywlb, jcyq, startScsj, endScsj, startWcsj, endWcsj);
		for (userCheckModel model : modelList) {
			model.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
			model.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
			model.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
			model.setScr_name(xtglyhbDao.getUser(model.getScr_bh()).getYhmc());
			model.setZxr_name(xtglyhbDao.getUser(model.getZxr_yhbh()).getYhmc());
		}
		return modelList;
	}

	@Override
	public boolean deleteCheck(int checkId) {
		checkDao.deleteCheck(checkId);
		List<Integer> yhList = checkDao.getYhByCheckId(checkId);
		int hasFinishedJob = 0;
		for(int yhbh : yhList){
			checkDao.updateYhStatus(yhbh, hasFinishedJob);
		}
		checkDao.deleteCheckYh(checkId);
		return false;
	}

}
