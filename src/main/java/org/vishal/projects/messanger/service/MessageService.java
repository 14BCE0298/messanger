package org.vishal.projects.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.vishal.projects.messanger.database.Database;
import org.vishal.projects.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getMessagesByYear(int year) {
		List<Message> messagesInYearList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year) {
				messagesInYearList.add(message);
			}
		}
		return messagesInYearList;
	}
	
	public List<Message> getMessagesByPagination(int start, int size) {
		List<Message> messagesByPagnationList = new ArrayList<Message>(messages.values());
		return messagesByPagnationList.size() <= size ? messagesByPagnationList 
												: messagesByPagnationList
												.subList(start, ((start + size) < messagesByPagnationList.size()
														? (start + size) : messagesByPagnationList.size()));
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
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
	
	public void removeMessage(Long Id) {
		messages.remove(Id);
	}
}
