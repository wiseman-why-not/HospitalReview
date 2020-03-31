-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hospitaldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hospitaldb` ;

-- -----------------------------------------------------
-- Schema hospitaldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospitaldb` DEFAULT CHARACTER SET utf8 ;
USE `hospitaldb` ;

-- -----------------------------------------------------
-- Table `hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital` ;

CREATE TABLE IF NOT EXISTS `hospital` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `street` VARCHAR(200) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(2) NOT NULL,
  `zip_code` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `gender` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `post` ;

CREATE TABLE IF NOT EXISTS `post` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `review` BLOB NOT NULL,
  `create date` DATETIME NOT NULL,
  `hospital_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_post_hospital_idx` (`hospital_id` ASC),
  INDEX `fk_post_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_post_hospital`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `procedure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `procedure` ;

CREATE TABLE IF NOT EXISTS `procedure` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `procedure_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `cost` INT(11) NOT NULL,
  `post_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_procedure_post1_idx` (`post_id` ASC),
  CONSTRAINT `fk_procedure_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS user;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `hospital`
-- -----------------------------------------------------
START TRANSACTION;
USE `hospitaldb`;
INSERT INTO `hospital` (`id`, `name`, `street`, `city`, `state`, `zip_code`) VALUES (1, 'Denver Health', '777 Bannock St', 'Denver', 'CO', 80204);
INSERT INTO `hospital` (`id`, `name`, `street`, `city`, `state`, `zip_code`) VALUES (2, 'Saint Joseph Hospital', '1375 E 19th Ave', 'Denver', 'CO', 80218);
INSERT INTO `hospital` (`id`, `name`, `street`, `city`, `state`, `zip_code`) VALUES (3, 'Kindred Hospital Denver', '1920 N High St', 'Denver', 'CO', 80218);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `hospitaldb`;
INSERT INTO `user` (`id`, `username`, `password`, `age`, `gender`) VALUES (1, 'ricksanchez', 'rick', 65, 'male');
INSERT INTO `user` (`id`, `username`, `password`, `age`, `gender`) VALUES (2, 'bethsmith', 'beth', 35, 'female');
INSERT INTO `user` (`id`, `username`, `password`, `age`, `gender`) VALUES (3, 'jerrysmith', 'jerry', 35, 'male');
INSERT INTO `user` (`id`, `username`, `password`, `age`, `gender`) VALUES (4, 'summersmith', 'summer', 17, 'female');
INSERT INTO `user` (`id`, `username`, `password`, `age`, `gender`) VALUES (5, 'mortysmith', 'morty', 14, 'male');

COMMIT;

