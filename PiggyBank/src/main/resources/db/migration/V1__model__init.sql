CREATE TABLE account
(
    number       BIGINT  NOT NULL,
    owner_id     BIGINT  NOT NULL,
    balance      DECIMAL NOT NULL,
    account_type INT     NOT NULL,
    card_number  BIGINT  NULL,
    CONSTRAINT pk_account PRIMARY KEY (number)
);

CREATE TABLE card
(
    number         BIGINT NOT NULL,
    account_number BIGINT NOT NULL,
    CONSTRAINT pk_card PRIMARY KEY (number)
);

CREATE TABLE card_pyment
(
    id          char(36)     NOT NULL,
    card_number BIGINT       NOT NULL,
    amount      DECIMAL      NOT NULL,
    merchant    VARCHAR(255) NULL,
    date        date         NOT NULL,
    time        time         NOT NULL,
    CONSTRAINT pk_card_pyment PRIMARY KEY (id)
);

CREATE TABLE stock
(
    id        char(36) NOT NULL,
    owner_id  BIGINT   NOT NULL,
    amount    DECIMAL  NOT NULL,
    stocks_id BIGINT   NOT NULL,
    CONSTRAINT pk_stock PRIMARY KEY (id)
);

CREATE TABLE stocks_list
(
    id    BIGINT NOT NULL,
    value DOUBLE NOT NULL,
    CONSTRAINT pk_stocks_list PRIMARY KEY (id)
);

CREATE TABLE transaction
(
    id             char(36) NOT NULL,
    sender_id      BIGINT   NOT NULL,
    recipient_id   BIGINT   NOT NULL,
    amount         DECIMAL  NOT NULL,
    execution_date date     NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

CREATE TABLE user
(
    id        BIGINT       NOT NULL,
    name      VARCHAR(255) NOT NULL,
    surname   VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NULL,
    email     VARCHAR(255) NOT NULL,
    birt_date date         NOT NULL,
    phone_num VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT uc_account_card_number UNIQUE (card_number);

ALTER TABLE account
    ADD CONSTRAINT uc_account_number UNIQUE (number);

ALTER TABLE card
    ADD CONSTRAINT uc_card_number UNIQUE (number);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD CONSTRAINT uc_user_phone_num UNIQUE (phone_num);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_CARD_NUMBER FOREIGN KEY (card_number) REFERENCES card (number);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_OWNER FOREIGN KEY (owner_id) REFERENCES user (id);

ALTER TABLE card
    ADD CONSTRAINT FK_CARD_ON_ACCOUNT_NUMBER FOREIGN KEY (account_number) REFERENCES account (number);

ALTER TABLE card_pyment
    ADD CONSTRAINT FK_CARD_PYMENT_ON_CARD_NUMBER FOREIGN KEY (card_number) REFERENCES card (number);

ALTER TABLE stock
    ADD CONSTRAINT FK_STOCK_ON_OWNER FOREIGN KEY (owner_id) REFERENCES account (number);

ALTER TABLE stock
    ADD CONSTRAINT FK_STOCK_ON_STOCKS FOREIGN KEY (stocks_id) REFERENCES stocks_list (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_RECIPIENT FOREIGN KEY (recipient_id) REFERENCES account (number);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_SENDER FOREIGN KEY (sender_id) REFERENCES account (number);