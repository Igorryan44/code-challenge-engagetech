CREATE TABLE expense
(
    id     BIGINT           NOT NULL,
    date   TIMESTAMP(6) WITHOUT TIME ZONE,
    reason VARCHAR(255),
    value  DOUBLE PRECISION NOT NULL,
    vat    DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_expense PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255),
    email VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);