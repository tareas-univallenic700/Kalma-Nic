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
- **Primario**: #D46A3F (Terracota cálido)
- **Secundario**: #795548 (Marrón terroso)
- **Acentos**: #F57C00 (Naranja vibrante)
- **Fondo**: #F8E7DD (Beige suave)
- **Pasteles**: Verde, rosa, amarillo y azul suaves

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
