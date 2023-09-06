package br.com.jjw.papelaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdProdutoNotFound extends RuntimeException{
    public IdProdutoNotFound(String mensagem) {
        super(mensagem);
    }
}
