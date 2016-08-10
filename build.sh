#!/bin/bash

## mvn clean install -Dmaven.test.skip=true
project="user-biz"
dir="$project/target/"
jar=`ls ${dir} | grep '.*\.jar$'`
jarPath=${dir} $jar
echo $1
if [ $1 = "stop" ] ##inside [] must have space!
then
	pid=`ps aux | grep java | grep -i ${jar} | awk '{print \$2}'`
	kill -9 ${pid}
	echo "============= stop service ${jar} =========="
else
	java -jar $jarPath &
fi