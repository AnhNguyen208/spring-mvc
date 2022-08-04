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
-- Table structure for table `don_hang`
--

DROP TABLE IF EXISTS `don_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `don_hang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `ThongTinKhachHang` varchar(255) DEFAULT NULL,
  `idNhanVien` bigint(20) DEFAULT NULL,
  `ChietKhau` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q8ujb25oy8o4j8lv92gyg5mn4` (`idNhanVien`),
  CONSTRAINT `FK_q8ujb25oy8o4j8lv92gyg5mn4` FOREIGN KEY (`idNhanVien`) REFERENCES `nhan_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `don_hang`
--

LOCK TABLES `don_hang` WRITE;
/*!40000 ALTER TABLE `don_hang` DISABLE KEYS */;
INSERT INTO `don_hang` VALUES (1,'nguyenvana','2022-07-13 10:52:19','nguyenvana','2022-07-13 10:52:19','<p>T&ecirc;n KH: Roland Revening</p> <p>SDT: 848-206-3367</p> <p>Địa chỉ: 78 Superior Center</p>',3,100000),(2,'nguyenvana','2022-07-13 21:02:46','nguyenvana','2022-07-13 21:02:46','<p>T&ecirc;n KH: Levey Fawltey</p> <p>SDT: 481-265-6274</p> <p>Địa chỉ: 01131 Waywood Plaza</p>',3,100000),(3,'nguyenvana','2022-07-14 09:35:19','nguyenvana','2022-07-14 09:35:19','<p>T&ecirc;n KH: Alex Brittin</p> <p>SDT: 847-470-3247</p> <p>Địa chỉ: 1626 Lakeland Circle</p>',3,100000),(4,'nguyenvana','2022-07-14 09:46:57','nguyenvana','2022-07-14 09:46:57','<p>T&ecirc;n KH: Fraze Lambarth</p> <p>SDT: 447-657-0664</p> <p>Địa chỉ: 28808 Fairview Way</p>',3,100000),(5,'nguyenvana','2022-07-14 09:50:11','nguyenvana','2022-07-14 09:50:11','<p>T&ecirc;n KH: Larry Dominec</p> <p>SDT: 339-954-2950</p> <p>Địa chỉ: 8 Rowland Way</p>',3,100000),(6,'anonymousUser','2022-07-14 10:08:50','anonymousUser','2022-07-14 10:08:50','<p>T&ecirc;n KH: Juditha Baudins</p> <p>SDT: 783-308-8217</p> <p>Địa chỉ: 277 Londonderry Park</p>',3,100000),(7,'nguyenvana','2022-07-14 10:24:12','nguyenvana','2022-07-14 10:24:12','<p>T&ecirc;n KH: Wileen Fluger</p> <p>SDT: 650-202-7732</p> <p>Địa chỉ: 77 Corben Hill</p>',3,100000),(8,'nguyenvana','2022-07-14 22:34:46','nguyenvana','2022-07-14 22:34:46','<p>T&ecirc;n KH: Lyn Gerran </p> <p>SDT: 249-325-3080 </p> <p>Địa chỉ: 0979 Mockingbird Center </p>',7,100000),(9,'nguyenvana','2022-07-14 22:40:03','nguyenvana','2022-07-14 22:40:03','<p>T&ecirc;n KH: Bogey Blencowe </p> <p>SDT: 694-294-7494 </p> <p>Địa chỉ: 94012 Loomis Avenue </p>',7,100000),(10,'nguyenvana','2022-07-14 22:52:15','nguyenvana','2022-07-14 22:52:16','<p>T&ecirc;n KH: Demetrius Mabb </p> <p>SDT: 936-358-6029 </p> <p>Địa chỉ: 479 Redwing Terrace </p>',7,100000),(11,'nguyenvana','2022-07-15 08:18:47','nguyenvana','2022-07-15 08:18:47','<p>T&ecirc;n KH: Ailbert Tracey </p> <p>SDT: 752-698-7683 </p> <p>Địa chỉ: 571 Havey Street </p>',7,100000),(12,'nguyenvana','2022-07-15 08:33:32','nguyenvana','2022-07-15 08:33:32','<p>T&ecirc;n KH: Nester Gryglewski </p> <p>SDT: 490-906-5306 </p> <p>Địa chỉ: 6 Independence Pass </p>',7,150000),(13,'nguyenvana','2022-07-15 09:43:18','nguyenvana','2022-07-15 09:43:18','<p>T&ecirc;n KH: Janeczka Vogel  <p>SDT: 461-681-8497  <p>Địa chỉ: 08107 Hanson Trail ',7,100000),(14,'nguyenvana','2022-07-16 20:59:52','nguyenvana','2022-07-16 20:59:53','<p>T&ecirc;n KH: Archy Shapter</p>\n\n<p>SDT: 847-142-3945</p>\n\n<p>Địa chỉ: 5 Scoville Parkway</p>\n',3,150000),(15,'anonymousUser','2022-07-16 21:20:19','anonymousUser','2022-07-16 21:20:19','<p>T&ecirc;n KH: Bob Matushenko</p>\n\n<p>SDT: 508-332-3150</p>\n\n<p>Địa chỉ: 43 Rusk Place</p>\n',3,150000),(19,'nguyenvana','2022-07-20 12:14:20','nguyenvana','2022-07-20 12:14:20','<p>T&ecirc;n KH: Archy Shapter</p>\n\n<p>SDT: 847-142-3945</p>\n\n<p>Địa chỉ: 5 Scoville Parkway</p>\n',7,100000),(20,'nguyenvana','2022-07-20 20:03:46','nguyenvana','2022-07-20 20:03:46','<p>T&ecirc;n KH: Bob Matushenko</p>\n\n<p>SDT: 508-332-3150</p>\n\n<p>Địa chỉ: 43 Rusk Place</p>\n',7,150000),(25,'nguyenvana','2022-07-20 21:28:12','nguyenvana','2022-07-20 21:28:12','<p>T&ecirc;n KH: Pearce Kinforth</p>\n\n<p>SDT: 274-210-5698</p>\n\n<p>Địa chỉ: 98 Hagan Center</p>\n',3,50000),(26,'nguyenvana','2022-07-20 21:29:32','nguyenvana','2022-07-20 21:29:32','<p>T&ecirc;n KH: Willow Wombwell</p>\n\n<p>SDT: 143-234-0525</p>\n\n<p>Địa chỉ: 11529 Sachtjen Plaza</p>\n',7,250000),(28,'nguyenvana','2022-07-22 16:45:32','nguyenvana','2022-07-22 16:45:32','<p>T&ecirc;n KH: Anthia Kassidy</p>\n\n<p>SDT: 904-166-6335</p>\n\n<p>Địa chỉ: 8 Waywood Alley</p>\n',3,50000),(29,'nguyenvanb','2022-08-04 16:35:46','nguyenvanb','2022-08-04 16:35:46','<p>T&ecirc;n KH: Gerti Hambers</p>\n\n<p>SDT: 488-788-2642</p>\n\n<p>Địa chỉ: 440 Chinook Terrace</p>\n',3,50000);
/*!40000 ALTER TABLE `don_hang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 20:54:53
