CREATE DATABASE  IF NOT EXISTS `addressbook`
-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: addressbook
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*ICT-4300-2 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*ICT-4300-2 @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!ICT-4300-2 @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!ICT-4300-2 NAMES utf8 */;
/*!ICT-4300-2 @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!ICT-4300-2 TIME_ZONE='+00:00' */;
/*ICT-4300-2 @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!ICT-4300-2 @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!ICT-4300-2 @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!ICT-4300-2 @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ADRESS`
--

DROP TABLE IF EXISTS `ADRESS`;
/*ICT-4300-2 @saved_cs_client     = @@character_set_client */;
/*ICT-4300-2character_set_client = utf8 */;
CREATE TABLE `ADRESS` (
  `addressID` int(11) NOT NULL AUTO_INCREMENT,
  `Address` varchar(256) COLLATE utf8_turkish_ci NOT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`addressID`),
  KEY `FK_r0jn5aagcc7np4koxtudsvg55` (`person_id`),
  CONSTRAINT `FK_r0jn5aagcc7np4koxtudsvg55` FOREIGN KEY (`person_id`) REFERENCES `PERSON` (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*ICT-4300-2 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADRESS`
--

LOCK TABLES `ADRESS` WRITE;
/*ICT-4300-2 ALTER TABLE `ADRESS` DISABLE KEYS */;
INSERT INTO `ADRESS` VALUES (1,'Person1 Ornek adres 1',1),(2,'Person2 Ornek adres 2',2),(3,'Person2 Ornek adres 3',2);
/*ICT-4300-2 ALTER TABLE `ADRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSON`
--

DROP TABLE IF EXISTS `PERSON`;
/*!ICT-4300-2 SET @saved_cs_client     = @@character_set_client */;
/*!ICT-4300-2 character_set_client = utf8 */;
CREATE TABLE `PERSON` (
  `personID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(64) COLLATE utf8_turkish_ci NOT NULL,
  `Name` varchar(32) COLLATE utf8_turkish_ci NOT NULL,
  `Surname` varchar(64) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`personID`),
  UNIQUE KEY `UK_hrr9altnxip3weq5mbsl7ahb2` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*ICT-4300-2 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSON`
--

LOCK TABLES `PERSON` WRITE;
/*!40000 ALTER TABLE `PERSON` DISABLE KEYS */;
INSERT INTO `PERSON` VALUES (1,'erdem.sahin.uslu@gmail.com','Erdem','Sahin'),(2,'testmail@yahoo.com','Test','User');
/*!40000 ALTER TABLE `PERSON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PHONE`
--

DROP TABLE IF EXISTS `PHONE`;
/*ICT-4300-2 SET @saved_cs_client     = @@character_set_client */;
/*!ICT-4300-2 SET character_set_client = utf8 */;
CREATE TABLE `PHONE` (
  `phoneID` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) COLLATE utf8_turkish_ci NOT NULL,
  `phoneTitle` varchar(16) COLLATE utf8_turkish_ci NOT NULL,
  `person_id_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`phoneID`),
  UNIQUE KEY `UK_4xh7oqrueks21nty78jjk22le` (`phone`),
  KEY `FK_ivqjfogjactoaamsgs707wvp3` (`person_id_fk`),
  CONSTRAINT `FK_ivqjfogjactoaamsgs707wvp3` FOREIGN KEY (`person_id_fk`) REFERENCES `PERSON` (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*ICT-4300-2ET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PHONE`
--

LOCK TABLES `PHONE` WRITE;
/*ICT-4300-2 ALTER TABLE `PHONE` DISABLE KEYS */;
INSERT INTO `PHONE` VALUES (1,'+90(531)1111111','CEP',1),(2,'+90(312)0000000','EV',1),(3,'+90(500)7777777','CEP',2);
/*ICT-4300-2 ALTER TABLE `PHONE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'addressbook'
--

--
-- Dumping routines for database 'addressbook'
--
/*ICT-4300-2 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!ICT-4300-2 SQL_MODE=@OLD_SQL_MODE */;
/*ICT-4300-2 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!ICT-4300-2 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*ICT-4300-2 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!ICT-4300-2 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*ICT-4300-2 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!ICT-4300-2 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-21  4:26:27
