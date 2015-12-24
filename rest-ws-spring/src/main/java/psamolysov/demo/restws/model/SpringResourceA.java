package psamolysov.demo.restws.model;

import org.springframework.stereotype.Component;

@Component
public class SpringResourceA {

	public String message() {
		return "A#" + System.currentTimeMillis();
	}
}
