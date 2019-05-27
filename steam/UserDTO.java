package steam;


public class UserDTO {
	private String uname;
	private String uid;
	private String pw;
	private int uspec;
	private String uemail;
	private int ucash;
	private String ugamelist;
	private String ufriend;
	private String utheme;

	
	public UserDTO() {
		
	}
	public int getUcash() {
		return ucash;
	}

	public void setUcash(int ucash) {
		this.ucash = ucash;
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

	public String getUtheme() {
		return utheme;
	}

	public void setUtheme(String utheme) {
		this.utheme = utheme;
	}
}
