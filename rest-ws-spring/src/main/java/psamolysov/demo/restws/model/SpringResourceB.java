package psamolysov.demo.restws.model;

import org.springframework.stereotype.Component;

@Component
public class SpringResourceB {

	public String message() {
		return "B#" + System.currentTimeMillis();
	}
}
