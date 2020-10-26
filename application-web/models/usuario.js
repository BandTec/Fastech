'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
	let Usuario = sequelize.define('Usuario', {
		id: {
			field: 'idUser',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		nome: {
			field: 'nameUser',
			type: DataTypes.STRING,
			allowNull: false
		},
		login: {
			field: 'loginUser',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'passwordUser',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkestabelecimento: {
			field: 'fkestablishmentUser',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	},
		{
			tableName: 'usuario',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

	return Usuario;
};
