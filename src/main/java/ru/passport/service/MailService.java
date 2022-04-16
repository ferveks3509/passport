package ru.passport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.passport.model.Passport;

@Component
public class MailService {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    private PassportService passportService;

    public MailService(PassportService passportService) {
        this.passportService = passportService;
    }

    @Scheduled(fixedRate = 30000)
    public void scheduleTask() {
        Iterable<Passport> passports = passportService.findAllNotValidDate();
        for (Passport passport : passports) {
            template.send("expiredPassport", passport.toString());
        }
    }
}