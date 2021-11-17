package cr.ac.ucr.ie.florida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.florida.model.Company;
import cr.ac.ucr.ie.florida.service.CompanyService;

@RestController
@RequestMapping ("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	private ResponseEntity<List<Company>> getAllCompanies(){
		return ResponseEntity.ok(companyService.findAll());
	}

}
