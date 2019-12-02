-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelaria
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `registrarquartos`
--

DROP TABLE IF EXISTS `registrarquartos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrarquartos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idHospede` int(11) NOT NULL,
  `idQuarto` int(11) NOT NULL,
  `diaria` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idHospede` (`idHospede`),
  KEY `idQuarto` (`idQuarto`),
  CONSTRAINT `registrarquartos_ibfk_1` FOREIGN KEY (`idHospede`) REFERENCES `hospede` (`ID`),
  CONSTRAINT `registrarquartos_ibfk_2` FOREIGN KEY (`idQuarto`) REFERENCES `quarto` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrarquartos`
--

LOCK TABLES `registrarquartos` WRITE;
/*!40000 ALTER TABLE `registrarquartos` DISABLE KEYS */;
INSERT INTO `registrarquartos` VALUES (1,17,7,5,500),(2,17,6,3,500),(3,17,11,3,800),(4,17,7,6,800),(5,17,11,3,800),(6,17,8,3,800),(7,17,7,4,500),(8,17,6,5,500),(9,26,6,2,800),(10,17,8,7,800),(11,28,10,6,500),(12,28,8,5,8797);
/*!40000 ALTER TABLE `registrarquartos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 17:39:39
