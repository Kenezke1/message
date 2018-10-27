package com.message.system.message_system.Repository;

import com.message.system.message_system.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    @Override
    Optional<Message> findById(Integer id);

    List<Message> findAllByConversationId(Integer conversationId);

}
