package org.launchcode.hellospring.Controllers;

import org.launchcode.hellospring.Models.Languages;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//Created by NDB

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        if (name == null){
            name = "World";
        }
        return "Hello "+name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String languageshtml = "";
        HashMap<String,String> langMap = Languages.langs();
        for(Map.Entry<String,String> language:langMap.entrySet()){
            languageshtml += "<option value='"+language.getKey()+"'>"+language.getValue()+"</option>";
        }
        String html = "<form method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='lang'>" +
                languageshtml +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name"),
               language = request.getParameter("lang");

        return Languages.greeting(language)+" "+name;

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSeg(@PathVariable String name){
        return "Jo " + name;

    }


    @RequestMapping(value = "bye")
    public String goodbye(){
        return "redirect:/";
    }
}
