package ru.client.controller;

import org.springframework.web.bind.annotation.*;
import ru.client.model.Passport;
import ru.client.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping
    public Passport save(@RequestBody Passport passport) {
        return passportService.save(passport);
    }

    @PutMapping
    public void update(@RequestBody Passport passport) {
        passportService.update(passport);
    }

    @GetMapping("/{id}")
    public Passport findById(@PathVariable int id) {
        return passportService.findById(id);
    }

    @GetMapping
    public List<Passport> findAll() {
        return passportService.findAll();
    }

    @GetMapping("/findBySeries/{series}")
    public Passport findBySeries(@PathVariable int series) {
        return passportService.findBySeries(series);
    }

    @GetMapping("/notValid")
    public List<Passport> getAllNotValid() {
        return passportService.findNotValid();
    }

    @GetMapping("/soonValid")
    public List<Passport> findAllSoonValid() {
        return passportService.getValidSoon();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        passportService.delete(id);
    }
}

