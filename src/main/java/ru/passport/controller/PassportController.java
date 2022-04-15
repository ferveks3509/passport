package ru.passport.controller;

import org.springframework.web.bind.annotation.*;
import ru.passport.model.Passport;
import ru.passport.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping
    public List<Passport> getAll() {
        return passportService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Passport getById(@PathVariable int id) {
        return passportService.findById(id);
    }

    @GetMapping("/getBySeries/{series}")
    public Passport getByName(@PathVariable int series) {
        return passportService.findBySeries(series);
    }

    @GetMapping("/notValid")
    public List<Passport> getNotValid() {
        return passportService.findAllNotValidDate();
    }

    @GetMapping("/soonValid")
    public List<Passport> getValidSoon() {
        return passportService.findAllByValidSoon();
    }

    @PostMapping
    public Passport save(@RequestBody Passport passport) {
        return passportService.saveOrUpdate(passport);
    }

    @PutMapping
    public Passport update(@RequestBody Passport passport) {
        return passportService.saveOrUpdate(passport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        passportService.delete(id);
    }
}