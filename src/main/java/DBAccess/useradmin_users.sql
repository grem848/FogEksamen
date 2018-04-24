
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'jens@somewhere.com','jensen','customer'),(2,'ken@somewhere.com','kensen','customer'),(3,'robin@somewhere.com','batman','employee'),(4,'kaj@nowhere.com','123','customer'),(5,'andy@nowhere.com','123','employee'),(10,'admin','admin','customer'),(11,'hej@nowhere.com','123','customer');

UNLOCK TABLES;

