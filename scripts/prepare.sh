#!/bin/bash

#刪除 jar
if [ -f /usr/bin/hylapp/app.jar ]; then
  sudo rm /usr/bin/hylapp/app.jar
fi
exit 0
# #停止tomcat
# PIDT=`ps -ef | grep 'tomcat8'`
# if [ -z "$PIDT" ]; then
#   echo "Tomcat8 未啟動!"
# else
#   sudo service tomcat8 stop
# fi
# #停止apache2
# PIDA=`ps -ef | grep 'apache2'`
# if [ -z "$PIDA" ]; then
#   echo "Apache2 未啟動!"
# else
#   sudo service apache2 stop
# fi

# service apache2 start