create table produto(

    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    descricao varchar(200) not null,
    preco DECIMAL(10, 2) not null,
    quantidade int not null CHECK (quantidade >= 0),

    primary key(id)

);