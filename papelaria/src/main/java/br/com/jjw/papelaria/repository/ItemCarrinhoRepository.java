package br.com.jjw.papelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jjw.papelaria.domain.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho,Long>{
    
}
