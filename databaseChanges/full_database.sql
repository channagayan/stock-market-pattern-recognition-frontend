CREATE DATABASE  IF NOT EXISTS `arcanedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `arcanedb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: arcanedb
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doublebottom`
--

DROP TABLE IF EXISTS `doublebottom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doublebottom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstMin` varchar(10) DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `firstMax` varchar(45) DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `secondMin` varchar(45) DEFAULT NULL,
  `secondMinPrice` double DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `breakPoint` varchar(45) DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doublebottom`
--

LOCK TABLES `doublebottom` WRITE;
/*!40000 ALTER TABLE `doublebottom` DISABLE KEYS */;
/*!40000 ALTER TABLE `doublebottom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doubletop`
--

DROP TABLE IF EXISTS `doubletop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doubletop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock` varchar(45) DEFAULT NULL,
  `firstMax` varchar(45) DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `firstMin` varchar(45) DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `secondMax` varchar(45) DEFAULT NULL,
  `secondMaxPrice` double DEFAULT NULL,
  `breakPoint` varchar(45) DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doubletop`
--

LOCK TABLES `doubletop` WRITE;
/*!40000 ALTER TABLE `doubletop` DISABLE KEYS */;
/*!40000 ALTER TABLE `doubletop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headnshoulder`
--

DROP TABLE IF EXISTS `headnshoulder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headnshoulder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstMax` varchar(45) DEFAULT NULL,
  `secondMax` varchar(45) DEFAULT NULL,
  `thirdMax` varchar(45) DEFAULT NULL,
  `firstMin` varchar(45) DEFAULT NULL,
  `secondMin` varchar(45) DEFAULT NULL,
  `breakPoint` varchar(45) DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `secondMaxPrice` double DEFAULT NULL,
  `thirdMaxPrice` double DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `secondMinPrice` double DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headnshoulder`
--

LOCK TABLES `headnshoulder` WRITE;
/*!40000 ALTER TABLE `headnshoulder` DISABLE KEYS */;
/*!40000 ALTER TABLE `headnshoulder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headnshoulderbottom`
--

DROP TABLE IF EXISTS `headnshoulderbottom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headnshoulderbottom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstMin` varchar(45) DEFAULT NULL,
  `secondMin` varchar(45) DEFAULT NULL,
  `firstMax` varchar(45) DEFAULT NULL,
  `secondMax` varchar(45) DEFAULT NULL,
  `thirdMin` varchar(45) DEFAULT NULL,
  `breakPoint` varchar(45) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `secondMinPrice` double DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `secondMaxPrice` double DEFAULT NULL,
  `thirdMinPrice` double DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headnshoulderbottom`
--

LOCK TABLES `headnshoulderbottom` WRITE;
/*!40000 ALTER TABLE `headnshoulderbottom` DISABLE KEYS */;
/*!40000 ALTER TABLE `headnshoulderbottom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pattern`
--

DROP TABLE IF EXISTS `pattern`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pattern` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pattern`
--

LOCK TABLES `pattern` WRITE;
/*!40000 ALTER TABLE `pattern` DISABLE KEYS */;
INSERT INTO `pattern` VALUES (1,'tripplebottom'),(2,'doubletop'),(3,'doublebottom'),(4,'trippletop'),(5,'headnshoulder'),(6,'headnshoulderbottom');
/*!40000 ALTER TABLE `pattern` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripplebottom`
--

DROP TABLE IF EXISTS `tripplebottom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tripplebottom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstMin` varchar(10) DEFAULT NULL,
  `secondMin` varchar(10) DEFAULT NULL,
  `thirdMin` varchar(10) DEFAULT NULL,
  `breakPoint` varchar(10) DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `secondMinPrice` double DEFAULT NULL,
  `thirdMinPrice` double DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `firstMax` varchar(10) DEFAULT NULL,
  `secondMax` varchar(10) DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `secondMaxPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripplebottom`
--

LOCK TABLES `tripplebottom` WRITE;
/*!40000 ALTER TABLE `tripplebottom` DISABLE KEYS */;
/*!40000 ALTER TABLE `tripplebottom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trippletop`
--

DROP TABLE IF EXISTS `trippletop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trippletop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstMax` varchar(45) DEFAULT NULL,
  `secondMax` varchar(45) DEFAULT NULL,
  `thirdMax` varchar(45) DEFAULT NULL,
  `breakPoint` varchar(45) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `firstMin` varchar(45) DEFAULT NULL,
  `secondMin` varchar(45) DEFAULT NULL,
  `firstMaxPrice` double DEFAULT NULL,
  `secondMaxPrice` double DEFAULT NULL,
  `thirdMaxPrice` double DEFAULT NULL,
  `firstMinPrice` double DEFAULT NULL,
  `secondMinPrice` double DEFAULT NULL,
  `breakPointPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trippletop`
--

LOCK TABLES `trippletop` WRITE;
/*!40000 ALTER TABLE `trippletop` DISABLE KEYS */;
/*!40000 ALTER TABLE `trippletop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',1),(2,'user','user',2),(3,'Hello','test',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-08  7:56:44
