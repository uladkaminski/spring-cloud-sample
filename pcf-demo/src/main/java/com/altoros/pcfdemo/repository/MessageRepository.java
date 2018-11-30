package com.altoros.pcfdemo.repository;

import com.altoros.pcfdemo.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAll();
}
