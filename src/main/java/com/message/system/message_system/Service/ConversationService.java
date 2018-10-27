package com.message.system.message_system.Service;

import com.message.system.message_system.Model.Conversation;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;

import java.util.List;

public interface ConversationService {

    Conversation findById(Integer conversationId) throws ConversationNotExistsException;

    List<Conversation> findConversationsByUserId(Integer userId)throws UserNotFoundException;

    Conversation addConversation(Integer participant1Id,Integer participant2Id)throws UserNotFoundException;
}
