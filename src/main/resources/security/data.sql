INSERT INTO users SELECT * FROM CSVREAD('classpath:security/user-data.csv');
commit;
INSERT INTO authorities SELECT * FROM CSVREAD('classpath:security/user-authorities.csv');
commit;