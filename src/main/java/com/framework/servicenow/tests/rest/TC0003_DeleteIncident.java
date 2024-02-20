package com.framework.servicenow.tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC0003_DeleteIncident extends RESTAssuredBase {
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Delete Incident";
		testDescription = "Delete Incident using REST API";
		authors = "Nasar";
		category = "REST";
	}

	@Test(dependsOnMethods = "com.framework.servicenow.tests.rest.TC001_CreateIncident_ConfigurationManager.createIncident")
	public void deleteincident() throws FileNotFoundException, IOException {
		Response response=delete(ConfigurationManager.configuration().path_Delete_Update()+Sys_Id);
		verifyResponseCode(response,ConfigurationManager.configuration().delete_statuscode());
	}	
}
