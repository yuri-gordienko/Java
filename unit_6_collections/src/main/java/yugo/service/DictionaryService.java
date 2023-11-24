package yugo.service;

import yugo.entity.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryService {

    Dictionary[] dictionaries = new Dictionary[2];

    int size;
    public void put(Dictionary dictionary) {
        if (size == dictionaries.length) {
            Dictionary[] newDic = new Dictionary[size * 2];
            for (int i = 0; i < dictionaries.length; i++) {
                newDic[i] = dictionaries[i];
            }
            dictionaries = newDic;
        }
        for (int i = 0; i < dictionaries.length; i++) {
            if (dictionaries[i] != null && dictionary.getKey().equals(dictionaries[i].getKey())) {
                dictionaries[i] = dictionary;
                break;
            }
            if (dictionaries[i] == null) {
                dictionaries[i] = dictionary;
                break;
            }
        }
        size++;
    }

    public int size() {
        int count = 0;
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        if (dictionaries == null) {
            return true; // масив є нульовим
        }
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null) {
                return false; // знайдено непорожній елемент
            }
        }
        return true; // всі елементи масиву є нульовими
    }

    public boolean containsKey(String k) {
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null && k.equals(dictionary.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(String v) {
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null && v.equals(dictionary.getValue())) {
                return true;
            }
        }
        return false;
    }

    public String getValueByKey(String k) {
        String v = null;
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null && dictionary.getKey().equals(k)) {
                v = dictionary.getValue();
            }
        }
        return v;
    }

    public void remove(String k) {
        for (int i = 0; i < dictionaries.length; i++) {
            if (dictionaries[i] != null && k.equals(dictionaries[i].getKey())) {
                dictionaries[i] = null;
            }
        }
    }

    public Dictionary[] copyArrays () {

        Dictionary[] secondDic = new Dictionary[10];
        for (int i = 0; i < secondDic.length; i++) {
            Dictionary dic = new Dictionary();
            dic.setKey("4");
            dic.setValue("Kira Gordienko");
            secondDic[i] = dic;
            break;
        }
//        // копівання масивів в третій спільний масив:
//        // System.arraycopy(від куди, з якого індексу, куди, з якого індексу, по який індекс);
        Dictionary[] mutualDic = new Dictionary[dictionaries.length + secondDic.length];
        System.arraycopy(dictionaries, 0, mutualDic, 0, dictionaries.length);
        System.arraycopy(secondDic, 0, mutualDic, dictionaries.length, secondDic.length);

        dictionaries = mutualDic;

        return dictionaries;
    }

    public String clear() {
        for (int i = 0; i < dictionaries.length; i++) {
            dictionaries[i] = null;
        }
        return null;
    }


    public String[] keySet() {
        List<String> keyList = new ArrayList<>();
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null) {
                keyList.add(dictionary.getKey());
            }
        }
        return new String[]{Arrays.toString(new List[]{keyList})};
    }

    public String[] values() {
        List<String> valuesList = new ArrayList<>();
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null) {
                valuesList.add(dictionary.getValue());
            }
        }
        return valuesList.toArray(new String[0]);   // так покрасивее и метод, и распечатка в консоле
    }

    public Dictionary[] readAll() {
        return dictionaries;
    }
}
