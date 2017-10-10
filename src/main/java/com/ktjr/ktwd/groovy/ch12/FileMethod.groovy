package com.ktjr.ktwd.groovy.ch12

import static groovy.io.FileType.ANY
import static groovy.io.FileVisitResult.SKIP_SUBTREE

/**
 * Created by yzy
 * on 2017/10/9.
 */
class FileMethod {

    static void main(String[] args) {
//        String pathName = System.properties.'user.dir' + '/src/main/java/com/ktjr/ktwd/groovy/ch12/demo.txt'
//        writeFile(pathName)

        createDir("demo")
    }

    static def sumFile() {
        def totalSize = 0
        def count = 0
        def sortByTypeThenName = {
            a, b ->
                a.isFile() != b.isFile() ?
                        a.isFile() <=> b.isFile() :
                        a.name <=> b.name
        }

        def log = []

        def inputDir = new File("../")
        inputDir.traverse(
                type: ANY,
                nameFilter: ~/.*groovy.*/,
                excludeNameFilter: ~/.*Test.*/,
                preDir: {
                    if (it.name =~ '.?gradle|build')
                        return SKIP_SUBTREE
                    count = 0
                    totalSize = 0
                },
                postDir: {
                    if (count) {
                        log << "Found $count files in $it.name: $totalSize bytes"
                        count = 0
                        totalSize = 0
                    }
                },
                postRoot: true,
                sort: sortByTypeThenName
        ) { it -> totalSize += it.size(); count++ }

        println log.join('\n')
        println log
    }

    static def writeFile(String pathName) {
        def outFile = new File(pathName)
        def lines = ['line one', 'line two', 'line three']
        outFile.write(lines[0..1].join('\n'))
        outFile.append('\n' + lines[2])
        assert lines == outFile.readLines()
    }

    /**
     * 在临时文件中进行文件IO拷贝
     * @param dirName
     * @return
     */
    static def createDir(String dirName) {

        File tempDir = File.createTempDir('demo','dir')
        assert tempDir.directorySize() == 0
        File source = new File(tempDir, 'input.dat')
        source.bytes = 'hello world'.bytes
        assert tempDir.directorySize() == 11
        File destination = new File(tempDir, 'output.dat')

        destination.withDataOutputStream {
            os ->
                source.withDataInputStream {
                    is ->
                        os << is
                }
        }
        assert tempDir.directorySize() == 22
        tempDir.deleteDir()
    }
}
