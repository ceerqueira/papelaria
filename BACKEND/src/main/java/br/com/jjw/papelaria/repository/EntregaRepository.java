package br.com.jjw.papelaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jjw.papelaria.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega,Long>{

    boolean existsByNumeroPedido(int id);

    @Query("SELECT e FROM Entrega e WHERE e.numeroPedido = :numeroPedido")
    Optional <Entrega> findByNumeroPedido(@Param("numeroPedido") int numeroPedido);

    
}
