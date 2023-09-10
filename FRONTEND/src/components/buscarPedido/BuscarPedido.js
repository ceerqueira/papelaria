import React, { useState } from 'react';
import './index.css';

function BuscarPedido() {
  const [numeroPedido, setNumeroPedido] = useState('');
  const [pedido, setPedido] = useState([]);
  const [cliente, setCliente] = useState({});
  const [codigoAcesso, setCodigoAcesso] = useState('');

  const buscarPedido = async () => {
    try {
      // Primeira requisição para obter os detalhes do pedido
      const pedidoResponse = await fetch(`http://localhost:8080/pedido/${numeroPedido}`);
      if (pedidoResponse.ok) {
        const pedidoData = await pedidoResponse.json();
        setPedido(pedidoData);
      } else {
        console.error('Erro ao buscar o pedido.');
      }

      // Segunda requisição para obter o código de acesso e os dados do cliente
      const codigoAcessoResponse = await fetch(`http://localhost:8080/endereco/${numeroPedido}`);
      if (codigoAcessoResponse.ok) {
        const codigoAcessoData = await codigoAcessoResponse.text();
        setCodigoAcesso(codigoAcessoData);
        const clienteData = JSON.parse(codigoAcessoData); // Converter a resposta em um objeto JSON
        setCliente(clienteData);
      } else {
        console.error('Erro ao buscar o código de acesso.');
      }
    } catch (error) {
      console.error('Erro ao buscar o pedido ou código de acesso:', error);
    }
  };

  return (
    <div>
      <h1>Buscar Pedido</h1>
      <label>Digite o código de acesso: </label>
      <input
        type="text"
        value={numeroPedido}
        onChange={(e) => setNumeroPedido(e.target.value)}
      />
      <button onClick={buscarPedido}>Buscar</button>

      {codigoAcesso && (
        <div className='titulo'>
          <h2 >Dados do cliente</h2>
          <p>Nome: {cliente.nome}</p>
          <p>Telefone: {cliente.telefone}</p>
          <p>Endereco: {cliente.endereco}</p>
        </div>
      )}

      {pedido.length > 0 && (
        <div>
          <h2 className='titulo'>Itens do Pedido: </h2>
          <ul>
            {pedido.map((item) => (
              <li key={item.id}>
                <p>Nome: {item.produto.nome}</p>
                <p>Quantidade: {item.quantidade}</p>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default BuscarPedido;
