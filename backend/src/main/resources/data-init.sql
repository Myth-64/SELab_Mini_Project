DELETE FROM Users_Roles;
DELETE FROM Users;
DELETE FROM Roles;
DELETE FROM Reviews;
DELETE FROM Papers;

INSERT INTO Users(email,name,password,username) VALUES
("1313mithun@gmail.com ","Mithun","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","mithun"),
("krishnendhu123@gmail.com","Krishnendhu","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","krishnendhu"),
("anudeep352@gmail.com","Anudeep","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","anudeep"),
("speaker1@gmail.com","speaker1","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","speaker1"),
("speaker2@gmail.com","speaker2","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","speaker2"),
("reviewer1@gmail.com","reviewer1","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer1"),
("reviewer2@gmail.com","reviewer2","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer2"),
("reviewer3@gmail.com","reviewer3","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer3"),
("reviewer4@gmail.com","reviewer4","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer4"),
("reviewer5@gmail.com","reviewer5","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer5");


INSERT INTO Roles(name) VALUES
("ROLE_ADMIN"),
("ROLE_USER"),
("ROLE_SPEAKER"),
("ROLE_REVIEWER");

INSERT INTO Users_Roles VALUES
((SELECT id FROM Users WHERE name="Mithun"),(SELECT id from Roles where name="ROLE_USER")),
((SELECT id FROM Users WHERE name="Krishnendhu"),(SELECT id from Roles where name="ROLE_USER")),
((SELECT id FROM Users WHERE name="Anudeep"),(SELECT id from Roles where name="ROLE_USER")),
((SELECT id FROM Users WHERE name="speaker1"),(SELECT id from Roles where name="ROLE_SPEAKER")),
((SELECT id FROM Users WHERE name="speaker2"),(SELECT id from Roles where name="ROLE_SPEAKER")),
((SELECT id FROM Users WHERE name="reviewer1"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="reviewer2"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="reviewer3"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="reviewer4"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="reviewer5"),(SELECT id from Roles where name="ROLE_REVIEWER"));


INSERT INTO Papers(title,description,status,author_ID) VALUES
("Paper1","Paper1","UNASSIGNED",(SELECT id FROM Users WHERE name="speaker1")),
("Paper2","Paper2","UNDER_REVIEW",(SELECT id FROM Users WHERE name="speaker1")),
("Paper3","Paper3","COMPLETED_REVIEW",(SELECT id FROM Users WHERE name="speaker1")),
("Paper4","Paper4","ACCEPTED",(SELECT id FROM Users WHERE name="speaker2")),
("Paper5","Paper5","REJECTED",(SELECT id FROM Users WHERE name="speaker2"));


INSERT INTO Reviews(author_id,paper_id,assignee_id,review_description,status) VALUES
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper1"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper1"),(SELECT id FROM Users WHERE name="Krishnendhu"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper2"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper2"),(SELECT id FROM Users WHERE name="Anudeep"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper3"),(SELECT id FROM Users WHERE name="Anudeep"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper3"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper4"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="speaker1"),(SELECT paper_id FROM Papers WHERE title="Paper5"),(SELECT id FROM Users WHERE name="Krishnendhu"),"Lol","ACCEPTED");

INSERT INTO Tracks(title) VALUES
("Artificial Intelligence"),
("IoT"),
("Blockchain Technology"),
("Cybersecurity"),
("Quantum Computing");

INSERT INTO User_Tracks VALUES
((SELECT id FROM Users WHERE name="speaker1"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT id FROM Users WHERE name="speaker1"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT id FROM Users WHERE name="speaker1"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT id FROM Users WHERE name="speaker2"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT id FROM Users WHERE name="speaker2"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing"));

INSERT INTO Paper_Tracks VALUES
((SELECT paper_id FROM Papers WHERE title="Paper1"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT paper_id FROM Papers WHERE title="Paper1"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT paper_id FROM Papers WHERE title="Paper2"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT paper_id FROM Papers WHERE title="Paper2"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT paper_id FROM Papers WHERE title="Paper3"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT paper_id FROM Papers WHERE title="Paper3"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT paper_id FROM Papers WHERE title="Paper4"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT paper_id FROM Papers WHERE title="Paper4"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT paper_id FROM Papers WHERE title="Paper5"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT paper_id FROM Papers WHERE title="Paper5"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence"));
