package ua.andriosta.raiywayservice.pojo.users;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private ArrayList<User> list = new ArrayList<User>();

	public UserService() {
		list.add(new User("andriy", "krit12"));
	}

	public String checkUser(User user) {

		if (list.contains(user))

			return "succes";

		return "failed";
	}

	public String createUser(User user) {

		if (isExistUser(user)) {

			return "exist";
		}

		else {

			list.add(user);

			return "success";
		}
	}

	public boolean isExistUser(User existUser) {

		for (User user : list) {
			if (user.getUsername().equals(existUser.getUsername()))
				return true;
		}
		return false;
	}
}
