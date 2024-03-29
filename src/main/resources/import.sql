-- Insertar datos en la tabla categories
INSERT INTO categories (id, name) VALUES 
(1, 'Electrónica'),
(2, 'Ropa'),
(3, 'Hogar'),
(4, 'Juguetes');

-- Insertar datos en la tabla products
INSERT INTO products (id, name, price, id_category) VALUES
(1, 'Teléfono móvil', 599.99, 1),
(2, 'Televisor LED', 899.99, 1),
(3, 'Camisa de algodón', 29.99, 2),
(4, 'Pantalones vaqueros', 39.99, 2),
(5, 'Juego de sábanas', 49.99, 3),
(6, 'Sartén antiadherente', 24.99, 3),
(7, 'Muñeca de peluche', 14.99, 4),
(8, 'Rompecabezas', 9.99, 4);
