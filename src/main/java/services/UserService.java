package services;

import Entities.User;
import dao.UserDao;

public class UserService {
	private UserDao userDAO;

    public UserService(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, Integer age, String job) {
        // You can add validation or other business logic here if needed

        // Create a new user
        User newUser = new User(name, age, job);

        // Save the user using the UserDAO
        userDAO.save(newUser);
    }
}
