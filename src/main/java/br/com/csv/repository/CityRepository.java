package br.com.csv.repository;

import br.com.csv.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT c FROM City c WHERE c.capital = TRUE " +
            "ORDER BY c.nameCity ")
     List<City> findCapital();
}
