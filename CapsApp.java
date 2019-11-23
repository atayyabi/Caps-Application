package com.example.capsapp;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class CapsApp {
    private CountryDB db;

    public CapsApp() {
        this.db = new CountryDB();
    }

    public String qa() {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (n * Math.random());
        String c = capitals.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        String q;
        String a;
        if (Math.random() < 0.5) {
            q = "What is the capital of " + ref.getName() + "?";
            a = ref.getCapital();
        }
        else {
            q = ref.getCapital() + " is the capital of ?";
            a = ref.getName();
        }
        return String.format("%s\n%s", q, a);
    }
}
