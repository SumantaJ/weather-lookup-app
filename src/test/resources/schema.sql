DROP TABLE IF EXISTS weatherinfo;

CREATE TABLE weatherinfo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  TEMP DOUBLE NOT NULL,
  PRESSURE INT NOT NULL,
  UMBRELLA BOOLEAN NOT NULL,
  CITY VARCHAR(100) NOT NULL
);
