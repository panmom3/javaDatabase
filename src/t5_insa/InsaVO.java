package t5_insa;

public class InsaVO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String ipsail;
	
	// 사용자가 작업에 필요한 변수들을 필드로 등록한다.
	private String cbYY;  //년도
	private String cbMM;  //월
	private String cbDD;  //일
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIpsail() {
		return ipsail;
	}
	public void setIpsail(String ipsail) {
		this.ipsail = ipsail;
	}
	public String getCbYY() {
		return cbYY;
	}
	public void setCbYY(String cbYY) {
		this.cbYY = cbYY;
	}
	public String getCbMM() {
		return cbMM;
	}
	public void setCbMM(String cbMM) {
		this.cbMM = cbMM;
	}
	public String getCbDD() {
		return cbDD;
	}
	public void setCbDD(String cbDD) {
		this.cbDD = cbDD;
	}
	@Override
	public String toString() {
		return "InsaVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", ipsail=" + ipsail
				+ ", cbYY=" + cbYY + ", cbMM=" + cbMM + ", cbDD=" + cbDD + "]";
	}
}
