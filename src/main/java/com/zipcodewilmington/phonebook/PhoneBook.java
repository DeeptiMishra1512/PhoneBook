package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        //initialized with  hash map variable (map) because it is passed in argument
        this.phonebook = map;
    }

    public PhoneBook() {
        //initialized with new hash map because it dosent have any input coming from arguments
        //to mention the type of map(hash map).
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, List.of(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, List.of(phoneNumbers));


    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if(phonebook.containsKey(name)){
                //&& phonebook.containsValue(phoneNumber)) {
            return true;
        }
        else return false;
    }

    public List<String> lookup(String name) {
        //Created variable to store value of type List
        List<String> phone;
        phone = phonebook.get(name);
        return phone;
    }

    public String reverseLookup(String phoneNumber)  {
        String name = "";
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            for(String list : entry.getValue()) {
                if (list.equals(phoneNumber)) {
                    name = entry.getKey();
                }
            }
        }
        return name;
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }


    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
