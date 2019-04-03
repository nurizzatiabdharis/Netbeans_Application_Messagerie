-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 03, 2018 at 09:08 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `amplirt`
--

-- --------------------------------------------------------

--
-- Table structure for table `destinataire`
--

DROP TABLE IF EXISTS `destinataire`;
CREATE TABLE IF NOT EXISTS `destinataire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=208 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destinataire`
--

INSERT INTO `destinataire` (`id`, `nom`, `prenom`, `tel`, `mail`, `type`) VALUES
(5, 'Jean', 'Marc', '0123456789', NULL, 'Personnel'),
(7, 'Nadwah', 'Azizah', '097456341', 'nadwah@gmail.com', 'Professionnel'),
(34, 'Marc', 'Antoine', '0172644312', 'mantoine@unice.fr', 'Personnel'),
(32, 'Obrien', 'Dylan', '079995509', 'dylan@gmail.com', 'Professionnel'),
(31, 'Pierre', 'Maire', '0765656512', 'jean@gmail.com', 'Personnel'),
(45, 'Afa', '', '0771764091', 'afa@gmail.com', 'Professionnel'),
(39, 'Aqilah', 'Shah', '0876768612', 'aqilah@yahoo.com', 'Professionnel'),
(50, 'Haris', 'Zaty', '0771762389', 'zaty@yahoo.com', 'Professionnel'),
(73, 'Antoine', 'Lucas', '065746382', 'lucas@gmail.com', 'Personnel'),
(51, 'McCall', 'Scott', '0122642771', 'scott@teenwolf.com', 'Professionnel'),
(64, 'Stilinski', 'Stiles', '0972536273', 'stiles@teenwolf.com', 'Professionnel'),
(63, 'Martin', 'Lydia', '0987674587', 'lydia@teenwolf.com', 'Professionnel'),
(65, 'Argent', 'Alisson', '011112334', 'alisson@teenwolf.com', 'Professionnel'),
(66, 'Hale', 'Derek', '084324832', 'derek@teenwolf.com', 'Professionnel'),
(74, 'Durand', 'Julie', '0127842382', 'julie@gmail.com', 'Personnel'),
(207, 'Tenret', 'Thomas', '0668762651', 'thomas@gmail.com', 'Personnel'),
(75, 'Dubois', 'Alice', '056673212', 'alice@yahoo.com', 'Personnel'),
(203, 'Dupand', 'Marie', '', '', 'Personnel'),
(204, 'Sheldon Lee', 'Cooper', '0771765719', 'shelly@yahoo.com', 'Personnel'),
(206, 'Patric', 'Laura', '0975289371', 'laura@yahoo.com', 'Personnel');

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `nomGroupe` varchar(20) DEFAULT NULL,
  `idDest` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGroupe`),
  KEY `idDest` (`idDest`)
) ENGINE=MyISAM AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`idGroupe`, `nomGroupe`, `idDest`) VALUES
(77, 'Family', 73),
(3, 'TP Java', 39),
(4, 'TP Reseaux', 7),
(60, 'TP Java', 5),
(48, 'TP WAN', 7),
(11, 'TP Telecom', 32),
(12, 'TP Java', 45),
(49, 'TP WAN', 32),
(16, 'TP WAN', 50),
(19, 'TP Info', 51),
(82, 'Amis', 7),
(81, 'Amis', 50),
(80, 'Amis', 39),
(76, 'Family', 75),
(58, 'Family', 203),
(32, 'Teen Wolf', 51),
(33, 'Teen Wolf', 64),
(34, 'Teen Wolf', 63),
(35, 'Teen Wolf', 65),
(57, 'TP Elec', 203),
(37, 'Teen Wolf', 66),
(56, 'Family', 204),
(79, 'Amis', NULL),
(98, 'Amis', 45);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `idmsg` int(11) NOT NULL AUTO_INCREMENT,
  `dest` varchar(30) NOT NULL,
  `msg` text NOT NULL,
  PRIMARY KEY (`idmsg`)
) ENGINE=MyISAM AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`idmsg`, `dest`, `msg`) VALUES
(1, 'toto', 'salut toto!'),
(2, 'titi', 'ca va titi?'),
(4, 'Nadwah', 'Salut Nadwah!'),
(8, 'Jean', 'test msg'),
(6, 'Izzati', 'Aujourdhui c\'est vendredi. Tu es libre?'),
(7, 'toto', 'tu es libre demain?'),
(9, 'Jean', 'test 123'),
(10, 'Argent', 'Please don\'t die!'),
(11, 'McCall', 'I need season 8!!!!!'),
(17, 'Jean', 'je fait un test'),
(18, 'Nasrul', 'Test de msg crypte'),
(27, 'Stilinski', 'Test msg groupe'),
(26, 'McCall', 'Test msg groupe'),
(28, 'Martin', 'Test msg groupe'),
(29, 'Argent', 'Test msg groupe'),
(30, 'Hale', 'Test msg groupe'),
(38, 'Bob', 'Hai bob'),
(39, 'Aziz', 'Elec test'),
(40, 'Bob', 'Elec test'),
(41, 'Obrien', 'test tel'),
(42, 'Haris', 'test tel'),
(43, 'Toto', 'tesrjhfjtdgfcv'),
(44, 'Aziz', 'vtyfiub hkv'),
(45, 'Bob', 'vtyfiub hkv'),
(46, 'Sarah Aziz', 'On a cours demain!'),
(47, 'Marley Bob', 'On a cours demain!'),
(94, 'Cooper Sheldon Lee', 'test'),
(93, 'Marie Dupand', 'test'),
(53, 'Scott McCall', 'reunion ce soir!'),
(54, 'Stiles Stilinski', 'reunion ce soir!'),
(55, 'Lydia Martin', 'reunion ce soir!'),
(56, 'Alisson Argent', 'reunion ce soir!'),
(57, 'Derek Hale', 'reunion ce soir!'),
(58, 'Scott McCall', 'Test'),
(59, 'Zaty Haris', 'Test'),
(60, 'Scott McCall', 'testcrypte'),
(61, 'Zaty Haris', 'testcrypte'),
(62, 'Zaty Haris', 'le cours annule demain'),
(63, 'Iman Nasrul', 'le cours annule demain'),
(64, 'Marc', 'salut marc'),
(65, 'Argent', 'salut'),
(92, 'Alice Dubois', 'test'),
(91, 'Lucas Antoine', 'test'),
(90, 'Nadwah', 'salut'),
(89, 'Marie Dupand', 'Cours annule aujourdhui'),
(88, 'Marley Bob', 'Cours annule aujourdhui'),
(87, 'Sarah Aziz', 'Cours annule aujourdhui'),
(86, 'Nasrul', 'Salut! ca va?'),
(85, 'Marc', 'test'),
(84, 'Sheldon Lee', 'Dernier episode aujourdhui!');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
