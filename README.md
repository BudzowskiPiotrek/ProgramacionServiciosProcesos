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

## 🛠️ Tecnologías y Conceptos

| Tecnología | Descripción |
| :--- | :--- |
| **Java** | Lenguaje de programación utilizado para la concurrencia. |
| **Threads (Hilos)** | Unidad básica de ejecución concurrente. |
| **Sincronización** | Mecanismos para gestionar el acceso a recursos compartidos (`wait()`, `notify()`). |
| **Java Concurrency API** | Utilidades avanzadas como `Executors`, `Callable` y `Future`. |
| **Sistema Operativo** | Interacción con el SO para la gestión de procesos. |

---

## 📂 Estructura de Proyectos

Cada carpeta en este repositorio está dedicada a un concepto o práctica específica de PSP.

| Carpeta | Descripción | Estado |
| :--- | :--- | :--- |
| **`01_Hilos_Basicos`** | Ejercicios de creación e inicio de múltiples hilos. | ✅ Completado |
| **`02_Sincronizacion`** | Problemas del productor/consumidor y el lector/escritor utilizando *locks* y *monitors*. | ⚙️ En Curso |
| **`03_Pools_Executors`** | Uso de *Thread Pools* para optimizar la ejecución de tareas. | ⚙️ En Curso |
| **`04_Comunicaciones`** | Ejercicios de comunicación entre procesos (Pipes, Sockets). | ⏳ Pendiente |
| **`ProyectoFinal_PSP`** | Proyecto práctico que implementa múltiples hilos y sincronización. | ⏳ Pendiente |

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
