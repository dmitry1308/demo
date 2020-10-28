package ru.ifdsls.demo.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSonFileParser implements Parser<JsonObject,String>{

    @Override
    public JsonObject parse(String sourcePath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new FileReader(sourcePath));
        JsonObject jsonObject = element.getAsJsonObject();
        return jsonObject;
    }
}
