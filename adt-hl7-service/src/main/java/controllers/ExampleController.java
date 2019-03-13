package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.HealthInsuranceService;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
public class ExampleController {

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser () {
		
		HealthInsuranceService service = new HealthInsuranceService();
		service.createInsurance();
		
		return "Saved";
	}
	
	
}
