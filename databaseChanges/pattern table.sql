DROP TABLE IF EXISTS `pattern`;
CREATE TABLE `pattern` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM arcanedb.pattern;
INSERT INTO `pattern` VALUES (1,'Tripple Bottom'),(2,'Tripple Top');