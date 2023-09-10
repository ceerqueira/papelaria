CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT, 
    quantidade INT,
    numero_pedido INT,
    status VARCHAR(50) 
);