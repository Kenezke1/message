package com.message.system.message_system.Controller;


import com.message.system.message_system.Model.Conversation;
import com.message.system.message_system.Service.ConversationService;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("")
    public Conversation findById(@RequestParam("conversationId") Integer conversationId) throws ConversationNotExistsException {
        return conversationService.findById(conversationId);
    }

    @GetMapping("/all")
    public List<Conversation> findAllByUserId(@RequestParam("userId") Integer userId) throws UserNotFoundException {
        return conversationService.findConversationsByUserId(userId);
    }

    @PostMapping("")
    public Conversation addConversarion(@RequestParam("participant1") Integer participant1,
                                        @RequestParam("participant2") Integer participant2) throws UserNotFoundException {
        return conversationService.addConversation(participant1,participant2);
    }
}
