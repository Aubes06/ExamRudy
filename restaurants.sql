-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 30 mars 2020 à 09:27
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `restaurants`
--

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `CatID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CatLabel` varchar(30) NOT NULL,
  `CatDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CatID`),
  UNIQUE KEY `CatID_UNIQUE` (`CatID`),
  UNIQUE KEY `CatLabel_UNIQUE` (`CatLabel`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`CatID`, `CatLabel`, `CatDescription`) VALUES
(1, 'Viandes', ''),
(2, 'Légumes', ''),
(3, 'Poisons', ''),
(4, 'Pâtes', '');

-- --------------------------------------------------------

--
-- Structure de la table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
CREATE TABLE IF NOT EXISTS `dishes` (
  `DisID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DisLabel` varchar(30) NOT NULL,
  `DisDescription` varchar(255) DEFAULT NULL,
  `DisPrice` decimal(10,2) NOT NULL,
  `DisCatID` int(11) NOT NULL,
  PRIMARY KEY (`DisID`),
  UNIQUE KEY `DisID_UNIQUE` (`DisID`),
  UNIQUE KEY `DisLabel_UNIQUE` (`DisLabel`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dishes`
--

INSERT INTO `dishes` (`DisID`, `DisLabel`, `DisDescription`, `DisPrice`, `DisCatID`) VALUES
(1, 'Poissons Pané', 'L\'arnaque du siècle ! Tu ne l\'aura jamais ton plat, car il n\'est pas encore né..', '15.00', 3),
(2, 'Spaghetti Bolognèse', '', '15.00', 4),
(3, 'Spaghetti Jambon-Crème', '', '12.50', 4),
(4, 'Spaghetti Carbonara', '', '14.50', 4),
(5, 'Poulet roti', '', '19.00', 1),
(6, 'Truites', '', '16.50', 3),
(12, 'miam', 'miam', '5.50', 0),
(15, 'testtesttesttest', 'testtest', '8.99', 0),
(25, 'Laurent', 'tsstete', '8.50', 3);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `UseID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `UseEmail` varchar(255) NOT NULL,
  `UsePassword` char(32) NOT NULL,
  `UseName` varchar(60) NOT NULL,
  PRIMARY KEY (`UseID`),
  UNIQUE KEY `UseID_UNIQUE` (`UseID`),
  UNIQUE KEY `UseEmail_UNIQUE` (`UseEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
