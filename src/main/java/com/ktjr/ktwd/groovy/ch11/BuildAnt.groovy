package com.ktjr.ktwd.groovy.ch11

/**
 * Created by forker on 2017/9/30.
 */
/**
 * Build scripts often involve a range of tasks: cleaning directories,
 *compiling code, running unit tests, producing documentation,
 *  moving and copying files, bundling archive files, deploying the application, and much more
 */
TARGET_DIR = 'target'
CHAPTERS_DIR = 'chapters'
ant = new AntBuilder()
ant.delete(dir: TARGET_DIR)
ant.copy(toDir: TARGET_DIR){
    fileset(dir: CHAPTERS_DIR,includes:'*.doc', excludes:'~*')
}