package org.vishal.projects.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vishal.projects.messanger.database.Database;
import org.vishal.projects.messanger.model.Comment;
import org.vishal.projects.messanger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Comment> getAllComments(long mid) {
		return new ArrayList<Comment>(messages.get(mid).getComments().values());
	}

	public Comment getComment(long mid, long cid) {
		return messages.get(mid).getComments().get(cid);
	}

	public Comment addComment(long mid, Comment comment) {
		comment.setId(messages.get(mid).getComments().size() + 1);
		messages.get(mid).getComments().put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long mid, Comment comment) {
		if (comment.getId() <= 0) {
			return null;
		} else {
			messages.get(mid).getComments().put(comment.getId(), comment);
		}
		return comment;
	}

	public void removeComment(long mid, long cid) {
		messages.get(mid).getComments().remove(cid);
		}
}
