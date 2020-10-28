package ru.ifdsls.demo.dataPerson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Passport {
    private String series;
    private String number;


    public Passport() {
    }

    public Passport(String series, String number) {
        this.series = series;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" + "series='" + series + '\'' + ", number='" + number + '\'' + '}';
    }
}
