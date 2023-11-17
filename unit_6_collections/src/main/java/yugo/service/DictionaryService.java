package yugo.service;

import yugo.entity.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryService {

    Dictionary[] dictionaries = new Dictionary[2];

    public int size() {
        return dictionaries.length;
    }

    public boolean isEmpty() {
        if (dictionaries == null) {
            return true;
        }
        for (Dictionary dictionary : dictionaries) {
            if (dictionary == null) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey (String key) {
        for (Dictionary dictionary : dictionaries) {
            if (key.equals(dictionary.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue (String value) {
        for (Dictionary dictionary : dictionaries) {
            if (value.equals(dictionary.getValue())) {
                return true;
            }
        }
        return false;
    }

    public String getValueByKey(String key) {
        String v = null;
        for (Dictionary dictionary : dictionaries) {
            if (key.equals(dictionary.getKey())) {
                v = dictionary.getValue();
            }
        }
        return v;
    }

    int arraySize;
    public void put(Dictionary dictionary) {
        if (arraySize == dictionaries.length) {
            Dictionary[] secondDic = new Dictionary[arraySize * 2];
            for (int i = 0; i < dictionaries.length; i++) {
                secondDic[i] = dictionaries[i];
            }
            dictionaries = secondDic;
        }
        for (int i = 0; i < dictionaries.length; i++) {
            if (dictionaries[i] !=  null && dictionary.getKey().equals(dictionaries[i].getKey())) {
                dictionaries[i] = dictionary;
                break;
            }
            if (dictionaries[i] == null) {
                dictionaries[i] = dictionary;
                break;
            }
        }
        arraySize++;
    }

    public void remove(String key) {
        for (int i = 0; i < dictionaries.length; i++) {
            if (key.equals(dictionaries[i].getKey())) {
                dictionaries[i] = null;
            }
        }
    }

    public Dictionary[] copyArrays() {
        Dictionary[] secondDic = new Dictionary[10];
        for (int i = 0; i < secondDic.length; i++) {
            Dictionary dic = new Dictionary();
            dic.setKey("4");
            dic.setValue("Kira Gordienko");
            secondDic[i] = dic;
            break;
        }

        // копівання масивів в третій спільний масив:
        // System.arraycopy(від куди, з якого індексу, куди, з якого індексу, по який індекс);
        Dictionary[] mutualDic = new Dictionary[dictionaries.length + secondDic.length];
        System.arraycopy(dictionaries, 0, mutualDic, 0, dictionaries.length);
        System.arraycopy(secondDic, 0, mutualDic, dictionaries.length, secondDic.length);

        return mutualDic;
    }

    public void clear() {
        for (int i = 0; i < dictionaries.length; i++) {
            dictionaries[i] = null;
        }
    }

    public String[] keySet() {
        List<String> keyList = new ArrayList<>();
        for (Dictionary dictionary : dictionaries) {
            keyList.add(dictionary.getKey());
        }
        return new String[]{Arrays.toString(new List[]{keyList})};
    }

    public String[] values() {
        List<String> valueList = new ArrayList<>();
        for (Dictionary dictionary : dictionaries) {
            valueList.add(dictionary.getValue());
        }
        return valueList.toArray(new String[]{});       // так покрасивее и метод, и распечатка в консоле
    }

    public Dictionary[] readAll() {
        return dictionaries;
    }
}
