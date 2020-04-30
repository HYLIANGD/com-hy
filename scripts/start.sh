# source /etc/profile.d/setenv.sh
# ps -ef
# env
java -jar -Dserver.port=8080 /usr/bin/hylapp/app.jar > /dev/null 2>&1 &