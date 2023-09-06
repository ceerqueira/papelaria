CREATE TABLE item_carrinho (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    carrinho_compras_id BIGINT NOT NULL,
    FOREIGN KEY (carrinho_compras_id) REFERENCES carrinho_compras(id),
    id_produto BIGINT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    quantidade int not null CHECK (quantidade >= 0)
);
