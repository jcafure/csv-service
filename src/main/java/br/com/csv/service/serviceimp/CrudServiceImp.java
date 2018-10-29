package br.com.csv.service.serviceimp;

import br.com.csv.model.City;
import br.com.csv.repository.CityRepository;
import br.com.csv.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImp extends CrudService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        if (!isPersist(city)){
            buildCity(city);
            cityRepository.save(city);
        }

        return city;
    }

    @Override
    public void deleteCity(Integer idCity) {
        cityRepository.deleteById(idCity);
    }

    private void buildCity(City city) {
        city.setIdIbge(city.getIdIbge());
        city.setEstado(city.getEstado());
        city.setNameCity(city.getNameCity());
        city.setCapital(false);
        city.setLongitude(city.getLongitude());
        city.setLatitude(city.getLatitude());
        city.setNoAccents(city.getNoAccents());
        city.setAlternativeNames(city.getAlternativeNames());
        city.setMicroRegion(city.getAlternativeNames());
        city.setMesoregion(city.getMesoregion());

    }

    private boolean isPersist(City city) {
        if (city.getId() != null){
            return  true;
        }
        return false;
    }

}
