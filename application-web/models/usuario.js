'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
	let Usuario = sequelize.define('Usuario', {
		id: {
			field: 'idCollaborator',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		nome: {
			field: 'name',
			type: DataTypes.STRING,
			allowNull: false
		},
		cpf: {
			field: 'cpf',
			type: DataTypes.STRING,
			allowNull: false
		},
		login: {
			field: 'login',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'password',
			type: DataTypes.STRING,
			allowNull: false
		},
		office: {
			field: 'office',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkestabelecimento: {
			field: 'fkCompanyBranch',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	},
		{
			tableName: 'Collaborator',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

	return Usuario;
};
