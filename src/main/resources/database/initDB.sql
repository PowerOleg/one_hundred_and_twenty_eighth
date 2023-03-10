CREATE TABLE IF NOT EXISTS customers (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(30) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    address     VARCHAR(150) NOT NULL,
    budget      DECIMAL     NOT NULL
);