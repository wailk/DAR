

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
INSERT INTO Appartements(name, id_user,adresse, type, superficie, meuble, loyer)  
VALUES ('app1', 1, '3 bd voltaire 75010 paris', 'F4', '200 m2', true, 750,5 );
INSERT INTO Appartements(name, id_user,adresse, type, superficie, meuble, loyer)  
VALUES ('app2', 2, '3 bd voltaire 75010 paris', 'F4', '200 m2', true, 750,5 );
INSERT INTO Appartements(name, id_user,adresse, type, superficie, meuble, loyer)  
VALUES ('app3', 2, '3 bd voltaire 75010 paris', 'F4', '200 m2', true, 750,5 );
INSERT INTO Appartements(name, id_user,adresse, type, superficie, meuble, loyer)  
VALUES ('app4', 2, '3 bd voltaire 75010 paris', 'F4', '200 m2', true, 750,5 );

--Photos
INSERT INTO Photos(id_appartement, chemin)
VALUES(1, "test/chemin/photo1");
INSERT INTO Photos(id_appartement, chemin)
VALUES(1, "test/chemin/photo2");