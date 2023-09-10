import React, { useState } from 'react';
import './App.css';
import ListarProdutos from './components/ListarProdutos/ListarProdutos';
import Pedidos from './components/pedidos/Pedidos';
import BuscarPedido from './components/buscarPedido/BuscarPedido'; // Note que o import foi alterado

function App() {
  const [paginaAtual, setPaginaAtual] = useState('listarProdutos');

  const mostrarListarProdutos = () => {
    setPaginaAtual('listarProdutos');
  };

  const mostrarPedidos = () => {
    setPaginaAtual('pedidos');
  };

  const mostrarBuscarPedidos = () => {
    setPaginaAtual('buscarPedidos');
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>MENU</h1>
        <nav>
          <button onClick={mostrarListarProdutos}>Listar Produtos</button>
          <button onClick={mostrarPedidos}>Pedidos</button>
          <button onClick={mostrarBuscarPedidos}>Buscar pedidos</button> {/* Altere o onClick para chamar mostrarBuscarPedidos */}
        </nav>
        {paginaAtual === 'listarProdutos' && <ListarProdutos />}
        {paginaAtual === 'pedidos' && <Pedidos />}
        {paginaAtual === 'buscarPedidos' && <BuscarPedido />} {/* Adicione esta condição */}
      </header>
    </div>
  );
}

export default App;
