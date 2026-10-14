package fr.cda.Exceptions;

public class ExceptionMediatheque extends RuntimeException {
    public ExceptionMediatheque(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }
}
