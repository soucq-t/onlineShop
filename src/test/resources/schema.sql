use chen_onlineShop
DROP TABLE IF EXISTS bestellung
DROP TABLE IF EXISTS warenKorbArtikel
DROP TABLE IF EXISTS artikel
DROP TABLE IF EXISTS kategorie
DROP TABLE IF EXISTS verkaeuferAccount
DROP TABLE IF EXISTS kundeAccount



create table kundeAccount
(
    kA_id INT IDENTITY(1,1)Primary Key,
    username VARCHAR(30) NOT NULL,
    kennwort VARCHAR(30) NOT NULL,
    Lieferadresse VARCHAR(30) NOT NULL



)



create table verkaeuferAccount
(
    vA_id INT IDENTITY(1,1)Primary Key,
    username VARCHAR(30) NOT NULL,
    kennwort VARCHAR(30) NOT NULL,
    sitz VARCHAR(30)
)



create table kategorie
(
    kat_id INT IDENTITY(1,1) Primary Key,
    kat_name VARCHAR (30) NOT NULL
)



create table artikel
(
    art_id INT IDENTITY(1,1) Primary Key,
    art_name VARCHAR(30) NOT NULL ,
    art_price DECIMAL(8,2) NOT NULL,
    art_Description VARCHAR(30) NOT NULL,
    art_kat_id INT references kategorie on delete set null,
    art_vA_id INT references verkaeuferAccount on delete set null
)



create table warenKorbArtikel
(
    wKA_id int IDENTITY(1,1) Primary Key,
    war_art_id int references artikel on delete set null,
    war_kA_id int references kundeAccount on delete set null
)



create table bestellung
(
    bes_id INT IDENTITY(1,1) Primary Key,
    bes_kA_id int references kundeAccount on delete set null
    --Lieferadresse VARCHAR(30) NOT NULL
)



create table bestellungsArtikel
(
    bA_id int IDENTITY(1,1) Primary Key,
    bA_art_id int references artikel on delete cascade,
    bA_bes_id int references bestellung on delete cascade
)