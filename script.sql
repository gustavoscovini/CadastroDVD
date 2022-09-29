CREATE TABLE IF NOT EXISTS ator(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL,
	sobrenome VARCHAR(30) NOT NULL,
	dataEstreia DATE NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS genero(
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS classificacao(
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(150) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS dvd (
	id INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(45) NOT NULL,
	dataLancamento DATE NOT NULL,
	anoLancamento VARCHAR(4) NOT NULL,
	duracao VARCHAR(3) NOT NULL,
	atorp_id INT NOT NULL,
	atorc_id INT NOT NULL,
	genero_id INT not null,
	classificacao_id INT not null,
	PRIMARY KEY (id),
	CONSTRAINT fk_dvd_atorp
	FOREIGN KEY (atorp_id)
	REFERENCES ator (id),
	CONSTRAINT fk_dvd_atorc
	FOREIGN KEY (atorc_id)
	REFERENCES ator (id),
	CONSTRAINT fk_dvd_genero
	FOREIGN KEY (genero_id)
	REFERENCES genero (id),
	CONSTRAINT fk_dvd_classificacao
	FOREIGN KEY (classificacao_id)
	REFERENCES classificacao (id)
	ON DELETE RESTRICT
	ON UPDATE CASCADE
) ENGINE = InnoDB;