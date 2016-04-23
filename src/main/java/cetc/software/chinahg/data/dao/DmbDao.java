package cetc.software.chinahg.data.dao;

import java.util.List;

import cetc.software.chinahg.data.dataobject.ExamDmb;

public interface DmbDao {
	List<String> dmmsList(int lx);

	List<ExamDmb> dmbList(int lx);

	String getDmms(int lx, int dmbh);

	boolean insertDmb(int lx, int dmbh, String dmms);

	boolean updateDmb(int lx, int dmbh, String dmms);

	boolean deleteDmb(int lx, int dmbh);

	int getMaxDmbhByLx(int lx);
}
