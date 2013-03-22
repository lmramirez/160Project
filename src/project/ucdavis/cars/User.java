package project.ucdavis.cars;

//As far as I can think, we only care about userId and if they're an Admin or not. 
//If you want to add any other variables, go ahead, otherwise, I think union suits our needs quite nicely.
//This DOES support logging in/out as far as I understand

public class User {
	static int userId;
	static boolean isAdmin;
	
	public User()	{
		
	}
	public static void setUserId(int uid)	{
		User.userId = uid;
	}
	public static void setIsAdmin(boolean ia)	{
		User.isAdmin = ia;
	}
}
