CREATE SCHEMA INDUSTRIA;

USE INDUSTRIA;

-- CÓDIGO
SELECT * FROM DDD;
CREATE TABLE DDD
(
	codDDD INT AUTO_INCREMENT PRIMARY KEY,
    numDDD CHAR(3) NOT NULL,
    regiaoDDD VARCHAR(45) NOT NULL
);
SELECT * FROM FORNECEDOR;
CREATE TABLE FORNECEDOR
(
	numFornecedor INT AUTO_INCREMENT PRIMARY KEY,
	nomeFornecedor VARCHAR(100) NOT NULL
);
SELECT * FROM DEPARTAMENTO;
CREATE TABLE DEPARTAMENTO
(
	numDepart INT AUTO_INCREMENT PRIMARY KEY,
    setorDepart VARCHAR(45) NOT NULL

);
SELECT * FROM FUNCIONARIO;
CREATE TABLE FUNCIONARIO
(
	numFunc INT AUTO_INCREMENT PRIMARY KEY,
    nomeFunc VARCHAR(100) NOT NULL,
    salariFunc DECIMAL(7,2) NOT NULL,
	numDepart INT NOT NULL,
    dataInicioFunc DATE NOT NULL,
	CONSTRAINT FUNCIONARIO_DEPARTAMENTO
		FOREIGN KEY (numDepart)
		REFERENCES DEPARTAMENTO (numDepart)
);
SELECT * FROM TELEFONE;
CREATE TABLE TELEFONE
(
	codTelefone INT AUTO_INCREMENT PRIMARY KEY,
    numTelefone VARCHAR(20),
	codDDD INT NOT NULL,
    numFornecedor INT,
    numFunc INT,
    CONSTRAINT FORNECEDOR_TELEFONE
		FOREIGN KEY (numFornecedor)
		REFERENCES FORNECEDOR (numFornecedor),
    CONSTRAINT DDDTELEFONE
		FOREIGN KEY (codDDD) 
        REFERENCES DDD(codDDD),
	CONSTRAINT FUNCIONARIO_TELEFONE
		FOREIGN KEY (numFunc)
		REFERENCES FUNCIONARIO (numFunc)
);
SELECT * FROM PROJETO;
CREATE TABLE PROJETO
(
	numProjeto INT AUTO_INCREMENT PRIMARY KEY,
    orcaProjeto DECIMAL(8,2)
);
SELECT * FROM FUNCIONARIO_PROJETO;
CREATE TABLE FUNCIONARIO_PROJETO
(
	codFunc INT AUTO_INCREMENT PRIMARY KEY,
    numFunc INT NOT NULL,
    numProjeto INT NOT NULL,
    dataInicioProjeto DATE,
    horasTrabalhadas FLOAT,
	CONSTRAINT FUNCIONARIO
		FOREIGN KEY (numFunc)
		REFERENCES FUNCIONARIO (numFunc),
    CONSTRAINT PROJETO
		FOREIGN KEY (numProjeto)
		REFERENCES PROJETO (numProjeto)
);
SELECT * FROM DEPOSITO;
CREATE TABLE DEPOSITO
(
	numDeposito INT AUTO_INCREMENT PRIMARY KEY,
    nomeDeposito VARCHAR(100) NOT NULL
);
SELECT * FROM ENDERECO;
CREATE TABLE ENDERECO(
	codEndereco INT AUTO_INCREMENT PRIMARY KEY,
    lograEndereco VARCHAR(45) NOT NULL,
    numEndereco INT NOT NULL,
    cidadeEndereco VARCHAR(45) NOT NULL,
    estadoEndereco VARCHAR(45) NOT NULL,
	numFornecedor INT,
    numDeposito INT,
    CONSTRAINT ENDERECO_FORNECEDOR
		FOREIGN KEY (numFornecedor)
		REFERENCES FORNECEDOR (numFornecedor),
    CONSTRAINT ENDERECO_DEPOSITO
		FOREIGN KEY (numDeposito)
		REFERENCES DEPOSITO (numDeposito)
);
SELECT * FROM PECA;
CREATE TABLE PECA
(
	numPeca INT AUTO_INCREMENT PRIMARY KEY,
    pesoPeca FLOAT NOT NULL,
    corPeca VARCHAR(45) NOT NULL,
    numDeposito INT NOT NULL,
    CONSTRAINT PECA_DEPOSITO
		FOREIGN KEY (numDeposito)
		REFERENCES DEPOSITO (numDeposito),
    CONSTRAINT CHECK_PESO
		CHECK (pesoPeca>0)
);
SELECT * FROM PECA_FORNECEDOR;
CREATE TABLE PECA_FORNECEDOR
(
	codPecaFor INT AUTO_INCREMENT PRIMARY KEY,
    numFornecedor INT NOT NULL,
    numPeca INT NOT NULL,
    CONSTRAINT PECA
		FOREIGN KEY (numPeca)
		REFERENCES PECA (numPeca),
    CONSTRAINT FORNECEDOR
		FOREIGN KEY (numFornecedor)
		REFERENCES FORNECEDOR (numFornecedor)
);
SELECT * FROM FORNECEDOR_PROJETO;
CREATE TABLE FORNECEDOR_PROJETO
(
	codForProj INT AUTO_INCREMENT PRIMARY KEY,
    numFornecedor INT NOT NULL,
    numProjeto INT NOT NULL,
    nomeMaterial VARCHAR(100) NOT NULL,
    qtdMaterial INT NOT NULL,
    CONSTRAINT PROJETO_FORN
		FOREIGN KEY (numProjeto)
		REFERENCES PROJETO (numProjeto),
    CONSTRAINT FORNECEDOR_PROJ
		FOREIGN KEY (numFornecedor)
		REFERENCES FORNECEDOR (numFornecedor)
);

