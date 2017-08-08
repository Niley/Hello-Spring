package org.launchcode.hellospring.Models;

import java.util.HashMap;

public class Languages {
    public static HashMap<String,String> langs(){
        HashMap<String, String> languages = new HashMap<>();
        languages.put("en","English");
        languages.put("nl","Dutch");
        languages.put("de","German");
        languages.put("fr","French");
        languages.put("it","Italian");
        languages.put("ru","Russian");
        return languages;
    }
    public static String greeting(String abbrev){
        HashMap<String, String> greetings = new HashMap<>();
        greetings.put("en","Hello");
        greetings.put("nl","Hallo");
        greetings.put("de","Hallo");
        greetings.put("fr","Bonjour");
        greetings.put("it","Bongiorno");
        greetings.put("ru","Priviet");
        return greetings.get(abbrev);
    }
}
