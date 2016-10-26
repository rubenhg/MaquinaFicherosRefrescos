-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2016 at 12:08 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maquinarefrescos`
--

-- --------------------------------------------------------

--
-- Table structure for table `monedas`
--

CREATE TABLE `monedas` (
  `nombre` varchar(45) NOT NULL,
  `valor` int(11) NOT NULL,
  `inicial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monedas`
--

INSERT INTO `monedas` (`nombre`, `valor`, `inicial`) VALUES
('100cent', 100, 5),
('10cent', 10, 5),
('200cent', 200, 5),
('20cent', 20, 5),
('50cent', 50, 5),
('5cent', 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Precio` int(11) NOT NULL,
  `NumLatas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`idProductos`, `Nombre`, `Precio`, `NumLatas`) VALUES
(1, 'CocaCola', 160, 5),
(2, 'FantaNaranja', 140, 5),
(3, 'SevenUP', 135, 5),
(4, 'Agua', 75, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monedas`
--
ALTER TABLE `monedas`
  ADD PRIMARY KEY (`nombre`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProductos`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
