CREATE TABLE `student`
(
    `SNO`   VARCHAR(45) NOT NULL,
    `SNAME` VARCHAR(45) NOT NULL,
    `SSEX`  VARCHAR(45) NOT NULL
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO `student` VALUES ('1', 'wkk', '男');
INSERT INTO `student` VALUES ('1', 'hxx', '女');
