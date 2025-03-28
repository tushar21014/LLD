package Entities;

import java.util.*;
public interface Commentable {
	void addComment(Comment comment);
	List<Comment> getComments();
}