-- SELECTS

/*SELECT * FROM DDD;
SELECT numDDD, regiaoDDD FROM DDD;
SELECT numDDD, regiaoDDD FROM DDD WHERE regiaoDDD = 'São Paulo';
SELECT * FROM DEPARTAMENTO;
SELECT setorDepart FROM DEPARTAMENTO;
SELECT setorDepart FROM DEPARTAMENTO WHERE setorDepart = 'Vendas';
SELECT * FROM DEPOSITO;
SELECT nomeDeposito FROM DEPOSITO;
SELECT * FROM ENDERECO;
SELECT lograEndereco, cidadeEndereco FROM ENDERECO;
SELECT lograEndereco, numEndereco FROM ENDERECO WHERE cidadeEndereco = 'São Paulo';
SELECT * FROM FORNECEDOR;
SELECT nomeFornecedor FROM FORNECEDOR;
SELECT * FROM FORNECEDOR_PROJETO;
SELECT * FROM FUNCIONARIO;
SELECT nomeFunc, salariFunc FROM FUNCIONARIO;
SELECT nomeFunc, dataInicioFunc FROM FUNCIONARIO WHERE dataInicioFunc > '2023-01-01';
SELECT * FROM FUNCIONARIO_PROJETO;
SELECT numFunc, numProjeto FROM FUNCIONARIO_PROJETO;
SELECT numProjeto, horasTrabalhadas FROM FUNCIONARIO_PROJETO WHERE numFunc = 2;
SELECT * FROM PECA;
SELECT pesoPeca, corPeca FROM PECA;
SELECT numPeca, pesoPeca FROM PECA WHERE corPeca = 'Azul';
SELECT * FROM PECA_FORNECEDOR;
SELECT * FROM PROJETO;
SELECT orcaProjeto FROM PROJETO;
SELECT orcaProjeto FROM PROJETO WHERE orcaProjeto > 10000;
SELECT * FROM TELEFONE;
SELECT numTelefone, codDDD FROM TELEFONE;
SELECT numTelefone FROM TELEFONE WHERE numFunc = 1;*/

-- DELETES

/*DROP TABLE DDD;
DROP TABLE DEPARTAMENTO;
DROP TABLE DEPOSITO;
DROP TABLE ENDERECO;
DROP TABLE FORNECEDOR;
DROP TABLE FORNECEDOR_PROJETO;
DROP TABLE FUNCIONARIO;
DROP TABLE FUNCIONARIO_PROJETO;
DROP TABLE PECA;
DROP TABLE PECA_FORNECEDOR;
DROP TABLE PROJETO;
DROP TABLE TELEFONE;*/

-- INSERTS

INSERT INTO DDD (numDDD, regiaoDDD) VALUES
(11, 'São Paulo'),
(21, 'Rio de Janeiro'),
(31, 'Belo Horizonte'),
(41, 'Curitiba'),
(51, 'Porto Alegre'),
(61, 'Brasília'),
(71, 'Salvador'),
(81, 'Recife'),
(91, 'Belém'),
(12, 'Santos'),
(22, 'Niterói'),
(32, 'Juiz de Fora'),
(42, 'Londrina'),
(52, 'Caxias do Sul'),
(62, 'Goiânia'),
(72, 'Vitória da Conquista'),
(82, 'Maceió'),
(92, 'Manaus');

INSERT INTO FORNECEDOR (nomeFornecedor) VALUES 
('Fornecedor A'),
('Fornecedor B'),
('Fornecedor C'),
('Fornecedor D'),
('Fornecedor E'),
('Fornecedor F'),
('Fornecedor G'),
('Fornecedor H'),
('Fornecedor I'),
('Fornecedor J');

