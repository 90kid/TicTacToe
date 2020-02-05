CREATE TABLE user(
    id BIGINT PRIMARY KEY,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    enabled BOOLEAN NOT NULL
)

