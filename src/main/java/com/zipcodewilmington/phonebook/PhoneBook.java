package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        // USED A LINKEDHASHMAP SO GETALLCONTACTNAMES
        // WILL PRINT OUT IN THE ORDER THEY WERE ADDED (for tests)
        this.phonebook = new LinkedHashMap<>(map);
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> numbers;
        if(this.phonebook.get(name) == null){
            numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            this.phonebook.put(name, numbers);
        }
        else{
            numbers = (ArrayList<String>) this.phonebook.get(name);
            numbers.add(phoneNumber);
            this.phonebook.put(name, numbers);
        }


    }

    public void addAll(String name, String... phoneNumbers) {
        for(int i = 0; i < phoneNumbers.length; i++){
            add(name, phoneNumbers[i]);
        }
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.get(name) != null;
    }

    public Boolean hasEntry(String name, String phoneNumber){
        return this.phonebook.get(name) != null && this.phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String key : this.phonebook.keySet()){
            if(this.phonebook.get(key).contains(phoneNumber)){
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> keys = new ArrayList<>();
        keys.addAll(this.phonebook.keySet());
        this.phonebook.entrySet();
        return keys;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
