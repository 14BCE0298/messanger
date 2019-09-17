package org.vishal.projects.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vishal.projects.messanger.database.Database;
import org.vishal.projects.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public Message addMessage(Message message) {
		message.setId(messages.get(messages.size()).getId() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0 ) {
			return null;
		} else {
			messages.put(message.getId(), message);
		}
		return message;
	}
	
	public Message removeMessage(Long Id) {
		return messages.remove(Id);
	}
}
