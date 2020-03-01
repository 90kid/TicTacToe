CREATE TABLE user(
    id BIGINT PRIMARY KEY,
    login VARCHAR(80) NOT NULL,
    email VARCHAR(80) NOT NULL,
    password VARCHAR(80) NOT NULL,
    enabled BOOLEAN NOT NULL,
    win_number INT DEFAULT 0,
    lose_number INT DEFAULT 0,
    number_of_played_game INT DEFAULT 0
)

