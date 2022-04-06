set -e
psql -U admin admin << EOSQL
CREATE TABLE Tenant(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE Departments(
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    tenant_id INTEGER NOT NULL,
    FOREIGN KEY(tenant_id) REFERENCES Tenant(id) on delete set null
);
CREATE TABLE Users(
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    first_name_kana VARCHAR(100) NOT NULL,
    last_name_kana VARCHAR(100) NOT NULL,
    tenant_id INTEGER NOT NULL,
    dno1 INTEGER,
    dno2 INTEGER,
    dno3 INTEGER,
    FOREIGN KEY(tenant_id) REFERENCES Tenant(id) on delete set null,
    FOREIGN KEY(dno1) REFERENCES Departments(id) on delete set null,
    FOREIGN KEY(dno2) REFERENCES Departments(id) on delete set null,
    FOREIGN KEY(dno3) REFERENCES Departments(id) on delete set null
);
CREATE TABLE Oidcps(
    id SERIAL PRIMARY KEY,
    tenant_id INTEGER NOT NULL,
    client_id TEXT NOT NULL,
    client_secret TEXT NOT NULL,
    client_name TEXT NOT NULL,
    provider TEXT NOT NULL,
    scope TEXT NOT NULL,
    redirect_uri_template TEXT NOT NULL,
    client_authentication_method TEXT NOT NULL,
    authorization_grant_type TEXT NOT NULL,
    authorization_domain TEXT NOT NULL,
    user_name_attribute TEXT NOT NULL,
    FOREIGN KEY(tenant_id) REFERENCES Tenant(id) on delete set null
);
EOSQL