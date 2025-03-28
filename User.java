package Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private final int id;
	private final String username;
	private int reputation;
	private final String email;	
	private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;
	
    public User(String username, String email)
    {
    	this.id = generateId();
        this.username = username;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }
    
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
    
    public Question askQuestion(String title, String content, List<String> tags)
    {
    	Question q = new Question(this,title,content,tags);
    	questions.add(q);
    	return q;
    }
    
    public Answer answerQuestion(Question question, String content)
    {
    	Answer answer = new Answer(this,question,content);
    	answers.add(answer);
    	question.addAnswers(answer);	
    	return answer;
    }
    
    public Comment addComment(Commentable commentable, String content)
    {
    	Comment comment = new Comment(this, content);
    	comments.add(comment);
    	commentable.addComment(comment);
    	return comment;
    }
    
    
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public int getReputation() {
		return reputation;
	}

	public String getEmail() {
		return email;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<Comment> getComments() {
		return comments;
	}
    
}
