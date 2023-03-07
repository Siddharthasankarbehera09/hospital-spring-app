package org.springbootproject.hospitalspringapp.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private T body;
	private int code;
}
