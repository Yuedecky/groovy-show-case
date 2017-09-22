package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/22.
 */
class DirectoryIter {

    static void main(args){
        readDirectory(System.properties."user.dir"+"/src/main/resources")
    }

    static void readDirectory(filePath){

        def f = new File(filePath)
        f.eachFile {
            it ->
                if(it.isFile()){
                    println "FILE:${it}"
                }
                else if(it.isDirectory()){
                    println "DIR:${it}"
                }
                else {
                    println "uh ,I am not Sure what it is..."
                }
        }


    }
}
