package ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	/*Generate a new universally unique ID for a user
	 * @return the uuid
	 */

	public String getNewUserUUID() {
		//init
		String uuid;
		Random rnd = new Random();
		int len = 6;
		boolean nonUnique;
		//continue looping until we get a unique ID 
		do {
			uuid="";
			for(int c = 0 ; c < len ; c++) {
				uuid += ((Integer)rnd.nextInt(10)).toString();
			}
			nonUnique = false;
			for(User u : this.users) {
				if(uuid.compareTo(u.getUUID())==0) {
					nonUnique = true;
					break;
				}
			}
			
		}while(nonUnique);
		return uuid;
	}
	public String getNewAccountUUID() {
		
	}
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
}
