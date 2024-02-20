package com.framework.servicenow.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC0002_UpdateIncident extends RESTAssuredBase {
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Update Incident";
		testDescription = "Update Incident using REST API";
		authors = "Nasar";
		category = "REST";
		//dataProvider
		dataFileName = "TC004";
		dataFileType = "JSON";
	}

	@Test(dependsOnMethods = "com.framework.servicenow.tests.rest.TC001_CreateIncident_ConfigurationManager.createIncident",dataProvider = "fetchData")
	public void updateincident(File file) throws FileNotFoundException, IOException {

		Response response = putWithFileBodyAndURL(file,ConfigurationManager.configuration().path_Delete_Update()+Sys_Id);
		verifyResponseCode(response,ConfigurationManager.configuration().put_statuscode());
	}	
}
