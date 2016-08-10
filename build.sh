#!/bin/bash

## mvn clean install -Dmaven.test.skip=true
project="user-biz"
dir="$project/target/"
jar=`ls ${dir} | grep '.*\.jar$'`
if [ ! ${jar}];then
	echo " no runnable jar was found in ${dir}"
	exit -1
fi
echo			"=============	 process ${jar} =========="
jarPath="${dir}$jar"
pid=`ps aux | grep java | grep -i ${jar} | awk '{print \$2}'`
if [ pid ] ;then
 	kill -9 ${pid}
	echo 		"============= 	stop service ${jar} =========="
fi
java -jar $jarPath