DELETE FROM Users_Roles;
DELETE FROM Users;
DELETE FROM Roles;
DELETE FROM Reviews;
DELETE FROM Papers;

INSERT INTO Users(email,name,password,username) VALUES
("1313mithun@gmail.com ","Mithun","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","mithun"),
("krishnendhu123@gmail.com","Krishnendhu","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","krishnendhu"),
("anudeep352@gmail.com","Anudeep","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","anudeep"),
("speaker1@gmail.com","Samuel Reynolds","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","speaker1"),
("speaker2@gmail.com","Olivia Davis","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","speaker2"),
("reviewer1@gmail.com","Alexander Hayes","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer1"),
("reviewer2@gmail.com","Lisa Robinson","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer2"),
("reviewer3@gmail.com","John Smith","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer3"),
("reviewer4@gmail.com","Daniel Martinez","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW","reviewer4"),
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
((SELECT id FROM Users WHERE name="Samuel Reynolds"),(SELECT id from Roles where name="ROLE_SPEAKER")),
((SELECT id FROM Users WHERE name="Olivia Davis"),(SELECT id from Roles where name="ROLE_SPEAKER")),
((SELECT id FROM Users WHERE name="Alexander Hayes"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="Lisa Robinson"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="John Smith"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="Daniel Martinez"),(SELECT id from Roles where name="ROLE_REVIEWER")),
((SELECT id FROM Users WHERE name="reviewer5"),(SELECT id from Roles where name="ROLE_REVIEWER"));


INSERT INTO Papers(title,description,status,author_ID) VALUES
("Intelligent Integration: Exploring AI-Driven Optimization in IoT Ecosystems","This paper provides a comprehensive review of the synergy between Artificial Intelligence (AI) and the Internet of Things (IoT), focusing on how AI techniques can optimize IoT systems. It examines the integration of AI algorithms to enhance efficiency, reliability, and adaptability within IoT ecosystems, offering insights into current advancements and future prospects.",
"UNASSIGNED",(SELECT id FROM Users WHERE name="Samuel Reynolds")),
("Securing the Internet of Things: Blockchain-Based Solutions for Trust and Integrity","This paper explores the potential of blockchain technology in securing the Internet of Things (IoT) ecosystem by providing tamper-proof, transparent, and decentralized solutions. It examines how blockchain can address trust and integrity issues in IoT data exchange and device authentication, offering insights into the benefits and challenges of integrating these two innovative technologies.",
"UNDER_REVIEW",(SELECT id FROM Users WHERE name="Samuel Reynolds")),
("Blockchain-Powered Cybersecurity: Enhancing Resilience in the Digital Age","This paper delves into the intersection of blockchain technology and cybersecurity, showcasing how blockchain can revolutionize traditional cybersecurity approaches. It explores the utilization of blockchain for secure authentication, immutable record-keeping, and decentralized threat detection, offering insights into how these advancements can bolster resilience against evolving cyber threats in the modern digital landscape.",
"COMPLETED_REVIEW",(SELECT id FROM Users WHERE name="Samuel Reynolds")),
("Quantum Computing's Impact on Cybersecurity: Challenges and Opportunities","This paper examines the implications of quantum computing on cybersecurity, exploring both the potential threats posed by quantum algorithms to current encryption methods and the opportunities for developing quantum-resistant cryptographic techniques. It discusses the urgent need for research and development in quantum-safe cybersecurity solutions to ensure the resilience of digital infrastructure in the face of advancing quantum technologies.",
"ACCEPTED",(SELECT id FROM Users WHERE name="Olivia Davis")),
("Integrating Artificial Intelligence with Quantum Computing: A Formal Examination of Computational Advancements","This paper provides a formal analysis of the integration between Artificial Intelligence (AI) and Quantum Computing, exploring the potential synergies to push the boundaries of computational power. It examines theoretical frameworks, practical applications, and challenges in harnessing AI algorithms within quantum computing architectures, aiming to elucidate the transformative impact on problem-solving and decision-making paradigms.",
"REJECTED",(SELECT id FROM Users WHERE name="Olivia Davis"));


