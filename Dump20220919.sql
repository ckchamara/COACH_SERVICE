-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: busbook
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `bookedroutes`
--

DROP TABLE IF EXISTS `bookedroutes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookedroutes` (
  `CustomerId` int NOT NULL,
  `routeId` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookedroutes`
--

LOCK TABLES `bookedroutes` WRITE;
/*!40000 ALTER TABLE `bookedroutes` DISABLE KEYS */;
INSERT INTO `bookedroutes` VALUES (123,'fr_sp_1'),(123,'202_ai');
/*!40000 ALTER TABLE `bookedroutes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `countryId` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES ('fr','France'),('ger','Germany'),('sp','Spain');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countrycities`
--

DROP TABLE IF EXISTS `countrycities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countrycities` (
  `countryId` varchar(45) NOT NULL,
  `cityId` varchar(45) NOT NULL,
  `citiies` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countrycities`
--

LOCK TABLES `countrycities` WRITE;
/*!40000 ALTER TABLE `countrycities` DISABLE KEYS */;
INSERT INTO `countrycities` VALUES ('fr','fr_bo','Bordeaux'),('fr','fr_ma','Marseille'),('fr','fr_pa','Paris'),('ger','ger_be','Berlin'),('ger','ger_fr','Frankfurt '),('ger','ger_mu','Munich'),('sp','sp_ba','Barcelona'),('sp','sp_ma','Madrid'),('sp','sp_va','Valencia');
/*!40000 ALTER TABLE `countrycities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `CustomerId` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `Lastname` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `LoginPassword` varchar(255) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `PhoneNumber` int DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CustomerId`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (123,'Michale','Jordan','mjordan@gmail.com','admin','1993-05-07','Male',44456345,'21/3, lapis avenue, germany'),(124,'smidits','ubalingan','silnigan@gmail.com','user','1996-05-07','Female',44876346,'2193, imbgan plaza, germany'),(125,'sdf','sdf','sd','asdwqr','1993-05-07','Male',2345,'asd'),(126,'madushan','madushan','asd','23','1994-12-18','Male',345,'sadasd');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `days`
--

DROP TABLE IF EXISTS `days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `days` (
  `iddays` int NOT NULL AUTO_INCREMENT,
  `day` varchar(45) NOT NULL,
  PRIMARY KEY (`iddays`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `days`
--

LOCK TABLES `days` WRITE;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` VALUES (1,'Sunday'),(2,'Monday'),(3,'Tuesday'),(4,'Wednesday'),(5,'Thursday'),(6,'Friday'),(7,'Saturday');
/*!40000 ALTER TABLE `days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'','','JHJ'),(2,'Deshanga','Mawatha','compa'),(3,'kasun','Maduranga','4321'),(4,'chamara','Dayarathne','1234'),(5,'Deshanga','Adhikari','JHJ'),(6,'ASD','FD','JHJ');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `routeId` varchar(45) NOT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `originCity` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `destinationCity` varchar(45) DEFAULT NULL,
  `departure` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `price` double DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `remainSeats` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES ('28','SE','Westend','PF','Maywood','2022-04-06',NULL,73,21,84),('29','JP','Lighthouse Bay','GT','Hanson','2021-11-18',NULL,33,16,81),('30','CN','Burning Wood','CD','Independence','2022-06-25',NULL,30,19,77),('31','GR','Gina','AL','Continental','2022-05-15',NULL,5,97,98),('32','PS','Dayton','PH','Kenwood','2021-10-27',NULL,91,16,81),('33','PH','Elmside','BG','Green','2022-08-13',NULL,59,41,5),('34','ID','Badeau','CM','Aberg','2022-01-13',NULL,55,97,14),('35','UA','Acker','RU','Warner','2021-11-10',NULL,44,68,56),('36','CN','Vahlen','ID','Donald','2022-07-27',NULL,98,14,95),('37','BR','Lighthouse Bay','CN','Mccormick','2022-07-15',NULL,51,25,31),('38','GA','Iowa','ID','Independence','2022-04-14',NULL,82,90,61),('39','TH','Heffernan','CN','Kings','2022-08-29',NULL,74,80,1),('40','FR','Warrior','CN','Maryland','2021-11-12',NULL,67,19,58),('41','FR','Clarendon','CN','Manufacturers','2021-12-02',NULL,24,48,60),('42','SE','Thierer','PH','Chive','2021-11-01',NULL,54,87,14),('43','PH','Westridge','BR','Meadow Vale','2022-07-06',NULL,23,43,72),('45','ID','Cascade','ZA','Linden','2022-04-01',NULL,66,5,14),('47','CN','Meadow Ridge','US','Lunder','2022-08-06',NULL,35,88,88),('48','NL','Loomis','PH','Erie','2021-12-28',NULL,35,50,18),('49','UA','School','NO','Pleasure','2022-02-25',NULL,96,35,87),('50','RU','Independence','CN','Barnett','2022-04-01',NULL,5,17,24),('205_bd','Italy','dddd','Bulgaria','adf','2021-01-01','04:01:00',89,42,45);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19 22:20:04
