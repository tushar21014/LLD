package Entities;

import java.util.*;
public class Comment {
	private final int id;
	private final User user;
	private final String content;
	private final Date creationTime;
	
	public Comment(User user, String content) {
		this.id = generateId();
		this.user = user;
		this.content = content;
		this.creationTime = new Date();		
	}
	
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

	public User getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	
	
}
