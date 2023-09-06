package br.com.jjw.papelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jjw.papelaria.domain.CarrinhoCompras;

public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Long> {
    
}
