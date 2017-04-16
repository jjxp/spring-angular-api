#import.sql

start transaction;

INSERT INTO hibernate_sequences (sequence_name, sequence_next_hi_value) VALUES ('DomainEntity', '1');

INSERT INTO authority (id, version, authority) VALUES ('1', '0', 'ADMIN');
INSERT INTO authority (id, version, authority) VALUES ('2', '0', 'USER');

INSERT INTO useraccount (id, version, username, password) VALUES ('3', '0', 'admin', '89dbb9136a77cb71b219a5a2e2031bb362b4db6071fb3156a0fc1680d6b68968e26f180f3bbfab5e');
INSERT INTO useraccount (id, version, username, password) VALUES ('4', '0', 'user', '8fde763698e52e18f6bd6c08e61d954ca7141c85fdae95c12dc479a3621922c0024e929dc6e7c3ed');

INSERT INTO user_authority (user_account, authority) VALUES ('3', '1');
INSERT INTO user_authority (user_account, authority) VALUES ('4', '2');

INSERT INTO user (id, version, firstName, lastName, age, gender) VALUES ('5', '0', 'Peter', 'Griffin', '42', 'M');
INSERT INTO user (id, version, firstName, lastName, age, gender) VALUES ('6', '0', 'Lois', 'Griffin', '40', 'F');
INSERT INTO user (id, version, firstName, lastName, age, gender) VALUES ('7', '0', 'Stewie', 'Griffin', '1', 'M');

INSERT INTO car (id, version, brand, model, numberPlate, userId) VALUES ('8', '0', 'Mercedes-Benz', '300d w124', 'M 3023 HZ', '5');
INSERT INTO car (id, version, brand, model, numberPlate, userId) VALUES ('9', '0', 'BMW', '320i E30', 'SE 1840 BP', '6');

commit;