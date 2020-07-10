
public class MountainBean {
	private int no;
	private String name;
	private String place;
	private String top;
	private String who;
	private String phone;
	
	
	public MountainBean(int no, String name, String place, String top, String who) {
		super();
		this.no = no;
		this.name = name;
		this.place = place;
		this.top = top;
		this.who = who;
	}
	public MountainBean() {
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
