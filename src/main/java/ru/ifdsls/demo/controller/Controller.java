package ru.ifdsls.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifdsls.demo.dataPerson.Passport;

@RestController
@CrossOrigin
@RequestMapping("/passport")
public class Controller {
    @PostMapping
    public ResponseEntity<Passport> parseDataPersonAndReturnEntity(@RequestBody Passport passport) {

        Passport checkedPassport = checkedPassport(passport);
        return ResponseEntity.ok(checkedPassport);
    }

    private Passport checkedPassport(Passport passport) {
        Passport checkedPassport = new Passport();

        if (passport != null) {
            String series = passport.getA1();
            if (series != null) {
                if (isMatches(series)) {
                    checkedPassport.setA1(series);
                }
            } else {
                checkedPassport.setA1("");
            }
            String number = passport.getA2();
            if (number != null) {
                if (isMatches(number)) {
                    checkedPassport.setA2(number);
                }
            } else {
                checkedPassport.setA2("");
            }
        }
        return checkedPassport;
    }

    private boolean isMatches(String series) {
        return series.matches("[-+]?\\d+");
    }

}
