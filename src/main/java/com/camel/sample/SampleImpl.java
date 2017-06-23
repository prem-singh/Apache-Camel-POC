package com.camel.sample;

import org.springframework.stereotype.Service;

@Service
public class SampleImpl implements SampleInterface {

	@Override
	public User getUser() {
		return getDummyUser();
	}

	private User getDummyUser() {
		User u = new User();
		u.setAge(25);
		u.setName("Bob");
		u.setEmail("bob@gmail.com");
		u.setJobTitle("Java Developer");
		return u;
	}

}