INSERT INTO Reviews(author_id,paper_id,assignee_id,review_description,status) VALUES
-- ((SELECT id from Users WHERE name="Samuel Reynolds"),(SELECT paper_id FROM Papers WHERE title="Intelligent Integration: Exploring AI-Driven Optimization in IoT Ecosystems"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
-- ((SELECT id from Users WHERE name="Samuel Reynolds"),(SELECT paper_id FROM Papers WHERE title="Intelligent Integration: Exploring AI-Driven Optimization in IoT Ecosystems"),(SELECT id FROM Users WHERE name="Krishnendhu"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="Alexander Hayes"),(SELECT paper_id FROM Papers WHERE title="Securing the Internet of Things: Blockchain-Based Solutions for Trust and Integrity"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="Lisa Robinson"),(SELECT paper_id FROM Papers WHERE title="Securing the Internet of Things: Blockchain-Based Solutions for Trust and Integrity"),(SELECT id FROM Users WHERE name="Anudeep"),"Nice","ACCEPTED"),
((SELECT id from Users WHERE name="John Smith"),(SELECT paper_id FROM Papers WHERE title="Blockchain-Powered Cybersecurity: Enhancing Resilience in the Digital Age"),(SELECT id FROM Users WHERE name="Anudeep"),"Epic","ACCEPTED"),
((SELECT id from Users WHERE name="Daniel Martinez"),(SELECT paper_id FROM Papers WHERE title="Blockchain-Powered Cybersecurity: Enhancing Resilience in the Digital Age"),(SELECT id FROM Users WHERE name="Mithun"),"Lol","ACCEPTED"),
((SELECT id from Users WHERE name="Daniel Martinez"),(SELECT paper_id FROM Papers WHERE title="Quantum Computing's Impact on Cybersecurity: Challenges and Opportunities"),(SELECT id FROM Users WHERE name="Mithun"),"Amazing","ACCEPTED"),
((SELECT id from Users WHERE name="Lisa Robinson"),(SELECT paper_id FROM Papers WHERE title="Quantum Computing's Impact on Cybersecurity: Challenges and Opportunities"),(SELECT id FROM Users WHERE name="Krishnendhu"),"Nicee","ACCEPTED"),
((SELECT id from Users WHERE name="John Smith"),(SELECT paper_id FROM Papers WHERE title="Integrating Artificial Intelligence with Quantum Computing: A Formal Examination of Computational Advancements"),(SELECT id FROM Users WHERE name="Krishnendhu"),"Badd","ACCEPTED");

INSERT INTO Tracks(title) VALUES
("Artificial Intelligence"),
("IoT"),
("Blockchain Technology"),
("Cybersecurity"),
("Quantum Computing");

INSERT INTO User_Tracks VALUES
((SELECT id FROM Users WHERE name="Samuel Reynolds"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT id FROM Users WHERE name="Samuel Reynolds"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT id FROM Users WHERE name="Samuel Reynolds"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT id FROM Users WHERE name="Olivia Davis"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT id FROM Users WHERE name="Olivia Davis"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT id FROM Users WHERE name="Alexander Hayes"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT id FROM Users WHERE name="Alexander Hayes"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT id FROM Users WHERE name="Lisa Robinson"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT id FROM Users WHERE name="Lisa Robinson"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT id FROM Users WHERE name="John Smith"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT id FROM Users WHERE name="John Smith"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT id FROM Users WHERE name="Daniel Martinez"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT id FROM Users WHERE name="Daniel Martinez"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT id FROM Users WHERE name="reviewer5"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT id FROM Users WHERE name="reviewer5"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology"));





INSERT INTO Paper_Tracks VALUES
((SELECT paper_id FROM Papers WHERE title="Intelligent Integration: Exploring AI-Driven Optimization in IoT Ecosystems"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence")),
((SELECT paper_id FROM Papers WHERE title="Intelligent Integration: Exploring AI-Driven Optimization in IoT Ecosystems"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT paper_id FROM Papers WHERE title="Securing the Internet of Things: Blockchain-Based Solutions for Trust and Integrity"),(SELECT track_Id FROM Tracks WHERE title="IoT")),
((SELECT paper_id FROM Papers WHERE title="Securing the Internet of Things: Blockchain-Based Solutions for Trust and Integrity"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT paper_id FROM Papers WHERE title="Blockchain-Powered Cybersecurity: Enhancing Resilience in the Digital Age"),(SELECT track_Id FROM Tracks WHERE title="Blockchain Technology")),
((SELECT paper_id FROM Papers WHERE title="Blockchain-Powered Cybersecurity: Enhancing Resilience in the Digital Age"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT paper_id FROM Papers WHERE title="Quantum Computing's Impact on Cybersecurity: Challenges and Opportunities"),(SELECT track_Id FROM Tracks WHERE title="Cybersecurity")),
((SELECT paper_id FROM Papers WHERE title="Quantum Computing's Impact on Cybersecurity: Challenges and Opportunities"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT paper_id FROM Papers WHERE title="Integrating Artificial Intelligence with Quantum Computing: A Formal Examination of Computational Advancements"),(SELECT track_Id FROM Tracks WHERE title="Quantum Computing")),
((SELECT paper_id FROM Papers WHERE title="Integrating Artificial Intelligence with Quantum Computing: A Formal Examination of Computational Advancements"),(SELECT track_Id FROM Tracks WHERE title="Artificial Intelligence"));
