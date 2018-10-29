package br.com.csv.controller;

import br.com.csv.model.City;
import br.com.csv.model.State;
import br.com.csv.service.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityServices cityServices;

    @RequestMapping(value = "/csvToImport", method = RequestMethod.POST)
    public ResponseEntity<?> importCsv(){
        try{
        cityServices.importCsv();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/capital", method = RequestMethod.GET)
    public ResponseEntity<?> findCapital(){
        try{
            List<City> capital = cityServices.findCapital();
            return ResponseEntity.ok(capital);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/stateWhiteLargerAndSmallerQuantityOfCity", method = RequestMethod.GET)
    public ResponseEntity<?> stateWithLargerAndSmallerQuantityOfCity(){
        try{
            List<State> states = cityServices.stateWithLargerAndSmallerQuantityOfCity();
            return ResponseEntity.ok(states);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/numberOfCityByState", method = RequestMethod.GET)
    public ResponseEntity<?> numberOfCityByState(){
        try{
            List<State> states = cityServices.numberOfCityByState();
            return ResponseEntity.ok(states);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByIdIbge/{idIbge}", method = RequestMethod.GET)
    public ResponseEntity<?> findByIdIbge(@PathVariable(value = "idIbge") Integer idIbge){
        try{
           City city = cityServices.findByidIbge(idIbge);
           return ResponseEntity.ok(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
