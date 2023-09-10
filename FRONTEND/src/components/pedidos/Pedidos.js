import React, { useState, useEffect } from 'react';
import './Pedidos.css';

function Pedidos() {
  const [cartItems, setCartItems] = useState([]); // Estado para os itens do carrinho

  // Função para carregar os itens do carrinho da API
  const fetchCartItems = async () => {
    try {
      const response = await fetch('http://localhost:8080/pedido'); // Fazer a requisição GET para obter os itens do carrinho
      if (response.ok) {
        const data = await response.json();
        setCartItems(data); // Atualizar o estado com os itens do carrinho
      }
    } catch (error) {
      console.log('Carrinho vazio');
    }
  };

  // Efeito para carregar os itens do carrinho ao montar o componente
  useEffect(() => {
    fetchCartItems();
  }, []);


  // Função para remover um item do carrinho
  const removeFromCart = async (product) => {
    try {
      // Fazer a requisição DELETE para remover o item do carrinho na API
      const response = await fetch(`http://localhost:8080/pedido/${product.id}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        fetchCartItems(); // Recarregar os itens do carrinho após a remoção bem-sucedida
      } else {
        console.error('Você não pode deixar o carrinho vazio');
      }
    } catch (error) {
      console.error('Erro ao remover item do carrinho:', error);
    }
  };

  // Função para atualizar a quantidade de um item no carrinho
  const updateQuantity = async (product, newQuantity) => {
    try {
      // Fazer a requisição PUT para atualizar a quantidade do item no carrinho na API
      const response = await fetch('http://localhost:8080/pedido', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ idPedido: product.id, quantidade: newQuantity }),
      });

      if (response.ok) {
        fetchCartItems(); // Recarregar os itens do carrinho após a atualização bem-sucedida
      } else {
        console.error('Erro ao atualizar quantidade do item no carrinho.');
      }
    } catch (error) {
      console.error('Erro ao atualizar quantidade do item no carrinho:', error);
    }
  };

  const [codigoAcesso, setCodigoAcesso] = useState('');
  const finalizarPedido = async () => {
    try {
      // Verifique se o carrinho não está vazio antes de finalizar o pedido
      if (cartItems.length === 0) {
        console.error('O carrinho está vazio. Adicione itens antes de finalizar o pedido.');
        return;
      }

      // Solicite ao usuário que insira os dados necessários (nome, endereço, telefone e número do pedido)
      const nome = prompt('Digite seu nome:');
      const endereco = prompt('Digite seu endereço:');
      const telefone = prompt('Digite seu telefone:');

      // Verifique se os campos obrigatórios não estão vazios
      if (!nome || !endereco || !telefone) {
        alert('Por favor, preencha todos os campos obrigatórios.');
        return;
      }

      // Dados a serem enviados em formato JSON
      const dadosPedido = {
        nome,
        endereco,
        telefone,
      };

      // Faz a requisição POST para finalizar o pedido
      const response = await fetch('http://localhost:8080/endereco', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dadosPedido),
      });

      const responseText = await response.text(); // Ler a resposta como texto
      const codigoAcessoMatch = responseText.match(/\d+/); // Procurar por uma sequência de dígitos

      if (codigoAcessoMatch) {
        const codigoAcesso = codigoAcessoMatch[0]; // Obter o primeiro conjunto de dígitos encontrado
        setCodigoAcesso(codigoAcesso);
        alert('Pedido finalizado com sucesso! Seu código de acesso é: ' + codigoAcesso);
         setTimeout(() => {
          window.location.reload();
        }, 3000); 
      } else {
        console.error('Formato de código de acesso inválido na resposta do servidor.');
      }
    } catch (error) {
      alert('Erro ao finalizar o pedido:', error);
    }
  };


  return (
    <div>
      <h1>Carrinho de Compras</h1>
      <ul>
        {cartItems.map((item) => (
          <li key={item.id}>
            <h2>{item.produto.nome}</h2>
            <p>Quantidade: {item.quantidade}</p>
            <button onClick={() => updateQuantity(item, item.quantidade + 1)}>+</button>
            <button onClick={() => updateQuantity(item, item.quantidade - 1)}>-</button>
            <button onClick={() => removeFromCart(item)}>Remover do Carrinho</button>
          </li>
        ))}
      </ul>
      {codigoAcesso && (
        <p className='titulo'>Seu código de acesso é: {codigoAcesso}</p>
      )}
      <button className="botao" onClick={finalizarPedido}>Finalizar Pedido</button>
    </div>
  );
}

export default Pedidos;
