package ru.ifdsls.demo.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifdsls.demo.dataPerson.Children;
import ru.ifdsls.demo.dataPerson.Passport;
import ru.ifdsls.demo.parser.JSonFileParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/validate/prime-number")
    public ResponseEntity<Passport> parseDataPerson(@RequestParam("number") String sourcePath) throws FileNotFoundException {
        JsonObject parsedObject = new JSonFileParser().parse(sourcePath);
        Passport passport = getPassportFields(parsedObject);

        return ResponseEntity.ok(passport);
    }


    public Passport getPassportFields(JsonObject jsonObject) {
        JsonObject jSonPassport = getJsonPassport(jsonObject);

        int series = jSonPassport.get("series").getAsInt();

        int number = 0;
        if (!jSonPassport.get("number").isJsonNull()) {
            number = jSonPassport.get("number").getAsInt();
        }

        List<Children> children = getChildren(jSonPassport);

        Passport passport = new Passport(series, number);
        System.out.println(passport);
        return passport;
    }

    private List<Children> getChildren(JsonObject jSonPassport) {
        JsonArray jSonChildrenList = jSonPassport.get("Children").getAsJsonArray();

        ArrayList<Children> childrenList = new ArrayList<>();
        for (int i = 0; i < jSonChildrenList.size(); i++) {
            JsonObject jSonChildren = (JsonObject) jSonChildrenList.get(i);
            String name = jSonChildren.get("name").getAsString();
            int age = jSonChildren.get("age").getAsInt();
            Children children = new Children(name, age);
            childrenList.add(children);
        }
        return childrenList;
    }

    private JsonObject getJsonPassport(JsonObject jsonObject) {
        return jsonObject.getAsJsonObject("personData").getAsJsonObject("passport");
    }
}
