# ⚙️ Programación de Servicios y Procesos (DAM) - Concurrencia y Hilos

![Estado del Curso](https://img.shields.io/badge/Curso-2º%20DAM-blue?style=flat-square)
![Lenguaje Principal](https://img.shields.io/badge/Lenguaje-Java-red?style=flat-square)
![Conceptos](https://img.shields.io/badge/Conceptos-Hilos%20%7C%20Sincronizaci%C3%B3n-critical?style=flat-square)
![Licencia](https://img.shields.io/badge/Licencia-MIT-green?style=flat-square)

---

## ✨ Introducción al Repositorio

Este repositorio recoge las prácticas y el código desarrollado en la asignatura de **Programación de Servicios y Procesos (PSP)**. El temario se centra en la **programación concurrente y paralela**, fundamental para crear aplicaciones eficientes y con capacidad de respuesta.

Exploramos la gestión de tareas asíncronas, la comunicación entre procesos y la correcta sincronización para evitar problemas de concurrencia.

### 🎯 Contenidos Clave:

* **Creación de Hilos (*Threads*):** Implementación de la interfaz `Runnable` y extensión de la clase `Thread` en Java.
* **Sincronización:** Uso de `synchronized`, *locks* y semáforos para proteger recursos compartidos.
* **Procesos:** Gestión de procesos externos y comunicación entre ellos.
* **Pools de Hilos:** Uso de `ExecutorService` para la gestión eficiente de recursos.
* **Servicios:** Creación y manejo de servicios del sistema (dependiendo del temario).

---

## 🛠️ Tecnologías Clave y Conceptos

| Tecnología | Descripción |
| :--- | :--- |
| **Java** | Lenguaje de programación principal utilizado para desarrollar todas las funcionalidades de concurrencia y comunicación. |
| **Threads (Hilos)** | Unidad básica de ejecución concurrente, desde la creación simple hasta la gestión avanzada. |
| **Sincronización (Monitores & Locks)** | Mecanismos para gestionar el acceso a recursos compartidos (como `wait()`, `notify()`/`notifyAll()`) y clases como `ReentrantLock` y `Semaphore`. |
| **Sockets (TCP/UDP)** | Implementación de la comunicación en red entre procesos, incluyendo aplicaciones de cliente-servidor como chats. |

---


## 📚 Contenido y Progreso del Módulo PSP

| Carpeta | Descripción | Estado |
| :--- | :--- | :--- |
| **`Hilos`** | Código de ejercicios básicos de creación e inicio de múltiples hilos (Copias del temario). | ✅ Completado |
| **`Hilos_Ejercicios`** | Soluciones y código propio desarrollado por mí, incluyendo ejercicios de **Sincronización** y **Pruebas de Validación** de este tema. | ✅ Completado |
| **`Comunicaciones`** | Ejercicios de base sobre comunicación en la red "TCP/UDP" (Copias del temario). | ✅ Completado |
| **`Comunicaciones_Ejercicios`** | Soluciones propias de la comunicación en red, incluyendo ejemplos de **Chats TCP/UDP** y una **Prueba de Validación** de este tema. | ✅ Completado |
| **`Examenes_Finales`** | Carpeta destinada a incluir el **Proyecto Final** o simulacros de examen. | ⏳ Pendiente |

---

## 🚀 Instalación y Ejecución

Para ejecutar los ejemplos de este repositorio:

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/BudzowskiPiotrek/ProgramacionServiciosProcesos.git](https://github.com/BudzowskiPiotrek/ProgramacionServiciosProcesos.git)
    ```
2.  **Abre en tu IDE (IntelliJ IDEA o Eclipse):**
    * Importa la carpeta del proyecto como un proyecto Java estándar.
3.  **Ejecuta la clase principal (`main`)** de la práctica que desees probar para ver la concurrencia en acción.

---

## 👤 Autor

Desarrollado por [BudzowskiPiotrek](https://github.com/BudzowskiPiotrek) como parte de mi formación en DAM.

¡Las contribuciones y sugerencias para mejorar las implementaciones de concurrencia son bienvenidas!
