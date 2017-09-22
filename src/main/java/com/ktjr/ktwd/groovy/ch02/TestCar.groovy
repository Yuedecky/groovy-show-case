package com.ktjr.ktwd.groovy.ch02
import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class TestCar {


    @Test
    void test(){
        def cars = [
                new Car(make: 'Peugeot', model: '508'),
                new Car(make: 'Renault', model: 'Clio')]
        def makes = cars*.make //返回一个只包含make条目的集合
        assert makes == ['Peugeot', 'Renault']
    }
}
