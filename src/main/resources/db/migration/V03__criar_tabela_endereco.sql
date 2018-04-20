CREATE TABLE endereco (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	pessoa_id BIGINT(20), 
	logradouro VARCHAR(50) NOT NULL,
	numero VARCHAR(10),
	complemento VARCHAR(15),
	bairro VARCHAR(40) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	cidade VARCHAR(40) NOT NULL,
	estado VARCHAR(2) NOT NULL,
	flag_ende_princ VARCHAR(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE endereco ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (codigo);

DELETE FROM pessoa;

ALTER TABLE pessoa ADD cpf VARCHAR(14) NOT NULL;
ALTER TABLE pessoa ADD rg VARCHAR(15) NOT NULL;
ALTER TABLE pessoa ADD data_nasci DATE NOT NULL;


ALTER TABLE pessoa DROP COLUMN ativo;
ALTER TABLE pessoa DROP COLUMN logradouro;
ALTER TABLE pessoa DROP COLUMN numero;
ALTER TABLE pessoa DROP COLUMN complemento;
ALTER TABLE pessoa DROP COLUMN bairro;
ALTER TABLE pessoa DROP COLUMN cep;
ALTER TABLE pessoa DROP COLUMN cidade;
ALTER TABLE pessoa DROP COLUMN estado;


INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('João Silva', '025.099.546-89', '58.198.247-99', '1981/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Bruno Batista', '038.023.235-99', '59.198.247-89', '1988/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Jonatas Pereira', '025.079.546-89', '57.138.247-99', '1983/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Marcos Silva', '035.099.546-89', '55.198.247-91', '1984/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Maria Santos', '045.099.546-89', '54.198.247-92', '1985/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Tacy Bezerra', '055.099.546-89', '53.198.247-93', '1986/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Raimunda Silva', '065.099.546-89', '52.198.247-94', '1987/05/15');
INSERT INTO pessoa (nome, cpf, rg, data_nasci) values ('Ester Silva', '075.099.546-89', '51.198.247-95', '1980/05/15');

