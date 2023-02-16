package com.example.part13_javafx_projects.part_13;

import java.util.*;

public class VPDictionary {

    private List<String> words;
    private Map<String, String> translations;

    public VPDictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        this.add("sana", "word");
    }

    // get
    public String get(String word) {
        return this.translations.get(word);
    }

    // add
    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        this.translations.put(word, translation);
    }

    // getRandomWord
    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }

    // swap dictionary direction
    public void swapDict() {
        ArrayList newList = new ArrayList();
        HashMap<String, String> newMap = new HashMap<>();

        for (String key : this.translations.keySet()) {
            newList.add(translations.get(key)); // add the translation to the newList
            newMap.put(this.translations.get(key), key); // add the key,value to the newMap (reversed)
        }

        this.words = newList;
        this.translations = newMap;
    }

}
