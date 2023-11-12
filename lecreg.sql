-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 31, 2023 at 02:52 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lecreg`
--

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE IF NOT EXISTS `lecturer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `telno` int NOT NULL,
  `wexperience` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`id`, `address`, `age`, `email`, `lname`, `qualification`, `subject`, `telno`, `wexperience`) VALUES
(1, 'Negombo', 26, 'naveen@gmail.com', 'Naveen', 'Bsc', 'Software Engineering', 740808956, '4 years'),
(4, 'Rathnapura', 30, 'sandaru@gmailcom', 'Malshan', 'BSC', 'Tamil', 123456789, '3years'),
(5, 'Aturugiriya', 26, 'hasira@gmail.com', 'Hasira', 'Masters', 'English', 767864011, '2 years');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
