package com.transion.eksath.blogic.dispatch.domain;

public class InvalidProfileIdException extends RuntimeException{
    public InvalidProfileIdException(String profileId){
        super("Invalid worker profile id" + profileId);
    }
}
