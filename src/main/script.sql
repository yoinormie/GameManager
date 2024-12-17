-- 1. Crear un usuario llamado 'manager' con la contraseña 'manager' y privilegios de superusuario
CREATE ROLE manager WITH LOGIN PASSWORD 'manager' SUPERUSER;

-- 2. Crear una base de datos llamada 'apps' con el propietario 'manager'
CREATE DATABASE apps OWNER manager;

-- 3. Conectarse a la base de datos 'apps' (PostgreSQL no ejecuta "USE" como MySQL, así que se debe hacer manualmente en el cliente)
\c apps;

-- 4. Crear una tabla llamada 'owner' con las columnas especificadas
CREATE TABLE owner (
    id SERIAL PRIMARY KEY,         -- Clave primaria autoincrementable (NOT NULL implícito en PRIMARY KEY)
    name VARCHAR(255) NOT NULL,    -- Columna 'name' que no puede ser nula
    first_surname VARCHAR(255) NOT NULL, -- Columna 'first_surname' que no puede ser nula
    second_surname VARCHAR(255)    -- Columna 'second_surname' (puede ser nula si no se especifica NOT NULL)
);

-- 5. Confirmación de creación
COMMENT ON TABLE owner IS 'Tabla que contiene información de propietarios.';
