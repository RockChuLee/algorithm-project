package com.nyu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s).append("+");
        }
        return sb.substring(0,sb.toString().length()-1);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] split = s.split("\\+");
        return Arrays.asList(split);
    }

}
