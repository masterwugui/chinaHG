package cetc.software.chinahg.web.service;

public interface DmbService {
	int getMaxDmbh(int lx);
	
	void updateDmbh(int lx, int dmbh, String dmms);
	
	void deleteDmbh(int lx, int dmbh);
}
