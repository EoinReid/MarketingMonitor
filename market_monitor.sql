-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2019 at 05:34 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `market_monitor`
--

-- --------------------------------------------------------

--
-- Table structure for table `adds`
--

CREATE TABLE `adds` (
  `Type` enum('For Sale','Wanted') NOT NULL,
  `Photo` longblob,
  `Title` text NOT NULL,
  `Price` double NOT NULL,
  `Section` text NOT NULL,
  `Description` text NOT NULL,
  `Timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID` int(11) NOT NULL,
  `Currency` enum('£','€') NOT NULL,
  `SubSection` text NOT NULL,
  `view_Count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adds`
--

INSERT INTO `adds` (`Type`, `Photo`, `Title`, `Price`, `Section`, `Description`, `Timestamp`, `ID`, `Currency`, `SubSection`, `view_Count`) VALUES
('For Sale', NULL, '40 Inch Samsung Smart TV', 380, 'Electronics', '40 Inch Samsung Smart TV, New with original box, SA65V', '2019-11-21 15:38:25', 1, '€', 'TV', 213),
('For Sale', NULL, '42 Inch Samsung Tv', 345.99, 'Electronics', 'A 42 Inch Samsung TV, brand new with original box, not used, SA21c', '2019-11-21 15:47:17', 2, '€', 'TV', 186),
('For Sale', NULL, '500GB Xbox One and Two Controllers', 199.99, 'Electronics', 'A 500GB Xbox One reset to factory standard, Comes with two controllers both in good condition', '2019-11-21 15:47:17', 3, '€', 'Games & Consoles', 225),
('For Sale', NULL, 'Kona Hei Hei Trail DL Large 2019', 1800, 'Sports & Hobbies', 'Make: Kona\r\nModel: Hei Hei Trail DL\r\nYear: 2019\r\n\r\nSize: Large\r\n\r\nCondition: New/Ex-Display Model.\r\nGet a whopping e1000 off this Ex-Display bike! Brand new, never ridden and ready to rip some trails.\r\n\r\nFrame: Kona 6061 Aluminum Butted 140mm Travel\r\nFork: RockShox Revelation RC Solo Air 140mm Tapered 110mm Spacing\r\n\r\nWheels: WTB STP i29 TCS\r\nTyres: Maxxis Minion DHF TR DUAL 27.5x2.3\" / Maxxis Tomahawk TR DUAL 27.5x2.3\"\r\n\r\nGroupset\r\nShifters: SRAM GX-Eagle\r\nBrakes: SRAM Guide R - SRAM Centerline 180mm/SRAM Centerline 160mm\r\nFront Derailleur: N/a\r\nRear Derailleur: SRAM GX-Eagle\r\nCrankset: SRAM Descendant 6K - 34t X-Sync Eagle\r\n\r\nRRP: €2500\r\nPrice Now: €1800\r\n\r\nReference Code: KLB87', '2019-11-21 15:55:40', 4, '€', 'Cycling', 78),
('For Sale', NULL, 'Sony 50Inch Curved Smart Tv', 500, 'Electronics', 'Sony 50Inch Curved Smart Tv\r\nBuilt In WiFi \r\nSmart Tv \r\nSpotless Condition \r\nYouTube Netflix And Loads More Apps \r\nRRP €850\r\nModel KD50SD8005\r\nReference Code : HT87C', '2019-11-21 15:55:40', 5, '€', 'TV', 56);

-- --------------------------------------------------------

--
-- Table structure for table `donedeal_account`
--

CREATE TABLE `donedeal_account` (
  `Full_Name` text NOT NULL,
  `Phone` varchar(12) DEFAULT NULL,
  `County` text NOT NULL,
  `Area` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`) VALUES
(1, 'username', 'password'),
(2, 'James_Brown', 'JB_Pass123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adds`
--
ALTER TABLE `adds`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adds`
--
ALTER TABLE `adds`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
