package br.com.csv.controller;

import br.com.csv.model.City;
import br.com.csv.service.serviceimp.CrudServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    CrudServiceImp crudServiceImp;

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ResponseEntity<?> importCsv(@RequestBody City city){
        try{
            crudServiceImp.addCity(city);
            return ResponseEntity.ok(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/deleteCity/{idCity}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value ="idCity") Integer idcity){
        try{
            crudServiceImp.deleteCity(idcity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    //metodo para transformar o objeto em json
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getModel() {
        City cityToJson = new City();
        return ResponseEntity.ok(cityToJson);
    }


}
