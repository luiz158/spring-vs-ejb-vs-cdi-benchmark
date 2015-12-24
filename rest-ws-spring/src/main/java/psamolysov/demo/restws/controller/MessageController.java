package psamolysov.demo.restws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import psamolysov.demo.restws.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService service;
	
	@RequestMapping(path = "/message", method = RequestMethod.GET, 
			produces = "text/plain")
	public String message() {
		return service.message();
	}
}
