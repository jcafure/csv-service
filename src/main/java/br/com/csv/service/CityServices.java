package br.com.csv.service;

import br.com.csv.model.City;
import br.com.csv.model.State;
import br.com.csv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;


@Service
public class CityServices {

    @Autowired
    CityRepository cityRepository;


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


}
