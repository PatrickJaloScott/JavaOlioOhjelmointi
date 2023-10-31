/*	Starting databases for simple maven project
People: (student, library user), Bank: (accounts, transactions)
Library:
	books:
		id, title, author, isbn, publication year, reservedmemberid
	reservations
School: enrollment (courses, students)
Shopping list?
Vehicles?
*/
USE simplifieddb;

/*CREATE TABLE libraryUsers(id INT NOT NULL AUTO_INCREMENT,personID INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(personID) REFERENCES persons(id));
/*CREATE TABLE students(id INT NOT NULL AUTO_INCREMENT,personID INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(personID) REFERENCES persons(id));
/*CREATE TABLE persons(id INT NOT NULL AUTO_INCREMENT,firstName VARCHAR(128) NOT NULL,lastName VARCHAR(128) NOT NULL,age INT,PRIMARY KEY(id));

finish following -> bank account
CREATE TABLE bank_account(id INT NOT NULL AUTO_INCREMENT,balance INT,personID INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(personID) REFERENCES persons(id));
CREATE TABLE bank_transactions(id INT NOT NULL AUTO_INCREMENT,senderID INT NOT NULL,recipientID INT NOT NULL,amount INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(senderID) REFERENCES bank_account(id),FOREIGN KEY(recipientID) REFERENCES bank_account(id));
*/
#continue to make book table
CREATE TABLE books();