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
-- Table structure for table `hang`
--

DROP TABLE IF EXISTS `hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `AnhDaiDienHang` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SDT` varchar(255) DEFAULT NULL,
  `TenHang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hang`
--

LOCK TABLES `hang` WRITE;
/*!40000 ALTER TABLE `hang` DISABLE KEYS */;
INSERT INTO `hang` VALUES (1,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1l_7818wSlaFyGvJjKXK_zYdR299heLxa/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'Owen'),(2,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1LI9dmXWgglJ5HCSj2Vqa_aAtMQVipLGH/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'An Phước Pierre Cardin'),(3,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1EwxJss-e2slDn8OFL1afdJ71UsCHO31C/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'Việt Tiến'),(4,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1kRsjPRpYMQl_DGBrljFsUijjmKKih69q/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'Top4man'),(5,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"me src=&quot;https://drive.google.com/file/d/13C2GcFziusr5XrLp5KW2MWBgFa7_iMvq/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'4men'),(6,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"150\" scrolling=\"no\" src=\"https://drive.google.com/file/d/15TZ6j43MnDyRoXlyShZGiBLZwij7VG5B/preview\" width=\"150\"></iframe></p>',NULL,NULL,NULL,'Biluxury'),(7,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"100\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1sFOR1HaQ9HtGc3gMkahIT_wepqVKJzGy/preview\" width=\"100\"></iframe></p>',NULL,NULL,NULL,'Merriman'),(8,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"100\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1dJEomQ74GeE5qegf8UHDqEuux5Ht8Ltg/preview\" width=\"100\"></iframe></p>\n',NULL,NULL,NULL,'Novelty'),(9,NULL,NULL,NULL,NULL,'<p><iframe frameborder=\"0\" height=\"100\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1dxEecn444YZli_dLASAO7Ztgw8P8oCkd/preview\" width=\"100\"></iframe></p>',NULL,NULL,NULL,'May 10'),(10,NULL,NULL,NULL,NULL,'\n<p><iframe frameborder=\"0\" height=\"100\" scrolling=\"no\" src=\"https://drive.google.com/file/d/1LFjv3Kplrms9COX0hwmv54eqRDXQ4_R9/preview\" width=\"100\"></iframe></p>\n\n',NULL,NULL,NULL,'Gucci');
/*!40000 ALTER TABLE `hang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 20:54:52
