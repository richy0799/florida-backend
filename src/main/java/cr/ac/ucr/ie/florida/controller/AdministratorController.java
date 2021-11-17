package cr.ac.ucr.ie.florida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.florida.service.AdministratorService;
import cr.ac.ucr.ie.florida.model.Administrator;

@RestController
@RequestMapping ("/administrator")
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@GetMapping
	private ResponseEntity<List<Administrator>> getAllAdmin(){
		return ResponseEntity.ok(administratorService.findAll());
	}

}
