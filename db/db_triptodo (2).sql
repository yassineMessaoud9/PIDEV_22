-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 07 mars 2022 à 20:02
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_triptodo`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `idadresse` int(30) NOT NULL,
  `paysadresse` varchar(30) NOT NULL,
  `rueadresse` varchar(30) NOT NULL,
  `contactadresse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`idadresse`, `paysadresse`, `rueadresse`, `contactadresse`) VALUES
(1, 'omar', 'fitouri', 5949849),
(11, 'ukranie', 'chernobyle', 45632178),
(12, 'france', 'parisss', 5649899),
(13, 'america', 'ennde', 4984545),
(16, 'belgique', 'cite wahat', 78945612),
(17, 'yassine', 'yassine', 79546),
(18, 'omar', 'omar', 789),
(19, 'omar', 'omar', 789),
(20, 'omar', 'omar', 789),
(21, 'ghgbh', 'vhv', 123456),
(22, 'omar', 'jjd', 7889),
(23, 'noussa', 'noussa', 5125896),
(24, 'asma', 'asma', 788),
(28, 'france', 'Paris', 231566894);

-- --------------------------------------------------------

--
-- Structure de la table `avion`
--

CREATE TABLE `avion` (
  `numserieavion` int(11) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `nbrplace` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `avion`
--

INSERT INTO `avion` (`numserieavion`, `marque`, `nbrplace`) VALUES
(2, 'boinggg', 171),
(4, 'f22', 7891578),
(5, 'aaaa', 1),
(6, 'bbbb', 2),
(8, 'oo', 2);

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

CREATE TABLE `avis` (
  `idAvis` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `NomAvis` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `avis`
--

INSERT INTO `avis` (`idAvis`, `rate`, `NomAvis`) VALUES
(2, 10, 'aeaeaz'),
(5, 4, 'yeser basaaa'),
(6, 4, 'yeser basaaa'),
(7, 4, 'yezzmortyy'),
(8, 2, 'rarara'),
(9, 5, 'rarara'),
(10, 4, 'bzrte'),
(11, 5, 'passa'),
(12, 3, 'aaa'),
(13, 2, 'azeraze'),
(14, 3, 'ena yassine'),
(15, 4, 'yassine');

-- --------------------------------------------------------

--
-- Structure de la table `commandplat`
--

CREATE TABLE `commandplat` (
  `id` int(11) NOT NULL,
  `idCommande` int(11) NOT NULL,
  `Plat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commandplat`
--

INSERT INTO `commandplat` (`id`, `idCommande`, `Plat`) VALUES
(38, 902805, 2),
(39, 902805, 3),
(43, 216054, 3),
(44, 216054, 4);

-- --------------------------------------------------------

--
-- Structure de la table `commandrestau`
--

CREATE TABLE `commandrestau` (
  `Num_Commande` int(200) NOT NULL,
  `prix_commande` double NOT NULL,
  `date_commande` date DEFAULT current_timestamp(),
  `idUser` int(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `etat` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commandrestau`
--

INSERT INTO `commandrestau` (`Num_Commande`, `prix_commande`, `date_commande`, `idUser`, `latitude`, `longitude`, `etat`) VALUES
(216054, 85, '2022-03-06', 14, 27.839076094777816, 26.455078125000004, 0),
(902805, 52.7, '2022-03-06', 14, 35.460669951495305, 9.580078125, 0);

-- --------------------------------------------------------

--
-- Structure de la table `compagnieaerienne`
--

CREATE TABLE `compagnieaerienne` (
  `idcompagnie` int(11) NOT NULL,
  `nomcompagnie` varchar(30) NOT NULL,
  `idadresse` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compagnieaerienne`
--

INSERT INTO `compagnieaerienne` (`idcompagnie`, `nomcompagnie`, `idadresse`) VALUES
(3, 'travelto', 1),
(5, 'ons', 16),
(6, 'yassine', 11),
(8, 'omar', 24),
(9, 'bbbbb', 23);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEve` int(50) NOT NULL,
  `intituleEve` varchar(50) NOT NULL,
  `paysEve` varchar(50) NOT NULL,
  `prixEve` float NOT NULL,
  `datedebutEve` date NOT NULL,
  `datefinEve` date NOT NULL,
  `addressEve` varchar(50) NOT NULL,
  `typeEve` varchar(50) NOT NULL,
  `photoEve` varchar(50) NOT NULL,
  `nbplaceEve` int(11) NOT NULL,
  `descriptionEve` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`idEve`, `intituleEve`, `paysEve`, `prixEve`, `datedebutEve`, `datefinEve`, `addressEve`, `typeEve`, `photoEve`, `nbplaceEve`, `descriptionEve`) VALUES
(23, 'rrrrrrrrrrrrr', 'aerta', 5461, '2034-02-17', '2034-02-16', 'eee', 'd', 'rarar', 519, 'azera'),
(25, 'dsfd', 'azera', 55, '2022-03-05', '2022-03-06', 'azeae', 'festival', '', 2122, '1646464'),
(35, 'aaer', 'aera', 515, '2025-04-03', '2022-03-05', 'zz', 'festival', 'dimoz.PNG', 666, 'lk,ok,ok'),
(36, 'aaer', 'aera', 515, '2025-04-03', '2027-03-13', 'zz', 'festival', 'dimoz.PNG', 666, 'lk,ok,ok'),
(37, 'aaa', 'aaa', 555, '2022-03-06', '2025-03-08', 'zz', 'Carnaval', 'dimoz.PNG', 5565565, 'barcha'),
(38, 'aaa', 'aaa', 8889, '2022-03-18', '2022-03-26', 'aaa', 'Carnaval', '1.jpg', 45, 'azazazaz');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `idhotel` int(11) NOT NULL,
  `nomhotel` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `etoile` int(11) NOT NULL,
  `nbrChambre` int(11) NOT NULL,
  `photo` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hotel`
--

INSERT INTO `hotel` (`idhotel`, `nomhotel`, `adresse`, `etoile`, `nbrChambre`, `photo`) VALUES
(4, 'movenpick', 'ufff', 3333, 5666, 'fff'),
(51, 'asmakkk', 'houmetsouk', 5, 5, 'ffffffffff'),
(53, 'jn', 'jnnnn', 3, 9, 'kim'),
(54, 'a', 'ji', 0, 8, 'jj'),
(55, 'll', 'op', 5, 7, 'KJJ'),
(57, 'hhhhhhhhhhhhhhhhh', 'h', 5, 1, 'hh'),
(58, 'HH', 'H', 1, 1, 'HH'),
(59, 'T', 'T', 3, 12, 'R'),
(60, 'TTTTTTTTTTTTTTTTTTTTTTTTTT', 'TTTT', 12, 12, 'TT'),
(62, 'movenpick', 'u', 5, 3, 'k;;kpm'),
(65, 'HOtel', 'MArsa', 5, 58, '10143.jpg'),
(66, 'Olr', 'tunise', 5, 85, '2.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE `plat` (
  `idPlat` int(20) NOT NULL,
  `nomPlat` varchar(255) NOT NULL,
  `prixPlat` double NOT NULL,
  `photoPlat` varchar(255) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `plat`
--

INSERT INTO `plat` (`idPlat`, `nomPlat`, `prixPlat`, `photoPlat`, `description`) VALUES
(1, 'Couscous', 42.5, 'PhotoPlat', 'couscous bel OSBEN'),
(2, 'Rouz', 10.2, 'rouz', 'rouz'),
(3, 'Couscous', 42.5, 'PhotoPlat', 'couscous bel OSBEN'),
(4, 'Couscous', 42.5, 'PhotoPlat', 'couscous bel OSBEN');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `idReclamation` int(20) NOT NULL,
  `typeReclamation` enum('en_cours','traite') NOT NULL,
  `description` varchar(1000) NOT NULL,
  `dateReclamation` date NOT NULL,
  `intituleReclamation` varchar(50) NOT NULL,
  `etatReclamation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`idReclamation`, `typeReclamation`, `description`, `dateReclamation`, `intituleReclamation`, `etatReclamation`) VALUES
(4, 'en_cours', 'this guy kept flaming me the whole event', '2022-12-16', 'bug while awseourghy', 'waiting for response'),
(5, 'en_cours', 'this guy kept flaming me the whole event', '2022-12-16', 'bug while picking', 'waiting for response'),
(7, 'en_cours', 'xxxxxxxx', '2022-02-04', 'nnn', 'perte'),
(10, 'en_cours', 'egegeege', '2022-02-26', 'erwg', 'vol'),
(11, 'en_cours', 'salem salem salem salem salem ena ena ena ena ena ***** putin putin putin putin ', '2015-02-07', 'erwg', 'perte'),
(12, 'en_cours', '***** bogga passa ', '2016-02-13', 'werth', 'perte'),
(16, 'en_cours', '************ ', '2023-03-09', 'rrr', 'perte'),
(17, 'en_cours', '**** man ', '2022-03-12', 'rr', 'vol'),
(18, 'en_cours', 'rrrrrrrrrrrrrrrrr ', '2022-03-11', 'aeezar', 'vol'),
(19, 'en_cours', 'dhay3t 7yeti ***** ', '2022-03-12', 'ya rrabi', 'perte'),
(20, 'en_cours', '***** yass ', '2022-03-08', 'aaaa', 'Abuse'),
(21, 'en_cours', '***** aa ', '2022-03-07', 'aaa', 'Abuse');

-- --------------------------------------------------------

--
-- Structure de la table `reservationhotels`
--

CREATE TABLE `reservationhotels` (
  `idReservationHotel` int(11) NOT NULL,
  `typeChambre` varchar(50) NOT NULL,
  `nbrnuit` int(11) NOT NULL,
  `datereservation` date NOT NULL,
  `nbrpersonne` int(11) NOT NULL,
  `dateallerReser` date NOT NULL,
  `dateretourReser` date NOT NULL,
  `idU` int(11) NOT NULL,
  `idhotel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservationhotels`
--

INSERT INTO `reservationhotels` (`idReservationHotel`, `typeChambre`, `nbrnuit`, `datereservation`, `nbrpersonne`, `dateallerReser`, `dateretourReser`, `idU`, `idhotel`) VALUES
(4, 'TTtttttttt', 2, '2022-03-10', 3, '2022-03-10', '2022-03-03', 1, 4),
(8, 'aa', 1, '2022-03-10', 3, '2022-03-17', '2022-03-09', 1, 4),
(10, 'aa', 1, '2022-03-10', 3, '2022-03-17', '2022-03-09', 1, 4),
(12, '', 2, '2022-03-16', 3, '2022-03-18', '2022-03-23', 1, 4),
(13, 'tt', 2, '2022-03-09', 3, '2022-03-01', '2022-03-10', 1, 4),
(14, '', 2, '2022-03-09', 3, '2022-03-01', '2022-03-10', 1, 4),
(16, 'H', 4, '2022-03-16', 6, '2022-03-03', '2022-03-17', 1, 4),
(30, 'HH', 3, '2022-03-11', 4, '2022-03-29', '2022-03-31', 1, 60),
(32, 'H', 12, '2022-03-04', 11, '2022-03-03', '2023-03-11', 1, 53),
(33, 'hhh', 12, '2022-03-17', 23, '2022-03-03', '2022-03-10', 1, 54),
(34, 'hhh', 12, '2022-03-17', 99, '2022-03-03', '2023-03-05', 1, 54);

-- --------------------------------------------------------

--
-- Structure de la table `reservationrestaurant`
--

CREATE TABLE `reservationrestaurant` (
  `idreservationrestau` int(11) NOT NULL,
  `datereservationrestau` date NOT NULL,
  `datedebutres` date NOT NULL,
  `datefinres` date NOT NULL,
  `idU` int(11) NOT NULL,
  `idrestau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservationvol`
--

CREATE TABLE `reservationvol` (
  `idreservationvol` int(11) NOT NULL,
  `idU` int(11) NOT NULL,
  `numvol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservationvol`
--

INSERT INTO `reservationvol` (`idreservationvol`, `idU`, `numvol`) VALUES
(1, 1, 7),
(3, 1, 7),
(5, 1, 12),
(6, 1, 10),
(7, 1, 10),
(8, 1, 11),
(9, 1, 10),
(10, 1, 10),
(11, 1, 11),
(12, 14, 11);

-- --------------------------------------------------------

--
-- Structure de la table `reset`
--

CREATE TABLE `reset` (
  `id` int(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `code` int(22) NOT NULL,
  `timeMils` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reset`
--

INSERT INTO `reset` (`id`, `email`, `code`, `timeMils`) VALUES
(23, 'yassine.messaoud98@gmail.com', 397026, '1645959134546'),
(24, 'yassine.messaoud98@gmail.com', 70582, '1645959330346'),
(25, 'yassine.messaoud98@gmail.com', 821466, '1645959476618'),
(26, 'yassine.messaoud98@gmail.com', 279339, '1646080401097'),
(27, 'yassine.messaoud98@gmail.com', 370721, '1646080426687'),
(28, 'medyassinee.messaoud@esprit.tn', 306731, '1646132262146');

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

CREATE TABLE `restaurant` (
  `idrestau` int(11) NOT NULL,
  `nomrestau` varchar(30) NOT NULL,
  `typerestau` varchar(30) NOT NULL,
  `nbrtable` int(11) NOT NULL,
  `localisation` varchar(30) NOT NULL,
  `telephone` int(11) NOT NULL,
  `photo` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `restaurant`
--

INSERT INTO `restaurant` (`idrestau`, `nomrestau`, `typerestau`, `nbrtable`, `localisation`, `telephone`, `photo`) VALUES
(4, '4forchettoikp', 'lmmmmms', 3, 'carthage', 4, 'lkij'),
(22, 'planAAAAA', '4 FORCHETTE ', 3, 'carthage', 3, 'photo'),
(34, 'f', '4 FORCHETTE ', 0, 'gg', 999, 'f'),
(35, 'f', '4 FORCHETTE ', 0, 'gg', 999, 'f'),
(36, 'g', '5FORCHETTE ', 99, 'rrrrrrr', 99, 'g'),
(37, 'HHHHHHHHHHHHHHHHHH', '5FORCHETTE ', 1, 'TT', 12345678, 'HHHHHHHHHHHHHHHHHH'),
(38, 'TTTTTTT', '5FORCHETTE ', 12, 'GG', 123456789, 'TTTTTTT'),
(39, 'TTTTTTT', '5FORCHETTE ', 12, 'GG', 12345678, 'TTTTTTT'),
(40, 'TTTTTTT', '5FORCHETTE ', 12, 'GG', 1234567, 'TTTTTTT'),
(41, 'hh', '5FORCHETTE ', 13, 'FFFFFFFFF', 123456789, 'hh'),
(43, 'hh', '5FORCHETTE ', 13, 'FFFFFFFFF', 1234567897, 'hh'),
(45, 'g', '4 FORCHETTE ', 12, 'TTT', 12345678, 'g'),
(47, 'HH', '5FORCHETTE ', 23, 'HH', 123456789, 'HH'),
(48, 'L', '4 FORCHETTE ', 2, 'KK', 12345678, 'L'),
(49, 'L', '4 FORCHETTE ', 2, 'KK', 23456890, 'L'),
(50, 'LLLL', '4 FORCHETTE ', 9, 'KK', 12345678, 'LLLL'),
(51, 'LLLLLLLLLLLLLLLLLL', '5FORCHETTE ', 236, 'LLLLLLLL', 1234567899, 'LLLLLLLLLLLLLLLLLL'),
(52, 'LLLL', '5FORCHETTE ', 9, 'LL', 12345678, 'LLLL'),
(55, 'hafoud', '4 FORCHETTE ', 11, 'ariana', 78436589, 'logo.png');

-- --------------------------------------------------------

--
-- Structure de la table `sponsors`
--

CREATE TABLE `sponsors` (
  `id` int(20) NOT NULL,
  `nomSponsors` varchar(255) NOT NULL,
  `prixDonations` double NOT NULL,
  `dateDeb` date NOT NULL,
  `dateFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sponsors`
--

INSERT INTO `sponsors` (`id`, `nomSponsors`, `prixDonations`, `dateDeb`, `dateFin`) VALUES
(3, 'Mohsenaa', 15.501, '2022-02-20', '2022-02-20'),
(5, 'Coca Cola', 11024.65, '2022-02-25', '2023-02-23');

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

CREATE TABLE `ticket` (
  `idTicket` int(20) NOT NULL,
  `prixTicket` float NOT NULL,
  `dateTicket` date NOT NULL,
  `idEve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`idTicket`, `prixTicket`, `dateTicket`, `idEve`) VALUES
(36, 5498500, '2022-03-18', 23),
(37, 55, '2030-03-15', 25),
(38, 55, '2025-03-01', 25),
(39, 849, '2026-03-06', 25),
(40, 99, '2026-02-27', 25),
(41, 88, '2022-03-05', 25);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idU` int(20) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `motpasse` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `role` enum('Admin','Client','','') NOT NULL,
  `activated` enum('Active','Desactive','','') NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idU`, `nom`, `prenom`, `adresse`, `email`, `motpasse`, `photo`, `pays`, `role`, `activated`) VALUES
(1, 'ayass', 'mesas', 'Ariana Soghra', 'maha.mess@gmail.com', '$2a$10$9KIaXQxC3h1D4LRxUTA8iOTRuOkE3fikLIL.XupOuNlM.lyO1tmqK', 'photooo', 'tunis', 'Client', 'Active'),
(3, 'pop', 'aa', 'aa', 'aa', '$2a$10$RC2QV5UYDD21pnsc5GoSrODDm6q9SqKMbn8iDbNM3zB865A/0wiFC', 'aa', 'tunis', 'Admin', 'Active'),
(10, 'yahya', 'messaoud', 'Ariana', 'medyassinee.messaoud@esprit.tn', '$2a$10$DZZxSQNnZ3ScBIk0R2Gmre9qBCoGROKEwsDr2cVHXnYKPg4eMb2uC', 'photo', 'tunisie', 'Admin', 'Active'),
(14, 'med', 'yassine', 'Manouba', 'yassine.messaoud98@gmail.com', '$2a$10$trLpOXdxK4HDwpsFWXN8Fu63kmD6Pte5Fi1uwJkoIV.akqSIkzbD.', '2.jpg', 'tunsie', 'Admin', 'Active'),
(15, 'ayadi', 'aayaddi', 'ojeoaj', 'aaaa@.com', '$2a$10$7shv1X6CPoxb5XmZMppuv.aEMFhW7V5O8iwk1kOThVex848SJHNAy', '10143.jpg', 'tunis', 'Admin', 'Active'),
(18, 'ali', 'mess', 'tuni', 'mahamessaoud2@gmail.com', '$2a$10$Fx3q8sWDHseMBvSr8pkpmu/vsNB5V944Trm3JLpmUHuY95Ban2iIe', '671066803_.jpg', 'tunisie', 'Admin', 'Active'),
(21, 'Asma', 'oudherfi', 'Ariana', 'Asma.oudherfi@esprit.tn', '$2a$10$0IuyW/f66kZG3vr/UAmsM.V/MRnDs21lVQfdVwPaaWmzjLMimVvu6', '98348988_.jpg', 'ariana', 'Admin', 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `numvol` int(10) NOT NULL,
  `dateallervol` date NOT NULL,
  `tempallervol` varchar(30) NOT NULL,
  `dateretourvol` date NOT NULL,
  `tempretourvol` varchar(100) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `classvol` varchar(30) NOT NULL,
  `prixvol` float NOT NULL,
  `typevol` varchar(30) NOT NULL,
  `idcompagnie` int(30) NOT NULL,
  `numserieavion` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`numvol`, `dateallervol`, `tempallervol`, `dateretourvol`, `tempretourvol`, `destination`, `classvol`, `prixvol`, `typevol`, `idcompagnie`, `numserieavion`) VALUES
(7, '2037-05-21', '12:55', '2022-05-12', 'ons', 'rrrrrrrrrrrrrrrrr', 'firstclass', 60.45, 'allerretour', 3, 2),
(10, '2022-03-23', '12:14', '2022-03-31', '12:55', 'canada', 'jj', 12.32, 'firstclass', 5, 2),
(11, '2022-03-05', '1245', '2022-06-04', '12:40', 'france', 'firstclass', 12.25, 'aller ', 5, 2),
(12, '2022-03-03', '12:14', '2023-03-10', '14:32', 'france', 'first', 14.15, 'allerretour', 6, 8),
(13, '2022-03-01', '12:30', '2020-03-01', '14:40', 'paris', 'first', 40.54, 'allerretour', 8, 8),
(14, '2022-03-02', '00:00', '2022-03-06', '00:00', 'paris', 'firstclass', 50.2, 'allerretour', 8, 8),
(15, '2022-03-02', '12:44', '2022-03-26', '12:54', 'france', 'first', 100, 'allerretour', 9, 8),
(16, '2022-03-08', '12:2', '2022-03-15', '15:55', 'lybyie', 'first', 45.54, 'first', 9, 2),
(17, '2022-03-02', '12:44', '2022-03-26', '12:54', 'france', 'first', 100, 'allerretour', 9, 8),
(18, '2022-03-08', '12:2', '2022-03-15', '15:55', 'lybyie', 'first', 45.54, 'first', 9, 2),
(22, '0000-00-00', '', '0000-00-00', '', '', '', 0, '', 8, 4),
(23, '2022-03-05', '00:00', '2022-03-12', '10:10', 'trukey', 'a', 50, 'type', 9, 4),
(24, '2022-03-01', 'nh', '2022-03-10', 'bbkj', 'hbhbbhj', 'bbjhjh', 50, 'bhjjbh', 9, 6),
(25, '2022-03-05', '11:11', '2022-03-18', '11;11', 'yyyyy', 'yyy', 50, 'yyyy', 9, 6),
(26, '2022-03-05', '44:44', '2022-03-11', '11:11', 'drr', 'rrr', 50, 'rr', 9, 6),
(27, '2022-03-05', '44:44', '2022-03-11', '11:11', 'drr', 'rrr', 50, 'rr', 9, 4),
(28, '2022-03-05', '44:44', '2022-03-11', '11:11', 'drr', 'rrr', 50, 'rr', 5, 4),
(29, '2022-03-02', '12:44', '2022-03-06', '12:44', 'mmm', 'mm', 500, 'pp', 5, 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`idadresse`);

--
-- Index pour la table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`numserieavion`);

--
-- Index pour la table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`idAvis`);

--
-- Index pour la table `commandplat`
--
ALTER TABLE `commandplat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_compla` (`idCommande`),
  ADD KEY `fk_Plat` (`Plat`);

--
-- Index pour la table `commandrestau`
--
ALTER TABLE `commandrestau`
  ADD PRIMARY KEY (`Num_Commande`),
  ADD KEY `fkcomUser` (`idUser`);

--
-- Index pour la table `compagnieaerienne`
--
ALTER TABLE `compagnieaerienne`
  ADD PRIMARY KEY (`idcompagnie`),
  ADD KEY `fk_comadr` (`idadresse`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEve`);

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idhotel`);

--
-- Index pour la table `plat`
--
ALTER TABLE `plat`
  ADD PRIMARY KEY (`idPlat`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`idReclamation`);

--
-- Index pour la table `reservationhotels`
--
ALTER TABLE `reservationhotels`
  ADD PRIMARY KEY (`idReservationHotel`),
  ADD KEY `fk_hoo` (`idU`),
  ADD KEY `fk_hooU` (`idhotel`);

--
-- Index pour la table `reservationrestaurant`
--
ALTER TABLE `reservationrestaurant`
  ADD PRIMARY KEY (`idreservationrestau`),
  ADD KEY `fk_user_res` (`idU`),
  ADD KEY `fk_reshotell_restau` (`idrestau`);

--
-- Index pour la table `reservationvol`
--
ALTER TABLE `reservationvol`
  ADD PRIMARY KEY (`idreservationvol`),
  ADD KEY `fkreseruser` (`idU`),
  ADD KEY `fkresevvol` (`numvol`);

--
-- Index pour la table `reset`
--
ALTER TABLE `reset`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`idrestau`);

--
-- Index pour la table `sponsors`
--
ALTER TABLE `sponsors`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `fk_idevetick` (`idEve`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idU`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`numvol`),
  ADD KEY `fkcomvol` (`idcompagnie`),
  ADD KEY `fkvolavion` (`numserieavion`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `idadresse` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `avis`
--
ALTER TABLE `avis`
  MODIFY `idAvis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `commandplat`
--
ALTER TABLE `commandplat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `compagnieaerienne`
--
ALTER TABLE `compagnieaerienne`
  MODIFY `idcompagnie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEve` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idhotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT pour la table `plat`
--
ALTER TABLE `plat`
  MODIFY `idPlat` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `idReclamation` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `reservationhotels`
--
ALTER TABLE `reservationhotels`
  MODIFY `idReservationHotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT pour la table `reservationrestaurant`
--
ALTER TABLE `reservationrestaurant`
  MODIFY `idreservationrestau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `reservationvol`
--
ALTER TABLE `reservationvol`
  MODIFY `idreservationvol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `reset`
--
ALTER TABLE `reset`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `idrestau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `sponsors`
--
ALTER TABLE `sponsors`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idTicket` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idU` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `vol`
--
ALTER TABLE `vol`
  MODIFY `numvol` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commandplat`
--
ALTER TABLE `commandplat`
  ADD CONSTRAINT `fk_Plat` FOREIGN KEY (`Plat`) REFERENCES `plat` (`idPlat`),
  ADD CONSTRAINT `fk_compla` FOREIGN KEY (`idCommande`) REFERENCES `commandrestau` (`Num_Commande`);

--
-- Contraintes pour la table `commandrestau`
--
ALTER TABLE `commandrestau`
  ADD CONSTRAINT `fkcomUser` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idU`);

--
-- Contraintes pour la table `compagnieaerienne`
--
ALTER TABLE `compagnieaerienne`
  ADD CONSTRAINT `fk_comadr` FOREIGN KEY (`idadresse`) REFERENCES `adresse` (`idadresse`);

--
-- Contraintes pour la table `reservationrestaurant`
--
ALTER TABLE `reservationrestaurant`
  ADD CONSTRAINT `fk_reshotell_restau` FOREIGN KEY (`idrestau`) REFERENCES `restaurant` (`idrestau`),
  ADD CONSTRAINT `fk_user_res` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`);

--
-- Contraintes pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_idevetick` FOREIGN KEY (`idEve`) REFERENCES `evenement` (`idEve`);

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `fkcomvol` FOREIGN KEY (`idcompagnie`) REFERENCES `compagnieaerienne` (`idcompagnie`),
  ADD CONSTRAINT `fkvolavion` FOREIGN KEY (`numserieavion`) REFERENCES `avion` (`numserieavion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
