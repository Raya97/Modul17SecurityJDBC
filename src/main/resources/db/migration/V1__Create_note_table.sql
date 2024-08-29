CREATE TABLE note (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content TEXT NOT NULL
);

INSERT INTO note (title, content) VALUES ('Sample Note', 'This is a sample note.');
INSERT INTO note (title, content) VALUES ('Another Note', 'This is another sample note.');

