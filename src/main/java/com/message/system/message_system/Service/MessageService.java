package com.message.system.message_system.Service;

import com.message.system.message_system.Model.Message;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.MessageNotFoundException;
import com.message.system.message_system.exceptions.UserNotFoundException;

import java.util.List;

public interface MessageService {

    List<Message> findAllByConversationId(Integer conversationId) throws ConversationNotExistsException;

    Message sendMessage(Integer conversationId, Integer senderId, String content) throws ConversationNotExistsException,UserNotFoundException;

    void editMessage(Integer messageId, String newContent) throws  ConversationNotExistsException,UserNotFoundException;

    void deleteMessage(Integer id) throws MessageNotFoundException;
}
