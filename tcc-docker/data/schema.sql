DROP TABLE IF EXISTS curtida CASCADE;
DROP TABLE IF EXISTS comentario CASCADE;
DROP TABLE IF EXISTS amizade CASCADE;
DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS postagem CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome_completo VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	senha VARCHAR(128) NOT NULL,
	ativo BOOLEAN NOT NULL,
	apelido VARCHAR(50),
	imagem_perfil VARCHAR(512)
);
ALTER TABLE usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_apelido UNIQUE (apelido);

CREATE TABLE permissao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	funcao VARCHAR(100) NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE permissao ADD CONSTRAINT pk_permissao PRIMARY KEY (id);
ALTER TABLE permissao ADD CONSTRAINT uk_permissao UNIQUE (funcao, usuario_id);
ALTER TABLE permissao ADD CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;

CREATE TABLE amizade (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	amigo_id BIGINT NOT NULL,
	situacao VARCHAR(30) NOT NULL
);
ALTER TABLE amizade ADD CONSTRAINT pk_amizade PRIMARY KEY (id);
ALTER TABLE amizade ADD CONSTRAINT uk_amizade UNIQUE (usuario_id, amigo_id);
ALTER TABLE amizade ADD CONSTRAINT ck_amizade_situacao CHECK (situacao IN ('SOLICITADA', 'ACEITA'));
ALTER TABLE amizade ADD CONSTRAINT fk_amizade_usuario_1 FOREIGN KEY (usuario_id) REFERENCES usuario ON DELETE CASCADE;
ALTER TABLE amizade ADD CONSTRAINT fk_amizade_usuario_2 FOREIGN KEY (amigo_id) REFERENCES usuario ON DELETE CASCADE;

CREATE TABLE postagem (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	conteudo TEXT NOT NULL,
	visibilidade VARCHAR(30) NOT NULL,
	usuario_id BIGINT NOT NULL,
	data_postagem TIMESTAMP NOT NULL
);
ALTER TABLE postagem ADD CONSTRAINT pk_postagem PRIMARY KEY (id);
ALTER TABLE postagem ADD CONSTRAINT ck_postagem_visibilidade CHECK (visibilidade IN ('AMIGOS', 'PUBLICO'));
ALTER TABLE postagem ADD CONSTRAINT fk_postagem_usuario FOREIGN KEY (usuario_id) REFERENCES usuario ON DELETE CASCADE;

CREATE TABLE curtida(
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	postagem_id BIGINT NOT NULL
);
ALTER TABLE curtida ADD CONSTRAINT pk_curtida PRIMARY KEY (id);
ALTER TABLE curtida ADD CONSTRAINT uk_curtida UNIQUE (usuario_id, postagem_id);
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_usuario FOREIGN KEY (usuario_id) REFERENCES usuario ON DELETE CASCADE;
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_postagem FOREIGN KEY (postagem_id) REFERENCES postagem ON DELETE CASCADE;

CREATE TABLE comentario(
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	conteudo TEXT NOT NULL,
	usuario_id BIGINT NOT NULL,
	postagem_id BIGINT NOT NULL
);
ALTER TABLE comentario ADD CONSTRAINT pk_postagem_comentario PRIMARY KEY (id);
ALTER TABLE comentario ADD CONSTRAINT fk_postagem_comentario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario ON DELETE CASCADE;
ALTER TABLE comentario ADD CONSTRAINT fk_postagem_comentario_postagem FOREIGN KEY (postagem_id) REFERENCES postagem ON DELETE CASCADE;
