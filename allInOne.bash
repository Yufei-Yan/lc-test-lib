javac ./lc/test/*.java
# javadoc -d ./doc/ lc.test

javac ./lc/verification/*.java
# javadoc -d ./doc/ lc.verification

javadoc -d ./doc/ lc.test lc.verification

jar -cvf lcTester.jar ./lc/*/*.class

mv ./lcTester.jar ./bin/lcTester.jar