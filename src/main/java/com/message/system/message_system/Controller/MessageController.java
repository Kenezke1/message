package com.message.system.message_system.Controller;

import com.message.system.message_system.Model.Message;
import com.message.system.message_system.Service.MessageService;
import com.message.system.message_system.exceptions.ConversationNotExistsException;
import com.message.system.message_system.exceptions.MessageNotFoundException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public Message findById(@RequestParam("messageId") Integer messageId){
        return null;
    }

    @GetMapping("/conversation")
    public List<Message> findByIdConversationId(@RequestParam("conversationId") Integer conversationId) throws ConversationNotExistsException {
        return messageService.findAllByConversationId(conversationId);
    }

    @PostMapping("")
    public Message sendMessage(@RequestBody String content,
                               @RequestParam("conversationId") Integer conversationId,
                               @RequestParam("sender") Integer sender) throws ConversationNotExistsException, UserNotFoundException {
        return messageService.sendMessage(conversationId,sender,content);
    }

    @PatchMapping("")
    public void editContent(@RequestBody String newContent,
                            @RequestParam("messageId") Integer messageId) throws ConversationNotExistsException, UserNotFoundException {
        messageService.editMessage(messageId, newContent);
    }

    @DeleteMapping("")
    public void deleteMessage(@RequestParam("messageId") Integer messageId) throws MessageNotFoundException {
        messageService.deleteMessage(messageId);
    }
}
