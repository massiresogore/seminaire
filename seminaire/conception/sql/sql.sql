DROP TABLE IF EXISTS evenement ;
CREATE TABLE evenement (id_evenement BIGINT AUTO_INCREMENT NOT NULL,
                        lieu_evenement VARCHAR(200),
                        addresse_evenement VARCHAR(200),
                        description_evenement VARCHAR(200),
                        id_intervenant BIGINT NOT NULL ,
                        PRIMARY KEY (id_evenement)) ENGINE=InnoDB;

DROP TABLE IF EXISTS annonce ;
CREATE TABLE annonce (id_annonce BIGINT AUTO_INCREMENT NOT NULL,
                      date_annonce DATE,
                      titre_annonce VARCHAR(200),
                      resume_annonce VARCHAR(200),
                      lieu_annonce VARCHAR(200),
                      date_update_annonce DATE,
                      id_evenement BIGINT not null ,
                      PRIMARY KEY (id_annonce)) ENGINE=InnoDB;

DROP TABLE IF EXISTS utilisateur ;
CREATE TABLE utilisateur (id BIGINT AUTO_INCREMENT NOT NULL,
                          nom VARCHAR(200),
                          prenom VARCHAR(200),
                          affectation VARCHAR(200),
                          url VARCHAR(200),
                          PRIMARY KEY (id)) ENGINE=InnoDB;

DROP TABLE IF EXISTS notification ;
CREATE TABLE notification (id_notification BIGINT AUTO_INCREMENT NOT NULL,
                           text_notification VARCHAR(200),
                           date_envoie_notification DATE,
                           date_reception_notification DATE,
                           id_intervenant BIGINT NOT NULL ,
                           PRIMARY KEY (id_notification)) ENGINE=InnoDB;

DROP TABLE IF EXISTS notification_info ;
CREATE TABLE notification_info (id_appartenir BIGINT AUTO_INCREMENT NOT NULL,
                                id_participant BIGINT NOT NULL ,
                                id_notification BIGINT NOT NULL ,
                                PRIMARY KEY (id_appartenir)) ENGINE=InnoDB;

DROP TABLE IF EXISTS Commentaire ;
CREATE TABLE Commentaire (id_Commentaire BIGINT AUTO_INCREMENT NOT NULL,
                          contenu_Commentaire TEXT,
                          id_evenement BIGINT NOT NULL,
                          id_participant BIGINT NOT NULL,
                          PRIMARY KEY (id_Commentaire)) ENGINE=InnoDB;

DROP TABLE IF EXISTS calendrier ;
CREATE TABLE calendrier (id BIGINT AUTO_INCREMENT NOT NULL,
                         date DATETIME,
                         nom_semaine VARCHAR(200),
                         jour_semaine INT(200),
                         jour_ouvrable BOOLEAN,
                         jour_ferier BOOLEAN,
                         id_evenement BIGINT NOT NULL ,
                         PRIMARY KEY (id)) ENGINE=InnoDB;

ALTER TABLE evenement ADD CONSTRAINT FK_evenement_id_intervenant FOREIGN KEY (id_intervenant) REFERENCES utilisateur (id);

ALTER TABLE annonce ADD CONSTRAINT FK_annonce_id_evenement FOREIGN KEY (id_evenement) REFERENCES evenement (id_evenement);
ALTER TABLE notification ADD CONSTRAINT FK_notification_id_intervenant FOREIGN KEY (id_intervenant) REFERENCES utilisateur (id);
ALTER TABLE notification_info ADD CONSTRAINT FK_notification_info_id_intervenant FOREIGN KEY (id_participant) REFERENCES utilisateur (id);
ALTER TABLE notification_info ADD CONSTRAINT FK_notification_info_id_notification FOREIGN KEY (id_notification) REFERENCES notification (id_notification);
ALTER TABLE Commentaire ADD CONSTRAINT FK_Commentaire_id_evenement FOREIGN KEY (id_evenement) REFERENCES evenement (id_evenement);
ALTER TABLE Commentaire ADD CONSTRAINT FK_Commentaire_id_intervenant FOREIGN KEY (id_participant) REFERENCES utilisateur (id);
ALTER TABLE calendrier ADD CONSTRAINT FK_calendrier_id_evenement FOREIGN KEY (id_evenement) REFERENCES evenement (id_evenement);
