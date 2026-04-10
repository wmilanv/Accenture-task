
@ECHO OFF
SET MAVEN_PROJECTBASEDIR=%~dp0
SET WRAPPER_DIR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper
SET WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar

IF NOT EXIST "%WRAPPER_JAR%" (
  ECHO Downloading Maven Wrapper...
  powershell -Command "Invoke-WebRequest https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar -OutFile '%WRAPPER_JAR%'"
)

java -jar "%WRAPPER_JAR%" %*
