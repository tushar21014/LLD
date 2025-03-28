package Entities;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class StackOverflow {
	private final Map<Integer, User> users;
	private final Map<Integer, Question> questions;
	private final Map<Integer, Answer> answers;
	private final Map<String, Tag> tags;
	
	public StackOverflow()
	{
		users = new ConcurrentHashMap<Integer, User>();
		questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
	}
	
	public User createUser(String username, String email)
	{
		int id = users.size()+1;
		User user = new User(username,email);
		users.put(id, user);
		System.out.print("User Created\n");
		return user;
	}
	
	public Question askQuestion(User user, String title, String content, List<String> tags)
	{
		Question question = user.askQuestion(title, content, tags);
		questions.put(question.getId(), question);
		for (Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return question;
	}
	
	public Answer answerQuestion(User user, Question question, String Content)
	{
		Answer answer = user.answerQuestion(question, Content);
		answers.put(answer.getId(), answer);
		return answer;
	}
	
	public Comment addComment(User user,Commentable commentable, String content) {
		return user.addComment(commentable, content);
	}
	
	public void voteQuestion(User user, Question question, int value)
	{
		question.vote(user, value);
	}
	
	public void voteAnswer(User user, Answer answer, int value)
	{
		answer.vote(user, value);
	}
	
    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }
    
    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }
    
	
	
}
