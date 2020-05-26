
MAIN_CLASS=com.sd.ms.demo.DemoApp
LOG_PATH=demo.log

if [[ "$MAIN_CLASS" == "com.yourpackage.YourMainClass" ]]; then
    echo "请先修改 MAIN_CLASS 的值为你自己项目启动Class，然后再执行此脚本。"
	exit 0
fi

COMMAND="$1"

if [[ "$COMMAND" != "start" ]] && [[ "$COMMAND" != "stop" ]] && [[ "$COMMAND" != "restart" ]]&& [[ "$COMMAND" != "start2log" ]]; then
	echo "Usage: $0 start | stop | restart| start2log"
	exit 0
fi

APP_BASE_PATH=$(cd `dirname $0`; pwd)
CP=${APP_BASE_PATH}/config:${APP_BASE_PATH}/lib/*

function start()
{
    nohup java -Xverify:none ${JAVA_OPTS} -cp ${CP} ${MAIN_CLASS} >/dev/null 2>&1 &
}

function start2log()
{
    nohup java -Xverify:none ${JAVA_OPTS} -cp ${CP} ${MAIN_CLASS} > ${LOG_PATH} &
}

function stop()
{
    # 支持集群部署
    kill `pgrep -f ${APP_BASE_PATH}` 2>/dev/null
}

if [[ "$COMMAND" == "start" ]]; then
	start
elif [[ "$COMMAND" == "stop" ]]; then
    stop
elif [[ "$COMMAND" == "start2log" ]]; then
    start2log
else
    stop
    start
fi
