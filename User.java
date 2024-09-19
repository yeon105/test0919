package pakage;

public class User {

	private String name = null;
	private String id = null;
	private String pw = null;
	private String phone = null;
	private String address = null;
	private boolean login_state = false;

	public User(String pname, String pid, String ppw, String pphone, String paddress) {
		this.name = pname;
		this.id = pid;
		this.pw = ppw;
		this.phone = pphone;
		this.address = paddress;
	}

	public boolean isLogin() {
		return this.login_state;
	}

	public void setLogin() {
		this.login_state = true;
	}

	public void logout() {
		this.login_state = false;
	}

	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}
}
