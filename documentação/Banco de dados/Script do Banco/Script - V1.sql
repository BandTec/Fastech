CREATE TABLE Estabelecimento(
	idEstabelecimento INT PRIMARY KEY IDENTITY(1,1),
	cidadeEstabelecimento VARCHAR(45)
);

CREATE TABLE Usuario(
	idUsuario INT PRIMARY KEY IDENTITY(1,1),
	nomeUsuario VARCHAR(45),
	loginUsuario VARCHAR(45),
	senhaUsuario VARCHAR(45),
	fkestabelecimentoUsuario INT,
	fOREIGN KEY(fkestabelecimentoUsuario) REFERENCES Estabelecimento(idEstabelecimento)
);

CREATE TABLE Totem (
	idTotem INT PRIMARY KEY IDENTITY(1,1),
	cpuTotem TINYINT,
	memoriaTotem TINYINT,
	discoTotem TINYINT,
	fkestabelecimentoTotem INT,
	fOREIGN KEY(fkestabelecimentoTotem) REFERENCES Estabelecimento(idEstabelecimento)

);

CREATE TABLE Teste(
	idTeste INT PRIMARY KEY IDENTITY(1,1),
	dataHora DATETIME,
	cpuTeste TINYINT,
	memoriaTeste TINYINT,
	discoTeste TINYINT,
	pintgTeste TINYINT,
	fkestabelecimentoTeste INT,
	fOREIGN KEY(fkestabelecimentoTeste) REFERENCES Estabelecimento(idEstabelecimento)
);
CREATE TABLE Dados (
	idDados INT PRIMARY KEY IDENTITY(1,1),
	dataHora DATETIME,
	cpuDados TINYINT,
	memoriaDados TINYINT,
	discoDados TINYINT,
	fkestabelecimentoDados INT,
	fOREIGN KEY(fkestabelecimentoDados) REFERENCES Estabelecimento(idEstabelecimento)
);
