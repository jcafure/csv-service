package br.com.csv.repository;

import br.com.csv.model.City;
import br.com.csv.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT c FROM City c WHERE c.capital = TRUE " +
            "ORDER BY c.nameCity ")
     List<City> findCapital();


    @Query("Select New br.com.csv.model.State (c.estado, COUNT (c.estado)) " +
            "FROM City c " +
            "Group By c.estado Order By c.estado")
    public List<State> numberOfCitiesByState();

    @Query("Select c From City c WHERE c.idIbge = ?1")
    public City findByIdIbge (Integer idIbge);

    @Query("Select c From City c WHERE c.estado = ?1")
    public List<City> findCitiesByEstado(String uf);

    @Query("Select COUNT (Distinct c) From City c ")
    public Integer totalNumberOfCities();

}
