SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `transaction_detail`;
CREATE TABLE `transaction_detail`
(
  `tx_detail_id` BIGINT NOT NULL AUTO_INCREMENT,
  `address`      VARCHAR(100),
  `amount`       DOUBLE,
  `type`         TINYINT,
  `txhash`       CHAR(64),
  PRIMARY KEY (`tx_detail_id`),
  INDEX `idx_address` (`address`),
  INDEX `idx_txhash` (`txhash`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;