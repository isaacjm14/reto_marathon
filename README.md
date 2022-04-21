# reto_marathon
# Pasos a seguir
# clonar la rama con
git clone https://github.com/isaacjm14/reto_marathon.git
# Abrir el proyecto angular que esta en la carpeta front con cualquier ide visual studio code, atom, etc y utilizar el comando npm i
# para bajar las dependencias
# Abrir el proyecto springboot que esta en la carpeta back con su ide de preferencia sts, intelliJ, etc.
#y en el archivo pom.xml dar reload_proyect para bajar las dependencias

#Ver el video evidencia.wmv para realizar los pasos para correr el programa en local, la clave y el usuario esta en el archivo application.properties
#en el proyecto back cambiarla para realizar la coneccion a la bd en caso tenga diferente usuario instalado.

############ Utilizar el siguiente script en una bd mysql##########
CREATE DATABASE IF NOT EXISTS bd_marathon;

USE bd_marathon;

 CREATE TABLE IF NOT EXISTS EMPRESA (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  RUC VARCHAR(11) NOT NULL,
  RAZON_SOCIAL VARCHAR(100) NOT NULL ,
  ESTADO VARCHAR(10) NOT NULL ,
  DIRECCION VARCHAR(100) NULL ,
  UBIGEO VARCHAR(6) NULL ,
  DEPARTAMENTO VARCHAR(100) NULL ,
  PROVINCIA VARCHAR(100) NULL ,
  DISTRITO VARCHAR(100) NULL ,
  INDEX EMPRESA_idx ( RUC ASC ),
  INDEX TIPO_CAMBIO_ESTADO_idx ( ESTADO ASC ),
  PRIMARY KEY (ID))
ENGINE = InnoDB;

##################################################