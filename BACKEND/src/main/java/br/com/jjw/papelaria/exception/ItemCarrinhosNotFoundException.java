package br.com.jjw.papelaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemCarrinhosNotFoundException extends RuntimeException{
    public ItemCarrinhosNotFoundException(String mensagem) {
        super(mensagem);
    }
}
