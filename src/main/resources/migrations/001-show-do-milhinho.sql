CREATE TABLE `question` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL COLLATE 'utf8_unicode_ci',
	`right_answer` VARCHAR(255) NOT NULL COLLATE 'utf8_unicode_ci',
	`wrong_answers` VARCHAR(255) NOT NULL COLLATE 'utf8_unicode_ci',
	`tip` VARCHAR(255) NOT NULL COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB;