package cetc.software.chinahg.web.service;

import java.util.List;

import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

public interface ManageWorkService {
	checkModel cqUser(int cd, int ywlb, int jcyq, String scrYhmc, int scrYhbh, String scsj);
	
	List<checkModel> getCheckList();
	
}
