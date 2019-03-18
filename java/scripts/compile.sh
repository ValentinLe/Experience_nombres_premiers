#!bin/sh

cd $(dirname $0)/..
[ -d build ] || mkdir build/
javac -d build src/*/*.java
