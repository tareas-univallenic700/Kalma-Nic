# Kalma - App de Bienestar Emocional

## Descripción
Kalma es una aplicación móvil diseñada para el bienestar emocional, con un enfoque en el seguimiento del estado de ánimo y ejercicios de relajación. La app cuenta con una mascota principal, un panda rojo, que acompaña al usuario en su viaje hacia el bienestar.

## Características Principales

### 🎨 Diseño
- **Paleta de colores**: Inspirada en tonos cálidos y terrosos que transmiten calma y serenidad
- **Mascota principal**: Panda rojo personalizado que interactúa con el usuario
- **Interfaz moderna**: Diseño Material Design 3 con animaciones suaves

### 📱 Funcionalidades
- **Seguimiento de estado de ánimo**: Registro diario con 5 estados diferentes
- **Ejercicios de respiración**: Botón para iniciar sesiones de relajación
- **Navegación intuitiva**: 4 secciones principales (Inicio, Ejercicios, Progreso, Comunidad)
- **Animaciones interactivas**: El panda rojo responde a las acciones del usuario

### 🎯 Estados de Ánimo
- 😊 Feliz
- 😐 Neutral  
- 😢 Triste
- 😰 Ansioso
- 😌 Relajado

## Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal
- **Android SDK**: Framework nativo de Android
- **Material Design 3**: Sistema de diseño moderno
- **View Binding**: Para acceso seguro a las vistas
- **Vector Drawables**: Iconografía personalizada

## Estructura del Proyecto
```
app/
├── src/main/
│   ├── java/com/example/kalma_nic/
│   │   ├── LoginActivity.kt         # Pantalla de acceso con cuentas demo
│   │   ├── MainActivity.kt          # Actividad principal
│   │   └── SplashActivity.kt        # Pantalla de bienvenida
│   ├── res/
│   │   ├── drawable/                # Recursos gráficos
│   │   ├── layout/                  # Diseños de pantallas
│   │   ├── menu/                    # Menús de navegación
│   │   └── values/                  # Colores, strings, temas
│   └── AndroidManifest.xml          # Configuración de la app
```

## Paleta de Colores
- **Primario**: #E46727 (Naranja energizante inspirado en el panda rojo)
- **Primario claro**: #F9D7B4 (Durazno suave para superficies elevadas)
- **Secundario**: #794023 (Marrón cálido y acogedor)
- **Secundario claro**: #F6E2CF (Beige cremoso para tarjetas y fondos)
- **Acentos**: Verdes, rosas, amarillos y azules pastel que transmiten calma

## Contexto y objetivos
- **Bienestar juvenil**: Kalma se enfoca en adolescentes que necesitan apoyo accesible para gestionar ansiedad y autocuidado.
- **Objetivo general**: Ofrecer herramientas digitales que reduzcan la ansiedad, fortalezcan la autorregulación emocional y motiven hábitos saludables.
- **Objetivos específicos**:
  - Ejercicios guiados de respiración, relajación y mindfulness.
  - Rutinas personalizadas con recordatorios positivos diarios.
  - Registro y análisis de emociones mediante emojis y notas.
  - Gráficos y registros para visualizar la evolución emocional.
  - Interfaz clara, amigable y atractiva que motive el uso constante.
- **KalBot**: Chatbot empático que recibe al usuario, registra su estado de ánimo, sugiere recursos y refuerza la constancia con mensajes motivacionales.
- **Panorama nacional**: En Nicaragua, los diagnósticos de ansiedad reportados por el MINSA crecieron de 6,748 casos (2017) a 24,742 casos (2024), lo que refuerza la necesidad de recursos como Kalma.

## Instalación y Uso
1. Clona el repositorio
2. Abre el proyecto en Android Studio
3. Sincroniza las dependencias de Gradle
4. Ejecuta la aplicación en un dispositivo o emulador

### Acceso y cuentas
- **Pantalla de login:** tras la animación inicial se presenta un formulario para ingresar con cuentas de demostración.
- **Credenciales demo disponibles:**
  - abril.jimenez@kalma.app / Kalma123
  - carlos.martinez@kalma.app / Kalma123
  - estefany.rojas@kalma.app / Kalma123
  - leonardo.perez@kalma.app / Kalma123
  - marcela.garcia@kalma.app / Kalma123
- Tras iniciar sesión, el nombre del usuario se muestra en la pantalla principal y se habilitan las secciones del menú inferior.

## Pruebas y verificación
- `./gradlew lint`: Ejecuta las comprobaciones de lint de Android. Requiere que el SDK de Android esté instalado y configurado en la variable de entorno `ANDROID_HOME` o en `local.properties` como `sdk.dir`. Si no está presente, la tarea fallará antes de analizar el código.
- `./gradlew assembleDebug`: Genera un APK ejecutable. Al igual que la tarea de lint, depende de tener un SDK válido y un emulador o dispositivo configurado.

> En entornos de CI o contenedores sin acceso al SDK, es normal que `gradle lint` o `assembleDebug` fallen. Esto no indica un problema con el código fuente, sino una falta de dependencias del sistema.

### Instalación rápida del SDK de Android (Linux)
Si necesitas preparar el entorno manualmente, estos pasos instalan las herramientas de línea de comandos en `~/android-sdk` y configuran las variables requeridas:

```bash
mkdir -p ~/android-sdk/cmdline-tools
cd ~/android-sdk
curl -L -o commandlinetools.zip https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
unzip commandlinetools.zip -d cmdline-tools
mv cmdline-tools/cmdline-tools cmdline-tools/latest
export ANDROID_SDK_ROOT="$PWD"
yes | ~/android-sdk/cmdline-tools/latest/bin/sdkmanager "platform-tools" "platforms;android-35" "build-tools;35.0.0"
```

Después de la instalación, crea (o actualiza) `local.properties` con la ruta del SDK:

```properties
sdk.dir=/home/tu_usuario/android-sdk
```

En contenedores sin acceso a internet (como el utilizado en estas pruebas) la descarga del SDK puede responder con `HTTP/1.1 403 Forbidden`. En ese caso no es posible completar la instalación dentro del entorno aislado y se recomienda ejecutar los comandos anteriores en una máquina local con conexión.

## Próximas Funcionalidades
- [ ] Ejercicios de respiración interactivos
- [ ] Gráficos de progreso del estado de ánimo
- [ ] Notificaciones de bienestar diarias
- [ ] Comunidad de usuarios
- [ ] Meditaciones guiadas
- [ ] Base de datos local para persistencia

## Contribución
Este proyecto está en desarrollo activo. Las contribuciones son bienvenidas para mejorar la experiencia del usuario y agregar nuevas funcionalidades.

## Licencia
Proyecto desarrollado para fines educativos y de bienestar emocional.
