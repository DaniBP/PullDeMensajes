-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2016 a las 07:10:36
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `pullmensajes`
--
CREATE DATABASE IF NOT EXISTS `pullmensajes` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pullmensajes`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_mensaje`
--

CREATE TABLE IF NOT EXISTS `t_mensaje` (
  `idMensaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `mensaje` varchar(250) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `hora` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idMensaje`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `t_mensaje`
--

INSERT INTO `t_mensaje` (`idMensaje`, `nombreUsuario`, `mensaje`, `fecha`, `hora`) VALUES
(1, 'usuario1', 'Mensaje de prueba 1', '29 de Junio de 2016', '07:09:23 PM'),
(2, 'usuario2', 'Mensaje de prueba 2', '29 de Junio de 2016', '07:09:37 PM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE IF NOT EXISTS `t_usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(20) DEFAULT NULL,
  `passwordUsuario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `t_usuario`
--

INSERT INTO `t_usuario` (`idUsuario`, `nombreUsuario`, `passwordUsuario`) VALUES
(1, 'usuario1', '123'),
(2, 'usuario2', '123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
