-- Inserção de dados na tabela de Aplicativos
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Musica', 17.98);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Compras', 5.99);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Delivery', 7.50);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Viagens', 10.99);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Relacionamento', 29.95);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Aplicativo de Filmes', 15.99);

-- Script para inserir um cliente na tabela Cliente
INSERT INTO Cliente (nome, email) VALUES ('Joao Silva', 'joao.silva@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Amelia Pinto', 'amelia.pinto@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Janaina Jana', 'janaina.jana@hotmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Breno Rei', 'reibreno@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Alexandre Costa', 'costaalexandre@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Hebe Amaral', 'hebeamaral@hotmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Arthur Ricardo', 'arthuuur.ric@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Ema Gonzales', 'gonzalesema@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Haroldo Estilos', 'haroldo.estilos@gmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Bruna Tramontina', 'tramontina.bruna@hotmail.com');
INSERT INTO Cliente (nome, email) VALUES ('Eliana Pase', 'elianaapase.pase@gmail.com');

INSERT INTO Assinatura (aplicativo_codigo, cliente_codigo, inicio_vigencia, fim_vigencia, status)
VALUES 
((SELECT codigo FROM Aplicativo WHERE nome = 'Aplicativo de Musica'),
 (SELECT codigo FROM Cliente WHERE nome = 'Joao Silva'),
 '2024-11-24', '2024-12-01', TRUE),

((SELECT codigo FROM Aplicativo WHERE nome = 'Aplicativo de Compras'),
 (SELECT codigo FROM Cliente WHERE nome = 'Amelia Pinto'),
 '2024-11-24', '2024-12-01', TRUE),

((SELECT codigo FROM Aplicativo WHERE nome = 'Aplicativo de Delivery'),
 (SELECT codigo FROM Cliente WHERE nome = 'Janaina Jana'),
 '2024-11-24', '2024-12-01', TRUE),

((SELECT codigo FROM Aplicativo WHERE nome = 'Aplicativo de Viagens'),
 (SELECT codigo FROM Cliente WHERE nome = 'Breno Rei'),
 '2024-11-24', '2024-12-01', FALSE),

((SELECT codigo FROM Aplicativo WHERE nome = 'Aplicativo de Relacionamento'),
 (SELECT codigo FROM Cliente WHERE nome = 'Alexandre Costa'),
 '2024-11-24', '2024-12-01', TRUE);


 -- Promoção 
INSERT INTO Promocao (nome, dias_extras, desconto)
VALUES ('ANUAL', 335, 0.4);

INSERT INTO Promocao (nome, dias_extras, desconto)
VALUES ('EXTRA15', 15, 0.0);

INSERT INTO Promocao (nome, dias_extras, desconto)
VALUES ('PROMO10', 0, 0.1);

INSERT INTO Promocao (nome, dias_extras, desconto)
VALUES ('PROMO30', 0, 0.3);