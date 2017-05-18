package com.example.admin.vocabulary1;

/**
 * Created by User on 13.04.2017.
 */

public class WordTranslate {
    String word;
    String translate;
    long id;

    public WordTranslate(String word, String translate, long id)
    {
        this.word = word;
        this.translate = translate;
        this.id = id;
    }

    public String GetWord(){return word;}
    public String GetTranslate(){return translate;}
    public long getId() { return id;}
}
