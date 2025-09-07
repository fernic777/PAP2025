@echo off
echo ========================================
echo    CREAR TABLAS INICIALES
echo    PAP2025 - Base de datos
echo ========================================
echo.

REM Configurar Java 17
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%\bin;%PATH%

echo Verificando Java...
java -version
echo.

echo Compilando proyecto...
call gradlew.bat build
if %ERRORLEVEL% neq 0 (
    echo Error al compilar el proyecto
    pause
    exit /b 1
)

echo.
echo Creando tablas en la base de datos...
call gradlew.bat crearTablas

echo.
echo Proceso completado.
pause
