package ru.ifdsls.demo.dataPerson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Passport {
    private int series;
    private int number;
    private List<Children> childrenList;

    public Passport() {
    }

    public Passport(int series, int number) {
        this.series = series;
        this.number = number;
    }

    public Passport(int series, int number, List<Children> childrenList) {
        this.series = series;
        this.number = number;
        this.childrenList = childrenList;
    }


    @Override
    public String toString() {
        return "Passport{" + "series=" + series + ", number=" + number + ", childrenList=" + childrenList + '}';
    }
}
