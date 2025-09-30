@echo off
echo Limpiando cache y reinstalando Kalma...
echo.

REM Configurar JAVA_HOME
set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr
set PATH=%JAVA_HOME%\bin;%PATH%

echo 1. Limpiando cache de Gradle...
call gradlew.bat clean
echo.

echo 2. Limpiando cache de Android...
call gradlew.bat --stop
echo.

echo 3. Reconstruyendo proyecto...
call gradlew.bat assembleDebug
echo.

echo 4. Desinstalando version anterior (si existe)...
adb uninstall com.example.kalma_nic
echo.

echo 5. Instalando nueva versión...
adb install app\build\outputs\apk\debug\app-debug.apk
echo.

echo 6. Iniciando aplicación...
adb shell am start -n com.example.kalma_nic/.SplashActivity
echo.

echo ¡Instalación completada!
pause
