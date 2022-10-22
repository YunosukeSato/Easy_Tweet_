package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private String userName; // User name
	private String text; // tweet
	
	public Mutter() {}
	
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}
	
	
}
