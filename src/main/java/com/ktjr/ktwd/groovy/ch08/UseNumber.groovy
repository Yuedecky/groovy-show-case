package com.ktjr.ktwd.groovy.ch08

Number.metaClass{
    getMm = {
        delegate
    }
    getCm ={
        delegate * 10.mm
    }

    getM={
        delegate * 100.mm
    }
}

static void main(def args){
 assert 1.m +20.cm -8.mm == 1.192.m
}


