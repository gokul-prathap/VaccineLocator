package com.vaccine.locator.controller;

import com.vaccine.locator.constants.ErrorConstants;
import com.vaccine.locator.exception.EntryNotFoundException;
import com.vaccine.locator.exception.InvalidAadharNumberException;
import com.vaccine.locator.model.Location;
import com.vaccine.locator.model.Person;
import com.vaccine.locator.repository.LocationRepository;
import com.vaccine.locator.repository.PersonRepository;
import com.vaccine.locator.service.VaccineService;
import com.vaccine.locator.validation.AadharValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaccine-locator")
public class VaccineController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    PersonRepository personRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AadharValidation aadharValidation;

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/location/{aadhar_no}")
    public List<Location> getLocation(@PathVariable(value = "aadhar_no") long aadhar_no) {
        LOG.info("Getting all aadhar details..");
        return vaccineService.getLocations(aadhar_no);
    }
}