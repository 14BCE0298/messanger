package org.vishal.projects.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.vishal.projects.messanger.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1 = new Message(1L, "This is message 1", "Vishal");
		Message m2 = new Message(2L, "This is message 2", "Sharma");
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(m1);
		messages.add(m2);
		
		return messages;
	}
}
