package com.message.system.message_system.Service.Impl;

import com.message.system.message_system.Model.Conversation;
import com.message.system.message_system.Model.Message;
import com.message.system.message_system.Model.User;
import com.message.system.message_system.Repository.ConversationRepository;
import com.message.system.message_system.Repository.MessageRepository;
import com.message.system.message_system.Repository.UserRepository;
import com.message.system.message_system.Service.MessageService;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.MessageNotFoundException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public List<Message> findAllByConversationId(Integer conversationId) throws ConversationNotExistsException {
        if(conversationRepository.findById(conversationId).isPresent()){
            return messageRepository.findAllByConversationId(conversationId);
        }
        throw new ConversationNotExistsException("Conversation with this ID not exists!");
    }

    @Override
    public Message sendMessage(Integer conversationId, Integer senderId, String content) throws ConversationNotExistsException, UserNotFoundException {
        Optional<Conversation> conversation = conversationRepository.findById(conversationId);
        if(!conversation.isPresent()){
            throw new ConversationNotExistsException("Conversation with this ID is not present!");
        }
        Optional<User> sender = userRepository.findById(senderId);
        if(!sender.isPresent()){
            throw new UserNotFoundException("User with this ID not present!");
        }
        Message message = Message.builder()
                .conversation(conversation.get())
                .sender(sender.get())
                .content(content)
                    .build();

        return messageRepository.saveAndFlush(message);
    }

    @Override
    public void editMessage(Integer messageId, String newContent) throws ConversationNotExistsException, UserNotFoundException {
        Optional<Message> message = messageRepository.findById(messageId);
        if(message.isPresent()){
            message.get().setContent(newContent);
            message.get().setEdited(true);
        }
    }

    @Override
    public void deleteMessage(Integer id) throws MessageNotFoundException {
        if(messageRepository.findById(id).isPresent()){
            messageRepository.deleteById(id);
        }


    }
}
