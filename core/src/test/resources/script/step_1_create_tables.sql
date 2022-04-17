CREATE TABLE IF NOT EXISTS register_class.tenant (
    id bigint DEFAULT nextval('register_class.tenant_id_seq') PRIMARY KEY,
    name VARCHAR(100),
    identifier VARCHAR (100),
    type VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS register_class.institute (
    id bigint DEFAULT nextval('register_class.institute_id_seq') PRIMARY KEY,
    name VARCHAR(100),
    tenant_id bigint
);

ALTER TABLE register_class.institute ADD CONSTRAINT fk_institute__tenant__id
    FOREIGN KEY (id) REFERENCES register_class.tenant(id);

