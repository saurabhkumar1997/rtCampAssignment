package org.Utils;


import com.google.gson.Gson;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

import com.google.gson.JsonParseException;
import org.json.JSONObject;


import java.io.File;

import java.io.FileReader;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

public class TestDataUtil {

    public static String getFrameworkConfig(String parameter) {

        String assemblyLocation = System.getProperty("user.dir");

        String path = Paths.get(assemblyLocation+"/FrameworkConfig.json").toString();

        String fullPath = new File(path).getAbsolutePath();

        try {

            String json = Files.readString(Path.of(fullPath));

            JSONObject jObject = new JSONObject(json);

            return jObject.optString(parameter, "");

        } catch (IOException e) {

            e.printStackTrace();

            return "";

        }

    }

    public static String gettestdata(String featureFileName, String scenarioName, String key) {

        String jsonFilePath = getFrameworkConfig("TestDataFilePath") + featureFileName + ".json";

        try (FileReader reader = new FileReader(jsonFilePath)) {

            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Verify the "fileName" key in the JSON data

            String actualFileName = jsonObject.get("fileName").getAsString();

            if (!actualFileName.equals(featureFileName)) {

                throw new IllegalArgumentException("Provided feature file name does not match the JSON file name");

            }

            // Find the scenario with the given scenario name

            JsonArray scenarios = jsonObject.getAsJsonArray("scenarios");

            JsonObject targetScenario = null;

            for (int i = 0; i < scenarios.size(); i++) {

                JsonObject scenario = scenarios.get(i).getAsJsonObject();

                if (scenario.get("scenarioName").getAsString().equals(scenarioName)) {

                    targetScenario = scenario;

                    break;

                }

            }

            if (targetScenario != null && targetScenario.has("testData")) {

                JsonArray testDataArray = targetScenario.getAsJsonArray("testData");

                for (int i = 0; i < testDataArray.size(); i++) {

                    JsonObject testData = testDataArray.get(i).getAsJsonObject();

                    if (testData.has(key)) {

                        return testData.get(key).getAsString();

                    }

                    if(!testData.has(key)){

                        return "";

                    }

                }

            }

            throw new IllegalArgumentException("test data not found for the given scenario name");

        } catch (IOException | JsonParseException e) {

            e.printStackTrace();

            throw new IllegalArgumentException("Error reading JSON file or parsing JSON data");

        }

    }

}


