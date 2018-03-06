-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `CPF` VARCHAR(11) NOT NULL,
  `Nome` VARCHAR(200) NOT NULL,
  `endereco` VARCHAR(400) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `municipio` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(14) NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`CPF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pedidos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pedidos` (
  `cod` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `Clientes_CPF` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`cod`),
  INDEX `fk_Pedidos_Clientes_idx` (`Clientes_CPF` ASC),
  UNIQUE INDEX `cod_UNIQUE` (`cod` ASC),
  CONSTRAINT `fk_Pedidos_Clientes`
    FOREIGN KEY (`Clientes_CPF`)
    REFERENCES `mydb`.`Clientes` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Categorias` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Categorias` (
  `codCat` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codCat`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Produto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `codProd` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `Categorias_codCat` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`codProd`),
  INDEX `fk_Produto_Categorias1_idx` (`Categorias_codCat` ASC),
  CONSTRAINT `fk_Produto_Categorias1`
    FOREIGN KEY (`Categorias_codCat`)
    REFERENCES `mydb`.`Categorias` (`codCat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Itens_pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Itens_pedidos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Itens_pedidos` (
  `quantidade` INT NOT NULL,
  `Pedidos_cod` INT NOT NULL,
  `Produto_codProd` INT NOT NULL,
  INDEX `fk_Itens_pedidos_Pedidos1_idx` (`Pedidos_cod` ASC),
  INDEX `fk_Itens_pedidos_Produto1_idx` (`Produto_codProd` ASC),
  CONSTRAINT `fk_Itens_pedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_cod`)
    REFERENCES `mydb`.`Pedidos` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_pedidos_Produto1`
    FOREIGN KEY (`Produto_codProd`)
    REFERENCES `mydb`.`Produto` (`codProd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Hist_estoque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Hist_estoque` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Hist_estoque` (
  `data` DATE NOT NULL,
  `quantidade` VARCHAR(45) NOT NULL,
  `out_in` TINYINT(1) NOT NULL,
  `Produto_codProd` INT NOT NULL,
  INDEX `fk_Hist_estoque_Produto1_idx` (`Produto_codProd` ASC),
  CONSTRAINT `fk_Hist_estoque_Produto1`
    FOREIGN KEY (`Produto_codProd`)
    REFERENCES `mydb`.`Produto` (`codProd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pagamento` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pagamento` (
  `codPag` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `valor` DECIMAL NOT NULL,
  `num_cartaoCredito` VARCHAR(20) NOT NULL,
  `Pedidos_cod` INT NOT NULL,
  PRIMARY KEY (`codPag`),
  INDEX `fk_Pagamento_Pedidos1_idx` (`Pedidos_cod` ASC),
  CONSTRAINT `fk_Pagamento_Pedidos1`
    FOREIGN KEY (`Pedidos_cod`)
    REFERENCES `mydb`.`Pedidos` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nota_fiscal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Nota_fiscal` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Nota_fiscal` (
  `codNotaFiscal` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `Pedidos_cod` INT NOT NULL,
  PRIMARY KEY (`codNotaFiscal`),
  INDEX `fk_Nota_fiscal_Pedidos1_idx` (`Pedidos_cod` ASC),
  CONSTRAINT `fk_Nota_fiscal_Pedidos1`
    FOREIGN KEY (`Pedidos_cod`)
    REFERENCES `mydb`.`Pedidos` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
