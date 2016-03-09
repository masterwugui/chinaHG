package cetc.software.chinahg.data.dataobject;

// default package
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XtglyhbDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "XKXT_USER")
public class PubXtglYhb implements java.io.Serializable {
	private static final long serialVersionUID = 5741160517159659452L;
	private Integer yhbh;
	private String yhdm;
	private String yhmc;
	private String yhkl;
	private String permission;
	/** default constructor */
	public PubXtglYhb() {
		this.yhbh = -1;
	}

	/** minimal constructor */
	public PubXtglYhb(Integer yhbh) {
		this.yhbh = yhbh;
	}

	public PubXtglYhb(Integer yhbh, String yhdm, String yhmc, String yhkl,
			String yhbm,String fydm,String permission) {
		super();
		this.yhbh = yhbh;
		this.yhdm = yhdm;
		this.yhmc = yhmc;
		this.yhkl = yhkl;
		this.permission=permission;
	
	}

	// Property accessors
	@Id
	@Column(name = "YHBH", unique = true, nullable = false)
	public Integer getYhbh() {
		return this.yhbh;
	}

	public void setYhbh(Integer yhbh) {
		this.yhbh = yhbh;
	}

	@Column(name = "YHDM", length = 10)
	public String getYhdm() {
		return this.yhdm;
	}

	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}

	@Column(name = "YHMC", length = 20)
	public String getYhmc() {
		return this.yhmc;
	}

	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}

	@Column(name = "YHKL", length = 20)
	public String getYhkl() {
		return this.yhkl;
	}

	public void setYhkl(String yhkl) {
		this.yhkl = yhkl;
	}

	@Column(name = "permission")
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}