@ECHO off
CLS

:ProjectStart
ECHO.
ECHO 1. Clean the project
ECHO 2. Build the project
ECHO 3. Run the project
ECHO 4. Erase console
ECHO 5. Stop the project

SET choice=
SET /p choice=Type the operation to perform: 
IF NOT '%choice%'=='' SET choice=%choice:~0,1%
IF '%choice%'=='1' GOTO CleanProject
IF '%choice%'=='2' GOTO BuildProject
IF '%choice%'=='3' GOTO RunProject
IF '%choice%'=='4' GOTO ConsoleReset
IF '%choice%'=='5' GOTO ProjectStop
ECHO "%choice%" invalid, please try again !
ECHO.
GOTO ProjectStart

:CleanProject
ECHO Cleaning project ...
//TODO: Changer chemin absolu en relatif
call mvn clean -f "E:\Github\minecraft-plugin_BetterServer\pom.xml"
GOTO ProjectStart

:BuildProject
//TODO: Changer chemin absolu en relatif
ECHO Building project ...
call mvn install -f "E:\Github\minecraft-plugin_BetterServer\pom.xml"
IF NOT EXIST "./deps/plugins" MKDIR "./deps/plugins" ELSE DEL /Q /F "./deps/BetterServer-0.0.1-b.jar"
MOVE /Y "%cd%\build\BetterServer-0.0.1-b.jar" "./deps/plugins/"
GOTO ProjectStart

:RunProject
ECHO Running project ...
CD "./deps/"
CALL runServer
CD "../"
GOTO ProjectStart

:ConsoleReset
ECHO Cleaning console ...
CLS
GOTO ProjectStart

:ProjectStop
ECHO Ending project ...
PAUSE