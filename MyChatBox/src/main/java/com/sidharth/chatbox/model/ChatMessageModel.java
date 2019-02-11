package com.sidharth.chatbox.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageModel {
	
	private MessageType type;
	private String content;
	private String sender;

	public enum MessageType {
		JOIN,
		CHAT,
		LEAVE
	}
}
