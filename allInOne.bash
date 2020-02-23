javac ./lc/test/*.java

jar -cvf lcTester.jar ./lc/test/*.class
mv ./lcTester.jar ./bin/lcTester.jar

javadoc -d ./doc/ lc.test
