package org.geometerplus.zlibrary.core.xml;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map version of ZLStringMap.
 * Better performance when searching key.
 * Only the latest version of value saved.
 */
public class StringMapImpl extends ZLStringMap {
    private final Map<String, String> myMap;
    public static final byte TREE = 0x01;
    public static final byte LINK = 0x02;

    public StringMapImpl(){
        this(new HashMap<String, String>());
    }

    public StringMapImpl(byte strategy){
        switch (strategy){
            case TREE:
                myMap = new TreeMap<String, String>();
                break;
            case LINK:
                myMap = new LinkedHashMap<String, String>();
                break;
            default:
                myMap = new HashMap<String, String>();
        }
    }

    public StringMapImpl(Map<String, String> map){
        assert map != null;
        myMap = map;
    }

    @Override
    public void put(String key, String value) {
        assert key != null && value != null;
        myMap.put(key, value);
    }

    @Override
    public String getValue(String key) {
        assert key != null;
        return myMap.get(key);
    }

    @Override
    public int getSize() {
        return myMap.size();
    }

    @Override
    public String getKey(int index) {
        return (String) myMap.keySet().toArray()[index];
    }

    @Override
    String getValue(int index) {
        return (String) myMap.values().toArray()[index];
    }

    @Override
    public void clear() {
        myMap.clear();
        assert myMap.size() == 0;
    }
}
