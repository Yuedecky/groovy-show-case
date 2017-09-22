package com.ktjr.ktwd.groovy.ch02

/**
 * Created by forker on 2017/9/22.
 */
class ComparableObject implements Comparable<String>{


    final String obj = 'obj1'

    @Override
    int compareTo(String o) {
        int size = o?.size()
        for(def i = 0; i<size;i++){
            def c = o.charAt(i)
            if (Character.digit(c,10) > Character.digit(obj.asType(char),10)){
                return 1
            }
        }
        return 0
    }}
