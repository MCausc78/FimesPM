package org.mcausc78.fimespm.utils;

import java.util.List;
public class ArrayUtils {
    public static String getElement(String[] array, int element, String def) {
        try {
            return array[element];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            return def;
        }
    }
    public static String[] toArray(List<String> los) {
        String[] array = new String[los.size()];
        for(int i=0; i<los.size();i++) {
            array[i] = los.get(i);
        }
        return array;
    }
}
