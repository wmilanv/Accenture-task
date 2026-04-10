
CREATE TABLE IF NOT EXISTS product (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  stock INT,
  branch_id BIGINT
);
CREATE TABLE IF NOT EXISTS franchise (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS branch (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  franchise_id BIGINT
);

INSERT INTO product(name, stock, branch_id) VALUES
('A', 10, 1),
('B', 20, 1),
('C', 5, 1),
('D', 15, 2),
('E', 30, 2);

INSERT INTO franchise(name) VALUES ('Franquicia Maestro');
INSERT INTO branch(name, franchise_id) VALUES ('Sucursal Norte', 1), ('Sucursal Sur', 1);
