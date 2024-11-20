

CREATE SCHEMA IF NOT EXISTS world;

SET DATABASE SQL SYNTAX MYS TRUE;

SET MODE MYSQL;


CREATE TABLE world.city (
                            ID INT IDENTITY NOT NULL PRIMARY KEY,
                            Name VARCHAR(35) NOT NULL DEFAULT '',
                            CountryCode CHAR(3) NOT NULL DEFAULT '',
                            District VARCHAR(20) NOT NULL DEFAULT '',
                            Population INT NOT NULL DEFAULT '0',
                            FOREIGN KEY (CountryCode) REFERENCES world.country (Code)
);

CREATE TABLE world.country (
                               Code CHAR(3) NOT NULL DEFAULT '',
                               Name VARCHAR(52) NOT NULL DEFAULT '',
                               Continent VARCHAR(20) NOT NULL DEFAULT 'Asia',
                               Region VARCHAR(26) NOT NULL DEFAULT '',
                               SurfaceArea DECIMAL(10,2) NOT NULL DEFAULT '0.00',
                               IndepYear SMALLINT,
                               Population INT NOT NULL DEFAULT '0',
                               LifeExpectancy DECIMAL(3,1),
                               GNP DECIMAL(10,2),
                               GNPOld DECIMAL(10,2),
                               LocalName VARCHAR(45) NOT NULL DEFAULT '',
                               GovernmentForm VARCHAR(45) NOT NULL DEFAULT '',
                               HeadOfState VARCHAR(60),
                               Capital INT,
                               Code2 CHAR(2) NOT NULL DEFAULT '',
                               PRIMARY KEY (Code)
);

CREATE TABLE world.countrylanguage (
                                       CountryCode CHAR(3) NOT NULL DEFAULT '',
                                       Language VARCHAR(30) NOT NULL DEFAULT '',
                                       IsOfficial CHAR(1) NOT NULL DEFAULT 'F',
                                       Percentage DECIMAL(4,1) NOT NULL DEFAULT '0.0',
                                       PRIMARY KEY (CountryCode, Language),
                                       FOREIGN KEY (CountryCode) REFERENCES world.country (Code)
);

commit;
