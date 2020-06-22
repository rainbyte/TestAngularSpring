DROP TABLE IF EXISTS albums;
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
VALUES (1, '封茗囧菌', 'Fengming Jiongjun', 4);

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (2, '花澤香菜', 'Hanazawa Kana', 2);

INSERT INTO artists (id, name_native, name_romanized, country)
VALUES (3, '헤이즈', 'Heize', 3);

CREATE TABLE `albums` (
    `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name_native` varchar(256) NOT NULL,
    `name_romaji` varchar(256),
    `year` int(4) NOT NULL,
    `artist_id` int(11) NOT NULL REFERENCES artists(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (1, "Claire", NULL, 2013, 2);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (2, "25", NULL, 2014, 2);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (3, "Blue Avenue", NULL, 2014, 2);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (4, "Opportunity", NULL, 2017, 2);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (5, '헤이즈', 'Heize', 2014, 3);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (6, "만추", "Manchu", 2019, 3);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (7, "快來找我啊", "Kuài lái zhǎo wǒ a", 2018, 1);

INSERT INTO albums (id, name_native, name_romaji, year, artist_id)
VALUES (8, "去你妹的撩妹", "Qù nǐ mèi de liāo mèi", 2019, 1);

