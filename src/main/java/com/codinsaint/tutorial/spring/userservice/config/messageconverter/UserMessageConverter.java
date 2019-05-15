package com.codinsaint.tutorial.spring.userservice.config.messageconverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.codinsaint.tutorial.spring.userservice.model.User;

public class UserMessageConverter extends AbstractHttpMessageConverter<User> {

	public UserMessageConverter() {
		super(new MediaType("text", "user"));
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		String requestMessage = toUserMessage(inputMessage.getBody());
		int i=requestMessage.indexOf("\n");
		if(i==-1) {
			throw new HttpMessageNotReadableException("No First line found" ,inputMessage);
		}
		String email=requestMessage.substring(0, i).trim();
		String firstName=requestMessage.substring(i).split(" ")[0].trim();
		String lastName=requestMessage.substring(i).split(" ")[1].trim();
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}

	private String toUserMessage(InputStream body) {
		Scanner scanner = new Scanner(body, "UTF-8");
		return scanner.useDelimiter("\\A").next();
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	protected void writeInternal(User user, HttpOutputMessage outputMesssage)
			throws IOException, HttpMessageNotWritableException {
		OutputStream outputStream=outputMesssage.getBody();
		String body=user.getEmail()+"\n"+user.getFirstName()+" "+user.getLastName();
		outputStream.write(body.getBytes());
		outputStream.close();

	}

}
