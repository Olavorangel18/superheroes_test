CREATE TABLE tb_superheroes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    real_name VARCHAR(255),
    superpower VARCHAR(255),
    description VARCHAR(255)
);