package com.vaccine.locator.service;

import com.vaccine.locator.constants.ErrorConstants;
import com.vaccine.locator.exception.AlreadyVaccinatedException;
import com.vaccine.locator.exception.EntryNotFoundException;
import com.vaccine.locator.exception.InvalidAadharNumberException;
import com.vaccine.locator.model.Location;
import com.vaccine.locator.repository.LocationRepository;
import com.vaccine.locator.repository.PersonRepository;
import com.vaccine.locator.validation.AadharValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VaccineService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AadharValidation aadharValidation;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public int zipcode(long aadhar_no){
        int zipcode;
        try {
            zipcode=personRepository.findZipcodeByAadhar(aadhar_no);
        } catch(Exception n) {
            zipcode=0;
        }
        return zipcode;
    }
    public List<Location> getLocations(long aadhar_no){
        String errorMessage;
        int zipcode = zipcode(aadhar_no);
        if( !aadharValidation.isValid(String.valueOf(aadhar_no))) {
            errorMessage = ErrorConstants.INVALID_AADHAR;
            LOG.error(errorMessage);
            LOG.info("invalid aadhar details.. status: " +errorMessage);
            throw new InvalidAadharNumberException(errorMessage);
        }

        List<Location> locations = new ArrayList<>();
        // start and end of indian zipcodes
        if(zipcode>110000 && zipcode < 947232){
            locations=locationRepository.findNearestLocation(zipcode);
        } else if(zipcode==0){
            throw new AlreadyVaccinatedException(ErrorConstants.ALREADY_VACCINATED);
        }
        return locations;
    }
}
