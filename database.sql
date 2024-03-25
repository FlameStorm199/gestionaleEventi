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

/*DEBUG: Popolazione DB */
INSERT INTO ruoli (descrizione_ruolo) VALUES ('Amministratore');
INSERT INTO ruoli (descrizione_ruolo) VALUES ('Utente Standard');

INSERT INTO utenti (username, password, nome, cognome, ruolo) VALUES ('admin', 'adminpassword', 'Admin', 'Admin', 1);
INSERT INTO utenti (username, password, nome, cognome, ruolo) VALUES ('user1', 'user1password', 'User', 'One', 2);
INSERT INTO utenti (username, password, nome, cognome, ruolo) VALUES ('user2', 'user2password', 'User', 'Two', 2);

INSERT INTO eventi (nome_evento, num_tecnici, data) VALUES ('Conferenza', 10, '2024-03-21');
INSERT INTO eventi (nome_evento, num_tecnici, data) VALUES ('Fiera', 15, '2024-04-15');
INSERT INTO eventi (nome_evento, num_tecnici, data) VALUES ('Riunione', 8, '2024-05-10');

INSERT INTO eventiRuoli (id_evento, id_ruolo) VALUES (1, 1);
INSERT INTO eventiRuoli (id_evento, id_ruolo) VALUES (2, 2);
INSERT INTO eventiRuoli (id_evento, id_ruolo) VALUES (3, 2);
