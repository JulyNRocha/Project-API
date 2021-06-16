-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 16-Jun-2021 às 20:26
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetoapi`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `data_stream`
--

CREATE TABLE `data_stream` (
  `id` int(11) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `stream_key` varchar(255) NOT NULL,
  `device_id` int(11) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `data_stream`
--

INSERT INTO `data_stream` (`id`, `label`, `stream_key`, `device_id`, `unit_id`) VALUES
(6, 'temperature', 'grifzctqanmic94ozp0jqefp3qiek8lw', 4, 1),
(7, 'humidity', 'c46c2037y0v4c0yxbzp41mz6ezh2mgoj', 4, 5),
(8, 'carbon dioxide', '1byq4kauoieul9s001404840z748luvv', 4, 2),
(9, 'temperature', 'yy4d5v04u4p1c1jpqk29378zbwluotno', 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `measurement_unit`
--

CREATE TABLE `measurement_unit` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `measurement_unit`
--

INSERT INTO `measurement_unit` (`id`, `description`, `symbol`) VALUES
(1, 'Celsius', 'ºC'),
(2, 'Megagram per cubic metre', 'mg/m³'),
(3, 'hectopasca', 'hPA'),
(4, 'Lux', 'lux'),
(5, 'Percent', '%');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sensor_data`
--

CREATE TABLE `sensor_data` (
  `timestamp` datetime NOT NULL,
  `value` double NOT NULL,
  `stream_id` int(11) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sensor_data`
--

INSERT INTO `sensor_data` (`timestamp`, `value`, `stream_id`, `unit_id`) VALUES
('2021-06-16 16:55:03', 15, 6, 1),
('2021-06-16 16:55:07', 16, 6, 1),
('2021-06-16 16:55:10', 17, 6, 1),
('2021-06-16 16:55:14', 16, 6, 1),
('2021-06-16 16:55:16', 17, 6, 1),
('2021-06-16 16:55:20', 18, 6, 1),
('2021-06-16 16:55:26', 17, 6, 1),
('2021-06-16 16:55:30', 15, 6, 1),
('2021-06-16 16:55:33', 16, 6, 1),
('2021-06-16 16:55:37', 15, 6, 1),
('2021-06-16 16:56:35', 2.1, 7, 5),
('2021-06-16 16:56:44', 1.5, 7, 5),
('2021-06-16 16:56:49', 1.9, 7, 5),
('2021-06-16 16:56:52', 1.8, 7, 5),
('2021-06-16 16:56:59', 1.5, 7, 5),
('2021-06-16 16:57:11', 2, 7, 5),
('2021-06-16 16:57:17', 2.1, 7, 5),
('2021-06-16 16:57:52', 20, 8, 2),
('2021-06-16 16:57:57', 21, 8, 2),
('2021-06-16 16:58:00', 22, 8, 2),
('2021-06-16 16:58:03', 23, 8, 2),
('2021-06-16 16:58:07', 10, 8, 2),
('2021-06-16 16:58:11', 25, 8, 2),
('2021-06-16 16:58:15', 21, 8, 2),
('2021-06-16 16:58:18', 22, 8, 2),
('2021-06-16 17:01:49', -65.6, 9, 1),
('2021-06-16 17:01:59', -65.65, 9, 1),
('2021-06-16 17:02:03', -65.64, 9, 1),
('2021-06-16 17:02:07', -65.63, 9, 1),
('2021-06-16 17:02:12', -65.67, 9, 1),
('2021-06-16 17:02:16', -65.68, 9, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sensor_device`
--

CREATE TABLE `sensor_device` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `devicekey` varchar(255) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sensor_device`
--

INSERT INTO `sensor_device` (`id`, `description`, `devicekey`, `label`, `user_id`) VALUES
(4, 'sensor 0001', '4ax6vs998otrww91h7zcsrnffu1ay3q6', 'Isaac\'s Room control', 1),
(5, 'Kitchen\'s freezer sensor (Arduino)1', '688oabl6k7q2yirr1f03ot7038kyza7a', 'Kitchen\'s freezer sensor (Arduino)', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `email`, `username`) VALUES
(1, 'email@email.com', 'user1');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `data_stream`
--
ALTER TABLE `data_stream`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ex3n9aedd0lie9n3i47t1xgkx` (`stream_key`),
  ADD KEY `FKcrmd6wfuv9x05vhmkp7ldoi7h` (`device_id`),
  ADD KEY `FKcqmy5alswevay3j7ky7f5iblr` (`unit_id`);

--
-- Índices para tabela `measurement_unit`
--
ALTER TABLE `measurement_unit`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `sensor_data`
--
ALTER TABLE `sensor_data`
  ADD PRIMARY KEY (`timestamp`),
  ADD KEY `FKrs5ivhc1t70deg5fnl1mmxqyl` (`stream_id`),
  ADD KEY `FKdeyburh9ms7icfal0jphebsl9` (`unit_id`);

--
-- Índices para tabela `sensor_device`
--
ALTER TABLE `sensor_device`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfhbj2vwf3dn31vf282qcr8hs5` (`user_id`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `data_stream`
--
ALTER TABLE `data_stream`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `measurement_unit`
--
ALTER TABLE `measurement_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `sensor_device`
--
ALTER TABLE `sensor_device`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `data_stream`
--
ALTER TABLE `data_stream`
  ADD CONSTRAINT `FKcqmy5alswevay3j7ky7f5iblr` FOREIGN KEY (`unit_id`) REFERENCES `measurement_unit` (`id`),
  ADD CONSTRAINT `FKcrmd6wfuv9x05vhmkp7ldoi7h` FOREIGN KEY (`device_id`) REFERENCES `sensor_device` (`id`);

--
-- Limitadores para a tabela `sensor_data`
--
ALTER TABLE `sensor_data`
  ADD CONSTRAINT `FKdeyburh9ms7icfal0jphebsl9` FOREIGN KEY (`unit_id`) REFERENCES `measurement_unit` (`id`),
  ADD CONSTRAINT `FKrs5ivhc1t70deg5fnl1mmxqyl` FOREIGN KEY (`stream_id`) REFERENCES `data_stream` (`id`);

--
-- Limitadores para a tabela `sensor_device`
--
ALTER TABLE `sensor_device`
  ADD CONSTRAINT `FKfhbj2vwf3dn31vf282qcr8hs5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
