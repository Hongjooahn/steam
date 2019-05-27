package steam;

public class UserDTO1 {
	
	private String uname;
	private String uid;
	private String pw;
	private int uspec;
	private String uemail;
	private int ucash;
	private String utheme;
	private String ugamelist;
	private String ufriend;
	
	
	@Override
	public String toString() {
		return "UserDto [uname=" + uname + ", uid=" + uid + ", pw=" + pw + ", uspec=" + uspec + ", uemail=" + uemail
				+ ", ucash=" + ucash + ", utheme=" + utheme + ", ugamelist=" + ugamelist + ", ufriend=" + ufriend + "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getUspec() {
		return uspec;
	}
	public void setUspec(int uspec) {
		this.uspec = uspec;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public int getUcash() {
		return ucash;
	}
	public void setUcash(int ucash) {
		this.ucash = ucash;
	}
	public String getUtheme() {
		return utheme;
	}
	public void setUtheme(String utheme) {
		this.utheme = utheme;
	}
	public String getUgamelist() {
		return ugamelist;
	}
	public void setUgamelist(String ugamelist) {
		this.ugamelist = ugamelist;
	}
	public String getUfriend() {
		return ufriend;
	}
	public void setUfriend(String ufriend) {
		this.ufriend = ufriend;
	}
	
	
}
