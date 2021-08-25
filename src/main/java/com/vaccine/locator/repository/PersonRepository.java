package com.vaccine.locator.repository;

import com.vaccine.locator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
     @Query("select zipcode from Person where vaccinated=0 and aadhar_no = ?1")
     int findZipcodeByAadhar(long aadhar_no);
}
