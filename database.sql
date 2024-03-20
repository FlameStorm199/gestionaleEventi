CREATE DATABASE gestionaleEventi_masterDB;
USE gestionaleEventi_masterDB;

CREATE TABLE ruoli(
    id_ruolo int(8) zerofill auto_increment primary key,
    descrizione_ruolo varchar(50) not null
);

CREATE TABLE utenti(
    username varchar(20) binary primary key,
    password varchar(30) binary not null,
    nome varchar(50) not null,
    cognome varchar(50) not null,
    ruolo int(8) zerofill,
    CONSTRAINT fk_utentiruolo FOREIGN KEY(ruolo) REFERENCES ruoli(id_ruolo) on update cascade on delete cascade
);

CREATE TABLE eventi(
    id_evento int(8) zerofill auto_increment primary key,
    nome_evento varchar(50) not null,
    num_tecnici int not null,
    data date not null
);

CREATE TABLE eventiRuoli(
    id_evento int(8) zerofill,
    id_ruolo int(8) zerofill,
    CONSTRAINT fk_eventiruolieventi FOREIGN KEY(id_evento) REFERENCES eventi(id_evento) on update cascade on delete cascade,
    CONSTRAINT fk_eventiruoliruoli FOREIGN KEY(id_ruolo) REFERENCES ruoli(id_ruolo) on update cascade on delete cascade,
    PRIMARY KEY(id_evento, id_ruolo)
);