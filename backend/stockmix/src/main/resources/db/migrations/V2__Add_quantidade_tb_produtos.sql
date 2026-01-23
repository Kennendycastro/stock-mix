-- V2: Migrations para adicionar a colona de quantidade aos produtos.

ALTER TABLE tb_produtos
ADD COLUMN quantidade INTEGER;