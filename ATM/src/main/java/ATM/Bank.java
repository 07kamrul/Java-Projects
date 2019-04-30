package ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;

	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
	}
	
	/*
	 * Generate a new universally unique ID for a user
	 * 
	 * @return the uuid
	 */

	
	public String getNewUserUUID() {
		// init
		String uuid;
		Random rnd = new Random();
		int len = 3;
		boolean nonUnique;
		// continue looping until we get a unique ID
		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer) rnd.nextInt(10)).toString();
			}
			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}

		} while (nonUnique);
		return uuid;
	}

	public String getNewAccountUUID() {
		// init
		String uuid;
		Random rnd = new Random();
		int len = 10;
		boolean nonUnique;
		// continue looping until we get a unique ID
		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer) rnd.nextInt(10)).toString();
			}
			nonUnique = false;
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}

		} while (nonUnique);
		return uuid;
	}

	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}

	public User addUser(String firstName, String lastName, String pin) {

		// create a new user objects add it to our list
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);

		// create a savings account for the user
		Account newAccount = new Account("savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		return newUser;
	}

	public User userLogin(String userID, String pin) {
		for (User u : this.users) {
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		return null;
	}
}
