package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class MiniGorm {
    def db = []
    /**
     * 方法钩子
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name,Object args){
        db.find {
            it[name.toLowerCase() - 'findby'] == args
        }
    }

    static void main(String[] args) {

        def people = new MiniGorm()
        def dierk = [first: 'Dierk', last:'Koenig']
        def paul = [first: 'Paul', last:'King']
        people.db << dierk << paul
        assert people.findByLast('King') == paul
        assert people.findByFirst('Dierk') == dierk
    }
}
