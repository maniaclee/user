#!/bin/bash

mvn clean install -Dmaven.test.skip=true

java -jar ./user-biz/target/user-biz-1.0-SNAPSHOT.jar