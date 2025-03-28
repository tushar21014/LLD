package Entities;

public interface Voteable {
	void vote(User user, int value);
	int getVoteCount();
}
