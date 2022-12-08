package com.example.demo.exception;

/**
 * @author Rahil_Khan
 *
 */
public class FileGenerationException extends RuntimeException{

    private static final long serialVersionUID = 2725107262187251672L;

    public FileGenerationException(String message) {
        super(message);
    }
    public FileGenerationException(Exception e) {
        super(e.getMessage());
    }

    public FileGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
