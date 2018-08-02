package com.sap.todoapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sap.todoapp.models.TodoModel;

public interface TodoRepo extends CrudRepository<TodoModel, Long> {
}