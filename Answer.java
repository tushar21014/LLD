package Entities;

import java.util.*;

public class Answer implements Commentable, Voteable {
	private final int id;
	private final Question question;
	private final User author;
	private final String content;
	private final List<Vote> votes;
    private boolean isAccepted;
    private final Date creationDate;
    private final List<Comment> comments;
    
    
    
	public Answer(User author, Question question,  String content) {
		this.id = generateId();
		this.question = question;
		this.author = author;
		this.content = content;
		this.votes = new ArrayList<>();
		this.isAccepted = false;
		this.comments = new ArrayList<>();
		this.creationDate = new Date();
	}

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
    
	public boolean isAccepted() {
		return isAccepted;
	}
	
	public int getId() {
		return id;
	}
	public Question getQuestion() {
		return question;
	}
	public User getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		comments.add(comment);
		return;
		
	}
	
	public void markAsAccepted() {
		if(isAccepted) {
			throw new IllegalStateException("This answer is already accepted");
		}else {
			isAccepted = true;
		}
	}

	@Override
	public void vote(User user, int value) {
		// TODO Auto-generated method stub
		if(value != 1 || value != -1)
		{
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
		}
		
		votes.removeIf(v -> v.getUser().equals(user));
		votes.add(new Vote(user, value));
	}

	@Override
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return votes.stream().mapToInt(Vote::getValue).sum();
	}
    
	
}
