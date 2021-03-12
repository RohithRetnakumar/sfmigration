SET  JAVA_HOME=C:\PROGRA~1\Java\jdk-9.0.4
SET  PATH=%JAVA_HOME%/bin:$PATH

set CLASSPATH=./lib/*;./Platform-1.0.jar;
%JAVA_HOME%/bin/java -Xms1024m -Xmx1024m -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=127.0.0.1 com.reds.platform.platformmanagement.Platform