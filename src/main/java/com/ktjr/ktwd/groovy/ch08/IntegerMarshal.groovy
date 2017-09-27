package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/27.
 */
/**
 * 使用@Category注解，你可以如同写一个实例类，注释
 调整它具有类别所需的格式一样写你的class
 */
@Category(Integer)
class IntegerMarshal {
    String marshall(){
        toString()
    }

}
