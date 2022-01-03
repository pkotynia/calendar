CREATE TABLE calendars (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    uuid VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);