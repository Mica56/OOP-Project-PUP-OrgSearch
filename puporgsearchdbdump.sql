-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: puporgsearch
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblimg`
--

DROP TABLE IF EXISTS `tblimg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblimg` (
  `strorgname` varchar(50) NOT NULL,
  `strimgpath` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`strorgname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblimg`
--

LOCK TABLES `tblimg` WRITE;
/*!40000 ALTER TABLE `tblimg` DISABLE KEYS */;
INSERT INTO `tblimg` VALUES ('PUP Sintang Pusa','\"C:UsersmikayOneDriveDocumentsJava Filessrcimagecatto.jpg\"');
/*!40000 ALTER TABLE `tblimg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorg`
--

DROP TABLE IF EXISTS `tblorg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblorg` (
  `strorgname` varchar(50) NOT NULL,
  `strorgtype` varchar(50) DEFAULT NULL,
  `strorgemail` varchar(50) DEFAULT NULL,
  `strorgdes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`strorgname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorg`
--

LOCK TABLES `tblorg` WRITE;
/*!40000 ALTER TABLE `tblorg` DISABLE KEYS */;
INSERT INTO `tblorg` VALUES ('ASCII','Academic','ascii@gmail.com','An academic organization that aims to aid CS students.'),('PUP Sintang Pusa','Non-academic','pupsintangpusa@gmail.com','We exist for the cats. Let us all love cats<3'),('PUP-TPG','Non-Academic','puptpg@gmail.com','An org that aims to develop the programming skills of students.');
/*!40000 ALTER TABLE `tblorg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorgsjoin`
--

DROP TABLE IF EXISTS `tblorgsjoin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblorgsjoin` (
  `strorgsjoined` varchar(50) DEFAULT NULL,
  `blcreator` tinyint(1) DEFAULT NULL,
  `struser` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorgsjoin`
--

LOCK TABLES `tblorgsjoin` WRITE;
/*!40000 ALTER TABLE `tblorgsjoin` DISABLE KEYS */;
INSERT INTO `tblorgsjoin` VALUES ('ASCII',1,'michael.tayoto@gmail.com'),('PUP-TPG',1,'micaela.cerilla@gmail.com'),('PUP-TPG',NULL,'michael.tayoto@gmail.com'),('PUP Sintang Pusa',1,'megumichan@gmail.com');
/*!40000 ALTER TABLE `tblorgsjoin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblposts`
--

DROP TABLE IF EXISTS `tblposts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblposts` (
  `strheading` varchar(100) DEFAULT NULL,
  `strbody` varchar(1000) DEFAULT NULL,
  `dtime` datetime DEFAULT current_timestamp(),
  `strorgname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblposts`
--

LOCK TABLES `tblposts` WRITE;
/*!40000 ALTER TABLE `tblposts` DISABLE KEYS */;
INSERT INTO `tblposts` VALUES ('PUP-TPG Membership','The online membership for aspiring PUP-TPG members is now open starting from March 05 to 30','2021-02-26 23:18:05','PUP-TPG'),('ASCII Event','The online tutorial sessions for ASCII members will start on March 05, 2021.','2021-02-28 21:32:15','ASCII');
/*!40000 ALTER TABLE `tblposts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbluser` (
  `strname` varchar(50) DEFAULT NULL,
  `strcollege` varchar(50) DEFAULT NULL,
  `strstudnum` varchar(50) DEFAULT NULL,
  `stremail` varchar(50) NOT NULL,
  `strpass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stremail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` VALUES ('Megumi Tanegre','CHSS','2018-02673-MN-0','megumichan@gmail.com','kekeke'),('Micaela Cerilla','CCIS','2019-06342-MN-0','micaela.cerilla@gmail.com','whatever'),('Michael Tayoto','CCIS','2019-06343-MN-1','michael.tayoto@gmail.com','eyy');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 21:48:58
