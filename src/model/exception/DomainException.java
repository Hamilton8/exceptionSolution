package src.model.exception;

public class DomainException extends RuntimeException{


    public DomainException(){
        super();
    }

    public DomainException(String mess){
        super(mess);
    }
}
