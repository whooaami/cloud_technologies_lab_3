SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


DROP TABLE IF EXISTS `candidate_cv`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `contact_person`;
DROP TABLE IF EXISTS `english_interview`;
DROP TABLE IF EXISTS `mark_of_interview`;
DROP TABLE IF EXISTS `potential_candidate`;
DROP TABLE IF EXISTS `technical_interview`;
DROP TABLE IF EXISTS `vacancy`;
DROP TABLE IF EXISTS `vacancy_has_contact_person`;
DROP TABLE IF EXISTS `vacancy_has_potential_candidate`;


CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;


-- -----------------------------------------------------
-- Table `mydb`.`vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job_desciption` VARCHAR(45) NOT NULL,
  `project_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_project_name_vacancy
ON vacancy (project_name);

CREATE INDEX idx_job_desciption_vacancy
ON vacancy (job_desciption);


-- -----------------------------------------------------
-- Table `mydb`.`candidate_cv`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`candidate_cv` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job` VARCHAR(45) NULL,
  `work_experience` VARCHAR(45) NULL,
  `place_of_study` VARCHAR(45) NULL,
  `hobby` VARCHAR(45) NULL,
  `skills` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_job_candidate_cv
ON candidate_cv (job);

CREATE INDEX idx_work_experience_candidate_cv
ON candidate_cv (work_experience);


-- -----------------------------------------------------
-- Table `mydb`.`english_interview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`english_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level_of_technical` VARCHAR(45) NULL,
  `level_of_speaking` VARCHAR(45) NULL,
  `general_level` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_gen_level_english
ON english_interview (general_level);

CREATE INDEX idx_level_of_speaking_english
ON english_interview (level_of_speaking);


-- -----------------------------------------------------
-- Table `mydb`.`technical_interview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`technical_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `programming_language` VARCHAR(45) NOT NULL,
  `algorithm` VARCHAR(45) NOT NULL,
  `data_structure` VARCHAR(45) NULL,
  `database` VARCHAR(45) NOT NULL,
  `result_interview` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_result_technical_interview
ON technical_interview (result_interview);

CREATE INDEX idx_language_technical_interview
ON technical_interview (programming_language);


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` VARCHAR(45) NULL,
  `response` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_rating_comment
ON comment (rating);

CREATE INDEX idx_response_comment
ON comment (response);


-- -----------------------------------------------------
-- Table `mydb`.`mark_of_interview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mark_of_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level` ENUM('excellent', 'good', 'satisfactory') NOT NULL,
  `comment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mark_of_interview_comment1_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_mark_of_interview_comment1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `mydb`.`comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE INDEX idx_level_mark_of_interview
ON mark_of_interview (level);

CREATE INDEX idx_comment_id_mark_of_interview
ON mark_of_interview (comment_id);


