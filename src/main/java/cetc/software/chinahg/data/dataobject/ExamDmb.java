package cetc.software.chinahg.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pub_dmb")
public class ExamDmb {

	private int LX;

	private int DMBH;

	private String DMMS;

	@Column(name = "LX")
	public int getLX() {
		return LX;
	}

	public void setLX(int lX) {
		LX = lX;
	}

	@Column(name = "DMBH")
	public int getDMBH() {
		return DMBH;
	}

	public void setDMBH(int dMBH) {
		DMBH = dMBH;
	}

	@Id
	@Column(name = "DMMS")
	public String getDMMS() {
		return DMMS;
	}

	public void setDMMS(String dMMS) {
		DMMS = dMMS;
	}
	
	
}
