package ru.passport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.passport.model.Passport;

import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

    Passport findBySeries(int series);

    @Query(value = "SELECT * FROM passports p WHERE p.validity < current_date", nativeQuery = true)
    List<Passport> findAllNotValidDate();

    @Query(value = "SELECT * FROM passports p " +
            "WHERE p.validity < current_date + 90" +
            "AND p.validity > current_date", nativeQuery = true)
    List<Passport> findAllValidSoon();
}
