package br.com.jjw.papelaria.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "carrinho_compras_id")
    private CarrinhoCompras carrinhoCompras;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

}
