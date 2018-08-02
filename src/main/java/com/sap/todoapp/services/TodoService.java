package com.sap.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.todoapp.models.TodoModel;
import com.sap.todoapp.repositories.TodoRepo;

@Service
public class TodoService {

	@Autowired
	private TodoRepo todoRepo;
	
	public Iterable<TodoModel> getAllEntries() throws Exception{
		return todoRepo.findAll();
	}
	
	public TodoModel getTodoFromId(Long id) throws Exception{
		return todoRepo.findOne(id);
	}
	
	public void addNewTodo(String description) throws Exception{
		TodoModel todoModel = new TodoModel();
		todoModel.setToDo(description);
		
		todoRepo.save(todoModel);
	}
}
