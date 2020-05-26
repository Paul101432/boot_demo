@echo off
title demo-jf-11000

setlocal & pushd
set MAIN_CLASS=com.sdtech.demo.JFConfig
set LOG_PATH=../log.txt

if "%1"=="start" goto normal
if "%1"=="stop" goto normal
if "%1"=="restart" goto normal
if "%1"=="start2log" goto normal
if "%1"=="start2back" goto normal
if "%1"=="" goto normal
goto error


:error
echo Usage: sd.bat start | stop | restart | start2log | start2back
goto :eof


:normal
if "%1"=="start" goto start
if "%1"=="stop" goto stop
if "%1"=="restart" goto restart
if "%1"=="start2log" goto start2log
if "%1"=="start2back" goto start2back
if "%1"=="" goto start
goto :eof



:start
set APP_BASE_PATH=%~dp0
set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
echo starting sds-tps
java -Xverify:none %JAVA_OPTS% -cp %CP% %MAIN_CLASS%
goto :eof

rem 后台启动,并输出到指定文件,这里
:start2log
set APP_BASE_PATH=%~dp0
set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
echo starting sds-tps no-console to-log
javaw -Xverify:none %JAVA_OPTS% -cp %CP% %MAIN_CLASS% > %LOG_PATH%
goto :eof

rem 后台启动,不显示日志
:start2back
set APP_BASE_PATH=%~dp0
set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
echo starting sds-tps no-console
javaw -Xverify:none %JAVA_OPTS% -cp %CP% %MAIN_CLASS%
goto :eof


:stop
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo stopping sds-tps
for /f "tokens=1" %%i in ('jps -l ^| find "%MAIN_CLASS%"') do ( taskkill /F /PID %%i )
goto :eof


:restart
call :stop
call :start
goto :eof

endlocal & popd
pause
