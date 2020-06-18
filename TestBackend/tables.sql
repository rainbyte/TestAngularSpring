DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS countries;

CREATE TABLE `countries` (
    `id` int(3) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO countries (id, name) VALUES (1, 'Argentina');
INSERT INTO countries (id, name) VALUES (2, 'Japan');
INSERT INTO countries (id, name) VALUES (3, 'Korea');
INSERT INTO countries (id, name) VALUES (4, 'China');

CREATE TABLE `artists` (
    `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name_native` varchar(256) NOT NULL,
    `name_romanized` varchar(256),
    `country` int(3) NOT NULL REFERENCES countries(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '封茗囧菌', 'Fengming Jiongjun', 4);

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '花澤香菜', 'Hanazawa Kana', 2);

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '장다혜', 'Jang Da-hye', 3);