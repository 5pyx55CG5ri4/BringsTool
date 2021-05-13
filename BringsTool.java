package com.zly.main;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhuliyou
 * @date 2021/05/11
 */
public class BringsTool {

    private static final Integer[] AREA_NUMBER_BEFORE = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

    private static final Integer[] AFTER_ZONE_NUMBER = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    static Integer[] afterGetAreaNumber() throws Exception {
        Map<Integer, Integer> only = new LinkedHashMap<>();
        Integer[] afterGetAreaNumber = new Integer[2];
        for (int i = 0; i < AFTER_ZONE_NUMBER.length; i++) {
            int m = (int) (0 + Math.random() * 10);
            Thread.sleep(m);
            int ran = (int) (0 + Math.random() * 12);
            if (!only.containsKey(ran)) {
                only.put(ran, 1);
            } else {
                only.put(ran, only.get(ran) + 1);
            }
        }
        Map<Integer, Integer> integerIntegerMap = sortMapByValues(only);
        Set<Integer> integers = integerIntegerMap.keySet();
        Integer[] set = new Integer[integers.size()];
        Integer[] objects = integers.toArray(set);
        for (int i = 0; i < 2; i++) {
            afterGetAreaNumber[i] = AFTER_ZONE_NUMBER[objects[i]];
        }
        return afterGetAreaNumber;
    }

    static Integer[] areaBeforeAccessNumber() throws Exception {
        Map<Integer, Integer> only = new LinkedHashMap<>();
        Integer[] areaNumberBefore = new Integer[5];
        for (int i = 0; i < AREA_NUMBER_BEFORE.length; i++) {
            int m = (int) (0 + Math.random() * 10);
            Thread.sleep(m);
            int ran = (int) (0 + Math.random() * 35);
            if (!only.containsKey(ran)) {
                only.put(ran, 1);
            } else {
                only.put(ran, only.get(ran) + 1);
            }
        }
        Map<Integer, Integer> integerIntegerMap = sortMapByValues(only);
        Set<Integer> integers = integerIntegerMap.keySet();
        Integer[] set = new Integer[integers.size()];
        Integer[] objects = integers.toArray(set);
        for (int i = 0; i < 5; i++) {
            areaNumberBefore[i] = AREA_NUMBER_BEFORE[objects[i]];
        }
        return areaNumberBefore;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("----------------一将功成万骨枯--------------------");
        System.out.println("----------------万般皆是命，半点不由人！--------------------");
        System.out.println("----------------这将是你改变命运的开始--------------------");
        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = df.format(date);
        System.out.println("----------------当前时间:" + str + ":--------------------");
        File file = new File("D:\\Desktop\\" + str + ".txt");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
        }
        System.out.println("----------------开始机选了,准备好没--------------------");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        for (int i = 0; i < 5; i++) {
            Integer[] integers = areaBeforeAccessNumber();
            Arrays.sort(integers);
            Integer[] integers2 = afterGetAreaNumber();
            Arrays.sort(integers2);
            System.out.println("第" + (i + 1) + "注红球:" + Arrays.toString(integers));
            bufferedWriter.write("红球:" + Arrays.toString(integers));
            bufferedWriter.newLine();
            System.out.println("第" + (i + 1) + "注蓝球:" + Arrays.toString(integers2));
            bufferedWriter.write("蓝球:" + Arrays.toString(integers2));
            bufferedWriter.newLine();
        }
        System.out.println("----------------机选完了,祝你中奖--------------------");

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }


}
