-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2020 at 02:20 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `tkAdmin` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietsach`
--

CREATE TABLE `chitietsach` (
  `IDSach` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `tinhTrang` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKhachHang` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `hoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(65) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `maThe` varchar(7) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khosach`
--

CREATE TABLE `khosach` (
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `muonsach`
--

CREATE TABLE `muonsach` (
  `maMuonSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `maThe` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `IDSach` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `thoiDiemMuon` date NOT NULL,
  `thoiGianMuon` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nguoiquanly`
--

CREATE TABLE `nguoiquanly` (
  `maQuanLy` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `hoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(65) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `chucVu` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `tenSach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tenTacGia` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tenNXB` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `namXB` int(4) NOT NULL,
  `theLoai` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngonNgu` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tomTatNoiDung` text COLLATE utf8_unicode_ci NOT NULL,
  `giaTien` int(11) NOT NULL,
  `soTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `the`
--

CREATE TABLE `the` (
  `maThe` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `maKhachhang` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `ngayCap` date NOT NULL,
  `ngayHetHan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `trasach`
--

CREATE TABLE `trasach` (
  `maMuonSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `thoiDiemTra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`tkAdmin`);

--
-- Indexes for table `chitietsach`
--
ALTER TABLE `chitietsach`
  ADD PRIMARY KEY (`IDSach`),
  ADD KEY `FK_maSach_2` (`maSach`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKhachHang`),
  ADD KEY `FK_maThe` (`maThe`);

--
-- Indexes for table `khosach`
--
ALTER TABLE `khosach`
  ADD KEY `FK_maSach` (`maSach`);

--
-- Indexes for table `muonsach`
--
ALTER TABLE `muonsach`
  ADD PRIMARY KEY (`maMuonSach`),
  ADD KEY `FK_IDSach` (`IDSach`),
  ADD KEY `FK_maThe_2` (`maThe`);

--
-- Indexes for table `nguoiquanly`
--
ALTER TABLE `nguoiquanly`
  ADD PRIMARY KEY (`maQuanLy`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`maSach`);

--
-- Indexes for table `the`
--
ALTER TABLE `the`
  ADD PRIMARY KEY (`maThe`),
  ADD KEY `FK_maKhachHang` (`maKhachhang`);

--
-- Indexes for table `trasach`
--
ALTER TABLE `trasach`
  ADD KEY `FK_maMuonsach` (`maMuonSach`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietsach`
--
ALTER TABLE `chitietsach`
  ADD CONSTRAINT `FK_maSach_2` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`);

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `FK_maThe` FOREIGN KEY (`maThe`) REFERENCES `the` (`maThe`);

--
-- Constraints for table `khosach`
--
ALTER TABLE `khosach`
  ADD CONSTRAINT `FK_maSach` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`);

--
-- Constraints for table `muonsach`
--
ALTER TABLE `muonsach`
  ADD CONSTRAINT `FK_IDSach` FOREIGN KEY (`IDSach`) REFERENCES `chitietsach` (`IDSach`),
  ADD CONSTRAINT `FK_maThe_2` FOREIGN KEY (`maThe`) REFERENCES `the` (`maThe`);

--
-- Constraints for table `the`
--
ALTER TABLE `the`
  ADD CONSTRAINT `FK_maKhachHang` FOREIGN KEY (`maKhachhang`) REFERENCES `khachhang` (`maKhachHang`);

--
-- Constraints for table `trasach`
--
ALTER TABLE `trasach`
  ADD CONSTRAINT `FK_maMuonsach` FOREIGN KEY (`maMuonSach`) REFERENCES `muonsach` (`maMuonSach`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
