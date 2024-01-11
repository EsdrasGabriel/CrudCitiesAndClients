CREATE TABLE cities (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    state TEXT NOT NULL
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    full_name TEXT NOT NULL,
    gender TEXT NOT NULL,
    date_of_birth DATE NOT NULL,
    age INTEGER NOT NULL,
    city_id INTEGER REFERENCES cities(id)
);