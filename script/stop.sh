#!/bin/bash

SPRINGBOOT_JAR_NAME='app.jar'
PIDS=`ps -ef | grep "$SPRINGBOOT_JAR_NAME" | grep java |awk '{print $2}'`
if [ -z "$PIDS" ]; then
  echo "$SPRINGBOOT_JAR_NAME 未啟動!停止程序結束"
  exit 0
fi
echo -e "正在停止 $SPRINGBOOT_JAR_NAME 程序[PIDS] ...\c"
for PID in $PIDS ; do
  sudo kill $PID > /dev/null 2>&1
done
COUNT=0
while [ $COUNT -lt 1 ]; do
  echo -e "......\c"
  sleep 2
  COUNT=1
  for PID in $PIDS ; do
    PID_EXIST=`ps -f -p $PID | grep java`
    if [ -n "$PID_EXIST" ]; then
      COUNT=0
      break
    fi
  done
done
echo "$SPRINGBOOT_JAR_NAME 程序[PIDS], 已停止!"