package com.api.controller;

import com.api.model.CarModelElastic;
import com.api.model.CarRequest;
import com.api.repository.CarElasticRepository;
import com.api.repository.CarMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarElasticRepository carElasticRepository;
    private final CarMongoRepository carMongoRepository;

    @PostMapping
    public void save(@RequestBody CarRequest car) {
        carMongoRepository.save(car.toMongoEntity());
        carElasticRepository.save(car.toElasticEntity());
    }

    @GetMapping("/{id}")
    public CarModelElastic findById(@PathVariable String id) {
        return carElasticRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<CarModelElastic> findAll() {
        return carElasticRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        carMongoRepository.deleteById(id);
        carElasticRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody CarRequest car) {
        carMongoRepository.save(car.toMongoEntity(id));
        carElasticRepository.save(car.toElasticEntity(id));
    }
}
