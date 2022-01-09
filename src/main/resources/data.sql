CREATE TABLE calendar_user (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE calendar (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    uuid VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES calendar_user(id)
);

CREATE TABLE time_slot (
    id SERIAL PRIMARY KEY,
    calendar_id INT NOT NULL,
    user_id INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES calendar_user(id),
    CONSTRAINT fk_calendar FOREIGN KEY(calendar_id) REFERENCES calendar(id)
);