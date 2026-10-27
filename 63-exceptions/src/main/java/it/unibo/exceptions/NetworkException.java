package it.unibo.exceptions;

import it.unibo.exceptions.fakenetwork.api.NetworkComponent;
import it.unibo.exceptions.fakenetwork.impl.ServiceBehindUnstableNetwork;

import java.io.PrintStream;
import java.io.IOException;
import static it.unibo.exceptions.arithmetic.ArithmeticService.DIVIDED;
import static it.unibo.exceptions.arithmetic.ArithmeticService.MINUS;
import static it.unibo.exceptions.arithmetic.ArithmeticService.PLUS;
import static it.unibo.exceptions.arithmetic.ArithmeticService.TIMES;
import static java.lang.Double.parseDouble;

public class NetworkException extends IOException{


    public NetworkException(){
        super("Network error: no response");
        
    }

    public NetworkException(final String message){
        super("Network error while sending message: "+message);
        
    }




}