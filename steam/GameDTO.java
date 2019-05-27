package steam;


public class GameDTO {
	private String gname;
	private String gtheme;
	private int gprice;
	private int gspec;
	private int grate;

	public GameDTO(String gname, String gtheme, int gprice, int gspec, int grate) {
		this.gname = gname;
		this.gtheme = gtheme;
		this.gprice = gprice;
		this.gspec = gspec;
		this.grate = grate;

	}

	public GameDTO() {

	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGtheme() {
		return gtheme;
	}

	public void setGtheme(String gtheme) {
		this.gtheme = gtheme;
	}

	public int getGprice() {
		return gprice;
	}

	public void setGprice(int gprice) {
		this.gprice = gprice;
	}

	public int getGspec() {
		return gspec;
	}

	public void setGspec(int gspec) {
		this.gspec = gspec;
	}

	public int getGrate() {
		return grate;
	}

	public void setGrate(int grate) {
		this.grate = grate;
	}

	@Override
	public String toString() {
		return  gname + "  " + gtheme + "   " + gprice + "   " + gspec + "   "+ grate ;
	}

}
