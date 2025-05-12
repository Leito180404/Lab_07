package Actividad;

public class ExceptionEmpty extends Exception {
    public ExceptionEmpty(String msg) {
        super(msg);
    }

    public ExceptionEmpty() {
        super("Esta vacio.");
    }
}
