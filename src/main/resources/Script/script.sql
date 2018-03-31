-- -----------------------------------------------------
-- Table `GEDESAFT.V3`.`suspect`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEDESAFT.V3`.`suspect` (
  `id_suspect` INT NOT NULL AUTO_INCREMENT,
  `pseudoSuspect` VARCHAR(20) NULL,
  `photoSuspect` VARCHAR(45) NULL,
  `signeParticulierSuspect` MEDIUMTEXT NULL,
  `couleurPeauSuspect` VARCHAR(15) NULL,
  `couleurCheveuxSuspect` VARCHAR(15) NULL,
  `tailleSuspect` INT NULL,
  `id_affaire` INT NOT NULL,
  `id_personne` INT NOT NULL,
  PRIMARY KEY (`id_suspect`),
  UNIQUE INDEX `id_suspect_UNIQUE` (`id_suspect` ASC),
  INDEX `fk_suspect_affaire1_idx` (`id_affaire` ASC),
  INDEX `fk_suspect_personne1_idx` (`id_personne` ASC),
  CONSTRAINT `fk_suspect_affaire1`
    FOREIGN KEY (`id_affaire`)
    REFERENCES `GEDESAFT.V3`.`affaire` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suspect_personne1`
    FOREIGN KEY (`id_personne`)
    REFERENCES `GEDESAFT.V3`.`personne` (`id_personne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
