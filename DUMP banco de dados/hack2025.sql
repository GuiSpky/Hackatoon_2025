-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 24/06/2025 às 23:37
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hack2025`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `turma_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `turma_id`) VALUES
(1, 'guilherme', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `correcao_prova`
--

CREATE TABLE `correcao_prova` (
  `id` bigint(20) NOT NULL,
  `gabarito` varchar(255) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `prova_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `gabarito`
--

CREATE TABLE `gabarito` (
  `id` bigint(20) NOT NULL,
  `acertos` float DEFAULT NULL,
  `resposta_aluno` varchar(255) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `prova_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `gabarito_respostas`
--

CREATE TABLE `gabarito_respostas` (
  `gabarito_id` bigint(20) NOT NULL,
  `respostas` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `item_pergunta`
--

CREATE TABLE `item_pergunta` (
  `id` bigint(20) NOT NULL,
  `enunciado` varchar(255) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `prova_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `item_pergunta`
--

INSERT INTO `item_pergunta` (`id`, `enunciado`, `resposta`, `valor`, `prova_id`) VALUES
(1, 'teste 1', 'A', 1, 1),
(2, 'teste 2', 'B', 1, 1),
(3, 'teste 3', 'C', 1, 1),
(4, 'teste 4', 'D', 1, 1),
(5, 'teste 5', 'E', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `materia`
--

CREATE TABLE `materia` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `professor_id` bigint(20) DEFAULT NULL,
  `turma_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

CREATE TABLE `professor` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `prova`
--

CREATE TABLE `prova` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `turma_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `prova`
--

INSERT INTO `prova` (`id`, `nome`, `turma_id`) VALUES
(1, 'prova de java', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma`
--

CREATE TABLE `turma` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `turma`
--

INSERT INTO `turma` (`id`, `nome`) VALUES
(1, 'java');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `privilegio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `nome`, `password`, `privilegio`) VALUES
(1, 'admin@gmail.com', 'Administrador', '$2a$10$2S9sm0b7oajQL/GtuG1s7.l9QwqYQOsiOg31Fxvspu.xbmBwZvluC', 'ADMIN'),
(2, 'aluno@gmail.com', 'Aluno', '$2a$10$p9X7mTiGAJqftjW1C7rCuOfev8oR9wPoZix5VY/SqnAbnCc3MBL/.', 'ALUNO'),
(3, 'professor@gmail.com', 'Professor', '$2a$10$PNbxqA7ge10obg8X72fRmeSIUlnNFx9K11H3pAB8r5kFAzParKzhm', 'PROFESSOR');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKehtgr8rih20h4gomh4dd4sbxu` (`turma_id`);

--
-- Índices de tabela `correcao_prova`
--
ALTER TABLE `correcao_prova`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj54binxb65a17o0hjtr8sdti2` (`prova_id`);

--
-- Índices de tabela `gabarito`
--
ALTER TABLE `gabarito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1c5gd46qo92lvxc5jnoi4xuvb` (`aluno_id`),
  ADD KEY `FKfa6gchm3j7mo5raa24g2hb737` (`prova_id`);

--
-- Índices de tabela `gabarito_respostas`
--
ALTER TABLE `gabarito_respostas`
  ADD KEY `FK1uy96sedxb9j3f480s27o5aa3` (`gabarito_id`);

--
-- Índices de tabela `item_pergunta`
--
ALTER TABLE `item_pergunta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKorlk35luy9hca7d9styngli2v` (`prova_id`);

--
-- Índices de tabela `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcy95y5jagtu8dfh411tnv1xa2` (`professor_id`),
  ADD KEY `FK2sjx478behp4a3m8w1qqpht65` (`turma_id`);

--
-- Índices de tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `prova`
--
ALTER TABLE `prova`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnc0asx3bnw4mgqri5pwks5a4u` (`turma_id`);

--
-- Índices de tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `correcao_prova`
--
ALTER TABLE `correcao_prova`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `gabarito`
--
ALTER TABLE `gabarito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `item_pergunta`
--
ALTER TABLE `item_pergunta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `materia`
--
ALTER TABLE `materia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `prova`
--
ALTER TABLE `prova`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `FKehtgr8rih20h4gomh4dd4sbxu` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`);

--
-- Restrições para tabelas `correcao_prova`
--
ALTER TABLE `correcao_prova`
  ADD CONSTRAINT `FKj54binxb65a17o0hjtr8sdti2` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Restrições para tabelas `gabarito`
--
ALTER TABLE `gabarito`
  ADD CONSTRAINT `FK1c5gd46qo92lvxc5jnoi4xuvb` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`),
  ADD CONSTRAINT `FKfa6gchm3j7mo5raa24g2hb737` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Restrições para tabelas `gabarito_respostas`
--
ALTER TABLE `gabarito_respostas`
  ADD CONSTRAINT `FK1uy96sedxb9j3f480s27o5aa3` FOREIGN KEY (`gabarito_id`) REFERENCES `gabarito` (`id`);

--
-- Restrições para tabelas `item_pergunta`
--
ALTER TABLE `item_pergunta`
  ADD CONSTRAINT `FKorlk35luy9hca7d9styngli2v` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Restrições para tabelas `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `FK2sjx478behp4a3m8w1qqpht65` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`),
  ADD CONSTRAINT `FKcy95y5jagtu8dfh411tnv1xa2` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`);

--
-- Restrições para tabelas `prova`
--
ALTER TABLE `prova`
  ADD CONSTRAINT `FKnc0asx3bnw4mgqri5pwks5a4u` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
