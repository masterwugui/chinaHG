package cetc.software.chinahg.web.service;

import java.util.List;

import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

public interface UserService {
	List<userCheckModel> getCheckListByYhAndStatus(int yhbh, String status);
	
	userCheckModel updateCheckStatus(int check_bh, int yhbh, String status, String qrsj, String clyj);

	userCheckModel getUserCheckInfoByUserBhAndCheckBh(int yhbh, int checkId);
}
