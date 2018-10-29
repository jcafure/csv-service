package br.com.csv.repository;

import br.com.csv.model.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ColumnsRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public List<City> findCitiesByFilter(String column, String filter){

        StringBuilder consultvalue = new StringBuilder();
        consultvalue.append("Select c from City c where ");
        consultvalue.append(getNameColumn(column));
        consultvalue.append(" = :filter order by nameCity ");
        TypedQuery<City> query = entityManager.createQuery(consultvalue.toString(), City.class);

        switch (column) {
            case "ibge_id" : query.setParameter("filter", new Integer(filter));break;
            case "lat" : query.setParameter("filter", new BigDecimal(filter));break;
            case "lon" : query.setParameter("filter", new BigDecimal(filter));break;
            default:
                query.setParameter("filter", filter);
        }

        return query.getResultList();
    }

    private String getNameColumn(String colum) {
        switch (colum) {
            case "ibge_id" : return "idIbge";
            case "uf" : return "estado";
            case "name" : return "nameCity";
            case "no_accents" : return "noAccents";
            case "alternative_names" : return "alternativeNames";
            case "capital" : return "capital";
            case "microregion" : return "microRegion";
            case "mesoregion" : return "mesoregion";
            case "lat" : return "latitude";
            case "lon" : return "longitude";
            default:
                throw new RuntimeException("A Coluna não foi encontrada.");
        }
    }

}
