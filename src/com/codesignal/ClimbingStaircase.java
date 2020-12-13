package com.codesignal;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStaircase {


    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        list.add(0,2);
        list.stream().forEach(v-> System.out.println(v));
    }
}
