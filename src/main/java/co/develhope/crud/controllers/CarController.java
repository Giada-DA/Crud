package co.develhope.crud.controllers;

import co.develhope.crud.entities.Car;
import co.develhope.crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    //crea l'auto
    @PostMapping
    public Car create(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    //restituisce la lista di auto
    @GetMapping
    public List<Car> get(){
        return carRepository.findAll();
    }

    //restituisce una sola auto tramite id
    @GetMapping("/{id_car}")
    public Car getSingle(@PathVariable long id_car){
        return carRepository.existsById(id_car) ? carRepository.getById(id_car) : new Car();
    }

    //modificare i dati di una macchina
    @PutMapping("/{id_car}")
    public Car update(@PathVariable long id_car, @RequestParam String tipo){
        Car car;
        if (carRepository.existsById(id_car)){
            car = carRepository.getById(id_car);
            car.setTipo(tipo);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        return car;
    }

    //eliminare una singola auto
    @DeleteMapping("/{id_car}")
    public void delete(@PathVariable long id_car, HttpServletResponse risposta){
        if (carRepository.existsById(id_car)){
            carRepository.deleteById(id_car);
        }else{
            risposta.setStatus(409);
        }
    }

    //eliminare tutte le auto
    @DeleteMapping("")
    public void deleteAll(){
        carRepository.deleteAll();
    }

    /*
    // delete all
    @DeleteMapping
    public void deleteAll(@RequestParam List<Long> id_cars){
        carRepository.deleteAllById(id_cars);
    }
     */
}
