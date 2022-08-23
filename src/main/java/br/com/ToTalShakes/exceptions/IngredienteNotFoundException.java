package br.com.ToTalShakes.exceptions;

public class IngredienteNotFoundException extends RuntimeException{

    public IngredienteNotFoundException(String message) {
        super(message);
    }

    public IngredienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
