package br.com.csv.service;

import br.com.csv.model.City;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudService {

    protected abstract City addCity(City city);
    protected abstract void deleteCity(Integer idCity);


}
