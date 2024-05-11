package com.visitormanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitormanagement.repository.VisitorTypesRepository;
import com.visitormanagement.model.VisitorTypes;

@Service
public class VisitorTypesServiceImplementation implements VisitorTypesService {
	
	@Autowired
	VisitorTypesRepository visitorTypesRepository;
	
	@Override
	public List<VisitorTypes> getAllVisitorTypes() {
		return visitorTypesRepository.findAll();
	}
}