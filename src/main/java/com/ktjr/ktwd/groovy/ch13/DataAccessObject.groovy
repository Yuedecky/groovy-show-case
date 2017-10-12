package com.ktjr.ktwd.groovy.ch13

/**
 * Created by yzy
 * on 2017/10/11.
 */
abstract class DataAccessObject {

    def db
    List fieldNames

    abstract Map getFields()

    List dataSet() {
        List res = db.dataSet(tablename)
        res
    }

    def getIdField() {
        tablename.toLowerCase() + "Id"
    }

    String getTablename() {
        def name = this.getClass().name
        return name[name.lastIndexOf('.') + 1..-4]
    }


    def create(List args) {
        Map argMap = [:]
        args.eachWithIndex { entry, i ->
            argMap[fieldNames[i]] = entry
        }
        dataSet().add argMap
    }

    Map getSchema() {
        Map result = [:]
        fieldNames.each {
            result[it] = fields[fields.indexOf(it) + 1]
        }
        result
    }

    private getWhereId() {
        "WHERE $IdField = ?"
    }

    List getFieldNames() {
        List result = []
        0.step(fields.size(), 2) {
            result << fields[it]
        }
        result
    }

    def update(field, newValue, id) {
        def stmt = "UPDATE $tablename SET $field = ? $whereId"
        db.executeUpdate stmt, [newValue, id]
    }


    def delete(id) {
        def stmt = "DELETE FROM $tablename $whereId"
        db.executeUpdate stmt, [id]
    }


    def all() {
        def seleccts = fieldNames + idField
        def result = []
        def stmt = "SELECT" + seleccts.join(',') +
                "FROM $tablename ORDER BY $sortField"

        db.eachRow(stmt.toString()) {
            Map businessObject = [:]
            seleccts.each {
                rs ->
                    businessObject[it] = rs

            }
            result << businessObject
        }
        result
    }


}