-- -----------------------------------------------------
-- Table `mydb`.`potential_candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`potential_candidate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `github` VARCHAR(45) NULL,
  `linkedin` VARCHAR(45) NULL,
  `candidate_cv_id` INT NOT NULL,
  `english_interview_id` INT NOT NULL,
  `technical_interview_id` INT NOT NULL,
  `mark_of_interview_id` INT NOT NULL,
  PRIMARY KEY (`id`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`),
  INDEX `fk_potential_candidate_candidate_cv1_idx` (`candidate_cv_id` ASC) VISIBLE,
  INDEX `fk_potential_candidate_english_interview1_idx` (`english_interview_id` ASC) VISIBLE,
  INDEX `fk_potential_candidate_technical_interview1_idx` (`technical_interview_id` ASC) VISIBLE,
  INDEX `fk_potential_candidate_mark_of_interview1_idx` (`mark_of_interview_id` ASC) VISIBLE,
  CONSTRAINT `fk_potential_candidate_candidate_cv1`
    FOREIGN KEY (`candidate_cv_id`)
    REFERENCES `mydb`.`candidate_cv` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_english_interview1`
    FOREIGN KEY (`english_interview_id`)
    REFERENCES `mydb`.`english_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_technical_interview1`
    FOREIGN KEY (`technical_interview_id`)
    REFERENCES `mydb`.`technical_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_mark_of_interview1`
    FOREIGN KEY (`mark_of_interview_id`)
    REFERENCES `mydb`.`mark_of_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE INDEX idx_git_potential_candidate
ON potential_candidate (github);

CREATE INDEX idx_linkedin_potential_candidate
ON potential_candidate (linkedin);


-- -----------------------------------------------------
-- Table `mydb`.`contact_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contact_person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE INDEX idx_name_contact_person
ON contact_person (name);

CREATE INDEX idx_surname_contact_person
ON contact_person (surname);


-- -----------------------------------------------------
-- Table `mydb`.`vacancy_has_contact_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy_has_contact_person` (
  `vacancy_id` INT NOT NULL,
  `contact_person_id` INT NOT NULL,
  PRIMARY KEY (`vacancy_id`, `contact_person_id`),
  INDEX `fk_vacancy_has_contact_person_contact_person1_idx` (`contact_person_id` ASC) VISIBLE,
  INDEX `fk_vacancy_has_contact_person_vacancy_idx` (`vacancy_id` ASC) VISIBLE,
  CONSTRAINT `fk_vacancy_has_contact_person_vacancy`
    FOREIGN KEY (`vacancy_id`)
    REFERENCES `mydb`.`vacancy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_contact_person_contact_person1`
    FOREIGN KEY (`contact_person_id`)
    REFERENCES `mydb`.`contact_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE INDEX idx_vacancy_id_contact_person
ON vacancy_has_contact_person (vacancy_id);

CREATE INDEX idx_id_contact_person
ON vacancy_has_contact_person (contact_person_id);


-- -----------------------------------------------------
-- Table `mydb`.`vacancy_has_potential_candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy_has_potential_candidate` (
  `vacancy_id` INT NOT NULL,
  `potential_candidate_id` INT NOT NULL,
  PRIMARY KEY (`vacancy_id`, `potential_candidate_id`),
  INDEX `fk_vacancy_has_potential_candidate_potential_candidate1_idx` (`potential_candidate_id` ASC) VISIBLE,
  INDEX `fk_vacancy_has_potential_candidate_vacancy1_idx` (`vacancy_id` ASC) VISIBLE,
  CONSTRAINT `fk_vacancy_has_potential_candidate_vacancy1`
    FOREIGN KEY (`vacancy_id`)
    REFERENCES `mydb`.`vacancy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_potential_candidate_potential_candidate1`
    FOREIGN KEY (`potential_candidate_id`)
    REFERENCES `mydb`.`potential_candidate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE INDEX idx_vacancy_id_potential_candidate
ON vacancy_has_potential_candidate (vacancy_id);

CREATE INDEX idx_candidate_id_potential_candidate
ON vacancy_has_potential_candidate (potential_candidate_id);


USE `mydb` ;


CREATE TABLE IF NOT EXISTS `mydb`.`view1` (`id` INT);


DROP TABLE IF EXISTS `mydb`.`view1`;
USE `mydb`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- INSERT `candidate_cv`
-- -----------------------------------------------------
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('1', 'Python', '2 years', '', 'football', 'Databases');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('2', 'Java', '', 'LPNU', 'voleyball', 'PyCharm');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('3', 'Swift', '1 year', 'LNU', 'boxing', 'Sociable');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('4', 'C++', '', 'LPNU', 'football', 'Sociable');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('5', 'C#', '', 'LPNU', 'mma', 'Smart');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('6', 'Python', '2 years', '', 'football', 'Databases');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('7', 'Java', '', 'LPNU', 'voleyball', 'PyCharm');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('8', 'Swift', '', 'LNU', 'Reading', 'Sociable');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('9', 'C++', '3 years', 'LPNU', 'Coding', 'Sociable');
INSERT INTO `mydb`.`candidate_cv` (`id`, `job`, `work_experience`, `place_of_study`, `hobby`, `skills`) VALUES ('10', 'C#', '1 year', 'LPNU', 'Traveling', 'Smart');


-- -----------------------------------------------------
-- INSERT `english_interview`
-- -----------------------------------------------------
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('1', 'B2', 'B1', 'B2');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('2', 'C2', 'C1', 'C1');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('3', 'A2', 'A1', 'A1');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('4', 'C1', 'B2', 'B2');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('5', 'C2', 'A2', 'B1');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('6', 'B2', 'B1', 'B2');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('7', 'C2', 'C1', 'C1');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('8', 'A2', 'A1', 'A1');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('9', 'C1', 'B2', 'B2');
INSERT INTO `mydb`.`english_interview` (`id`, `level_of_technical`, `level_of_speaking`, `general_level`) VALUES ('10', 'C2', 'A2', 'B1');


-- -----------------------------------------------------
-- INSERT `technical_interview`
-- -----------------------------------------------------
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('1', 'Python', 'QuickSrot', 'bfs', 'MySQL', 'EXCELLENT');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('2', 'Java', 'HeapSort', 'deikstra', 'Postgres', 'GOOD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('3', 'C++', 'MergeSort', 'binary search', 'MongoDB', 'BAD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('4', 'C#', 'bfs', 'black-red tree', 'SQL', 'GOOD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('5', 'Swift', 'dfs', 'binary tree', 'SQLite', 'EXCELLENT');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('6', 'Python', 'MergeSrot', 'bfs', 'MySQL', 'EXCELLENT');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('7', 'Java', '', 'deikstra', 'Postgres', 'GOOD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('8', 'C++', '', 'binary search', 'MongoDB', 'BAD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('9', 'C#', '', 'black-red tree', 'SQL', 'GOOD');
INSERT INTO `mydb`.`technical_interview` (`id`, `programming_language`, `algorithm`, `data_structure`, `database`, `result_interview`) VALUES ('10', 'Swift', 'bfs', 'binary tree', 'SQLite', 'EXCELLENT');


-- -----------------------------------------------------
-- INSERT `comment`
-- -----------------------------------------------------
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('1', '1', 'Upgrade knowledge in db');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('2', '2', 'Upgrade knowledge in OOP');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('3', '3', 'GOOD');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('4', '4', 'Upgrade knowledge in ds');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('5', '5', 'GOOD');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('6', '6', 'Upgrade knowledge in db');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('7', '7', 'Bad');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('8', '8', 'GOOD');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('9', '9', 'Upgrade knowledge in ds');
INSERT INTO `mydb`.`comment` (`id`, `rating`, `response`) VALUES ('10', '10', 'Bad');


-- -----------------------------------------------------
-- INSERT `mark_of_interview`
-- -----------------------------------------------------
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('1', 'excellent', '1');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('2', 'excellent', '2');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('3', 'satisfactory', '3');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('4', 'good', '4');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('5', 'excellent', '5');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('6', 'good', '6');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('7', 'excellent', '7');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('8', 'satisfactory', '8');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('9', 'good', '9');
INSERT INTO `mydb`.`mark_of_interview` (`id`, `level`, `comment_id`) VALUES ('10', 'excellent', '10');


-- -----------------------------------------------------
-- INSERT `potential_candidate`
-- -----------------------------------------------------
INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('1', 'Ivan', 'Ivanich', '380985423', 'ivani@gmail.com', 'IvanIvaniv', 'Ivan Ivaniv', '1', '1', '1', '1');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('2', 'Petro', 'Petrenko', '380978423', 'petya@proton.mail', 'PetyaP', 'Petro Petrenko', '2', '2', '2', '2');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('3', 'Yaroslav', 'Shchudlyk', '380967423', 'yarkos03@gmail.com', 'whooaami', 'Yaroslav Shchudlyk', '3', '3', '3', '3');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('4', 'Taras', 'Tarasiv', '380953423', 'taras@gmail.com', 'TarasT', 'Taras Tarasiv', '4', '4', '4', '4');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('5', 'Stepan', 'Bandera', '380967777', 'stepanb@ukr.net', 'Bandera', 'Stepan Bandera', '5', '5', '5', '5');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('6', 'Max', 'Mad', '380977777', 'maxm@ukr.net', 'MadMax', 'Max Mad', '6', '6', '6', '6');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('7', 'Roman', 'Romaniv', '380937777', 'tomanb@ukr.net', 'RR', 'Roman Romaniv', '7', '7', '7', '7');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('8', 'Pedro', 'Pedrusik', '380947777', 'sb@ukr.net', 'Pedro', 'Pedro Pedrusik', '8', '8', '8', '8');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('9', 'Miha', 'Mikel', '380973777', 'micm@ukr.net', 'MMikel', 'Miha Mikel', '9', '9', '9', '9');

INSERT INTO `mydb`.`potential_candidate` (`id`, `name`, `surname`, `phone_number`, `email`, `github`, `linkedin`, `candidate_cv_id`, `english_interview_id`, `technical_interview_id`, `mark_of_interview_id`)
VALUES ('10', 'Shurik', 'Shapka', '380977747', 'shur@ukr.net', 'Shurik', 'Shurik Shapka', '10', '10', '10', '10');


-- -----------------------------------------------------
-- INSERT `contact_person`
-- -----------------------------------------------------
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('1', 'Yaroslav', 'Trevis', '380923423');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('2', 'Petro', 'Petriv', '380324323');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('3', 'Taras', 'Dryg', '380933123');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('4', 'Ernest', 'Brat', '380934321');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('5', 'Vitalik', 'Ivanov', '380923213');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('6', 'Yaroslav', 'Schev', '380923423');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('7', 'Max', 'Adamom', '380934323');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('8', 'David', 'Drake', '380934323');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('9', 'Digga', 'D', '380934321');
INSERT INTO `mydb`.`contact_person` (`id`, `name`, `surname`, `phone_number`) VALUES ('10', 'Vitalik', 'Ofb', '380934323');


-- -----------------------------------------------------
-- INSERT `vacancy`
-- -----------------------------------------------------
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('1', 'Python', 'WeatherMet');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('2', 'Java', 'Genius');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('3', 'C++', 'AppI');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('4', 'Swift', 'LvivMap');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('5', 'C#', 'CardIm');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('6', 'Python', 'NGine');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('7', 'Java', 'SoftS');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('8', 'C++', 'GL');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('9', 'Swift', 'Epam');
INSERT INTO `mydb`.`vacancy` (`id`, `job_desciption`, `project_name`) VALUES ('10', 'C#', 'Caeb');


-- -----------------------------------------------------
-- Insert `vacancy_has_potential_candidate`
-- -----------------------------------------------------
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('1', '1');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('2', '2');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('3', '3');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('4', '4');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('5', '5');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('6', '6');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('7', '7');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('8', '8');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('9', '9');
INSERT INTO `mydb`.`vacancy_has_potential_candidate` (`vacancy_id`, `potential_candidate_id`) VALUES ('10', '10');


-- -----------------------------------------------------
-- Insert `vacancy_has_contact_person`
-- -----------------------------------------------------
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('1', '1');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('2', '2');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('3', '3');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('4', '4');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('5', '5');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('6', '6');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('7', '7');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('8', '8');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('9', '9');
INSERT INTO `mydb`.`vacancy_has_contact_person` (`vacancy_id`, `contact_person_id`) VALUES ('10', '10');
