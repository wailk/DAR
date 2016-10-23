select * from appartements;

select * from users;

select * from photos;

-- reset all users , Appartements, Photos for tests 
-- users 
INSERT INTO users(name, firstname, email, telephone, mdp)  
VALUES ('zak', 'zak', 'zak@gamil.com', '0612345612', '123456789' );
INSERT INTO users(name, firstname, email, telephone, mdp) 
VALUES ('wail', 'walid', 'w.wali@gamil.com', '0612345612', 'mdp' );
INSERT INTO users(name, firstname, email, telephone, mdp)   
VALUES ('ashraf', 'nasser', 'serranshraf@gamil.com', '0612345612', 'mdp' );
INSERT INTO users(name, firstname, email, telephone, mdp)   
VALUES ('moatez', 'moatez', 'moatez@gamil.com', '0612345612', '1234' );
INSERT INTO users(name, firstname, email, telephone, mdp)   
VALUES ('root', 'root', 'root@gamil.com', '0612345612', 'root' );

-- Appartements

INSERT INTO `bd_immo`.`appartements`
(`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)
VALUES('3 bd voltaire 75010 paris',1000,true,'200','F4',1);
INSERT INTO `bd_immo`.`appartements`
(`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)
VALUES('3 bd voltaire 75010 paris',1000,true,'200','F4',2);
INSERT INTO `bd_immo`.`appartements`
(`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)
VALUES('3 bd voltaire 75010 paris',1000,true,'200','F4',2);
INSERT INTO `bd_immo`.`appartements`
(`adresse`,`loyer`,`meuble`,`superficie`,`type`,`id_user`)
VALUES('3 bd voltaire 75010 paris',1000,true,'200','F4',1);


-- Photos
INSERT INTO Photos(id_appartement, chemin)
VALUES(1, "test/chemin/photo1");
INSERT INTO Photos(id_appartement, chemin)
VALUES(1, "test/chemin/photo2");