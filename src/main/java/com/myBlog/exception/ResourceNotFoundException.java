package com.myBlog.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message); //supply any thing with super keyword, it goes to Postman
    }
}
