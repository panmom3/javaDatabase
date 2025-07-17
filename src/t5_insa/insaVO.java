package t5_insa;

public class insaVO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String ipsail;
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
	@Override
	public String toString() {
		return "insaVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", ipsail=" + ipsail + "]";
	}
	
	
}
