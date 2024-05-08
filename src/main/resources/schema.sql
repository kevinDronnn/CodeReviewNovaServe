CREATE TABLE IF NOT EXISTS review_cars (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           brand VARCHAR(255) NOT NULL,
                                           model VARCHAR(255) NOT NULL,
                                           weight DOUBLE NOT NULL,
                                           height DOUBLE NOT NULL,
                                           width DOUBLE NOT NULL,
                                           color VARCHAR(255) NOT NULL,
                                           engine_capacity DOUBLE NOT NULL
);
