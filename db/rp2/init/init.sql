CREATE DATABASE rp2;
USE rp2;

CREATE TABLE Tenant(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Departments(
    id BIGINT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    tenant_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(tenant_id) REFERENCES Tenant(id) on delete set null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    first_name_kana VARCHAR(100) NOT NULL,
    last_name_kana VARCHAR(100) NOT NULL,
    tenant_id INTEGER NOT NULL,
    dno1 INTEGER,
    dno2 INTEGER,
    dno3 INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY(tenant_id) REFERENCES Tenant(id) on delete set null,
    FOREIGN KEY(dno1) REFERENCES Departments(id) on delete set null,
    FOREIGN KEY(dno2) REFERENCES Departments(id) on delete set null,
    FOREIGN KEY(dno) REFERENCES Departments(id) on delete set null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
