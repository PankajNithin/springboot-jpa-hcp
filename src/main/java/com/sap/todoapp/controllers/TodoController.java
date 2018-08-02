package com.sap.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.todoapp.services.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/sapwebapi/app/gettodo",method=RequestMethod.GET)
	public ResponseEntity<?> getOneTodoById(@RequestParam("id") Long id){
		try{
			return ResponseEntity.
					status(HttpStatus.OK).
					body(todoService.getTodoFromId(id));
		}catch(Exception e){
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).
					body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/sapwebapi/app/getall",method=RequestMethod.GET)
	public ResponseEntity<?> getAllTodos(){
		try{
			return ResponseEntity.
					status(HttpStatus.OK).
					body(todoService.getAllEntries());
		}catch(Exception e){
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).
					body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/sapwebapi/app/addonetodo",method=RequestMethod.POST)
	public ResponseEntity<?> saveOneTodo(@RequestParam("item") String item){
		try{
			
			todoService.addNewTodo(item);
			
			return ResponseEntity.
					status(HttpStatus.OK).
					body("Successfully added a ne item");
		}catch(Exception e){
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).
					body(e.getMessage());
		}
	}
	
}
