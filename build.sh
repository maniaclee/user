#!/bin/bash

## mvn clean install -Dmaven.test.skip=true
project="user-biz"
dir="$project/target/"
jar=`ls ${dir} | grep '.*\.jar$'`
jarPath=${dir} $jar
echo $jarPath
java -jar $jarPath &