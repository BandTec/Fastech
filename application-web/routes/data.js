const { json } = require('express');
var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;


/* Mostrando as maquinas de acordo com a empresa */
router.get('/machine/:company', (req,res,next) => {
	let companyId = req.params.company;
	
    let machineSelect = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m, CompanyBranch cb 
    WHERE m.fkCompanyBranch = cb.idCompanyBranch AND cb.idCompanyBranch = ${companyId}`;

	sequelize.query(machineSelect, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length > 0) {
           
            res.json(resultado);   		
		} 
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Recuperando maquinas com estado good */

router.get('/status_good/:company', (req,res,next) => {
	let companyId = req.params.company;
	
	let statusGood = `SELECT COUNT(*) AS 'statusCount' FROM Machine m, CompanyBranch cb 
	WHERE m.fkCompanyBranch = cb.idCompanyBranch 
	AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Good';`;

	sequelize.query(statusGood, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length > 0) {
           
            res.json(resultado);   		
		} 
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Recuperando maquinas com estado warning */

router.get('/status_warning/:company', (req,res,next) => {
	let companyId = req.params.company;
	
	let statusWarning = `SELECT COUNT(*) AS 'statusCount' FROM Machine m, CompanyBranch cb 
	WHERE m.fkCompanyBranch = cb.idCompanyBranch 
	AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Warning';`;

	sequelize.query(statusWarning, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length > 0) {
           
            res.json(resultado);   		
		} 
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Recuperando maquinas com estado danger */

router.get('/status_danger/:company', (req,res,next) => {
	let companyId = req.params.company;
	
	let statusDanger = `SELECT COUNT(*) AS 'statusCount' FROM Machine m, CompanyBranch cb 
	WHERE m.fkCompanyBranch = cb.idCompanyBranch 
	AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Danger';`;

	sequelize.query(statusDanger, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length > 0) {
           
            res.json(resultado);   		
		} 
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});




module.exports = router;