package com.message.system.message_system.Service.Impl;

import com.message.system.message_system.Model.Conversation;
import com.message.system.message_system.Model.User;
import com.message.system.message_system.Repository.ConversationRepository;
import com.message.system.message_system.Repository.UserRepository;
import com.message.system.message_system.Service.ConversationService;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Conversation findById(Integer conversationId) throws ConversationNotExistsException {
        Optional<Conversation> conversation = conversationRepository.findById(conversationId);
        if(conversation.isPresent()){
            return conversation.get();
        }
        throw new ConversationNotExistsException("Conversation with this ID not present!");
    }

    @Override
    public List<Conversation> findConversationsByUserId(Integer userId) throws UserNotFoundException {
        if(!userRepository.findById(userId).isPresent()){
            throw new UserNotFoundException("User with this ID not present!");
        }
        return conversationRepository.findAllByUserId(userId);
    }

    @Override
    public Conversation addConversation(Integer participant1Id, Integer participant2Id) throws UserNotFoundException {
        Optional<User> participant1 = userRepository.findById(participant1Id);
        Optional<User> participant2 = userRepository.findById(participant2Id);

        if(!participant1.isPresent()){
            throw new UserNotFoundException("Participant 1 not exists!");
        }
        if (!participant2.isPresent()){
            throw new UserNotFoundException("Participant 2 not exists!");
        }

        Conversation newConversation = Conversation.builder()
                    .participant1(participant1.get())
                    .participant2(participant2.get())
                        .build();

        return conversationRepository.saveAndFlush(newConversation);
    }
}
