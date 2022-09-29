use heroku_77f5fb8e81d446e;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cod_producto` int NOT NULL,
  `descripcion_producto` varchar(25) NOT NULL,
  `estado_producto` varchar(10) NOT NULL,
  `precio_admin` double NOT NULL,
  `precio_publico` double NOT NULL,
  `precio_vendedor` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

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
) ENGINE=InnoDB;

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
) ENGINE=InnoDB;

show tables;