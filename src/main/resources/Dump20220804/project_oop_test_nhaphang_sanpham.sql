-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: project_oop_test
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `nhaphang_sanpham`
--

DROP TABLE IF EXISTS `nhaphang_sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhaphang_sanpham` (
  `id_nhaphang` bigint(20) NOT NULL,
  `id_sanpham` bigint(20) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `Gia` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_nhaphang`,`id_sanpham`),
  KEY `FK_3rtbelk3iseay673r60psar7o` (`id_sanpham`),
  CONSTRAINT `FK_3rtbelk3iseay673r60psar7o` FOREIGN KEY (`id_sanpham`) REFERENCES `san_pham` (`id`),
  CONSTRAINT `FK_9lc7nhayxd432lq94ia80vaih` FOREIGN KEY (`id_nhaphang`) REFERENCES `nhap_hang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhaphang_sanpham`
--

LOCK TABLES `nhaphang_sanpham` WRITE;
/*!40000 ALTER TABLE `nhaphang_sanpham` DISABLE KEYS */;
INSERT INTO `nhaphang_sanpham` VALUES (2,9,10,85000),(2,10,15,85000),(2,11,5,85000),(3,11,5,85000),(3,12,10,85000),(3,13,15,85000),(4,14,10,85000),(4,15,5,85000),(4,16,5,87000),(5,15,20,85000),(5,16,20,87000),(5,17,15,87000),(9,18,20,87000),(9,19,15,87000),(9,20,20,87000),(14,21,20,87000),(14,22,20,114000),(14,23,20,114000),(14,24,20,114000),(14,25,20,114000);
/*!40000 ALTER TABLE `nhaphang_sanpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 20:54:51