INSERT INTO DEPARTAMENTO (setorDepart) VALUES 
('Recursos Humanos'),
('Desenvolvimento'),
('Marketing'),
('Logística'),
('Financeiro'),
('Qualidade'),
('TI'),
('Vendas'),
('Produção'),
('Administrativo');

INSERT INTO FUNCIONARIO (nomeFunc, salariFunc, numDepart, dataInicioFunc) VALUES 
('João Silva', 5000.00, 1, '2023-01-15'), -- Recursos Humanos
('Maria Santos', 6000.00, 2, '2022-07-20'), -- Desenvolvimento
('Carlos Oliveira', 5500.00, 3, '2022-11-10'), -- Marketing
('Ana Costa', 5200.00, 4, '2023-03-05'), -- Logística
('Pedro Almeida', 5800.00, 5, '2022-09-28'), -- Financeiro
('Laura Pereira', 5300.00, 6, '2023-02-10'), -- Qualidade
('Rafael Martins', 6200.00, 7, '2022-06-15'), -- TI
('Julia Ferreira', 5700.00, 8, '2023-04-03'), -- Vendas
('Marcelo Santos', 5400.00, 9, '2022-12-20'), -- Produção
('Tiago Assis', 5100.00, 10, '2024-06-20'); -- Administrativo

INSERT INTO TELEFONE (numTelefone, codDDD, numFornecedor, numFunc) VALUES 
('123456789', 1, 1,NULL), 
('987654321', 2, 2,NULL), 
('456789123', 3, NULL,3),
('654123789', 3, NULL,4), 
('321789456', 4, NULL,5), 
('789456123', 5, 5,NULL),  
('654321987', 1, 7,NULL), 
('321987654', 6, NULL,7), 
('987456321', 9, 7,NULL), 
('986799863', 6, NULL, 10); 

INSERT INTO PROJETO (orcaProjeto) VALUES 
(5000.00), -- Projeto 1
(10000.00), -- Projeto 2
(7500.00), -- Projeto 3
(12000.00), -- Projeto 4
(9000.00), -- Projeto 5
(15000.00), -- Projeto 6
(8000.00),  -- Projeto 7
(6000.00),  -- Projeto 8
(11000.00), -- Projeto 9
(9500.00);  -- Projeto 10

INSERT INTO FUNCIONARIO_PROJETO (numFunc, numProjeto, dataInicioProjeto, horasTrabalhadas) 
VALUES (1, 1, '2024-01-10', 40),
		(2, 2, '2024-02-15', 35),
        (3, 3, '2024-03-20', 45),
        (4, 4, '2024-04-25', 50),
        (5, 5, '2024-05-30', 48),
        (6, 6, '2024-06-03', 38),
		(7, 7, '2024-07-14', 39),
        (8, 8, '2024-08-20', 43),
        (9, 9, '2024-09-28', 51),
        (10, 10, '2024-10-01', 47);

INSERT INTO DEPOSITO (nomeDeposito) VALUES 
('Depósito Central'),
('Depósito Norte'),
('Depósito Sul'),
('Depósito Leste'),
('Depósito Oeste'),
('Depósito Sudeste'),
('Depósito Sudoeste'),
('Depósito Nordeste'),
('Depósito Noroeste');

INSERT INTO ENDERECO (lograEndereco, numEndereco, cidadeEndereco, estadoEndereco, numFornecedor, numDeposito)
VALUES 
    ('Rua A', 123, 'São Paulo', 'SP', 1, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 1)
    ('Av. B', 456, 'Rio de Janeiro', 'RJ', 2, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 2)
    ('Rua C', 789, 'Belo Horizonte', 'MG', NULL, 1),  -- Endereço relacionado com depósito (numDeposito = 1)
    ('Rua D', 1011, 'Curitiba', 'PR', NULL, 2),  -- Endereço relacionado com depósito (numDeposito = 2)
    ('Av. E', 1213, 'Porto Alegre', 'RS', 3, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 3)
    ('Rua F', 1415, 'Salvador', 'BA', 4, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 4)
    ('Av. G', 1617, 'Fortaleza', 'CE', 5, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 5)
    ('Rua H', 1819, 'Brasília', 'DF', 6, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 6)
    ('Av. I', 2021, 'Manaus', 'AM', 7, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 7)
    ('Rua J', 2223, 'Recife', 'PE', 8, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 8)
    ('Av. K', 2425, 'Goiânia', 'GO', 9, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 9)
    ('Rua L', 2627, 'Belém', 'PA', 10, NULL),  -- Endereço relacionado com fornecedor (numFornecedor = 10)
    ('Av. M', 2829, 'Florianópolis', 'SC', NULL, 3),  -- Endereço relacionado com depósito (numDeposito = 3)
    ('Rua N', 3031, 'Campo Grande', 'MS', NULL, 4),  -- Endereço relacionado com depósito (numDeposito = 4)
    ('Av. O', 3233, 'São Luís', 'MA', NULL, 5),  -- Endereço relacionado com depósito (numDeposito = 5)
    ('Rua P', 3435, 'Maceió', 'AL', NULL, 6),  -- Endereço relacionado com depósito (numDeposito = 6)
    ('Av. Q', 3637, 'Natal', 'RN', NULL, 7),  -- Endereço relacionado com depósito (numDeposito = 7)
    ('Rua R', 3839, 'Teresina', 'PI', NULL, 8),  -- Endereço relacionado com depósito (numDeposito = 8)
    ('Av. S', 4041, 'João Pessoa', 'PB', NULL, 9);  -- Endereço relacionado com depósito (numDeposito = 9)

