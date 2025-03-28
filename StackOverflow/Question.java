package Entities;

import java.util.*;

public class Question implements Commentable, Voteable {
	private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;
    
    public Question(User author, String title, String content, List<String> tagNames)
    {
    	this.id = generateId();
    	this.author = author;
    	this.title = title;
    	this.content = content;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        for(String i : tagNames)
        {
        	this.tags.add(new Tag(i));
        }
    }
    
    public void addAnswers(Answer answer)
    {
    	answers.add(answer);
    	return;
    }
    
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	@Override
	public List<Comment> getComments() {
		return comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		comments.add(comment);
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
