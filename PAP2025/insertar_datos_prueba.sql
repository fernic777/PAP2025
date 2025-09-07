-- Script para insertar usuarios de prueba en PAP2025
-- Ejecutar en pgAdmin en la base de datos pap2025

-- Insertar 2 lectores en BIBLOTECA_INFANTIL
INSERT INTO usuarios (nombre, email) VALUES 
('Ana García', 'ana.garcia@email.com'),
('Carlos López', 'carlos.lopez@email.com');

-- Insertar los lectores con sus datos específicos
INSERT INTO lectores (usuario_id, direccion, fecha_registro_dia, fecha_registro_mes, fecha_registro_anio, estado, zona) VALUES 
((SELECT id FROM usuarios WHERE email = 'ana.garcia@email.com'), 'Calle de los Niños 123, Ciudad', 10, 1, 2025, 'ACTIVO', 'BIBLOTECA_INFANTIL'),
((SELECT id FROM usuarios WHERE email = 'carlos.lopez@email.com'), 'Avenida Infantil 456, Ciudad', 15, 1, 2025, 'ACTIVO', 'BIBLOTECA_INFANTIL');

-- Insertar 2 lectores en ARCHIVO_GENERAL
INSERT INTO usuarios (nombre, email) VALUES 
('María Rodríguez', 'maria.rodriguez@email.com'),
('Pedro Martínez', 'pedro.martinez@email.com');

INSERT INTO lectores (usuario_id, direccion, fecha_registro_dia, fecha_registro_mes, fecha_registro_anio, estado, zona) VALUES 
((SELECT id FROM usuarios WHERE email = 'maria.rodriguez@email.com'), 'Plaza del Archivo 789, Ciudad', 20, 1, 2025, 'ACTIVO', 'ARCHIVO_GENERAL'),
((SELECT id FROM usuarios WHERE email = 'pedro.martinez@email.com'), 'Calle Histórica 321, Ciudad', 25, 1, 2025, 'ACTIVO', 'ARCHIVO_GENERAL');

-- Insertar 2 bibliotecarios
INSERT INTO usuarios (nombre, email) VALUES 
('Laura Sánchez', 'laura.sanchez@biblioteca.com'),
('Roberto Fernández', 'roberto.fernandez@biblioteca.com');

INSERT INTO bibliotecarios (usuario_id, nro_empleado) VALUES 
((SELECT id FROM usuarios WHERE email = 'laura.sanchez@biblioteca.com'), 2001),
((SELECT id FROM usuarios WHERE email = 'roberto.fernandez@biblioteca.com'), 2002);

-- Verificar que se insertaron correctamente
SELECT 'Datos insertados exitosamente' as resultado;
