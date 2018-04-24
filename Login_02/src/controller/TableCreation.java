package controller;

import models.DaoModel;

/**
 * This class is responsible to Create the Table if it does not exist.
 */
public class TableCreation {

	public static void createTable() {
		DaoModel dao = new DaoModel();
		dao.createTable();
	}
}
