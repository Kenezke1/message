package com.message.system.message_system.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConversationNotExistsException extends Exception {

    public ConversationNotExistsException() {
    }

    public ConversationNotExistsException(String message) {
        super(message);
    }

    public ConversationNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversationNotExistsException(Throwable cause) {
        super(cause);
    }
}
