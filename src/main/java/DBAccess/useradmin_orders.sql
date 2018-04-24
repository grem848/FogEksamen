DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `sent` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderid`),
  KEY `user_id_idx` (`orderid`),
  KEY `userid_idx` (`id`),
  CONSTRAINT `userid` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

LOCK TABLES `orders` WRITE;
INSERT INTO `orders` VALUES (6,4,13,9,4,1),(7,4,5,8,5,0),(8,4,5,4,1,0),(9,4,4,4,1,0);
UNLOCK TABLES;
