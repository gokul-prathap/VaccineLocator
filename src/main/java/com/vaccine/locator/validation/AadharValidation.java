package com.vaccine.locator.validation;

import com.vaccine.locator.constants.ErrorConstants;
import com.vaccine.locator.exception.InvalidAadharNumberException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
@Service
public class AadharValidation {

    private  final Pattern VALID_AADHAR = Pattern.compile("^[2-9]{1}[0-9]{3}[0-9]{8}$");
    private  boolean status=false;
    public  boolean isValid(String aadhar) {
        if (VALID_AADHAR.matcher(aadhar).matches() && aadhar.length()==12) {
            status= true;
        } else {
            status=false;
            throw new InvalidAadharNumberException(ErrorConstants.INVALID_AADHAR);
        }
        return status;
    }
}
