package org.vishal.projects.messanger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vishal.projects.messanger.model.Message;
import org.vishal.projects.messanger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService MessageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return MessageService.getAllMessages();
	}
}
