// Defines a package in which the classes are
package com.visitormanagement.controller;

// Importing the necessary classes from the Spring framework
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.visitormanagement.model.VisitorTypes;
import com.visitormanagement.service.VisitorTypesServiceImplementation;

// @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response.
@RestController

// @CrossOrigin annotation is used to handle Cross-Origin-Resource-Sharing (CORS) from the server side.
// In this case, the server accepts requests from the origin "http://localhost:4200".
@CrossOrigin(origins = "http://localhost:4200")

// @RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
@RequestMapping("/visitortypes")
public class VisitorTypesController {
	
	// @Autowired annotation is used to auto-wire spring bean on setter methods, instance variable, and constructor.
	@Autowired
	VisitorTypesServiceImplementation visitorTypesServiceImplementation;
	
	// @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	@GetMapping("/fetch")
	public List<VisitorTypes> getAllVisitorTypes() {
		// It is fetching all the visitor types using the service implementation.
		return visitorTypesServiceImplementation.getAllVisitorTypes();
	}
}
