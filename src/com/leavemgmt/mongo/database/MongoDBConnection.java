package com.leavemgmt.mongo.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Singleton
 * 
 * @author skaushik
 *
 */
public class MongoDBConnection {

	public static MongoDBConnection dbConnection = new MongoDBConnection();

	private static String LOCALHOST = "localhost";

	private static Integer PORT_NUMBER = 27017;

	private static String DATABASE_NAME = "acnleavedetails";

	private static String COLLECTION_NAME = "employees";

	private MongoDBConnection() {

	}

	public static MongoDBConnection getMongoDBConnection() {
		return dbConnection;
	}

	public static DBCollection getDBCollection() {
		DB db = new MongoClient(LOCALHOST, 27017).getDB(DATABASE_NAME);
		DBCollection dbCollection = db.getCollection(COLLECTION_NAME);
		return dbCollection;
	}
}
