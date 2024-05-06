-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 06 May 2024, 22:30:16
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `20210305052`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cardealer`
--

CREATE TABLE `cardealer` (
  `id` int(11) NOT NULL,
  `carDealerName` varchar(50) NOT NULL,
  `location` varchar(100) NOT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `cardealer`
--

INSERT INTO `cardealer` (`id`, `carDealerName`, `location`, `telephone`) VALUES
(1, 'GUR CARDEALER', 'İstanbul/Maltepe', 533333909),
(2, 'YILMAZ CARDEALER', 'İstanbul/Pendik', 533333908),
(3, 'DEMIR CARDEALER', 'İstanbul/Ümraniye', 533333907),
(4, 'FATIH CARDEALER', 'İstanbul/Tuzla', 533333904),
(5, 'CEM CARDEALER', 'İstanbul/Kartal', 533333906);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`id`, `name`, `surname`, `telephone`) VALUES
(1, 'Enes', 'Çağan', 232323122),
(2, 'Yiğit', 'Duru', 232323123),
(3, 'Furkan', 'Bulut', 232323124),
(4, 'Kürşat', 'Karademir', 232323128),
(5, 'Tarık', 'Erdoğan', 232323125);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `COLOR` varchar(50) NOT NULL,
  `PRICE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`ID`, `NAME`, `COLOR`, `PRICE`) VALUES
(1, 'BMW', 'GREEN', 35000),
(2, 'VOLKSWAGEN ', 'WHITE', 15000),
(3, 'MERCEDES', 'WHITE', 40000),
(4, 'MASERATI', 'BLACK', 45000),
(5, 'PORSCHE', 'BLACK', 50000),
(6, 'RANGE ROVER', 'GRAY', 55000),
(7, 'ASTON MARTIN', 'WHITE', 60000),
(8, 'RENAULT', 'RED', 10000),
(9, 'FORD', 'GREEN', 15000),
(10, 'AUDI', 'BLACK', 35000);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `cardealer`
--
ALTER TABLE `cardealer`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `cardealer`
--
ALTER TABLE `cardealer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
