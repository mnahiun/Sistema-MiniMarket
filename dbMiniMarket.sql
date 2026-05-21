-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-05-2026 a las 00:47:35
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbMiniMarket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `descripcion`, `activo`) VALUES
(1, 'Productos de limpieza', 'Detergentes, limpiadores y desinfectantes', b'1'),
(2, 'Bebidas', 'Aguas, jugos, gaseosas, cerveza, bebidas, energizantes', b'1'),
(3, 'Cuidado personal ', 'Productos de aseo diario como jabones, shampoos, desodorantes y cremas dentales', b'1'),
(4, 'Productos desechables', 'Vasos, platos, cubiertos de plastico, servilletas', b'1'),
(5, 'Snacks', 'Papas fritas, nachos, chicharrones, frutos secos salados', b'1'),
(6, 'Productos para mascotas', 'Alimentos secos y humedos para perros y gatos, juguetes ', b'1'),
(7, 'Abarrotes', 'Productos  basicos de despena como arroz, aceite, enlatados, harinas ', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ingreso`
--

CREATE TABLE `detalle_ingreso` (
  `id` int(11) NOT NULL,
  `ingreso_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(11,2) NOT NULL,
  `codigo_Producto` varchar(20) DEFAULT NULL,
  `nombre_Producto` varchar(20) DEFAULT NULL,
  `subtotal` decimal(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id` int(11) NOT NULL,
  `venta_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(11,2) NOT NULL,
  `descuento` decimal(11,2) NOT NULL,
  `nombre_producto` varchar(20) DEFAULT NULL,
  `stock_producto` int(11) DEFAULT NULL,
  `codigo_producto` varchar(20) DEFAULT NULL,
  `subtotal` decimal(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--

CREATE TABLE `ingreso` (
  `id` int(11) NOT NULL,
  `persona_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `serie_comprobante` varchar(7) DEFAULT NULL,
  `num_comprobante` varchar(10) NOT NULL,
  `fecha` datetime NOT NULL,
  `impuesto` decimal(11,2) NOT NULL,
  `total` decimal(11,2) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Aceptado',
  `nombrePersona` varchar(50) DEFAULT NULL,
  `usuarioNombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ingreso`
--

INSERT INTO `ingreso` (`id`, `persona_id`, `usuario_id`, `tipo_comprobante`, `serie_comprobante`, `num_comprobante`, `fecha`, `impuesto`, `total`, `estado`, `nombrePersona`, `usuarioNombre`) VALUES
(1, 5, 3, 'Factura', 'S001', 'C01', '2026-05-19 00:00:00', 2520.00, 16520.00, 'Aceptado', 'Bebidas Y Refrescos El Manantial', 'Hector'),
(2, 5, 3, 'Factura', 'S002', 'C02', '2026-05-19 00:00:00', 3420.00, 22420.00, 'Aceptado', 'Bebidas Y Refrescos El Manantial', 'Hector'),
(3, 5, 3, 'Factura', 'S03', 'C003', '2026-05-19 00:00:00', 900.00, 5900.00, 'Aceptado', 'Bebidas Y Refrescos El Manantial', 'Hector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id` int(11) NOT NULL,
  `venta_id` int(11) NOT NULL,
  `metodo_pago` varchar(20) NOT NULL,
  `monto` decimal(11,2) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id`, `venta_id`, `metodo_pago`, `monto`, `fecha`) VALUES
(1, 1, 'efectivo', 38940.00, '2026-05-19 00:00:00'),
(2, 2, 'Nequi', 14160.00, '2026-05-20 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `tipo_persona` varchar(20) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `tipo_documento` varchar(20) DEFAULT NULL,
  `num_documento` varchar(20) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `tipo_persona`, `nombre`, `tipo_documento`, `num_documento`, `direccion`, `telefono`, `email`, `activo`) VALUES
(1, 'Proveedor', 'Distribuidora Alimentos del Norte S.A.S', 'NIT', '901.345.678-1', 'Calle 13 # 84-40', '3112345678', 'alimentosdelnorte@gmail.com', b'1'),
(2, 'Cliente', 'Carlos Cortes', 'CC', '1.015.432.789', 'Carrera 7 # 45-24', '3124567890', 'carlosmendoza@gmail.com', b'1'),
(3, 'Cliente', 'Andrea Gomez', 'CC', '52.345.678', 'Calle 100 # 20-50', '3158867854', 'andreagomez@hotmail.com', b'1'),
(4, 'Cliente', 'Diego Castro', 'CC', '79.987.654', 'Calle 65 # 24-03', '3174561234', 'diegocastro@gmail.com', b'1'),
(5, 'Proveedor', 'Bebidas Y Refrescos El Manantial', 'NIT', '800123456-3', 'Calle 40 # 30-60', '3175890123', 'bebidasmanantial@gmail.com', b'1'),
(6, 'Proveedor', 'Limpieza ProHogar', 'NIT ', '900555223-4', 'Carrera 65 # 20- 32', '3106789056', 'prohogar@gmail.com', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio_venta` decimal(11,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  `proveedor_Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `categoria_id`, `codigo`, `nombre`, `precio_venta`, `stock`, `descripcion`, `activo`, `proveedor_Id`) VALUES
(1, 1, '770124', 'Coca-Cola Original', 7000.00, -3, 'Coca cola de 1.5 Litros ', b'1', 1),
(2, 1, '8998678', 'Cerveza Águila', 3000.00, -4, 'Lata 330ml', b'1', 1),
(3, 1, '790089', 'Detergente Fab', 2000.00, 29, 'Detergente en polvo', b'1', 6),
(4, 1, '334790', 'Gatorade Tropical', 5000.00, 18, 'Gatorade sabor frutas tropicales', b'1', 5),
(5, 6, '673826', 'purina ', 5000.00, 30, 'purina para gatos', b'1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`, `descripcion`, `activo`) VALUES
(1, 'Administrador', 'persona que administra los registros de ventas y el control de inventario disponible ', 1),
(2, 'Cajero', 'Empleado que tiene permisos para registrar ventas y clientes', 1),
(3, 'Bodeguero', 'Empleado que recibe y organiza el inventario de productos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `tipo_documento` varchar(20) DEFAULT NULL,
  `num_documento` varchar(20) DEFAULT NULL,
  `descripcion` varchar(70) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `clave` varchar(128) NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `rol_id`, `nombre`, `tipo_documento`, `num_documento`, `descripcion`, `telefono`, `email`, `clave`, `activo`) VALUES
(1, 1, 'Nahin', 'CC', '1303678965', 'Admin del sistema ', '3157895645', 'admin@gmail.com', '142101', b'1'),
(2, 2, 'Daniel', 'CC', '1089678809', 'Cajero que registra ventas', '3184578756', 'cajero@gmail.com', '123456', b'1'),
(3, 3, 'Hector', 'CC', '1025774565', 'Empleado que maneja el inventario', '3504895676', 'bodeg@gmail.com', '1234', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `persona_id` int(11) NOT NULL,
  `tipo_documento` varchar(20) NOT NULL,
  `serie_comprobante` varchar(7) DEFAULT NULL,
  `num_comprobante` varchar(10) NOT NULL,
  `fecha` datetime NOT NULL,
  `impuesto` decimal(11,2) NOT NULL,
  `total` decimal(11,2) DEFAULT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Aceptado',
  `nombrePersona` varchar(20) DEFAULT NULL,
  `usuarioNombre` varchar(20) DEFAULT NULL,
  `num_documento` varchar(20) DEFAULT NULL,
  `tipo_comprobante` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `usuario_id`, `persona_id`, `tipo_documento`, `serie_comprobante`, `num_comprobante`, `fecha`, `impuesto`, `total`, `estado`, `nombrePersona`, `usuarioNombre`, `num_documento`, `tipo_comprobante`) VALUES
(1, 2, 3, 'CC', 'S01', 'C001', '2026-05-19 00:00:00', 5940.00, 38940.00, 'Aceptado', 'Andrea Gomez', 'Daniel', '52345678', 'Factura'),
(2, 2, 4, 'CC', 'S02', 'C002', '2026-05-19 00:00:00', 2160.00, 14160.00, 'Aceptado', 'Diego Castro', 'Daniel', '79987654', 'Factura'),
(3, 2, 4, 'CC', 'S03', 'C003', '2026-05-20 00:00:00', 5940.00, 38940.00, 'Aceptado', 'Diego Castro', 'Daniel', '79987654', 'Factura');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `detalle_ingreso`
--
ALTER TABLE `detalle_ingreso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_ingreso_ingreso_idx` (`ingreso_id`),
  ADD KEY `fk_detalle_ingreso_producto_idx` (`producto_id`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_venta_venta_idx` (`venta_id`),
  ADD KEY `fk_detalle_venta_producto_idx` (`producto_id`);

--
-- Indices de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ingreso_persona_idx` (`persona_id`),
  ADD KEY `fk_ingreso_usuario_idx` (`usuario_id`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pago__venta_idx` (`venta_id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  ADD KEY `fk_producto_categoria_idx` (`categoria_id`),
  ADD KEY `fk_producto_proveedor` (`proveedor_Id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD KEY `fk_usuario_rol_idx` (`rol_id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ingreso_persona_idx` (`persona_id`),
  ADD KEY `fk_venta_usuario_idx` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detalle_ingreso`
--
ALTER TABLE `detalle_ingreso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ingreso`
--
ALTER TABLE `detalle_ingreso`
  ADD CONSTRAINT `fk_detalle_ingreso_ingreso` FOREIGN KEY (`ingreso_id`) REFERENCES `ingreso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detalle_ingreso_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `fk_detalle_venta_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_venta_venta` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD CONSTRAINT `fk_ingreso_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ingreso_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `fk_pago_venta` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_proveedor` FOREIGN KEY (`proveedor_Id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_venta_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venta_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
