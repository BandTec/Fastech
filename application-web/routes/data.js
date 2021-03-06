const { json } = require('express');
var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;


/* Mostrando as maquinas de acordo com a empresa */
router.get('/machine/:company', (req, res, next) => {
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

/* Pesquisando maquinas */
router.get('/search/:name/:company', (req, res, next) => {
	let companyId = req.params.company;
	let nameMachine = req.params.name;

	let machineSelect = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m, CompanyBranch cb 
    WHERE m.fkCompanyBranch = cb.idCompanyBranch AND cb.idCompanyBranch = ${companyId} AND m.Name LIKE '%${nameMachine}%' ;`;

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


/* Recuperando dados de maquinas */
router.get('/datas_cpu/:company/:id', (req, res, next) => {
	let companyId = req.params.company;
	let idMachine = req.params.id;

	let machineSelect = `SELECT TOP 8 m.Name AS 'Name_Machine', t.NameType AS 'Type', d.Value AS 'Metrica', d.dtMoment AS 'Moment', c.Name AS 'Componente'
	FROM Machine m
		LEFT JOIN Component c ON c.fkMachine = m.idMachine 
		LEFT JOIN [Data] d ON d.Component_idComponent = c.idComponent 
		LEFT JOIN Types t ON t.idType = c.fkType 
		LEFT JOIN CompanyBranch cb ON m.fkCompanyBranch = cb.idCompanyBranch
	WHERE t.NameType = 'Cpu' AND cb.idCompanyBranch = ${companyId} AND m.idMachine = ${idMachine}
		ORDER BY d.dtMoment DESC;`;

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

router.get('/datas_mem/:company/:id', (req, res, next) => {
	let companyId = req.params.company;
	let idMachine = req.params.id;

	let machineSelect = `SELECT m.Name AS 'Name_Machine', t.NameType AS 'Type', d.Value AS 'Metrica', d.dtMoment AS 'Moment', c.Name AS 'Componente'
	FROM Machine m
		LEFT JOIN Component c ON c.fkMachine = m.idMachine 
		LEFT JOIN [Data] d ON d.Component_idComponent = c.idComponent 
		LEFT JOIN Types t ON t.idType = c.fkType 
		LEFT JOIN CompanyBranch cb ON m.fkCompanyBranch = cb.idCompanyBranch
	WHERE t.NameType = 'Memory' AND cb.idCompanyBranch = ${companyId} AND m.idMachine = ${idMachine}
		ORDER BY d.dtMoment DESC;`;

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

router.get('/datas_disk/:company/:id', (req, res, next) => {
	let companyId = req.params.company;
	let idMachine = req.params.id;

	let machineSelect = `SELECT m.Name AS 'Name_Machine', t.NameType AS 'Type', d.Value AS 'Metrica', d.dtMoment AS 'Moment', c.Name AS 'Componente'
	FROM Machine m
		LEFT JOIN Component c ON c.fkMachine = m.idMachine 
		LEFT JOIN [Data] d ON d.Component_idComponent = c.idComponent 
		LEFT JOIN Types t ON t.idType = c.fkType 
		LEFT JOIN CompanyBranch cb ON m.fkCompanyBranch = cb.idCompanyBranch
	WHERE t.NameType = 'Disk' AND cb.idCompanyBranch = ${companyId} AND m.idMachine = ${idMachine}
		ORDER BY d.dtMoment DESC;`;

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



/* informações de rede */
router.get('/network/:company/:machine', (req, res, next) => {
	let companyId = req.params.company;
	let machineId = req.params.machine;

	let statusGood = `SELECT d.Value AS 'Metrica'
	FROM Machine m
		LEFT JOIN Component c ON c.fkMachine = m.idMachine 
		LEFT JOIN [Data] d ON d.Component_idComponent = c.idComponent 
		LEFT JOIN Types t ON t.idType = c.fkType 
		LEFT JOIN CompanyBranch cb ON m.fkCompanyBranch = cb.idCompanyBranch
		WHERE t.idType = 4 AND cb.idCompanyBranch = ${companyId} AND m.idMachine = ${machineId}
		ORDER BY d.dtMoment DESC;`;

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


/* Recuperando maquinas com estado good */

router.get('/status_good/:company', (req, res, next) => {
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

router.get('/status_warning/:company', (req, res, next) => {
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

router.get('/status_danger/:company', (req, res, next) => {
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

/* Recuperando maquinas com disco cheio */

router.get('/disk_danger/:company', (req, res, next) => {
	let companyId = req.params.company;

	let statusWarning = `SELECT COUNT(M.idMachine) AS 'diskDanger' FROM Machine m
	LEFT JOIN CompanyBranch cb ON cb.idCompanyBranch = m.fkCompanyBranch 
	LEFT JOIN Component c ON c.fkMachine = m.idMachine 
	LEFT JOIN Types t ON c.fkType = t.idType 
	LEFT JOIN (SELECT MAX(dtMoment) AS dtMoment, Value  AS Value, 
		Component_idComponent FROM [Data] 
		GROUP BY Component_fkMachine, Component_idComponent,Value) d 
	ON d.Component_idComponent = c.idComponent 
WHERE t.idType = 3 AND d.Value >= 75  AND cb.idCompanyBranch = ${companyId};`;

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


/* Recuperando maquinas com estado danger na página */

router.get('/only_danger/:company', (req, res, next) => {
	let companyId = req.params.company;

	let statusDanger = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m, CompanyBranch cb 
    WHERE m.fkCompanyBranch = cb.idCompanyBranch AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Danger';`;

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

/* Recuperando maquinas com estado warning na página */

router.get('/only_warning/:company', (req, res, next) => {
	let companyId = req.params.company;

	let statusWarning = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m, CompanyBranch cb 
    WHERE m.fkCompanyBranch = cb.idCompanyBranch AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Warning';`;

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

/* Recuperando maquinas com estado good na página */

router.get('/only_good/:company', (req, res, next) => {
	let companyId = req.params.company;

	let statusGood = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m, CompanyBranch cb 
    WHERE m.fkCompanyBranch = cb.idCompanyBranch AND cb.idCompanyBranch = ${companyId} AND m.Status = 'Good';`;

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

/* Recuperando maquinas com disco em danger na página */

router.get('/only_danger_disk/:company', (req, res, next) => {
	let companyId = req.params.company;

	let onlyDangerDisk = `SELECT m.Name as nameMachine, m.Status, m.idMachine AS 'IdMachine' FROM Machine m
	LEFT JOIN CompanyBranch cb ON cb.idCompanyBranch = m.fkCompanyBranch 
	LEFT JOIN Component c ON c.fkMachine = m.idMachine 
	LEFT JOIN Types t ON c.fkType = t.idType 
	LEFT JOIN (SELECT MAX(dtMoment) AS dtMoment, Value  AS Value, Component_idComponent FROM [Data] GROUP BY Component_fkMachine, Component_idComponent,Value) d ON d.Component_idComponent = c.idComponent 
WHERE t.idType = 3 AND d.Value >= 75  AND cb.idCompanyBranch = ${companyId};`;

	sequelize.query(onlyDangerDisk, {
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