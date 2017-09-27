package com.ktjr.ktwd.groovy.ch08

use([IntegerMarshal,StringMarshal]){
    assert 1.marshall() == '1'
    assert "1".unMarshal() == 1
}
