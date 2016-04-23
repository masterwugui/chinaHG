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
	public checkModel cqUser(int cd, int ywlb, int jcyq, String scrYhmc, int scrYhbh, String scsj) {
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
		checkDao.insertNewCheck(cd, ywlb, jcyq, NotStarted, NotStarted, scsj, zxrA.getYhbh(),
				zxrA.getYhmc(), zxrB.getYhbh(), zxrB.getYhmc(), scrYhbh, scrYhmc);
		
		checkModel model = new checkModel();
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
		List<checkModel> modelList = checkDao.getCheckList();
		for(checkModel model : modelList){
			model.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
			model.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
			model.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
		}
		return modelList;
	}

}
