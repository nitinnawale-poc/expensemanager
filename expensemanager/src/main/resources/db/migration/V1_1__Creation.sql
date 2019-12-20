CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `category_list_of_expenses` (
  `category_categoryid` int(11) NOT NULL,
  `list_of_expenses_expenseid` int(11) NOT NULL,
  UNIQUE KEY `UK_dom0vtnw4goc96rikhfqyvfmk` (`list_of_expenses_expenseid`),
  KEY `FK4d3ucqmq4fb1sdplu8xnyosbn` (`category_categoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `expense` (
  `expenseid` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `date` datetime DEFAULT NULL,
  `expense_title` varchar(255) DEFAULT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`expenseid`),
  KEY `FK8qx7605jnyuedpdduhownyo5w` (`category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;