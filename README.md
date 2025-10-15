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
