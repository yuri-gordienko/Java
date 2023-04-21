#!/bin/sh

mvn clean package

java -jar resources/crud_jdbc.jar