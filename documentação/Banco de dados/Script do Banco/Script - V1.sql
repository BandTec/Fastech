CREATE TABLE Establishment(
	idEstablishment INT PRIMARY KEY IDENTITY(1,1),
	city VARCHAR(45),
    zipCode CHAR (9),
    street VARCHAR (45),
    EstablishmentNumber varchar (5)
    
    
);

CREATE TABLE Usuario(
	idUser INT PRIMARY KEY IDENTITY(1,1),
	nameUser VARCHAR(45),
	loginUser VARCHAR(45),
	passwordUser VARCHAR(45),
	fkestablishmentUser INT,
	fOREIGN KEY(fkEstablishmentUser) REFERENCES Establishment(idEstablishment)
);

CREATE TABLE Machine (
	idMachine INT PRIMARY KEY IDENTITY(1,1),
	processadorMachine TINYINT,
	memoryMachine TINYINT,
	discoMachine TINYINT,
	fkEstablishmentMachine INT,
	fOREIGN KEY(fkEstablishmentMachine) REFERENCES Establishment(idEstablishment)

);

CREATE TABLE Test(
	idTest INT PRIMARY KEY IDENTITY(1,1),
	dtMoment DATETIME,
	cpuTest TINYINT,
	memoryTest TINYINT,
	discTest TINYINT,
	pingTest TINYINT,
	fkEstablishmentTest INT,
	fOREIGN KEY(fkTestMachine) REFERENCES Machine(idMachine)
);
CREATE TABLE Datas (
	idDatas INT PRIMARY KEY IDENTITY(1,1),
	dtMoment DATETIME,
	cpuData TINYINT,
	menoryData TINYINT,
	discData TINYINT,
	fkEstablishmentData INT,
	fOREIGN KEY(fkDatasMachine) REFERENCES Machine(idMachine)
);
