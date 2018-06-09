package com.leavemgmt.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leavemgmt.model.EmployeeDetails;
import com.leavemgmt.model.LeaveDetails;
import com.leavemgmt.mongo.database.MongoDBConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RestController
public class LeaveManagementController {

	@RequestMapping(method = RequestMethod.POST, value = "/addLeaves")
	public LeaveDetails addLeaves(@RequestBody EmployeeDetails employeeDetails) {
		DBCollection mongoCollection = getDBCollection();
		System.out.println("New detailss " + employeeDetails);
		BasicDBObject dfind = new BasicDBObject();
		dfind.put("_id", new ObjectId(employeeDetails.get_id()));
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		DBCursor dc = mongoCollection.find(dfind);
		if (dc.hasNext()) {
			BasicDBObject df = (BasicDBObject) dc.next();
			BasicDBList obList = (BasicDBList) df.get("leaveDetailsArray");
			BasicDBObject newLeaveObj = new BasicDBObject();
			com.leavemgmt.model.db.LeaveDetails leaveDetails = new com.leavemgmt.model.db.LeaveDetails(
					LocalDate.parse(employeeDetails.getLeaveDetails().getStartDate()),
					LocalDate.parse(employeeDetails.getLeaveDetails().getEndDate()));
			JSONObject j = new JSONObject(leaveDetails);
			BasicDBObject db1 = (BasicDBObject) JSON.parse(j.toString());
			newLeaveObj.put("leaveDetails", db1);
			obList.add(newLeaveObj);
			mongoCollection.update(dfind, df);
		}
		return employeeDetails.getLeaveDetails();
	}

	public void updateLeaves(EmployeeDetails employeeDetails) {

	}

	public void deleteLeaves(EmployeeDetails employeeDetails) {

	}

	@RequestMapping("/allLeaves")
	public List<EmployeeDetails> getAllLeaves() {
		DBCollection mongoCollection = getDBCollection();
		DBCursor dbResult = mongoCollection.find();
		List<EmployeeDetails> employeeDetails = new ArrayList<>();
		while (dbResult.hasNext()) {
			DBObject dbEmp = dbResult.next();
			BasicDBList dbList = (BasicDBList) dbEmp.get("leaveDetailsArray");

			LeaveDetails[] leaveDetails = convertDBListToLeaveDetails(dbList);
			EmployeeDetails empDetails = new EmployeeDetails((String) ((ObjectId) dbEmp.get("_id")).toString(),
					(String) dbEmp.get("name"), (String) dbEmp.get("company"),
					dbEmp.get("experiance") != null ? Double.valueOf(dbEmp.get("experiance").toString()).intValue()
							: Integer.MIN_VALUE,
					null, dbEmp.get("totalLeaves") != null
							? Double.valueOf(dbEmp.get("totalLeaves").toString()).intValue() : Integer.MIN_VALUE, leaveDetails);
			employeeDetails.add(empDetails);
		}
		System.out.println(employeeDetails);
		return employeeDetails;
	}

	private LeaveDetails[] convertDBListToLeaveDetails(BasicDBList dbList) {
		if (dbList == null) {
			return null;
		}
		List<LeaveDetails> leaveDetails = new ArrayList<>();
		Iterator leaveDetailItr = dbList.iterator();
		while (leaveDetailItr.hasNext()) {
			BasicDBObject leaveDetailObject = (BasicDBObject) leaveDetailItr.next();
			BasicDBObject basicLeaveDetailObject = (BasicDBObject) leaveDetailObject.get("leaveDetails");
			String startDate = (String) basicLeaveDetailObject.get("startDate");
			String endDate = (String) basicLeaveDetailObject.get("endDate");
			LeaveDetails leaveDetail = new LeaveDetails(startDate, endDate);
			leaveDetails.add(leaveDetail);
		}
		return leaveDetails.toArray(new LeaveDetails[leaveDetails.size()]);
	}

	public void getLeavesOfEmployee(int empId) {

	}

	private DBCollection getDBCollection() {
		return MongoDBConnection.getMongoDBConnection().getDBCollection();
	}

}
