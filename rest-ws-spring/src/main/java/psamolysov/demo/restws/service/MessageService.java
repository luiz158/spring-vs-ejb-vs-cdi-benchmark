package psamolysov.demo.restws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psamolysov.demo.restws.model.SpringResourceA;
import psamolysov.demo.restws.model.SpringResourceB;

@Service
public class MessageService {

	@Autowired
	private SpringResourceA aresource;
	
	@Autowired
	private SpringResourceB bresource;
	
	public String message() {
		return aresource.message() + bresource.message();
	}
}
