package br.com.jjw.papelaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarrinhoComprasNotFoundException extends RuntimeException{
    public CarrinhoComprasNotFoundException(String mensagem) {
        super(mensagem);
    }
}
