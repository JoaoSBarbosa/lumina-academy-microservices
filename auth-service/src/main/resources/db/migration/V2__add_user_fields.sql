
ALTER TABLE tb_usuario RENAME COLUMN nome TO nome_usuario;

ALTER TABLE tb_usuario
    ADD COLUMN primeiro_nome VARCHAR(200) NOT NULL;
ALTER TABLE tb_usuario
    ADD COLUMN sobrenome VARCHAR(200) NOT NULL;
ALTER TABLE tb_usuario
    ADD COLUMN data_nascimento DATE;
ALTER TABLE tb_usuario
    ADD COLUMN genero VARCHAR(50);
ALTER TABLE tb_usuario
    ADD COLUMN telefone VARCHAR(20);
ALTER TABLE tb_usuario
    ADD COLUMN cpf VARCHAR(11) UNIQUE;
ALTER TABLE tb_usuario
    ADD COLUMN url_foto_perfil VARCHAR(255);
ALTER TABLE tb_usuario
    ADD COLUMN status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE';


ALTER TABLE tb_usuario
    ADD COLUMN tipo_usuario VARCHAR(20) NOT NULL DEFAULT 'USER';