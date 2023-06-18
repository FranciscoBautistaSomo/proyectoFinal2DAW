-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2023 a las 17:58:30
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
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre`) VALUES
(1, 'Audio'),
(2, 'Video'),
(3, 'Segunda Mano');

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
(35, 1, 'Tocadiscos molón', 100, 100, 28, 10),
(36, 2, 'Videocassette BETA', 125, 250, 28, 11),
(37, 2, 'Videocassette BETA', 125, 250, 29, 11),
(38, 1, 'La Radio de mi Abuela', 120, 120, 30, 14),
(39, 1, 'La Radio de mi Abuela', 120, 120, 31, 14),
(40, 1, 'Auriculares too stereo', 30, 30, 32, 15),
(41, 1, 'Amplificado de valvulas', 800.8, 800.8, 32, 17),
(42, 1, 'Tocadiscos molón', 120, 120, 33, 10),
(43, 1, 'Radio', 123, 123, 33, 9),
(44, 1, 'Tv muy cuca', 200, 200, 34, 16),
(45, 1, 'Auriculares too stereo', 30, 30, 35, 15),
(46, 1, 'Grabadora Vintage Cassette', 50, 50, 35, 21),
(47, 1, 'Tocadiscos molón', 120, 120, 36, 10),
(48, 1, 'Videocassette BETA', 125, 125, 38, 11),
(49, 1, 'Tocadiscos molón', 120, 120, 39, 10),
(50, 1, 'Amplificador Vintage LEAK Stereo 130', 949, 949, 40, 18),
(51, 1, 'Tocadiscos molón', 120, 120, 41, 10),
(52, 2, 'Radio', 123, 246, 42, 9),
(53, 2, 'Radio', 123, 246, 43, 9),
(54, 1, 'Radio', 123, 123, 44, 9),
(55, 1, 'Videocassette BETA', 125, 125, 45, 11),
(56, 1, 'Radio', 123, 123, 46, 9),
(57, 1, 'Radio', 123, 123, 49, 9),
(58, 1, 'Radio', 123, 123, 50, 9),
(59, 1, 'Videocassette BETA', 125, 125, 53, 11),
(60, 1, ' Mini Televisión ELEKTONIKA 407', 120, 120, 54, 20),
(61, 1, 'Videocassette BETA', 125, 125, 55, 11),
(62, 1, 'Tocadiscos molón', 120, 120, 56, 10),
(63, 1, 'Videocassette BETA', 125, 125, 57, 11),
(64, 1, 'Tocadiscos molón', 120, 120, 58, 10),
(65, 1, 'Tocadiscos molón', 120, 120, 59, 10);

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
(28, '2023-04-25 05:56:27', NULL, '0000000001', 350, 2),
(29, '2023-05-05 07:27:44', NULL, '0000000002', 250, 20),
(30, '2023-05-05 08:10:33', NULL, '0000000003', 120, 20),
(31, '2023-05-05 17:21:32', NULL, '0000000004', 120, 20),
(32, '2023-05-05 18:31:37', NULL, '0000000005', 830.8, 25),
(33, '2023-05-09 18:28:47', NULL, '0000000006', 243, 2),
(34, '2023-05-10 06:17:53', NULL, '0000000007', 200, 24),
(35, '2023-05-10 06:39:45', NULL, '0000000008', 80, 24),
(36, '2023-05-10 06:43:52', NULL, '0000000009', 120, 24),
(37, '2023-05-10 06:44:46', NULL, '0000000010', 0, 24),
(38, '2023-05-11 05:58:26', NULL, '0000000011', 125, 2),
(39, '2023-05-12 12:47:50', NULL, '0000000012', 120, 24),
(40, '2023-05-12 19:23:17', NULL, '0000000013', 949, 2),
(41, '2023-05-25 07:57:17', NULL, '0000000014', 120, 28),
(42, '2023-05-29 08:47:56', NULL, '0000000015', 246, 29),
(43, '2023-05-29 08:48:43', NULL, '0000000016', 246, 29),
(44, '2023-05-29 17:52:56', NULL, '0000000017', 123, 20),
(45, '2023-05-29 17:54:22', NULL, '0000000018', 125, 20),
(46, '2023-05-29 18:01:54', NULL, '0000000019', 123, 20),
(47, '2023-05-29 18:05:06', NULL, '0000000020', 0, 20),
(48, '2023-05-29 18:05:19', NULL, '0000000021', 0, 20),
(49, '2023-05-29 18:06:51', NULL, '0000000022', 123, 20),
(50, '2023-05-29 18:14:15', NULL, '0000000023', 123, 20),
(51, '2023-05-29 18:16:12', NULL, '0000000024', 0, 20),
(52, '2023-05-29 18:18:14', NULL, '0000000025', 0, 20),
(53, '2023-05-29 18:24:36', NULL, '0000000026', 125, 32),
(54, '2023-05-29 18:26:10', NULL, '0000000027', 120, 32),
(55, '2023-05-29 18:26:53', NULL, '0000000028', 125, 32),
(56, '2023-05-29 18:45:35', NULL, '0000000029', 120, 32),
(57, '2023-05-29 18:52:28', NULL, '0000000030', 125, 32),
(58, '2023-05-29 18:57:40', NULL, '0000000031', 120, 32),
(59, '2023-05-29 19:01:21', NULL, '0000000032', 120, 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `categoria_id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `cantidad`, `descripcion`, `imagen`, `nombre`, `precio`, `usuario_id`, `enabled`, `categoria_id_categoria`) VALUES
(9, 6, 'Radio de bolsillo FM/AM', 'b063a872-bd89-458d-9144-cb8f7ccb6b94_1.fd8be5edff996e21999091104fd006df.jpeg', 'Radio', 123, NULL, b'1', 1),
(10, 6, ' Un nuevo tocadiscos retro', 'tocaDiscos.jpg', 'Tocadiscos molón', 120, NULL, b'1', 1),
(11, 1, 'El bueno tio ', '510246718_o.jpg', 'Videocassette BETA', 125, NULL, b'1', 2),
(14, 0, 'La radio con la que mi abuela escuchaba el Nodo ', 'radioRetro.jpeg', 'La Radio de mi Abuela', 120, NULL, b'1', 1),
(15, 0, 'Para no dar la lata con el reggeton ', 'auriculares-retro.jpg', 'Auriculares too stereo', 30, NULL, b'1', 1),
(16, 4, 'La tele que tenias en tu cuarto y solo se veia bien un canal ', 'tvRetro.jpg', 'Tv muy cuca', 200, NULL, b'1', 3),
(17, 4, ' Para un sonido natural: con sus 6 tubos de iluminación naranja, este amplificador te ofrece un sonido dinámico y suave\r\n Look retro: su diseño purista ofrece una vista de los 6 tubos que atraerán la mirada\r\n Posibilidad de conexión variable: terminales de altavoz dorados para atornillar para 4 o 8 ohmios\r\n Amplificador: el VR-70 EII se puede utilizar como preamplificador y amplificador', 'Ampli_.jpg', 'Amplificado de valvulas', 800.8, NULL, b'1', 1),
(18, 9, ' Diseño industrial replica a la perfección al de las electrónicas “vintage” de LEAK. Tecnológicamente a la última, el Stereo 130 incorpora componentes de grado audiófilo,', 'Stereo 130.jpg', 'Amplificador Vintage LEAK Stereo 130', 949, NULL, b'1', 1),
(19, 4, ' Belle Epoque 1912 tocadiscos retro CD BT USB DAB+/UKW marrón', '10034402_yy_0001_titel___.jpg', 'Belle Epoque 1912 tocadiscos', 198, NULL, b'1', 1),
(20, 0, ' Mini Televisión ELEKTONIKA 407 De Colección de la Era Espacial', 'Mini_Televisión ELEKTONIKA_407.png', ' Mini Televisión ELEKTONIKA 407', 120, NULL, b'1', 2),
(21, 0, 'Grabadora cassette portatil Vintage, año 1968, maca Phillips con su respestiva funda. Tiene algún desperfecto. Funciona correctamente.', 'grabadoraVintage.JPG', 'Grabadora Vintage Cassette', 50, NULL, b'1', 3),
(22, 5, ' Portable Music Cassette Player', 'sony-walkman-web.jpg', 'Sony Walkman', 110, NULL, b'1', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `authority`, `nombre`) VALUES
(1, 'ROLE_ADMIN', NULL),
(2, 'ROLE_USER', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `nombre`, `apellidos`, `email`, `direccion`, `telefono`, `tipo`, `enabled`) VALUES
(1, 'admin', '$2a$04$WoqqJg.mlznaKhDwuw.g.u3JgjgN34nN81iwpeITVO3/mBaGaMWLW', 'admin', '', 'admin@g.com', NULL, NULL, 'ROLE_ADMIN', b'1'),
(2, 'johnDoe', '$2a$10$ps/eEUaQeJEmPq6O5chgZO5Oy9jN/k8VHOkEFbZa38HWUTRAjTuoC', 'John', 'Doe', 'johndoe@g.com', 'NoPlacetoGo', '655555557', 'ROLE_USER', b'1'),
(20, 'TomMcF', '$2a$10$g0X9mu.Qk3279fWRC.7T6eXkbOg0NT1r68GSulxec3IDc88/rG0li', 'Tom', 'McFarlam', 'tom@g.com', 'No where to go in this moment', '666698741', 'ROLE_USER', b'1'),
(21, 'hansolo', '$2a$10$WdWdKzXa/9KLElyEwZ7T1.RcRg24dvyd/WEK3FRWXyBzTPyCBQbBi', 'Han', 'Solo', 'alcon@g.com', 'In a far far away galaxy', '12345698', 'ROLE_USER', b'1'),
(22, 'dadfvda', '$2a$10$bFZz/tV0BuOKsBwDgWbEAuiGbWaLCUuNLRY5rEI4IaljFPCHt82MC', 'vdsvsdv', 'svdvv', 'svsvsvs@g.com', 'sdfsffd', '4456987123', 'ROLE_USER', b'0'),
(23, 'pruebaTest', '$2a$10$Mjkj8QI4KDmceo26QKWpouJAYUUc65UWad9WCFry./gKlB6s/BuKW', 'Prueba', 'Test', 'pruebaTest@g.com', 'NoPlace', '456987123', 'ROLE_USER', b'1'),
(24, 'PruebaFeliz', '$2a$10$TPFAzJSCL0oXsRFwvWusAeTlTySZjIKy4WScw6M1zCXX0TX7P0uGy', 'Prueba', 'Feliz Feliz', 'pruebaFeliz@g.com', 'No Place TO GO Today', '123654789', 'ROLE_USER', b'1'),
(25, 'TestVer2', '$2a$10$cg5N3bkfSLuqJ0FqTbCtD.fpZM10SAkhZOEbdK6TYWqKZHO9doTqi', 'Test', 'Ver2', 'testVer2@g.com', 'No country', '123654789', 'ROLE_USER', b'1'),
(28, 'TestVer3', '$2a$10$tnS8WrxqLkw4fAohL6gVbuuE8dDdB3Fq8fyx/wVPcOeoxRUWvnCu2', 'Test', 'Ver3', 'testVer3@g.com', 'No Country Cool', '456357951', 'ROLE_USER', b'1'),
(29, 'TestTodoOK', '$2a$10$v7Od4zFPffalchYmRIX2HOzHEUG/HjQxEjn.GYKb8ZLCkobE3Njlm', 'Test', 'TodoOK', 'testTodoOk@g.com', 'No Way to go', '45698712', 'ROLE_USER', b'1'),
(30, 'pruebaUltimaVersion', '$2a$10$SRMF9sssX9gHFy.US3z9GurkRdjHUVR3d1BipkXbgdaEjGQn.QF/i', 'pruebaUltima', 'Version', 'pruebaUltima@g.com', 'No place to go', '456987123', 'ROLE_USER', b'1'),
(31, 'testRegistro', '$2a$10$GBnA1OyRQy9oljdKSQmI7.6vjXHW8U7301tpjPlYHdOj4JjXuTA5.', 'Test', 'Registro', 'testregistro@g.com', NULL, '6666554789', 'ROLE_USER', b'1'),
(32, 'probarMsg', '$2a$10$WCPMOzy9d4OowIVcCBBYIOX7AMp3OEUUAK/5qaeLLclgJTXaOY6EK', 'Probar', 'Msg', 'probarmsg@g.com', NULL, '6666587491', 'ROLE_USER', b'1'),
(33, 'PruebaTodoOK', '$2a$10$GOZ4Yv3E60OLtwESS5b1ae/3ET90EdTbx3p.jJp32.XxFSO3oULxq', 'Prueba', 'TodoOK', 'todoOK@g.com', 'No Place to gto', '654987321', 'ROLE_USER', b'1');

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
(21, 2),
(22, 2),
(23, 2),
(20, 2),
(25, 2),
(28, 2),
(29, 2),
(2, 2),
(30, 2),
(31, 2),
(32, 2),
(24, 2),
(33, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

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
  ADD KEY `FKo8g0kqq9awvgh4elqai7tdhu` (`usuario_id`),
  ADD KEY `FK_productos_categoria` (`categoria_id_categoria`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

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
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD CONSTRAINT `FKdurdo71oa161lmmal7oeaor74` FOREIGN KEY (`orden_id`) REFERENCES `ordenes` (`id`),
  ADD CONSTRAINT `FKpruducto_detalle` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD CONSTRAINT `FKsqu43gsd6mtx7b1siww96324` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_productos_categoria` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `FKo8g0kqq9awvgh4elqai7tdhu` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `FKtk4qndf0xt1ijkk4a7wj5vnwb` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKuu9tea04xb29m2km5lwe46ua` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
