package ru.passport.service;

import org.springframework.stereotype.Service;
import ru.passport.model.Passport;
import ru.passport.repository.PassportRepository;

import java.util.List;

@Service
public class PassportService {

    private final PassportRepository postRepository;

    public PassportService(PassportRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Passport saveOrUpdate(Passport passport) {
        return postRepository.save(passport);
    }

    public Passport findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }

    public List<Passport> findAll() {
        return (List<Passport>) postRepository.findAll();
    }

    public Passport findBySeries(int series) {
        return postRepository.findBySeries(series);
    }

    public List<Passport> findAllNotValidDate() {
        return postRepository.findAllNotValidDate();
    }

    public List<Passport> findAllByValidSoon() {
        return postRepository.findAllValidSoon();
    }
}
