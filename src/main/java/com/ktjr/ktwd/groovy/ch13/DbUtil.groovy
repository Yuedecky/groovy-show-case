package com.ktjr.ktwd.groovy.ch13

import groovy.sql.Sql
import sun.util.logging.PlatformLogger

import java.text.SimpleDateFormat
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Created by yzy
 * on 2017/10/10.
 */

/**
 * hsqldb: subprotocol:
 * 1. jdbc:hsqldb:hsql://server/dbname ----> 连接hsqldb的server进程
 * 2.jdbc:hsqldb:file:/path/dbname -----> 基于文件的持久化机制连接单个客户端的hsqldb的实例，如果数据库不存在，以数据库名称的的多个命名文件将会被创建
 * 3.jdbc:hsqldb:mem:dbname: ------> 连接到非持久化的内存数据库
 *
 */
class DbUtil {

    static Sql create() {
        def db = [url           : 'jdbc:hsqldb:mem:testDB', user: 'sa', password: '', driver: 'org.hsqldb.jdbc.JDBCDriver',
                  cacheStatments: true]
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        Logger.getLogger('groovy.sql').level = Level.FINE

        sql.execute """
            DROP TABLE Athlete IF EXISTS cascade;
            DROP TABLE Record IF EXISTS;
            DROP TABLE PROJECT IF EXISTS ;
            DROP TABLE RECORD iF EXISTS;
        """

        /**
         * execute()
         * 1.String statement
         * 2.String prepStmt, List values
         * 3.GString prepStmt
         */
        sql.execute """ 
            CREATE TABLE Athlete (
                athleteId INTEGER GENERATED BY DEFAULT AS IDENTITY,
                firstname VARCHAR(64),
                lastname VARCHAR(64),
                dateOfBirth DATE,
                UNIQUE(athleteId));
                
                 CREATE TABLE Record (
                    runId INTEGER GENERATED BY DEFAULT AS IDENTITY,
                    time INTEGER, -- in seconds
                    venue VARCHAR(64),
                    whenRun DATE,
                    fkAthlete INTEGER,
                    CONSTRAINT fk FOREIGN KEY (fkAthlete)
                    REFERENCES Athlete (athleteId) ON DELETE CASCADE
                    );
        """



        sql
    }

    static def populate(def sql, String first, String last, Date birth) {

        def db = create()
        db.execute(sql, [first, last, birth])
    }

    static void main(String[] args) {
        testBatch()
    }

    static def init() {
        def sql = create()
        def data = [first: 'Paul', last: 'Tergat', birth: '1968-06-07']
        sql.execute """
          INSERT INTO Athlete (firstname, lastname, dateOfBirth)
VALUES (${data.first}, ${data.last}, ${data.birth});
      """
    }

    static def insertSql() {
        def sql = create()
        def insertSql = '''
                            INSERT INTO Athlete(firstname,lastName,dateOfBirth)
                            values(?,?,?)
            '''
        def params = ['Ronaldo', 'da Costa', '1970-06-04']
        def keyColumnNames = ['ATHLETEID']
        def keys = sql.executeInsert insertSql, params, keyColumnNames
        assert keys[0] == [ATHLETEID: 0]
        init()
        sql
    }

    /**
     * 读取数据的主要方法：
     * 1.eachRow() : String statement, {row -> code}* 2.eachRow(): String prepStmt, List values {row -> code}* 3.eachRow(): GString prepStmt, {row -> code}* 4.query(): String statement,{resultSet}* 5.query():String prepStmt,List values{resultSet -> code}* 6.query():GString prepStmt,{resultSet-> code}* 7.rows():String statement {resultSet-> code}*
     */


    static def findSome() {
        def db = insertSql()
        println "Athlete Info".center(25, "-")
        def fmt = new SimpleDateFormat('yyyy-MM-dd', Locale.CHINA)
        db.eachRow("SELECT * FROM Athlete") {
            a ->
                println "$a.firstname $a.lastname"
                println "borm on ${fmt.format(a.dateOfBirth)}"
                println "-" * 25
        }
        db.query("SELECT firstname,lastname FROM Athlete") {
            resultSet ->
                if (resultSet.next()) {
                    print resultSet.getString(1)
                    print ''
                    print resultSet.getString('lastname')
                }
        }

        List athletes = db.rows("SELECT FIRSTName ,lastname from Athlete")

        println "There are ${athletes.size()} Athletes:"
        println athletes.collect { "${it[0]} ${it.lastname}" }.join(',')


        db.eachRow("SELECT firstname,lastname FROM Athlete") {
            row ->
                def first = row[0]
                def last = row.lastname
                println "$first :: $last"
        }



        assert db.firstRow("SELECT  count(*) as num FROM Athlete").num == 1


        db.execute("DELETE FROM Athlete WHERE lastname = 'Tergat'")
        assert db.firstRow('SELECT COUNT(1) as num FROM Athlete').num == 0
    }

    static def transactionTest() {

        def sql = create()
        sql.withTransaction {
            insertSql()
        }

    }



    static def testBatch(){

        def db = create()
        db.withBatch {
            stmt ->
                stmt.addBatch '''
                        INSERT INTO Athlete (firstname, lastname, dateOfBirth)
VALUES ('Paula', 'Radcliffe', '1973-12-17')
                    '''
                stmt.addBatch """
                        INSERT INTO Record (time, venue, whenRun, fkAthlete)
                    SELECT ${2*60*60+15*60+25}, 'London', '2003-04-13',
                    athleteId FROM Athlete WHERE lastname='Radcliffe'
                    """
        }

        def qry = '''
            INSERT INTO Athlete (firstname, lastname, dateOfBirth)
            VALUES (?,?,?)
        '''
        db.withBatch(3,qry){
            ps ->
                ps.addBatch('Paula','Radcliffe','1978-09-26')
                ps.addBatch('Catherine', 'Ndereba', '1972-07-21')
                ps.addBatch('Naoko', 'Takahashi', '1972-05-06')
                ps.addBatch('Tegla', 'Loroupe', '1973-05-09')
                ps.addBatch('Ingrid', 'Kristiansen', '1956-03-21')
        }

        println db.firstRow('SELECT COUNT(*) as num FROM Athlete').num
    }

    /**
     * Mapping of Groovy AST Nodes to their SQL equlvalents:
     * 1. &&  and
     * 2. || or
     * 3. == =
     * 4. other operators  : themselves , literally
     * 5.
     */

    /**
     * 数据集是一个方便的方式来做一个表。
     * 但是在关系模型中工作单个表通常没有什么价值.
     *
     */
    static def accessMetaData(){
        def db = create()



    }
}
