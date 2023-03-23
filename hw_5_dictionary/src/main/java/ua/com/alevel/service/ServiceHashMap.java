package ua.com.alevel.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ServiceHashMap<K, V> {

    private HashMap<K, V> hashMap;

    public ServiceHashMap() {

        hashMap = new HashMap<K, V>();
    }

    public int size() {

        return hashMap.size();
    }

    public boolean isEmpty() {

        return hashMap.isEmpty();
    }

    public boolean containsKey(K key) {

        return hashMap.containsKey(key);
    }

    public boolean containsValue(V value) {

        return hashMap.containsValue(value);
    }

    public V get(K key) {

        return hashMap.get(key);
    }

    public boolean put(K key, V value) {
        if (hashMap.containsKey(key)) {
            return false;
        } else {
            hashMap.put(key, value);
            return true;
        }
    }

    public boolean remove(K key) {
        if (hashMap.containsKey(key)) {
            hashMap.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public boolean putAll(ServiceHashMap<K, V> hashMapService) {
        boolean bool = false;
        for (K key : hashMapService.keySet()) {
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, hashMapService.get(key));
                bool = true;
            }
        }
        return bool;
    }

    public boolean clear() {
        if (hashMap.isEmpty()) {
            return false;
        } else {
            hashMap.clear();
            return true;
        }
    }

    public Set<K> keySet() {

        return hashMap.keySet();
    }

    public Collection<V> values() {

        return hashMap.values();
    }

    @Override
    public String toString() {
        return ": " + hashMap +
                ' ';
    }
}