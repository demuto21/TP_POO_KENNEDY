drop table Equipement;

CREATE TABLE Equipement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) UNIQUE NOT NULL,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    owners VARCHAR(255) NOT NULL,
    statut VARCHAR(50) NOT NULL
);

