package com.example.litualura.service;

public class ConverterLanguage {

    public static String  ConverterLanguage( String language){
         switch (language){
             case "portugues":
                 return "pt";
             case "ingles":
                 return "en";
             case "espanhol":
                 return "es";
             case "frances":
                 return "fr";
             case "italiano":
                 return "it";
             case "alemao":
                 return "de";
             case "russo":
                 return "ru";
             case "chines":
                 return "zh";
             case "japones":
                 return "ja";
             case "coreano":
                 return "ko";
         }
         return language;
    }
}
