CREATE DATABASE Fastech;
use fastech;
CREATE TABLE CompanyBranch (
  idCompanyBranch INT PRIMARY KEY AUTO_INCREMENT,
  city VARCHAR(45),
  zipCode CHAR(9),
  street VARCHAR(45),
  companyBranch VARCHAR(5)
);
CREATE TABLE User (
  idUser INT PRIMARY KEY AUTO_INCREMENT,
  nameUser VARCHAR(45),
  loginUser VARCHAR(45),
  passwordUser VARCHAR(45),
  fkcompanyBranchUser INT,
  FOREIGN KEY (fkcompanyBranchUser) REFERENCES CompanyBranch (idCompanyBranch)
);
CREATE TABLE Machine (
  idMachine INT PRIMARY KEY AUTO_INCREMENT,
  processadorMachine INT,
  Memory INT,
  discoMachine INT,
  fkcompanyBranchMachine INT,
  FOREIGN KEY (fkcompanyBranchMachine) REFERENCES CompanyBranch (idCompanyBranch)
);
CREATE TABLE Components (
  idcomponents INT PRIMARY KEY AUTO_INCREMENT,
  Description VARCHAR(45)
);
CREATE TABLE Datas (
  idData INT,
  Value INT,
  dtMoment DATETIME,
  Machine_idMachine INT,
  components_idcomponents INT,
  PRIMARY KEY (
    idData,
    Machine_idMachine,
    components_idcomponents
  ),
  FOREIGN KEY (Machine_idMachine) REFERENCES Machine (idMachine),
  FOREIGN KEY (components_idcomponents) REFERENCES Components (idcomponents));

CREATE TABLE Test (
  idTest INT PRIMARY KEY AUTO_INCREMENT,
  dtMoment DATETIME,
  CpuTest INT,
  MemoryTest INT,
  discTest INT,
  pingTest INT,
  fkcompanyBranchTest INT, 
  FOREIGN KEY (fkcompanyBranchTest) REFERENCES Machine (idMachine)
  );
CREATE TABLE MachineComponents (
  idMachineComponents INT,
  components_idcomponents INT,
  Machine_idMachine INT,
  Machine_idCompanyBranch INT,
  PRIMARY KEY (
    idMachineComponents,
    components_idcomponents,
    Machine_idMachine
  ),
  FOREIGN KEY (components_idcomponents) REFERENCES Components (idcomponents),
  FOREIGN KEY (Machine_idMachine) REFERENCES Machine (idMachine),
  FOREIGN key (Machine_idCompanyBranch)REFERENCES CompanyBranch (idCompanyBranch));