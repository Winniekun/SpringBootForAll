CREATE TABLE `user`
(
    `id`       int(11)     NOT NULL AUTO_INCREMENT COMMENT '主键',
    `usercode` varchar(32) NOT NULL COMMENT '账号',
    `username` varchar(64) NOT NULL COMMENT '姓名',
    `password` varchar(32) NOT NULL COMMENT '密码',
    `salt`     varchar(64) DEFAULT NULL COMMENT '盐',
    `locked`   char(1)     DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO `user`
VALUES ('1', 'Promise', 'eran', '123456', null, '0');
