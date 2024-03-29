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
-- Table structure for table `hospede`
--

DROP TABLE IF EXISTS `hospede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospede` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) NOT NULL,
  `IDADE` int(11) DEFAULT NULL,
  `TELEFONE` varchar(200) NOT NULL,
  `EMAIL` varchar(200) NOT NULL,
  `idpagamento` int(11) NOT NULL,
  `Status_hospede` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idpagamento` (`idpagamento`),
  CONSTRAINT `hospede_ibfk_1` FOREIGN KEY (`idpagamento`) REFERENCES `metodopagamento` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospede`
--

LOCK TABLES `hospede` WRITE;
/*!40000 ALTER TABLE `hospede` DISABLE KEYS */;
INSERT INTO `hospede` VALUES (17,'Pedro',20,'(51) 98604-2381','pedro@viaflow.com.br',7,1),(18,'TESTE PEDRO',22,'51 99999','testepedro@gmail.com',8,NULL),(19,'ph',20,'51986042381','pedro@viaflow.com',7,NULL),(21,'Pedro Gomes',21,'51 986042381','pedro.gomes@viaflow.com',7,NULL),(22,'Juliano',30,'51 9999999','juliano@viaflow.com',7,NULL),(23,'Juliano',30,'51 9999999','juliano@viaflow.com',7,NULL),(24,'Mateeus',18,'(51) 999999','matheus@viaflow.com.br',7,NULL),(25,'Pedro Rosa',20,'(51) 999999','pedro.gomes@viaflow.com.br',7,NULL),(26,'Marlon Reis',30,'(51) 99217-3127','marlon@gmail.com',10,1),(27,'Luigi',26,'(51) 99238-4234','luigi@gmail.com',8,0),(28,'Jaime',40,'51 999999999','jaime@gmail.com',8,0);
/*!40000 ALTER TABLE `hospede` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 17:39:38
