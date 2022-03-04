CREATE TABLE PEDIDO(
ID BIGINT NOT NULL AUTO_INCREMENT,
FINALIZADO INT ,
PAGAMENTO_ID BIGINT NOT NULL,
RESTAURANTE_ID BIGINT NOT NULL,
USUARIO_ID BIGINT NOT NULL,
DATA_PEDIDO TIMESTAMP NOT NULL,
DATA_ATUALIZACAO TIMESTAMP NOT NULL,

PRIMARY KEY (ID)
)engine=InnoDB default charset=utf8;

ALTER TABLE PEDIDO ADD CONSTRAINT PAGAMENTO_ID_FK FOREIGN KEY (PAGAMENTO_ID) REFERENCES PAGAMENTO (ID);
ALTER TABLE PEDIDO ADD CONSTRAINT RESTAURANTE_ID_FK FOREIGN KEY (RESTAURANTE_ID) REFERENCES RESTAURANTE (ID);
ALTER TABLE PEDIDO ADD CONSTRAINT PEDIDO_USUARIO_ID_FK FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID);

CREATE TABLE STATUS(
ID BIGINT NOT NULL AUTO_INCREMENT,
DESCRICAO VARCHAR(50) NOT NULL,
OCORRENCIA TIMESTAMP NOT NULL,
PEDIDO_ID BIGINT ,

PRIMARY KEY (ID)
)engine=InnoDB default charset=utf8;

ALTER TABLE STATUS ADD CONSTRAINT PEDIDO_ID_FK FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO (ID);


CREATE TABLE ITEM_PEDIDO(
ID BIGINT NOT NULL AUTO_INCREMENT,
DESCRICAO VARCHAR(100) NOT NULL,
QUANTIDADE INT NOT NULL,
VALOR DECIMAL NOT NULL,
PEDIDO_ID BIGINT ,

PRIMARY KEY (ID)
)engine=InnoDB default charset=utf8;

ALTER TABLE ITEM_PEDIDO ADD CONSTRAINT ITEM_PEDIDO_ID_FK FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO (ID);