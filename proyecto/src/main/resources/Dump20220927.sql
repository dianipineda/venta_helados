-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ventaheladosjpa
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cod_producto` int NOT NULL,
  `descripcion_producto` varchar(25) NOT NULL,
  `estado_producto` varchar(10) NOT NULL,
  `precio_admin` double NOT NULL,
  `precio_publico` double NOT NULL,
  `precio_vendedor` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (34,162120,'GALLETA HELADO','inactivo',1391,2000,1650),(35,160107,'CHOCONOCO','inactivo',1277,2000,1530),(36,1057867,'CHOCONOCO CRACK','inactivo',1682,2500,2000),(37,1047515,'CHOCONOCO BILLONARIO','inactivo',1277,2000,1530),(38,161193,'ARTESANALITO','activo',1305,2000,1550),(41,888,'CHOCOCO','inactivo',1000,2000,1200),(42,87554,'PALETA DE NARANJA','inactivo',1000,2000,1200),(48,458712,'PALETA DE CHONTADURO','activo',700,1500,1000);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (8,'mireyita3862@gmail.com','Mireya Ramirez','proyecto22'),(9,'distribuidorah@yahoo.es','Mireya Ramirez','proyecto23');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula_ciudadania` bigint NOT NULL,
  `primer_apellido` varchar(15) NOT NULL,
  `segundo_apellido` varchar(15) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado_vendedor` varchar(10) NOT NULL,
  `primer_nombre` varchar(15) NOT NULL,
  `segundo_nombre` varchar(15) NOT NULL,
  `telefono` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,1116268542,'OSORIO','RUIZ','1975-08-27','activo','ESNER','',3205421396),(2,16985412,'VELAZQUEZ','RODRIGUEZ','1977-05-14','activo','ALEXANDER','',3154459625),(3,112548745,'OCAMPO','SOLANO','2022-09-05','inactivo','SANDRA','PATRICIA',3145845459),(4,1665488,'GIRON','DELGADO','2022-09-05','activo','FABIO','ENRIQUE',3145844399),(5,485445,'EE','EE','2022-09-29','activo','SANDRA','EE',3145844399),(6,14526987,'OCAMPO','MARTINEZ','2022-08-30','activo','FABIO','ANDREA',3148569652),(7,45874512,'GRISALES','MEDINA','2022-08-03','activo','PABLO','DAVID',8888),(8,222,'W','W','2022-09-22','activo','W','W',314584439),(9,999,'H','HH','2022-09-08','activo','H','H',31458443),(10,55,'D','D','2022-09-08','activo','D','D',888888),(11,5,'5','5','2022-10-08','activo','5','5',88);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_entrega` int NOT NULL,
  `cantidad_recibe` int NOT NULL,
  `fecha_hora_venta` date NOT NULL,
  `cod_producto` int DEFAULT NULL,
  `cedula_ciudadania` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l7g8ihlt8axy8luk6phqm1ol` (`cantidad_entrega`),
  UNIQUE KEY `UK_frjd5ep3rif7fey6t4kvq74ad` (`cantidad_recibe`),
  KEY `FKgl3n7t82ong7kcdfgq2d8gc3i` (`cod_producto`),
  KEY `FKkelhaku3h3dtg6micljhtvorn` (`cedula_ciudadania`),
  CONSTRAINT `FKgl3n7t82ong7kcdfgq2d8gc3i` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `FKkelhaku3h3dtg6micljhtvorn` FOREIGN KEY (`cedula_ciudadania`) REFERENCES `vendedores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-27 16:19:37
