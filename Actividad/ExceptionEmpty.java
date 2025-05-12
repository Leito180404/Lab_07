package Actividad;

public class ExceptionEmpty extends Exception {

    public ExceptionEmpty() {
        super("no hay nada");
    }

    public ExceptionEmpty(String message) {
        super(message);
    }
}
