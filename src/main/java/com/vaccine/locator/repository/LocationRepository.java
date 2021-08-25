package com.vaccine.locator.repository;

import com.vaccine.locator.model.Location;
import com.vaccine.locator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Person,Long> {

    @Query("SELECT l FROM Location l WHERE  l.zipcode>?1-5 and l.zipcode <?1+5 and l.slots>0")
    List<Location> findNearestLocation(int zipcode);
}
