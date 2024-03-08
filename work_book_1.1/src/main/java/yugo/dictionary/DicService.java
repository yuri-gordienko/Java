package yugo.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DicService {

    private Dictionary[] dictionary = new Dictionary[10];

    public void put(Dictionary dic) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] != null && dic.getKey().equals(dictionary[i].getKey())) { // peeked
                dictionary[i] = dic;
                break;
            }
            if (dictionary[i] == null) {
                dictionary[i] = dic;
                break;
            }
        }
    }

    public Dictionary[] readAll() {
        return dictionary;
    }

    public String getValueByKey(String key) {
        for (Dictionary dictionary1 : dictionary) {
            if (key.equals(dictionary1.getKey())) {
                return dictionary1.getValue();
            }
        }
        return null;
    }

    public String[] keySet() {
//        String[] keys = new String[dictionary.length];
//        for (int i = 0; i < dictionary.length; i++) {
//            if (dictionary[i] != null) {
//                for (int i1 = 0; i1 < keys.length; i1++) {
//                    if (keys[i] == null) {
//                        keys[i] = dictionary[i].getKey();
//                    }
//                }
//            }
//        }
//        return keys;

        String[] keys = new String[dictionary.length];
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] != null) {
                keys[i] = dictionary[i].getKey();
            }
        }
        return keys;
    }

    public String[] values() {
        List<String> values = new ArrayList<>();
        for (Dictionary dictionary1 : dictionary) {
            if (dictionary1 != null) {
                values.add(dictionary1.getValue());
            }
        }
        return values.toArray(new String[]{});
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] != null) {
                count++;
            }
        }
//        for (Dictionary dictionary1 : dictionary) {
//            if (dictionary1 != null) {
//                count++;
//            }
//        }
        return count;
    }

    public boolean isEmpty() {
//        for (Dictionary dictionary1 : dictionary) {
//            if (dictionary1 != null) {
//                return false;
//            }
//        }
//        return true;
        return Arrays.stream(dictionary).anyMatch(dictionary1 -> dictionary1 != null) ? false : true;
    }

    public boolean containsKey(String k) {
       try {
           for (Dictionary dictionary1 : dictionary) {
               if (k.equals(dictionary1.getKey())) {
                   return true;
               }
           }
       } catch (NullPointerException e) {
           System.out.println("Error, no Data !!!!!\n ---   " + e);
       }
        return false;
    }

    public boolean containsValue(String v) {
        try {
            for (Dictionary dictionary1 : dictionary) {
                if (v.equals(dictionary1.getValue())) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error, no Data !!!!!\n ---   " + e);
        }
        return false;
    }

    public void remove(String key) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] != null && dictionary[i].getKey().equals(key)) {
                dictionary[i] = null;
            }
        }
    }

    public Dictionary[] copyArrays() {
        Dictionary[] secondDic = new Dictionary[10];
        for (int i = 0; i < secondDic.length; i++) {
            Dictionary secDic = new Dictionary();
            secDic.setKey("4");
            secDic.setValue("Kira Gordienko");
            secondDic[i] = secDic;
            break;
        }

        Dictionary[] mutualDic = new Dictionary[(secondDic.length + dictionary.length) * 2];

//        for (int i = 0; i < dictionary.length; i++) {
//            if (dictionary[i] != null) {
//                mutualDic[i] = dictionary[i];
//            }
//        }
//        for (int i = 0; i < secondDic.length; i++) {      // peaked
//            if (secondDic[i] != null) {
//                mutualDic[dictionary.length + 1] = secondDic[i];
//            }
//        }
        System.arraycopy(dictionary, 0, mutualDic, 0, dictionary.length);
        System.arraycopy(secondDic, 0, mutualDic, dictionary.length, secondDic.length);

        return mutualDic;
    }

    public void clear() {
        for (int i = 0; i < dictionary.length; i++) {
                dictionary[i] = null;
        }
    }
}
