package br.com.csv.repository;

import br.com.csv.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {


    @Query("Select new br.com.csv.model.State (c.estado) as conte FROM City c " +
            "group by c.estado order by conte")
    public List<State> numberOfCitiesByState();
}
