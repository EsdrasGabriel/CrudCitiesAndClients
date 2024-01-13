CREATE TABLE cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    state VARCHAR(40) NOT NULL
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    date_of_birth DATE NOT NULL,
    age SMALLINT NOT NULL,
    city_id INT REFERENCES cities(id)
);