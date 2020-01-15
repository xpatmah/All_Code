-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema nedatabase
--

CREATE DATABASE IF NOT EXISTS nedatabase;
USE nedatabase;

--
-- Definition of table `cardinfo`
--

DROP TABLE IF EXISTS `cardinfo`;
CREATE TABLE `cardinfo` (
  `IP` varchar(45) NOT NULL,
  `CARDID` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`CARDID`,`IP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cardinfo`
--

/*!40000 ALTER TABLE `cardinfo` DISABLE KEYS */;
INSERT INTO `cardinfo` (`IP`,`CARDID`) VALUES 
 ('10.11.20.21','100GMUX-2'),
 ('10.12.21.10','100GMUX-2'),
 ('10.20.10.11','100GMUX-2'),
 ('10.22.11.22','100GMUX-2'),
 ('10.21.31.11','100GMUX-3'),
 ('10.22.11.22','100GMUX-3'),
 ('10.11.33.21','100GOCLD-1'),
 ('10.21.31.11','100GOCLD-2'),
 ('10.11.20.21','100GOCLD-3'),
 ('10.12.21.10','100GOCLD-3'),
 ('10.20.10.11','100GOCLD-3'),
 ('10.22.11.22','100GOCLD-4'),
 ('10.22.11.22','100GOCLD-5'),
 ('10.21.31.11','EMOTR-1'),
 ('10.11.33.21','EMOTR-2'),
 ('10.11.20.21','EMOTR-4'),
 ('10.12.21.10','EMOTR-4'),
 ('10.20.10.11','EMOTR-4'),
 ('10.11.20.21','PKTOTN-1'),
 ('10.12.21.10','PKTOTN-1'),
 ('10.20.10.11','PKTOTN-1'),
 ('10.22.11.22','PKTOTN-1'),
 ('21.23.23.45','PKTOTN-1'),
 ('10.21.31.11','PKTOTN-4');
/*!40000 ALTER TABLE `cardinfo` ENABLE KEYS */;


--
-- Definition of table `facility`
--

DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `FACILITYID` varchar(20) NOT NULL,
  `SERVICETYPE` varchar(45) NOT NULL,
  `IP` varchar(45) NOT NULL,
  `FREQUENCY` varchar(45) NOT NULL,
  `WAVELENGTH` varchar(45) NOT NULL,
  `DIFFRENTIALENCODING` varchar(45) NOT NULL,
  `CDI` varchar(45) NOT NULL,
  PRIMARY KEY  (`FACILITYID`,`IP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facility`
--

/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` (`FACILITYID`,`SERVICETYPE`,`IP`,`FREQUENCY`,`WAVELENGTH`,`DIFFRENTIALENCODING`,`CDI`) VALUES 
 ('OC12-1-2','10G','10.11.33.21','10','1601.2','HARD',''),
 ('OC12-1-6','100G','10.11.33.21','10','1601.2','HARD',''),
 ('OC12-2-1','30G','10.21.31.11','10','1603.4','HARD',''),
 ('OC12-3-1','100G','10.11.20.21','40','1603.4','SOFT',''),
 ('OC12-3-1','10G','10.20.10.11','10','1601.2','SOFT',''),
 ('OC12-3-5','100G','10.11.20.21','20','1604.6','SOFT',''),
 ('OC12-4-1','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OC12-5-1','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OC192-1-4','100G','10.11.33.21','10','1601.2','HARD',''),
 ('OC192-2-2','30G','10.21.31.11','10','1603.4','HARD',''),
 ('OC192-3-3','20G','10.11.20.21','30','1603.4','NONE',''),
 ('OC192-3-3','10G','10.12.21.10','10','1601.2','HARD',''),
 ('OC192-3-3','10G','10.20.10.11','20','1601.2','HARD',''),
 ('OC48-1-3','100G','10.11.33.21','10','1601.2','HARD',''),
 ('OC48-2-3','30G','10.21.31.11','10','1603.4','HARD',''),
 ('OC48-3-2','30G','10.11.20.21','40','1603.4','SOFT',''),
 ('OC48-3-2','10G','10.12.21.10','10','1601.2','HARD',''),
 ('OC48-3-2','10G','10.20.10.11','10','1601.2','SOFT',''),
 ('OC48-4-2','30G','10.22.11.22','30','1601.2','HARD',''),
 ('ODU1-1-1','10G','10.11.33.21','10','1601.2','HARD',''),
 ('ODU1-1-5','100G','10.11.33.21','10','1601.2','HARD',''),
 ('ODU1-2-4','40G','10.21.31.11','10','1603.4','HARD',''),
 ('ODU1-3-1','10G','10.12.21.10','10','1601.2','HARD',''),
 ('ODU1-3-4','30G','10.11.20.21','40','1604.6','SOFT',''),
 ('ODU1-3-4','10G','10.12.21.10','10','1601.2','HARD',''),
 ('ODU1-3-4','30G','10.20.10.11','20','1601.2','HARD',''),
 ('ODU1-3-5','30G','10.20.10.11','20','1602.1','HARD',''),
 ('ODU3-1-2','10G','10.21.31.11','10','1601.2','HARD',''),
 ('ODU3-2-2','100G','10.11.33.21','10','1604.6','HARD',''),
 ('ODU3-2-4','100G','10.11.33.21','10','1604.6','HARD',''),
 ('ODU3-4-1','100G','10.11.20.21','20','1604.6','SOFT',''),
 ('ODU3-4-1','30G','10.20.10.11','20','1602.1','HARD',''),
 ('ODUCTP-1-3','10G','10.11.20.21','10','1601.2','HARD',''),
 ('ODUCTP-1-3','10G','10.12.21.10','10','1601.2','HARD',''),
 ('ODUCTP-1-3','30G','10.22.11.22','10','1601.2','HARD',''),
 ('ODUCTP-1-4','10G','10.20.10.11','10','1601.2','NONE',''),
 ('ODUCTP-4-3','40G','10.21.31.11','30','1603.4','SOFT',''),
 ('ODUTTP-1-1','10G','10.12.21.10','10','1601.2','HARD',''),
 ('ODUTTP-1-1','10G','10.22.11.22','10','1601.2','HARD',''),
 ('ODUTTP-1-2','10G','10.11.20.21','10','1601.2','HARD',''),
 ('ODUTTP-1-2','10G','10.20.10.11','10','1601.2','SOFT',''),
 ('ODUTTP-1-3','10G','10.20.10.11','10','1601.2','NONE',''),
 ('ODUTTP-1-5','30G','10.11.20.21','30','1602.1','HARD',''),
 ('ODUTTP-1-5','30G','10.22.11.22','10','1601.2','HARD',''),
 ('ODUTTP-1-6','10G','10.20.10.11','10','1601.2','NONE',''),
 ('ODUTTP-4-2','40G','10.21.31.11','30','1603.4','HARD',''),
 ('ODUTTP-4-5','100G','10.21.31.11','30','1603.4','SOFT',''),
 ('OTM10-2-3','20G','10.12.21.10','10','1601.2','SOFT',''),
 ('OTM10-2-4','100G','10.11.20.21','40','1603.4','SOFT',''),
 ('OTM10-2-4','10G','10.20.10.11','10','1601.2','SOFT',''),
 ('OTM10-2-4','30G','10.22.11.22','10','1601.2','HARD',''),
 ('OTM10-2-5','20G','10.12.21.10','10','1604.6','NONE',''),
 ('OTM10-3-4','40G','10.21.31.11','30','1603.4','HARD',''),
 ('OTM2-2-1','30G','10.11.20.21','30','1602.1','HARD',''),
 ('OTM2-2-1','10G','10.20.10.11','10','1601.2','NONE',''),
 ('OTM2-2-1','30G','10.22.11.22','10','1601.2','HARD',''),
 ('OTM2-3-2','40G','10.21.31.11','10','1603.4','HARD',''),
 ('OTM2-3-4','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OTM4-2-2','20G','10.11.20.21','30','1602.1','SOFT',''),
 ('OTM4-2-2','10G','10.20.10.11','10','1601.2','NONE',''),
 ('OTM4-2-3','30G','10.22.11.22','10','1601.2','HARD',''),
 ('OTM4-2-5','100G','10.11.20.21','40','1603.4','SOFT',''),
 ('OTM4-2-5','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OTM4-3-1','40G','10.21.31.11','10','1603.4','HARD',''),
 ('OTM4-3-1','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OTM4-3-2','30G','10.22.11.22','30','1601.2','HARD',''),
 ('OTM4-3-5','40G','10.21.31.11','30','1603.4','HARD',''),
 ('OTM6-2-2','20G','10.12.21.10','10','1601.2','SOFT',''),
 ('OTM6-2-2','30G','10.22.11.22','10','1601.2','HARD',''),
 ('OTM6-2-3','30G','10.11.20.21','30','1602.1','SOFT',''),
 ('OTM6-2-3','10G','10.20.10.11','10','1601.2','NONE',''),
 ('OTM6-2-4','20G','10.12.21.10','10','1604.6','NONE',''),
 ('OTM6-2-5','10G','10.20.10.11','10','1601.2','SOFT',''),
 ('OTM6-3-3','40G','10.21.31.11','10','1603.4','HARD',''),
 ('OTM6-3-3','30G','10.22.11.22','30','1601.2','HARD',''),
 ('PTP-1-1','10G','10.11.20.21','10','1601.2','HARD',''),
 ('PTP-1-1','10G','10.20.10.11','10','1601.2','HARD',''),
 ('PTP-1-1','10G','21.23.23.45','10','1601.2','HARD',''),
 ('PTP-1-2','10G','10.12.21.10','10','1601.2','HARD',''),
 ('PTP-1-2','10G','10.22.11.22','10','1601.2','HARD',''),
 ('PTP-4-1','40G','10.21.31.11','30','1603.4','HARD',''),
 ('STM16-1-3','10G','10.21.31.11','10','1601.2','HARD',''),
 ('STM16-4-2','10G','10.12.21.10','10','1602.1','HARD',''),
 ('STM16-4-3','100G','10.11.20.21','30','1604.6','SOFT',''),
 ('STM16-4-3','30G','10.20.10.11','20','1602.1','HARD',''),
 ('STM16-4-5','40G','10.20.10.11','40','1602.1','HARD',''),
 ('STM4-1-1','10G','10.21.31.11','10','1601.2','HARD',''),
 ('STM4-1-5','30G','10.21.31.11','10','1603.4','HARD',''),
 ('STM4-2-1','100G','10.11.33.21','10','1601.2','HARD',''),
 ('STM4-2-3','100G','10.11.33.21','10','1604.6','HARD',''),
 ('STM4-2-5','100G','10.11.33.21','10','1604.6','HARD',''),
 ('STM4-4-1','10G','10.12.21.10','10','1602.1','SOFT',''),
 ('STM4-4-2','100G','10.11.20.21','30','1604.6','SOFT',''),
 ('STM4-4-2','30G','10.20.10.11','20','1602.1','HARD',''),
 ('STM4-4-4','10G','10.12.21.10','10','1602.1','NONE',''),
 ('STM4-4-5','100G','10.11.20.21','40','1602.1','NONE',''),
 ('STM64-1-4','10G','10.21.31.11','10','1603.4','HARD',''),
 ('STM64-4-3','10G','10.12.21.10','10','1602.1','NONE',''),
 ('STM64-4-4','100G','10.11.20.21','30','1604.6','SOFT',''),
 ('STM64-4-4','40G','10.20.10.11','40','1602.1','HARD',''),
 ('TCMTTP-1-4','10G','10.11.20.21','10','1601.2','HARD',''),
 ('TCMTTP-1-4','30G','10.12.21.10','10','1601.2','SOFT',''),
 ('TCMTTP-1-4','30G','10.22.11.22','10','1601.2','HARD',''),
 ('TCMTTP-1-5','10G','10.20.10.11','10','1601.2','NONE',''),
 ('TCMTTP-4-4','100G','10.21.31.11','30','1603.4','SOFT','');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;


--
-- Definition of table `ipshelf`
--

DROP TABLE IF EXISTS `ipshelf`;
CREATE TABLE `ipshelf` (
  `IP` varchar(45) NOT NULL,
  `shelf` varchar(45) NOT NULL,
  PRIMARY KEY  (`IP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ipshelf`
--

/*!40000 ALTER TABLE `ipshelf` DISABLE KEYS */;
INSERT INTO `ipshelf` (`IP`,`shelf`) VALUES 
 ('21.23.23.45','T Series');
/*!40000 ALTER TABLE `ipshelf` ENABLE KEYS */;


--
-- Definition of table `neinfo`
--

DROP TABLE IF EXISTS `neinfo`;
CREATE TABLE `neinfo` (
  `IP` varchar(16) NOT NULL,
  `PORT` varchar(16) NOT NULL,
  `shelf` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `syncstatus` varchar(45) NOT NULL,
  `softwareversion` varchar(45) NOT NULL,
  `areaserved` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`IP`,`PORT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `neinfo`
--

/*!40000 ALTER TABLE `neinfo` DISABLE KEYS */;
INSERT INTO `neinfo` (`IP`,`PORT`,`shelf`,`location`,`syncstatus`,`softwareversion`,`areaserved`,`status`,`name`) VALUES 
 ('10.11.20.21','5243','T Series','Kolkata','Synchronized','V0.2','Kolkata Central','Started','OME100111'),
 ('10.11.33.21','3113','T Series','Banglore ','Synchronized','V0.2','kormangalam','Started','OME130111'),
 ('10.12.21.10','4940','T Series','Mumbai','Synchronized','V0.2','Pune','Started','OME110112'),
 ('10.20.10.11','2323','T Series','Delhi','Synchronized','V0.2','Noida','Started','OME110111'),
 ('10.21.31.11','6295','T Series','Chennai','Synchronized','V0.2','Chennai Central','Started','OME120111'),
 ('10.22.11.22','5050','T Series','Jaipur','Synchronized','V0.2','Ajmer','Started','OME130534'),
 ('21.23.23.45','3067','T Series','Hydrabad','Synchronized','G1.9','Hydrabad Central','Started','OME120123');
/*!40000 ALTER TABLE `neinfo` ENABLE KEYS */;

--
-- Create schema serverinfodatabase
--

CREATE DATABASE IF NOT EXISTS serverinfodatabase;
USE serverinfodatabase;

--
-- Definition of table `enrollednetwork`
--

DROP TABLE IF EXISTS `enrollednetwork`;
CREATE TABLE `enrollednetwork` (
  `user` varchar(45) NOT NULL,
  `IP` varchar(45) NOT NULL,
  `Port` varchar(45) NOT NULL,
  PRIMARY KEY  (`user`,`IP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollednetwork`
--

/*!40000 ALTER TABLE `enrollednetwork` DISABLE KEYS */;
INSERT INTO `enrollednetwork` (`user`,`IP`,`Port`) VALUES 
 ('ADMIN','10.11.33.21','3113'),
 ('ADMIN','10.12.21.10','4940'),
 ('ADMIN','10.20.10.11','2323'),
 ('ADMIN','10.22.11.22','5050'),
 ('ADMIN','21.23.23.45','3067');
/*!40000 ALTER TABLE `enrollednetwork` ENABLE KEYS */;


--
-- Definition of table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `ID` varchar(34) NOT NULL,
  `PASSWORD` varchar(55) NOT NULL,
  PRIMARY KEY  USING BTREE (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`ID`,`PASSWORD`) VALUES 
 ('ADMIN','73acd9a5972130b75066c82595a1fae3'),
 ('ADMIN_122001','46c7f792b51e9b630c7441d3a77295'),
 ('ADMIN_122002','c3051ab697e82043de7fa842198227'),
 ('ADMIN_21074','d21ba82549405e77c9cc99616ee09eba'),
 ('ADMIN_244713','23592a2af233297f46d23427e45074');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
