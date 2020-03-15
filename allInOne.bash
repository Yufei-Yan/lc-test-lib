javac ./lc/test/*.java
javadoc -d ./doc/ lc.test

# jar -cvf lcTester.jar ./lc/test/*.class

javac ./lc/verification/*.java
javadoc -d ./doc/ lc.verification

jar -cvf lcTester.jar ./lc/*/*.class

mv ./lcTester.jar ./bin/lcTester.jar