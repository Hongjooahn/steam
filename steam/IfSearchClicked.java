package steam;

import javax.swing.JOptionPane;

public class IfSearchClicked {
	int select;
	String[] yesorno = { "FPS", "ffss", "RPG", "Adventure", "Action" };
	public IfSearchClicked() {
		String selecttheme = "";
		
		select = JOptionPane.showOptionDialog(null, "테마를 선택해주세요", "회원탈퇴?", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, yesorno, null);
		switch (select) {
		case 0:
			selecttheme = "FPS";
			break;
		case 1:
			selecttheme = "ffss";
			break;
		case 2:
			selecttheme = "RPG";
			break;
		case 3:
			selecttheme = "Adventure";
			break;
		case 4:
			selecttheme = "Action";
			break;

		}

		System.out.println(selecttheme);

		SteamShop sp = new SteamShop(4, selecttheme);
	}
}