INSERT INTO PECA (pesoPeca, corPeca, numDeposito)
VALUES
    (12.5, 'Vermelha', 1), -- NumDeposito 1 corresponde ao Depósito A
    (8.0, 'Verde', 2),     -- NumDeposito 2 corresponde ao Depósito B
    (15.3, 'Azul', 3),     -- NumDeposito 3 corresponde ao Depósito C
    (9.2, 'Amarela', 4),   -- NumDeposito 4 corresponde ao Depósito D
    (11.0, 'Roxa', 5);     -- NumDeposito 5 corresponde ao Depósito E

INSERT INTO PECA_FORNECEDOR (numFornecedor, numPeca)
VALUES
    (1, 1),  -- NumFornecedor 1 corresponde ao Fornecedor A e NumPeca 1 corresponde à primeira peça
    (2, 2),  -- NumFornecedor 2 corresponde ao Fornecedor B e NumPeca 2 corresponde à segunda peça
    (3, 3),  -- NumFornecedor 3 corresponde ao Fornecedor C e NumPeca 3 corresponde à terceira peça
    (4, 4),  -- NumFornecedor 4 corresponde ao Fornecedor D e NumPeca 4 corresponde à quarta peça
    (5, 5),  -- NumFornecedor 5 corresponde ao Fornecedor E e NumPeca 5 corresponde à quinta peça
    (6, 1),  -- NumFornecedor 6 corresponde ao Fornecedor F e NumPeca 1 corresponde à primeira peça
    (7, 2),  -- NumFornecedor 7 corresponde ao Fornecedor G e NumPeca 2 corresponde à segunda peça
    (8, 3),  -- NumFornecedor 8 corresponde ao Fornecedor H e NumPeca 3 corresponde à terceira peça
    (9, 4),  -- NumFornecedor 9 corresponde ao Fornecedor I e NumPeca 4 corresponde à quarta peça
    (10, 5);  -- NumFornecedor 10 corresponde ao Fornecedor J e NumPeca 5 corresponde à quinta peça

INSERT INTO FORNECEDOR_PROJETO (numFornecedor, numProjeto, nomeMaterial, qtdMaterial)
VALUES
    (1, 1, 'Material A', 100),   -- NumFornecedor 1 corresponde ao Fornecedor A e NumProjeto 1 corresponde ao primeiro projeto
    (2, 2, 'Material B', 200),   -- NumFornecedor 2 corresponde ao Fornecedor B e NumProjeto 2 corresponde ao segundo projeto
    (3, 3, 'Material C', 150),   -- NumFornecedor 3 corresponde ao Fornecedor C e NumProjeto 3 corresponde ao terceiro projeto
    (4, 1, 'Material D', 300),   -- NumFornecedor 4 corresponde ao Fornecedor D e NumProjeto 1 corresponde ao primeiro projeto
    (5, 2, 'Material E', 250),   -- NumFornecedor 5 corresponde ao Fornecedor E e NumProjeto 2 corresponde ao segundo projeto
    (6, 3, 'Material F', 200),   -- NumFornecedor 6 corresponde ao Fornecedor F e NumProjeto 3 corresponde ao terceiro projeto
    (7, 1, 'Material G', 150),   -- NumFornecedor 7 corresponde ao Fornecedor G e NumProjeto 1 corresponde ao primeiro projeto
    (8, 2, 'Material H', 100),   -- NumFornecedor 8 corresponde ao Fornecedor H e NumProjeto 2 corresponde ao segundo projeto
    (1, 3, 'Material I', 50),    -- NumFornecedor 1 corresponde ao Fornecedor A e NumProjeto 3 corresponde ao terceiro projeto
    (3, 1, 'Material J', 75);   -- NumFornecedor 3 corresponde ao Fornecedor C e NumProjeto 1 corresponde ao primeiro projeto