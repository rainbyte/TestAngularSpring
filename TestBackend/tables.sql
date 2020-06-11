DROP TABLE artists;
CREATE TABLE `artists` (
    `id` int(11) KEY NOT NULL AUTO_INCREMENT,
    `name_native` varchar(256) NOT NULL,
    `name_romanized` varchar(256),
    `country` varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '封茗囧菌', 'Fengming Jiongjun', 'China');

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '花澤香菜', 'Hanazawa Kana', 'Japan');

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (0, '장다혜', 'Jang Da-hye', 'Korea');