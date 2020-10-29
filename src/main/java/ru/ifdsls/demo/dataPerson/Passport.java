package ru.ifdsls.demo.dataPerson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passport {
    private String a1;
    private String a2;


    public Passport() {
    }

    public Passport(String series, String number) {
        this.a1 = series;
        this.a2 = number;
    }

    @Override
    public String toString() {
        return "Passport{" + "series='" + a1 + '\'' + ", number='" + a2 + '\'' + '}';
    }
}
