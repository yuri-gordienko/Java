package yugo.service;

import yugo.entity.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryService {

    private Dictionary[] dictionary = new Dictionary[2];

    public int size() {

        return dictionary.length;
    }

    public boolean isEmpty() {
        for (Dictionary dictionary1 : dictionary) {
            if (dictionary1 == null) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey (String key) {
        for (Dictionary dictionary1 : dictionary) {
            if (key.equals(dictionary1.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue (String value) {
        for (Dictionary dictionary1 : dictionary) {
            if (value.equals(dictionary1.getValue())) {
                return true;
            }
        }
        return false;
    }

    public Dictionary getValueByKey(String key) {
        for (Dictionary dictionary1 : dictionary) {
            if (key.equals(dictionary1.getKey())) {
                return dictionary1;
            }
        }
        return null;
    }

    int arraysize;
    public void put(Dictionary dic) {       // add to Put method for rewriting, becaise PUT is unic!!!!!!!!!!!!!
        if (arraysize == dictionary.length) {
            Dictionary[] dictionaries = new Dictionary[arraysize * 2];
            for (int i = 0; i < arraysize; i++) {
                dictionaries[i] = dictionary[i];
            }
            dictionary = dictionaries;
        }
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] == null) {
                dictionary[i] = dic;
                break;
            }
        }
        arraysize++;
    }

    public Dictionary remove(String key) {
        for (int i = 0; i < dictionary.length; i++) {
            if (key.equals(dictionary[i].getKey())) {
                dictionary[i] = null;
            }
            i++;
        }
        return null;
    }

    public Dictionary[] copyArrays() {
        Dictionary[] secondDic = new Dictionary[10 + dictionary.length];
        for (int i = 0; i < secondDic.length; i++) {
            Dictionary d = new Dictionary();
            d.setKey("4");
            d.setValue("Kira");
            secondDic[i] = d;
            break;
        }

        Dictionary[] generalDic = new Dictionary[(dictionary.length + secondDic.length) * 2];
        for (int i = 0; i < dictionary.length; i++) {
            if (generalDic[i] == null) {
                generalDic[i] = dictionary[i];
            }
        }
        for (int j = 0; j < secondDic.length; j++) {
                generalDic[dictionary.length + j] = secondDic[j];
        }
        return generalDic;
    }

    public void clear() {
        dictionary = null;
    }

    public String[] keySet() {
        List<String> keyList = new ArrayList<>();
        for (Dictionary dictionary1 : dictionary) {
            keyList.add(dictionary1.getKey());
        }
        return keyList.toArray(new String[]{});
    }

    public String[] values() {
        List<String> valuesList= new ArrayList<>();
        for (Dictionary dictionary1 : dictionary) {
            valuesList.add(dictionary1.getValue());
        }
        return valuesList.toArray(new String[]{});
    }

    public Dictionary[] readAll() {
        if (dictionary == null) {
            System.err.println("NullPointerException: Dictionary is null");
            // Обробка або повернення певного значення за необхідності
        }
        return dictionary;
    }
}
