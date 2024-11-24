-- Criação da tabela Aplicativo
CREATE TABLE IF NOT EXISTS Aplicativo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    custo_mensal DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);