package org.zerock.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {

        // key, value
        Map<String, String[]> map = new HashMap<>(); // map이라는 타입은 인터페이스 ,hashmap을 가장 많이 사용

        map.put("kor", new String[]{"불고기","비빔밥"});
        map.put("jap", new String[]{"초밥","라멘"});
        map.put("wes", new String[]{"피자","파스타"});

        String[] arr = map.get("wes");

        System.out.println(Arrays.toString(arr));

        int idx = (int)(Math.random() * arr.length); //arr 이 null , nullpointExceptopn .이나 <>

        System.out.println(arr[idx]);

    }
}
