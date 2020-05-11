-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2020 at 03:39 PM
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
-- Table structure for table `c_team`
--

CREATE TABLE `c_team` (
  `Id` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `team_url` varchar(50) NOT NULL,
  `Date` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `c_team`
--

INSERT INTO `c_team` (`Id`, `team_name`, `team_url`, `Date`) VALUES
(1, 'Afghanistan', '/team/_/id/40/afghanistan', '2020-05-11 11:07:22'),
(2, 'Australia', '/team/_/id/2/australia', '2020-05-11 11:07:23'),
(3, 'Bangladesh', '/team/_/id/25/bangladesh', '2020-05-11 11:07:23'),
(4, 'England', '/team/_/id/1/england', '2020-05-11 11:07:23'),
(5, 'India', '/team/_/id/6/india', '2020-05-11 11:07:23'),
(6, 'Ireland', '/team/_/id/29/ireland', '2020-05-11 11:07:23'),
(7, 'Namibia', '/team/_/id/28/namibia', '2020-05-11 11:07:23'),
(8, 'Nepal', '/team/_/id/33/nepal', '2020-05-11 11:07:23'),
(9, 'New Zealand', '/team/_/id/5/new-zealand', '2020-05-11 11:07:23'),
(10, 'Oman', '/team/_/id/37/oman', '2020-05-11 11:07:23'),
(11, 'Pakistan', '/team/_/id/7/pakistan', '2020-05-11 11:07:23'),
(12, 'Papua New Guinea', '/team/_/id/20/papua-new-guinea', '2020-05-11 11:07:23'),
(13, 'Scotland', '/team/_/id/30/scotland', '2020-05-11 11:07:23'),
(14, 'South Africa', '/team/_/id/3/south-africa', '2020-05-11 11:07:23'),
(15, 'Sri Lanka', '/team/_/id/8/sri-lanka', '2020-05-11 11:07:23'),
(16, 'United Arab Emirates', '/team/_/id/27/united-arab-emirates', '2020-05-11 11:07:23'),
(17, 'USA', '/team/_/id/11/united-states-of-america', '2020-05-11 11:07:23'),
(18, 'West Indies', '/team/_/id/4/west-indies', '2020-05-11 11:07:23'),
(19, 'Zimbabwe', '/team/_/id/9/zimbabwe', '2020-05-11 11:07:23'),
(20, 'Bermuda', '', '2020-05-11 12:47:28'),
(21, 'Canada', '', '2020-05-11 12:47:28'),
(22, 'Hong Kong', '', '2020-05-11 12:47:28'),
(23, 'Kenya', '', '2020-05-11 12:47:28'),
(24, 'Netherlands', '', '2020-05-11 12:47:29'),
(25, 'Utd Arab Emirates', '', '2020-05-11 12:47:29'),
(26, 'United States', '', '2020-05-11 12:47:29'),
(27, 'Belgium', '', '2020-05-11 12:47:29'),
(28, 'Denmark', '', '2020-05-11 12:47:29'),
(29, 'Finland', '', '2020-05-11 12:47:29'),
(30, 'Greece', '', '2020-05-11 12:47:29'),
(31, 'Guernsey', '', '2020-05-11 12:47:29'),
(32, 'Malawi', '', '2020-05-11 12:47:29'),
(33, 'Malaysia', '', '2020-05-11 12:47:29'),
(34, 'Malta', '', '2020-05-11 12:47:29'),
(35, 'Mexico', '', '2020-05-11 12:47:29'),
(36, 'Peru', '', '2020-05-11 12:47:29'),
(37, 'Qatar', '', '2020-05-11 12:47:29'),
(38, 'Romania', '', '2020-05-11 12:47:29'),
(39, 'Singapore', '', '2020-05-11 12:47:29'),
(40, 'Spain', '', '2020-05-11 12:47:29'),
(41, 'Thailand', '', '2020-05-11 12:47:29'),
(42, 'Uganda', '', '2020-05-11 12:47:29'),
(43, 'Vanuatu', '', '2020-05-11 12:47:29'),
(44, 'Other', '', '2020-05-11 12:47:29');

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
(129, 'hemal', '', '11-05-2020', '07:08:42');

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
  `SALARY` double NOT NULL,
  `PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `NAME`, `DOB`, `ADDRESS`, `PHONE`, `SALARY`, `PASSWORD`) VALUES
(1, 'hemal', '23-12-1995', 'Kanakapura Ramanagaram', '9880755666', 50000, '12');

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
-- AUTO_INCREMENT for table `c_team`
--
ALTER TABLE `c_team`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `login_details`
--
ALTER TABLE `login_details`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

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
