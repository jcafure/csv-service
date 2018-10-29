package br.com.csv.service.serviceimp;

import br.com.csv.model.City;
import br.com.csv.model.State;
import br.com.csv.repository.CityRepository;
import br.com.csv.repository.ColumnsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CityServices  {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ColumnsRepositoryCustom columnsRepositoryCustom;

    public void importCsv() throws IOException {
        Reader inputCsv = null;
        inputCsv = new FileReader(getClass().getClassLoader().getResource("cidades.csv").getFile());
        BufferedReader reader = new BufferedReader(inputCsv);
        String line = null;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            City city = new City();
            city.setIdIbge(new Integer(columns[0]));
            city.setEstado(columns[1]);
            city.setNameCity(columns[2]);
            city.setCapital(getBooleanValue(columns[3]));
            city.setLongitude(new BigDecimal(columns[4]));
            city.setLatitude(new BigDecimal(columns[5]));
            city.setNoAccents(columns[6]);
            city.setAlternativeNames(columns[7]);
            city.setMicroRegion(columns[8]);
            city.setMesoregion(columns[9]);
            cityRepository.save(city);
        }

    }

    public List<City> findCapital() {
        return cityRepository.findCapital();
    }

    private Boolean getBooleanValue(String column) {
        return new Boolean(column);
    }

    public List<State> stateWithLargerAndSmallerQuantityOfCity() {
        List<State> states = new ArrayList<>();
        states = cityRepository.numberOfCitiesByState();
        Optional<State> maxCity = states.stream().max(Comparator.comparing(State::getNumber));
        Optional<State> minCity = states.stream().min(Comparator.comparing(State::getNumber));
        return Arrays.asList(maxCity.get(), minCity.get());
    }

    public List<State> numberOfCityByState() {
        return cityRepository.numberOfCitiesByState();
    }

    public City findByidIbge(Integer idIbge){
        return cityRepository.findByIdIbge(idIbge);
    }

    public List<City> findCitiesByEstado(String uf) {
        return cityRepository.findCitiesByEstado(uf);
    }

    public List<City> findByFilter(String column, String filter){
        return columnsRepositoryCustom.findCitiesByFilter(column, filter);
    }

    public Integer totalNumberOfCities(){
       return cityRepository.totalNumberOfCities();
    }

}
