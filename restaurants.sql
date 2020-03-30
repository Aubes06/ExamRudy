-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 29 mars 2020 à 20:16
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

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
-- Structure de la table `allergies`
--

DROP TABLE IF EXISTS `allergies`;
CREATE TABLE IF NOT EXISTS `allergies` (
  `AllID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `AllIngID` int(10) UNSIGNED NOT NULL,
  `IngUseID` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`AllID`),
  UNIQUE KEY `AllID_UNIQUE` (`AllID`),
  KEY `fk_allergies_ingredients1_idx` (`AllIngID`),
  KEY `fk_allergies_users1_idx` (`IngUseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `categorys`
--

DROP TABLE IF EXISTS `categorys`;
CREATE TABLE IF NOT EXISTS `categorys` (
  `CatID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CatLabel` varchar(30) NOT NULL,
  `CatDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CatID`),
  UNIQUE KEY `CatID_UNIQUE` (`CatID`),
  UNIQUE KEY `CatLabel_UNIQUE` (`CatLabel`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorys`
--

INSERT INTO `categorys` (`CatID`, `CatLabel`, `CatDescription`) VALUES
(1, 'Viandes', 'Non végétarien !'),
(2, 'Légumes', 'Non carnivore !'),
(3, 'Poissons', ''),
(4, 'Pâtes', 'From Italia');

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
  PRIMARY KEY (`DisID`),
  UNIQUE KEY `DisID_UNIQUE` (`DisID`),
  UNIQUE KEY `DisLabel_UNIQUE` (`DisLabel`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dishes`
--

INSERT INTO `dishes` (`DisID`, `DisLabel`, `DisDescription`, `DisPrice`) VALUES
(1, 'Poissons Pané', 'L\'arnaque du siècle ! Tu ne l\'aura jamais ton plat, car il n\'est pas encore né..', '15.00'),
(2, 'Spaghetti Bolognèse', '', '15.00'),
(3, 'Spaghetti Jambon-Crème', '', '12.50'),
(4, 'Spaghetti Carbonara', '', '14.50'),
(5, 'Poulet roti', '', '19.00'),
(6, 'Truites', '', '16.50'),
(7, 'Caviar', 'Miam miam', '22.50');

-- --------------------------------------------------------

--
-- Structure de la table `dishes_categorys`
--

DROP TABLE IF EXISTS `dishes_categorys`;
CREATE TABLE IF NOT EXISTS `dishes_categorys` (
  `DisCatID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DisCatDisID` int(10) UNSIGNED NOT NULL,
  `DisCatCatID` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`DisCatID`),
  UNIQUE KEY `DisCatID_UNIQUE` (`DisCatID`),
  KEY `fk_dishes_categorys_dishes1_idx` (`DisCatDisID`),
  KEY `fk_dishes_categorys_categorys1_idx` (`DisCatCatID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dishes_categorys`
--

INSERT INTO `dishes_categorys` (`DisCatID`, `DisCatDisID`, `DisCatCatID`) VALUES
(5, 1, 3),
(6, 5, 1),
(7, 2, 4),
(8, 4, 4),
(9, 3, 4),
(10, 6, 3),
(11, 7, 3);

-- --------------------------------------------------------

--
-- Structure de la table `dishes_ingredients`
--

DROP TABLE IF EXISTS `dishes_ingredients`;
CREATE TABLE IF NOT EXISTS `dishes_ingredients` (
  `DisIngID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DisIngQuantity` float NOT NULL,
  `DisIngUnity` varchar(10) NOT NULL,
  `DisIngDisID` int(10) UNSIGNED NOT NULL,
  `DisIngIngID` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`DisIngID`),
  UNIQUE KEY `DisIngID_UNIQUE` (`DisIngID`),
  KEY `fk_dishes_ingredients_dishes_idx` (`DisIngDisID`),
  KEY `fk_dishes_ingredients_ingredients1_idx` (`DisIngIngID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
CREATE TABLE IF NOT EXISTS `favorites` (
  `FavID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FavUseID` int(10) UNSIGNED NOT NULL,
  `FavDisID` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`FavID`),
  UNIQUE KEY `FavID_UNIQUE` (`FavID`),
  KEY `fk_favorites_users1_idx` (`FavUseID`),
  KEY `fk_favorites_dishes1_idx` (`FavDisID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE IF NOT EXISTS `ingredients` (
  `IngID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `IngLabel` varchar(30) NOT NULL,
  PRIMARY KEY (`IngID`),
  UNIQUE KEY `IngID_UNIQUE` (`IngID`),
  UNIQUE KEY `IngLabel_UNIQUE` (`IngLabel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`UseID`, `UseEmail`, `UsePassword`, `UseName`) VALUES
(1, 'gorlier.0901.student@ifosupwavre.be', '81dc9bdb52d04dc20036dbd8313ed055', 'GORLIER Laurent');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `allergies`
--
ALTER TABLE `allergies`
  ADD CONSTRAINT `fk_allergies_ingredients1` FOREIGN KEY (`AllIngID`) REFERENCES `ingredients` (`IngID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_allergies_users1` FOREIGN KEY (`IngUseID`) REFERENCES `users` (`UseID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `dishes_categorys`
--
ALTER TABLE `dishes_categorys`
  ADD CONSTRAINT `fk_dishes_categorys_categorys1` FOREIGN KEY (`DisCatCatID`) REFERENCES `categorys` (`CatID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_dishes_categorys_dishes1` FOREIGN KEY (`DisCatDisID`) REFERENCES `dishes` (`DisID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `dishes_ingredients`
--
ALTER TABLE `dishes_ingredients`
  ADD CONSTRAINT `fk_dishes_ingredients_dishes` FOREIGN KEY (`DisIngDisID`) REFERENCES `dishes` (`DisID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_dishes_ingredients_ingredients1` FOREIGN KEY (`DisIngIngID`) REFERENCES `ingredients` (`IngID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `fk_favorites_dishes1` FOREIGN KEY (`FavDisID`) REFERENCES `dishes` (`DisID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_favorites_users1` FOREIGN KEY (`FavUseID`) REFERENCES `users` (`UseID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
