@echo off
echo ========================================
echo    SISTEMA DE GESTION DE BIBLIOTECA
echo    PAP2025 - Ejecutando aplicacion...
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
echo Ejecutando aplicacion...
call gradlew.bat run

echo.
echo Aplicacion finalizada.
pause
