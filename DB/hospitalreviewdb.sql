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
-- Table `medicalprocedure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medicalprocedure` ;

CREATE TABLE IF NOT EXISTS `medicalprocedure` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `procedure_name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `cost` INT(11) NOT NULL,
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
  `create_date` DATETIME NOT NULL,
  `hospital_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `medicalprocedure_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_post_hospital_idx` (`hospital_id` ASC),
  INDEX `fk_post_user1_idx` (`user_id` ASC),
  INDEX `fk_post_procedure1_idx` (`medicalprocedure_id` ASC),
  CONSTRAINT `fk_post_hospital`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_procedure1`
    FOREIGN KEY (`medicalprocedure_id`)
    REFERENCES `medicalprocedure` (`id`)
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


-- -----------------------------------------------------
-- Data for table `medicalprocedure`
-- -----------------------------------------------------
START TRANSACTION;
USE `hospitaldb`;
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (1, 'Cesarean Section', 'Caesarean section, also known as C-section, or caesarean delivery, is the use of surgery to deliver babies. A caesarean section is often necessary when a vaginal delivery would put the baby or mother at risk.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (2, 'Circumcision', 'Circumcision is a common procedure in which the skin covering the tip of the penis is surgically removed. It\'s usually performed on a newborn boy before he leaves the hospital, and often within the first 2 days of life.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (4, 'Arthroplasty of knee (Knee Replacement)', 'Knee replacement, also known as knee arthroplasty, is a surgical procedure to replace the weight-bearing surfaces of the knee joint to relieve pain and disability. It is most commonly performed for osteoarthritis, and also for other knee diseases such as rheumatoid arthritis and psoriatic arthritis.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (5, 'Percutaneous coronary angioplasty (PTCA) ', 'Percutaneous coronary intervention is a non-surgical procedure used to treat narrowing of the coronary arteries of the heart found in coronary artery disease.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (6, 'Laminectomy', 'Laminectomy is a type of surgery in which a surgeon removes part or all of the vertebral bone (lamina). This helps ease pressure on the spinal cord or the nerve roots that may be caused by injury, herniated disk, narrowing of the canal (spinal stenosis), or tumors.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (7, 'Spinal fusion', 'Spinal fusion, also called spondylodesis or spondylosyndesis, is a neurosurgical or orthopedic surgical technique that joins two or more vertebrae. This procedure can be performed at any level in the spine and prevents any movement between the fused vertebrae', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (8, 'Hip replacement', 'Hip replacement is a surgical procedure in which the hip joint is replaced by a prosthetic implant, that is, a hip prosthesis. Hip replacement surgery can be performed as a total replacement or a hemi replacement.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (9, 'cholecystectomy and common duct exploration', 'Cholecystectomy is surgery to remove the gallbladder. The gallbladder is a small sac that is under the liver and is part of the digestive system. The liver makes bile to help digest the fats you eat.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (10, 'Hysterectomy, abdominal and vaginal', 'Hysterectomy is the surgical removal of the uterus. It may also involve removal of the cervix, ovaries, fallopian tubes, and other surrounding structures. Usually performed by a gynecologist, a hysterectomy may be total or partial.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (11, 'Colorectal resection', 'A bowel resection or enterectomy is a surgical procedure in which a part of an intestine is removed, from either the small intestine or large intestine. Often the word enterectomy is reserved for the sense of small bowel resection, in distinction from colectomy, which covers the sense of large bowel resection.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (12, 'Blood transfusions', 'Blood transfusion is the process of transferring blood or blood products into one\'s circulation intravenously. Transfusions are used for various medical conditions to replace lost components of the blood.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (13, 'Respiratory intubation and mechanical ventilation', 'Intubation is placing a tube in your throat to help move air in and out of your lungs. Mechanical ventilation is the use of a machine to move air in and out of your lungs.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (3, 'Repair of current obstetric lacerations', 'Vaginal tears during childbirth, also called perineal lacerations or tears, occur when the baby\'s head is coming through the vaginal opening and is either too large for the vagina to stretch around or the head is a normal size but the vagina doesn\'t stretch easily. These kinds of tears are relatively common.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (14, 'Upper gastrointestinal endoscopy', 'A tiny camera on the end of the endoscope lets your doctor examine your esophagus, stomach and the beginning of your small intestine (duodenum). An upper endoscopy is a procedure used to visually examine your upper digestive system with a tiny camera on the end of a long, flexible tube.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (15, 'echocardiogram', 'An echocardiography, echocardiogram, cardiac echo or simply an echo, is an ultrasound of the heart. Echocardiography uses standard two-dimensional, three-dimensional, and Doppler ultrasound to create images of the heart. ', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (16, 'Amniotomy (Artificial rupture of membranes to assist delivery)', 'Amniotomy, also known as artificial rupture of membranes (AROM) and by the lay description \"breaking the water,\" is the intentional rupture of the amniotic sac by an obstetrical provider. This procedure is common during labor management and has been performed by obstetrical providers for at least a few hundred years.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (17, 'Hemodialysis', 'Hemodialysis, also spelled haemodialysis, or simply dialysis, is a process of purifying the blood of a person whose kidneys are not working normally.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (18, 'Colonoscopy and biopsy', 'Colonoscopy or coloscopy is the endoscopic examination of the large bowel and the distal part of the small bowel with a CCD camera or a fiber optic camera on a flexible tube passed through the anus.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (19, 'thoracentesis', 'Thoracentesis is a procedure in which a needle is inserted into the pleural space between the lungs and the chest wall. This procedure is done to remove excess fluid, known as a pleural effusion, from the pleural space to help you breathe easier.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (20, 'laparotomy (Ruptured Spleen)', ' Many people with a ruptured spleen experience serious bleeding that requires immediate surgery on the abdomen. The surgeon will cut open the abdomen and operate with a procedure called a laparotomy.', 0);
INSERT INTO `medicalprocedure` (`id`, `procedure_name`, `description`, `cost`) VALUES (21, 'Open Reduction Internal Fixation (Broken bones)', 'Internal fixation is an operation in orthopedics that involves the surgical implementation of implants for the purpose of repairing a bone, a concept that dates to the mid-nineteenth century and was made applicable for routine treatment in the mid-twentieth century.', 0);

COMMIT;

