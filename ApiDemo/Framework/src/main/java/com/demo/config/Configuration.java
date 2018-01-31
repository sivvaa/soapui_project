package com.demo.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public Config getConfig(String journeyName) {
        Map yamlParsers = new HashMap<String, ArrayList>();
        try {
            Yaml yaml = new Yaml();
            yamlParsers = (Map<String, ArrayList>) yaml.load(new FileReader("C:/MyFolder/SoapUi/abcd.yml"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, String> configMap =  (Map<String, String>)yamlParsers.get(journeyName);

        Config config = new Config();
        config.setServiceUrl(configMap.get("serviceUrl"));
        config.setKey(configMap.get("key"));
       return config;
    }

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        System.out.println(conf.getConfig("journey1"));
    }
}
