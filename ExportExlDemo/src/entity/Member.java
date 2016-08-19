package entity;

import java.util.Date;
public class Member implements java.io.Serializable {

	// Fields

	private String id;

	private String checkOrg;

	private String sn;

	private String memberName;

	private String sex;

	private String cardId;

	private String duty;

	private String title;

	private String academic;

	private String special;

	private String workTime;

	private String memo;

	private String role;
	
	private Date lastModify;
	
    private Date regTime;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** full constructor */
	public Member(String checkOrg, String sn, String memberName, String sex,
			String cardId, String duty, String title, String academic,
			String special, String workTime, String memo, String role, Date lastModify, Date regTime) {
		this.checkOrg = checkOrg;
		this.sn = sn;
		this.memberName = memberName;
		this.sex = sex;
		this.cardId = cardId;
		this.duty = duty;
		this.title = title;
		this.academic = academic;
		this.special = special;
		this.workTime = workTime;
		this.memo = memo;
		this.role = role;
		this.lastModify = lastModify;
		this.regTime = regTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheckOrg() {
		return this.checkOrg;
	}

	public void setCheckOrg(String checkOrg) {
		this.checkOrg = checkOrg;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAcademic() {
		return this.academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getLastModify() {
		return lastModify;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}