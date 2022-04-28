CREATE TABLE Bil(
    id INTEGER AUTO_INCREMENT NOT NULL,
    personnr VARCHAR(255) NOT NULL,
    navn VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    bilmerke VARCHAR(255) NOT NULL,
    biltype VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
-- Intet ; før etter objekt()

CREATE TABLE Modell(
    merke VARCHAR(255) NOT NULL,
    type VARCHAR (255) NOT NULL
);


