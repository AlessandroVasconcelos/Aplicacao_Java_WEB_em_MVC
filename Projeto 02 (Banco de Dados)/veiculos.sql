-- --------------------------------------------------------

--
-- Estrutura da tabela `Carro`
--

DROP TABLE IF EXISTS `Carro`;
CREATE TABLE IF NOT EXISTS `Carro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(20) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `proprietarioId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Carro_Proprietario_fk` (`proprietarioId`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Inserção de dados na tabela `Carro`
--

INSERT INTO `Carro` (`placa`, `marca`, `modelo`, `proprietarioId`) VALUES
('ABC1234', 'Ford', 'Fiesta', 1),
('XYZ5678', 'Chevrolet', 'Cruze', 2),
('DEF9012', 'Volkswagen', 'Golf', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Proprietario`
--

DROP TABLE IF EXISTS `Proprietario`;
CREATE TABLE IF NOT EXISTS `Proprietario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Inserção de dados na tabela `Proprietario`
--

INSERT INTO `Proprietario` (`nome`, `cpf`) VALUES
('João Silva', '123.456.789-00'),
('Maria Santos', '987.654.321-00'),
('Pedro Almeida', '111.222.333-44');
