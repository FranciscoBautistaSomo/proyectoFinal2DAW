-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-04-2023 a las 19:07:32
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `retrohifi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `total` double NOT NULL,
  `orden_id` int(11) DEFAULT NULL,
  `producto_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`id`, `cantidad`, `nombre`, `precio`, `total`, `orden_id`, `producto_id`) VALUES
(1, 1, 'Tele retro', 120, 120, 1, 8),
(2, 1, 'Radio', 123, 123, 2, 9),
(3, 2, 'Televisor', 700, 1400, 3, 3),
(4, 1, 'Tele retro', 120, 120, 3, 8),
(5, 1, 'Radio', 123, 123, 3, 9),
(6, 1, 'Tele retro', 120, 120, 4, 8),
(7, 2, 'Tele retro', 120, 240, 5, 8),
(8, 2, 'Tele retro', 120, 240, 6, 8),
(9, 1, 'Televisor', 700, 700, 6, 3),
(10, 2, 'Radio', 123, 246, 7, 9),
(11, 1, 'Tele retro', 120, 120, 7, 8),
(12, 1, 'Televisor', 700, 700, 8, 3),
(13, 1, 'Radio', 123, 123, 8, 9),
(14, 2, 'Radio', 123, 246, 9, 9),
(15, 1, 'Tele retro', 120, 120, 9, 8),
(16, 2, 'Tele retro', 120, 240, 10, 8),
(17, 1, 'Radio', 123, 123, 11, 9),
(18, 1, 'Radio', 123, 123, 17, 9),
(19, 2, 'Radio', 123, 246, 18, 9),
(20, 2, 'Tele retro', 120, 240, 19, 8),
(21, 5, 'Tele retro', 120, 600, 20, 8),
(22, 2, 'Televisor', 700, 1400, 21, 3),
(23, 2, 'Tele retro', 120, 240, 21, 8),
(24, 2, 'Radio', 123, 246, 21, 9),
(25, 5, 'Televisor', 700, 3500, 22, 3),
(26, 4, 'Televisor', 700, 2800, 23, 3),
(27, 1, 'Televisor', 700, 700, 24, 3),
(28, 1, 'Tele retro', 120, 120, 24, 8),
(29, 2, 'Radio', 123, 246, 25, 9),
(30, 1, 'Tele retro', 120, 120, 25, 8),
(31, 1, 'Radio', 123, 123, 26, 9),
(32, 1, 'Tele retro', 120, 120, 26, 8),
(33, 2, 'Televisor', 700, 1400, 27, 3),
(34, 2, 'Tele retro', 120, 240, 27, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `ordenes` (
  `id` int(11) NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_recibida` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ordenes`
--

INSERT INTO `ordenes` (`id`, `fecha_creacion`, `fecha_recibida`, `numero`, `total`, `usuario_id`) VALUES
(1, '2023-04-06 09:35:24', NULL, '0000000001', 120, 3),
(2, '2023-04-06 09:36:01', NULL, '0000000002', 123, 3),
(3, '2023-04-06 09:40:26', NULL, '0000000003', 1643, 3),
(4, '2023-04-07 17:31:06', NULL, '0000000004', 120, 3),
(5, '2023-04-10 16:13:45', NULL, '0000000005', 240, 3),
(6, '2023-04-10 16:18:29', NULL, '0000000006', 940, 3),
(7, '2023-04-10 16:37:58', NULL, '0000000007', 366, 3),
(8, '2023-04-10 16:39:48', NULL, '0000000008', 823, 4),
(9, '2023-04-11 06:00:06', NULL, '0000000009', 366, 2),
(10, '2023-04-11 11:40:09', NULL, '0000000010', 240, 2),
(11, '2023-04-11 11:52:09', NULL, '0000000011', 123, 2),
(12, '2023-04-11 12:02:34', NULL, '0000000012', 123, 2),
(13, '2023-04-11 12:06:30', NULL, '0000000013', 123, 2),
(14, '2023-04-11 12:07:46', NULL, '0000000014', 0, 2),
(15, '2023-04-11 12:07:54', NULL, '0000000015', 123, 2),
(16, '2023-04-11 12:09:20', NULL, '0000000016', 123, 2),
(17, '2023-04-11 12:11:35', NULL, '0000000017', 123, 2),
(18, '2023-04-11 12:14:59', NULL, '0000000018', 246, 2),
(19, '2023-04-11 12:15:35', NULL, '0000000019', 240, 2),
(20, '2023-04-11 12:19:11', NULL, '0000000020', 600, 2),
(21, '2023-04-11 12:20:39', NULL, '0000000021', 1886, 2),
(22, '2023-04-11 12:33:59', NULL, '0000000022', 3500, 2),
(23, '2023-04-11 12:34:50', NULL, '0000000023', 2800, 2),
(24, '2023-04-11 16:55:44', NULL, '0000000024', 820, 2),
(25, '2023-04-13 17:39:26', NULL, '0000000025', 366, 3),
(26, '2023-04-15 10:40:12', NULL, '0000000026', 243, 1),
(27, '2023-04-15 10:45:35', NULL, '0000000027', 1640, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `cantidad`, `descripcion`, `imagen`, `nombre`, `precio`, `usuario_id`) VALUES
(3, 10, ' Tele menuda y graciosa', 'tv2.jpg', 'Televisor', 700, NULL),
(8, 15, 'Tele de otros tiempos que funciona', 'tvRetro.jpg', 'Tele retro', 125, NULL),
(9, 5, 'Radio de bolsillo ', 'radioRetro.jpeg', 'Radio', 123, NULL),
(10, 3, ' Un nuevo tocadiscos retro', 'tocaDiscos.jpg', 'Tocadiscos molón', 100, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `nombre`, `apellidos`, `email`, `direccion`, `telefono`, `tipo`, `enabled`) VALUES
(1, 'admin', '$2a$04$WoqqJg.mlznaKhDwuw.g.u3JgjgN34nN81iwpeITVO3/mBaGaMWLW', 'admin', NULL, 'admin@g.com', NULL, NULL, 'ADMIN', b'1'),
(2, 'johnDoe', '$2a$10$ps/eEUaQeJEmPq6O5chgZO5Oy9jN/k8VHOkEFbZa38HWUTRAjTuoC', 'John', 'Doe', 'johndoe@g.com', 'NoPlace', '555123456', 'USER', b'1'),
(3, 'TomFoo', '$2a$10$R3vws3GVPvcG2ouoo6o8Du5YUuyeMofOQwV0Hnh2puJ94P5.Qgl3i', 'Tom', 'Foo', 'tomfoo@g.com', 'NoPlace 2', '555789456', 'USER', b'1'),
(4, 'TonySoprano', '$2a$10$qtz1zw2Bpvf9ZLr.XLEKbuN1asWwehMdw/gaHF1bBVq.3M3b4syGS', 'Tony', 'Soprano', 'tsoprano@g.com', 'Nowheretolive', '555789123', 'USER', b'1'),
(5, 'TestNuevo', '$2a$10$wwxPLVSkCxpZza9R3octyOtmAtZW17gcRCXONV9fLB0oX9mwoWTNO', 'Test', 'Nuevo', 'test@g.com', 'noplacetogo', '5555654789', 'USER', b'1'),
(6, 'PruebaTest2', '$2a$10$HawDlUO4hLTRBAQ5in3JcuQ5UIR0jJDkyAfi3PCVDffG5S3wVehBK', 'Prueba', 'Test2', 'ptest2@g.com', 'NoPlace 2', '555 456 456', 'USER', b'1'),
(7, 'test3Nuevo', '$2a$10$bSCEbv1/hYeKno1ZMyLOR.No6/DXABp5F6cBhH1IHy/8XMBr5NNYC', 'test', 'nuev', 'test3nuevo@g.com', 'noplafasd', '555645987', 'USER', b'1'),
(8, 'ProbandoProbando', '$2a$10$wyt2Iq77yD3B64EsnKUFfeH8FLWaeV6rLkO.fOLUHTFe/6nxhVWHa', 'Probando', 'Probando', 'probando@g.com', 'NoWheretoLive', '654789321', 'USER', b'1'),
(9, 'averahora', '$2a$10$x0e5Q5xCniDf/.N/aOe/yO3jpQREl2Jlij5VakcV7kk7IFPHVe9pS', 'A ver', 'Ahora', 'aver@g.com', 'no place', '123456789', 'USER', b'1'),
(10, 'otroNuevo', '$2a$10$ORW16Mx2uNnfNFXsuReiJObBJ7.1Fg.GfeR/sNT8gQ4Ge.c2pVW0m', 'otro', 'nuevo', 'otronuevo@g.com', 'noplacs', '123456789', 'USER', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `usuario_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_roles`
--

INSERT INTO `usuario_roles` (`usuario_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdurdo71oa161lmmal7oeaor74` (`orden_id`),
  ADD KEY `FKpruducto_detalle` (`producto_id`);

--
-- Indices de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsqu43gsd6mtx7b1siww96324` (`usuario_id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo8g0kqq9awvgh4elqai7tdhu` (`usuario_id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD KEY `FKtk4qndf0xt1ijkk4a7wj5vnwb` (`role_id`),
  ADD KEY `FKuu9tea04xb29m2km5lwe46ua` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD CONSTRAINT `FKdurdo71oa161lmmal7oeaor74` FOREIGN KEY (`orden_id`) REFERENCES `ordenes` (`id`),
  ADD CONSTRAINT `FKio4oyl8qt5jclekxp7bwws2iy` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKpruducto_detalle` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD CONSTRAINT `FKsqu43gsd6mtx7b1siww96324` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FKo8g0kqq9awvgh4elqai7tdhu` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `FKtk4qndf0xt1ijkk4a7wj5vnwb` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKuu9tea04xb29m2km5lwe46ua` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
