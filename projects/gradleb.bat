@echo off
REM Gradle batch script operatin on all projects in current folder

REM CALL :NORMALIZEPATH "..\jdk1.8.0_45"
REM SET JAVA_HOME=%RETVAL%

for /f "tokens=*" %%G  in ('DIR /a:d /b m*') do (
   echo Processing project  "%~dp0%%G"
   if exist "%~dp0%%G\gradlew.bat" (
     echo Executing  "%~dp0%%G\gradlew %*"
     cd "%~dp0%%G" 
     "%~dp0%%G\gradlew.bat" %* 
     cd "%~dp0"
   ) else (
     echo Executing  "Nothing to do..."
   )
)

:: ========== FUNCTIONS ==========
EXIT /B

:NORMALIZEPATH
  SET RETVAL=%~dpfn1
EXIT /B