package pakage;

import java.util.Scanner;

public class AddressManager {

	MenuManager menuManager = null;
	User[] userList = null;
	private final int USERLIST_COUNT = 3;

	public AddressManager() {
		this.menuManager = new MenuManager();
		userList = new User[USERLIST_COUNT];

		userList[0] = new User("김철수", "aa", "11", "010-1111-1111", "서울");
		userList[1] = new User("신짱구", "bb", "22", "010-2222-2222", "부산");
		userList[2] = new User("한유리", "cc", "33", "010-3333-3333", "인천");
	}

	public void run() {
		boolean end_flag = false;

		while (true) {
			this.menuManager.initMenu();
			int select = this.menuManager.selectInitMenu();

			switch (select) {
			case MenuManager.LOGIN:
				if (this.loginProcess()) {
					this.addressProcess();
				}
				break;
			case MenuManager.EXIT:
				end_flag = true;
				break;
			}

			if (end_flag) {
				break;
			}
		}
	}

	public boolean loginProcess() {
		Scanner input = new Scanner(System.in);

		System.out.print("ID: ");
		String id = input.nextLine();
		System.out.print("PW: ");
		String pw = input.nextLine();

		for (int i = 0; i < this.USERLIST_COUNT; i++) {
			if (id.equals(userList[i].getId()) && pw.equals(userList[i].getPw())) {
				userList[i].setLogin();
				return true;
			}
		}

		System.out.println("아이디, 비밀번호가 틀렸습니다.");
		return false;
	}

	public void addressProcess() {
		boolean end_flag = false;

		while (true) {
			this.menuManager.addressMenu();
			int select = this.menuManager.selectAddressMenu();

			switch (select) {
			case MenuManager.ADDRESS_SEARCH:
				this.addressSearch();
				break;
			case MenuManager.ALL_ADDRESS_SEARCH:
				this.allAddressSearch();
				break;
			case MenuManager.LOGOUT:
				this.logout();
				end_flag = true;
				break;
			}

			if (end_flag) {
				break;
			}
		}
	}

	public void addressSearch() {
		Scanner input = new Scanner(System.in);

		System.out.print("검색할 유저의 이름: ");
		String name = input.nextLine();

		boolean flag = false;

		for (int i = 0; i < this.USERLIST_COUNT; i++) {
			if (name.equals(userList[i].getName())) {
				System.out.println(name + "님의 주소: " + userList[i].getAddress());
				System.out.println(name + "님의 전화번호: " + userList[i].getPhone());

				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("입력하신 유저의 이름이 없습니다.");
		}

	}

	public void allAddressSearch() {
		for (int i = 0; i < this.USERLIST_COUNT; i++) {
			System.out.println(userList[i].getName()+"님의 주소: " + this.userList[i].getAddress());
			System.out.println(userList[i].getName()+"님의 전화번호: " + this.userList[i].getPhone());
		}
	}
	
	public void logout() {
		for (int i = 0; i < this.USERLIST_COUNT; i++) {
			if (userList[i].isLogin()) {
				System.out.println(userList[i].getName()+"님이 로그아웃하였습니다.");
				userList[i].logout();
			}
		}
	}

}
