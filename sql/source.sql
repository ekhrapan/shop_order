CREATE TABLE addresses(
	id INT AUTO_INCREMENT NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house_number VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE persons (
    id INT AUTO_INCREMENT,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    age INT,
    email VARCHAR(255) UNIQUE NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT PK_Persons PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES addresses(id),
    CHECK ( age >= 0 )
);