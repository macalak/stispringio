@echo off
REM Clean script operatin on all projects in current folder

del  /F /S /Q *.ipr *.iml *.iws .classpath .project  2> null 
for /f "tokens=*" %%G  in ('DIR /a:d /b m*') do (
   
     rmdir /S /Q "%~dp0%%G\.gradle" 2> null
	 rmdir /S /Q "%~dp0%%G\.settings" 2> null
	 rmdir /S /Q "%~dp0%%G\bin" 2> null
	 rmdir /S /Q "%~dp0%%G\.idea" 2> null
	 rmdir /S /Q "%~dp0%%G\build_gradle" 2> null
   
)

