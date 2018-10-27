package com.message.system.message_system.Repository;

import com.message.system.message_system.Model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation,Integer> {

    @Override
    Optional<Conversation> findById(Integer integer);

    @Query(nativeQuery = true,value = "SELECT * FROM conversations WHERE participant_1 = ?1 OR participant_2 = ?1")
    List<Conversation> findAllByUserId(Integer userId);
}
