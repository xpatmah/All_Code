package som.org.soapservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(serviceName="CommonService")
public class StudentCatalog {

	public List<String> getAllStudent(){
		List<String> studentList = new ArrayList<>();
		studentList.add("dfkdffds");
		studentList.add("cvdsd Bat");
		studentList.add("Hodfgsdfgdfsckey");
		
		return studentList;
	
	}
	
}

