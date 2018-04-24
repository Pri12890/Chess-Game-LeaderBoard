package controller;

import models.DaoModel;

/**
 * This class is responsible to Create the Table if it does not exist.
 */
public class TableCreation {

	public static void main(String[] args) {

		DaoModel dao = new DaoModel();
		dao.createTable();

	}

}
