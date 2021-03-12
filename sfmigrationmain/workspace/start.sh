#!/bin/bash
export JAVA_HOME=/home/admin/jdk-9.0.4
export PATH=$JAVA_HOME/bin:$PATH

export CLASSPATH=./lib/*:./lib/Platform-1.0.jar;
echo $JAVA_HOME 
echo $JAVA_VERSION
echo $PATH

java -Xms1G -Xmx1G -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=127.0.0.1 com.reds.platform.platformmanagement.Platform > log.txt 2> errors.txt & 
PID=$! 
echo $PID > pid.txt 
