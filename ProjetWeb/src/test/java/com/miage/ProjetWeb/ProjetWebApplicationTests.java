package com.miage.ProjetWeb;

import Service.CoursService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.HttpCookie;

@SpringBootTest
class ProjetWebApplicationTests {

	private static CoursService coursServices;

	ProjetWebApplicationTests(CoursService coursServices) {
		this.coursServices = coursServices;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetCoursDate() throws JSONException, IOException {
		String date = "2022-12-29";

		String result = String.valueOf(coursServices.getCoursDate(date).getClass());
		assertEquals(date, result, Boolean.parseBoolean(result));
	}

	 @Test
	 public void testGetCoursBeginandEndDate() throws JSONException, IOException {
		String dateBegin="2022-12-01";
		String dateEnd = "2022-12-29";

		String result = String.valueOf(coursServices.getCoursBeginEndDate(dateBegin,dateEnd).getClass());
		assertEquals(dateBegin,dateEnd, Boolean.parseBoolean(result));
	 }

	 @Test
	 public boolean testReccordClick(){
		int reccord=0;

		int result = Integer.parseInt(reccordClick().getValue());
		if(reccord==result){
			return true;
		}else{
			return false;
		}
	 }

	private static HttpCookie reccordClick() {
		ProjetWebApplicationTests coursRepository = null;
		return coursRepository.reccordClick();
	}

	private static Object assertEquals(String data, String result, boolean b) {
		if(data==result){
			return true;
		}else {
			return false;
		}
	}

}
