-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10-Set-2021 às 02:05
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdproduto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cor`
--

CREATE TABLE `cor` (
  `idCor` int(11) NOT NULL,
  `corProduto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cor`
--

INSERT INTO `cor` (`idCor`, `corProduto`) VALUES
(1, 'Azul'),
(2, 'Preto'),
(3, 'Verde'),
(4, 'Incolor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL,
  `marcaProduto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`idMarca`, `marcaProduto`) VALUES
(1, 'Marca Diabo'),
(4, 'Marca meia boca'),
(5, 'Marca top');

-- --------------------------------------------------------

--
-- Estrutura da tabela `operacao`
--

CREATE TABLE `operacao` (
  `idOperacao` int(11) NOT NULL,
  `codigoProduto` varchar(20) NOT NULL,
  `descOperacao` enum('Entrada','Saida') NOT NULL,
  `quantProduto` int(11) NOT NULL,
  `dataOperacao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `operacao`
--

INSERT INTO `operacao` (`idOperacao`, `codigoProduto`, `descOperacao`, `quantProduto`, `dataOperacao`) VALUES
(25, '1', 'Entrada', 100, '05/09/2021'),
(26, '1', 'Saida', 10, '08/09/2021'),
(27, '2', 'Entrada', 50, '01/09/2021'),
(28, '2', 'Saida', 2, '08/09/2021'),
(29, '3', 'Entrada', 80, '28/08/2021'),
(30, '3', 'Saida', 12, '03/09/2021'),
(31, '1', 'Saida', 91, '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `codigoProduto` varchar(20) NOT NULL,
  `descProduto` varchar(20) NOT NULL,
  `marcaProduto` varchar(20) NOT NULL,
  `precoProduto` double NOT NULL,
  `corProduto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `codigoProduto`, `descProduto`, `marcaProduto`, `precoProduto`, `corProduto`) VALUES
(16, '1', 'Teclado', 'Marca top', 299.99, 'Preto'),
(17, '2', 'SSD sata', 'Marca Diabo', 250, 'Incolor'),
(18, '3', 'Mouse Gamer', 'Marca meia boca', 119.99, 'Verde');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cor`
--
ALTER TABLE `cor`
  ADD PRIMARY KEY (`idCor`);

--
-- Índices para tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Índices para tabela `operacao`
--
ALTER TABLE `operacao`
  ADD PRIMARY KEY (`idOperacao`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cor`
--
ALTER TABLE `cor`
  MODIFY `idCor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `operacao`
--
ALTER TABLE `operacao`
  MODIFY `idOperacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
