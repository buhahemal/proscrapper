-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2020 at 08:04 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proscrapper`
--

-- --------------------------------------------------------

--
-- Table structure for table `c_grounds`
--

CREATE TABLE `c_grounds` (
  `Id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `ground_city` varchar(100) DEFAULT NULL,
  `ground_name` varchar(100) DEFAULT NULL,
  `no_of_test` varchar(30) DEFAULT NULL,
  `no_of_odi` varchar(30) DEFAULT NULL,
  `no_of_t20` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_player`
--

CREATE TABLE `c_player` (
  `Id` int(11) NOT NULL,
  `player_name` text NOT NULL,
  `player_url` text NOT NULL,
  `country_Id` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '1 For Active 0 For Inactive',
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_player_odi_batting`
--

CREATE TABLE `c_player_odi_batting` (
  `Id` int(11) NOT NULL,
  `c_player_Id` int(11) NOT NULL,
  `No_of_match` varchar(11) NOT NULL,
  `innings` varchar(11) NOT NULL,
  `Run` varchar(11) NOT NULL,
  `Notout` varchar(11) NOT NULL,
  `Highest_score` varchar(11) NOT NULL,
  `Average` varchar(11) NOT NULL,
  `Balls_faced` varchar(11) NOT NULL,
  `Strike_rate` varchar(11) NOT NULL,
  `no_of_century` varchar(11) NOT NULL,
  `no_of_fifty` varchar(11) NOT NULL,
  `no_of_four` varchar(11) NOT NULL,
  `no_of_six` varchar(11) NOT NULL,
  `no_of_catches` varchar(11) NOT NULL,
  `no_of_stumping` varchar(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_player_profile`
--

CREATE TABLE `c_player_profile` (
  `Id` int(11) NOT NULL,
  `c_player_Id` int(11) NOT NULL,
  `player_fullname` varchar(250) NOT NULL,
  `player_borndetails` varchar(300) NOT NULL,
  `player_age` varchar(20) NOT NULL,
  `player_team` varchar(250) NOT NULL,
  `player_battingstyle` varchar(50) NOT NULL,
  `player_bowlingstyle` varchar(50) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_player_t20_batting`
--

CREATE TABLE `c_player_t20_batting` (
  `Id` int(11) NOT NULL,
  `c_player_Id` int(11) NOT NULL,
  `No_of_match` varchar(11) NOT NULL,
  `innings` varchar(11) NOT NULL,
  `Run` varchar(11) NOT NULL,
  `Notout` varchar(11) NOT NULL,
  `Highest_score` varchar(11) NOT NULL,
  `Average` varchar(11) NOT NULL,
  `Balls_faced` varchar(11) NOT NULL,
  `Strike_rate` varchar(11) NOT NULL,
  `no_of_century` varchar(11) NOT NULL,
  `no_of_fifty` varchar(11) NOT NULL,
  `no_of_four` varchar(11) NOT NULL,
  `no_of_six` varchar(11) NOT NULL,
  `no_of_catches` varchar(11) NOT NULL,
  `no_of_stumping` varchar(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_player_test_batting`
--

CREATE TABLE `c_player_test_batting` (
  `Id` int(11) NOT NULL,
  `c_player_Id` int(11) NOT NULL,
  `No_of_match` varchar(11) NOT NULL,
  `innings` varchar(11) NOT NULL,
  `Run` varchar(11) NOT NULL,
  `Notout` varchar(11) NOT NULL,
  `Highest_score` varchar(11) NOT NULL,
  `Average` varchar(11) NOT NULL,
  `Balls_faced` varchar(11) NOT NULL,
  `Strike_rate` varchar(11) NOT NULL,
  `no_of_century` varchar(11) NOT NULL,
  `no_of_fifty` varchar(11) NOT NULL,
  `no_of_four` varchar(11) NOT NULL,
  `no_of_six` varchar(11) NOT NULL,
  `no_of_catches` varchar(11) NOT NULL,
  `no_of_stumping` varchar(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `c_team`
--

CREATE TABLE `c_team` (
  `Id` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `team_url` varchar(50) NOT NULL,
  `Date` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `Id` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `DATE` varchar(20) NOT NULL,
  `TIME` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_details`
--

INSERT INTO `login_details` (`Id`, `NAME`, `TYPE`, `DATE`, `TIME`) VALUES
(126, 'hemal', '', '11-05-2020', '06:53:25'),
(127, 'hemal', '', '11-05-2020', '06:54:40'),
(128, 'hemal', '', '11-05-2020', '06:55:08'),
(129, 'hemal', '', '11-05-2020', '07:08:42'),
(130, 'hemal', '', '11-05-2020', '07:14:01'),
(131, 'hemal', '', '11-05-2020', '07:14:16'),
(132, 'hemal', '', '11-05-2020', '07:31:58'),
(133, 'Hemal', '', '11-05-2020', '09:16:43'),
(134, 'hemal', '', '11-05-2020', '10:17:41'),
(135, 'hemal', '', '11-05-2020', '10:26:35');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `NAME`, `DOB`, `ADDRESS`, `PHONE`, `PASSWORD`) VALUES
(1, 'Hemal', '23-12-1995', '91-Atmiy Bunglows ,Surat', '9265075346', '12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `c_grounds`
--
ALTER TABLE `c_grounds`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `c_player`
--
ALTER TABLE `c_player`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Country` (`country_Id`);

--
-- Indexes for table `c_player_odi_batting`
--
ALTER TABLE `c_player_odi_batting`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `c_player_profile`
--
ALTER TABLE `c_player_profile`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `c_player_t20_batting`
--
ALTER TABLE `c_player_t20_batting`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `c_player_test_batting`
--
ALTER TABLE `c_player_test_batting`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `c_team`
--
ALTER TABLE `c_team`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `login_details`
--
ALTER TABLE `login_details`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `c_grounds`
--
ALTER TABLE `c_grounds`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_player`
--
ALTER TABLE `c_player`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_player_odi_batting`
--
ALTER TABLE `c_player_odi_batting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_player_profile`
--
ALTER TABLE `c_player_profile`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_player_t20_batting`
--
ALTER TABLE `c_player_t20_batting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_player_test_batting`
--
ALTER TABLE `c_player_test_batting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_team`
--
ALTER TABLE `c_team`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login_details`
--
ALTER TABLE `login_details`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `c_player`
--
ALTER TABLE `c_player`
  ADD CONSTRAINT `Country` FOREIGN KEY (`country_Id`) REFERENCES `c_team` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
