package by.artemeow.exception;

public class InvalidCommandLineParameterException extends Exception {
    private String arg;
    public String getArg(){
        return arg;
    }

    public InvalidCommandLineParameterException(String arg){
        super("Ошибка при чтении параметра ");
        this.arg = arg;
    }
}
