package com.ktjr.ktwd.groovy.ch15

/**
 * Created by yzy
 * on 2017/10/13.
 */
class CounterTest extends GroovyTestCase {
    static final Integer[] NEG_NUMBERS = [-2, -3, -4]
    static final Integer[] POS_NUMBERS = [4, 5, 6]
    static final Integer[] MIXED_NUMBERS = [4, 6, -9, -2, 0]
    static final MAP = [key1: new Object(),key2: new Object()]
    private counter

    void setUp() {
        counter = new Counter()
    }

    void testCounterWorks() {
        assertEquals(2, counter.biggerThan([5, 10, 24], 7))
    }


    private check(expectedCount, items, threshold) {
        assertEquals(expectedCount, counter.biggerThan(items, threshold))
    }

    void testMixed() {
        check(2, NEG_NUMBERS, -4)
        check(2, POS_NUMBERS, 4)
        check(2, MIXED_NUMBERS, 0)
    }

    void testInputDatachanged() {
        def numbers = NEG_NUMBERS.clone()

        def originLength = numbers.size()
        counter.biggerThan(numbers, 0)
        assertLength originLength, numbers
        assertArrayEquals NEG_NUMBERS, numbers
    }


    void testInputDataAssumptions() {
        assertTrue NEG_NUMBERS.every {
            it < 0
        }
        assertTrue POS_NUMBERS.every {
            it > 0
        }
        assertContains 0, MIXED_NUMBERS

        int negCount = 0
        int posCount = 0
        MIXED_NUMBERS.grep {
            it > 0
        }.count {
            posCount++
        }
        MIXED_NUMBERS.grep{
            it < 0
        }.count{
            negCount++
        }
        assertEquals posCount, 2
        assertEquals negCount,2
    }

    void testCountHowManyFromSampleStrings(){
        check(2,['Dog','Cat','Antelope'],'Bird')
    }


    void testHashMapRejectsNull() {
        shouldFail(NullPointerException) {
            new HashMap(null)
        }
    }


    void testHashMapReturnsOriginalObjects(){
        def myMap = new HashMap()
        MAP.entrySet().each {
            myMap[it] = MAP[it]
            assertSame MAP[it], myMap[it]
        }
        assert MAP.dump().contains('java.lang.Object')
        assert myMap.size() == MAP.size()
    }
}
