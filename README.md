# 🐾 ADÓPTAME – Sistema de Gestión y Adopción de Animales

## 📌 Descripción del proyecto

**ADÓPTAME** es una aplicación de escritorio desarrollada en Java que tiene como objetivo facilitar la búsqueda, consulta y gestión de animales que se encuentran en busca de un hogar.

El sistema permite visualizar un catálogo de animales, consultar sus características, aplicar filtros de búsqueda y administrar sus registros mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

El proyecto utiliza una interfaz gráfica desarrollada con **Java Swing** y estructuras de datos como `ArrayList` y `HashMap` para organizar y gestionar la información.

Actualmente, los registros iniciales se encuentran definidos en un archivo Java independiente que funciona como fuente de datos del sistema.

---

## 🎯 Objetivo general

Desarrollar un prototipo de escritorio que permita administrar y consultar información de animales en adopción, facilitando su organización, búsqueda y visualización mediante una interfaz gráfica intuitiva.

## 🎯 Objetivos específicos

- Implementar una interfaz gráfica amigable utilizando Java Swing.
- Organizar la información de los animales mediante programación orientada a objetos.
- Incorporar estructuras de datos para almacenar y consultar registros.
- Implementar filtros por nombre, especie y disponibilidad.
- Permitir el registro, modificación y eliminación de animales.
- Facilitar la consulta de información detallada de cada animal.
- Separar los datos iniciales de la lógica principal del programa.

---

## ✨ Funcionalidades principales

### 🔐 1. Inicio de sesión

El sistema cuenta con una pantalla de acceso para el administrador.

**Credenciales de demostración:**

| Campo | Valor |
|---|---|
| Usuario | `admin` |
| Contraseña | `admin123` |

El acceso permite ingresar a la pantalla principal de la aplicación.

### 🏠 2. Catálogo de animales

Muestra los animales registrados mediante tarjetas individuales que incluyen:

- Fotografía del animal.
- Nombre.
- Especie.
- Raza.
- Edad.
- Estado de disponibilidad.
- Acceso a su ficha informativa.

### 🔎 3. Búsqueda y filtros

El sistema permite localizar animales utilizando diferentes criterios:

- **Búsqueda general:** nombre, ID, especie, raza, tamaño, características, salud, disponibilidad o edad.
- **Filtro por especie:** perro, gato u otro.
- **Filtro por disponibilidad:** disponible, adoptado o en observación.
- **Ordenamiento:** nombre alfabético, edad ascendente, edad descendente y tamaño.

También incluye una opción para limpiar los filtros y restablecer la búsqueda.

### 📋 4. Ficha del animal

Cada animal cuenta con una ficha que permite consultar su información detallada:

- Código de identificación.
- Nombre.
- Especie.
- Raza.
- Edad.
- Tamaño.
- Características.
- Estado de salud.
- Disponibilidad.
- Fotografía.

### ⚙️ 5. Gestión de animales (CRUD)

El sistema incorpora un módulo administrativo que permite gestionar los registros.

**Crear:** registrar nuevos animales mediante un formulario.

**Leer:** visualizar los registros existentes en una tabla.

**Actualizar:** modificar los datos de un animal seleccionado.

**Eliminar:** retirar un registro previa confirmación.

El formulario permite ingresar información como nombre, especie, raza, edad, tamaño, características, salud y disponibilidad.

### 🖼️ 6. Gestión de fotografías

Cada animal puede tener asociada una fotografía mediante una ruta de archivo.

Cuando no existe una imagen asociada, el sistema muestra una imagen de reemplazo.

Las fotografías se visualizan tanto en las tarjetas del catálogo como en las fichas individuales.

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Aplicación |
|---|---|
| Java | Lenguaje de programación principal. |
| Java Swing | Desarrollo de la interfaz gráfica. |
| AWT | Colores, dimensiones, fuentes y eventos gráficos. |
| ArrayList | Almacenamiento de la colección de animales. |
| HashMap | Búsqueda de animales mediante su identificador. |
| Programación orientada a objetos | Organización del sistema mediante clases y objetos. |
| VS Code | Entorno de desarrollo utilizado. |
| Git y GitHub | Control de versiones y almacenamiento del proyecto. |

---

## 📁 Estructura del proyecto

El proyecto utiliza dos archivos Java principales:

```text
ADOPTAME/
│
├── Adoptame.java
├── BaseDatos.java
└── README.md
```

### 1. Adoptame.java

Es el archivo principal del sistema. Contiene:

- La ventana principal.
- La pantalla de inicio de sesión.
- El catálogo de animales.
- Los filtros de búsqueda.
- Las tarjetas de visualización.
- Las fichas individuales.
- El módulo de gestión CRUD.
- La validación de formularios.
- La personalización visual de los componentes.
- La lógica de administración de los animales.

También contiene la clase interna `Animal`, que representa cada registro mediante sus atributos.

### 2. BaseDatos.java

Es el archivo encargado de proporcionar los registros iniciales del sistema.

Contiene 56 animales de ejemplo, cada uno con información como:

- Identificador.
- Nombre.
- Especie.
- Raza.
- Edad.
- Tamaño.
- Características.
- Estado de salud.
- Disponibilidad.
- Ruta de imagen.

Su método principal es:

```java
public static List<Adoptame.Animal> cargarAnimales()
```

Este método crea una lista, incorpora los registros iniciales y devuelve la colección a la clase principal.

**Importante:** `BaseDatos.java` funciona como una fuente de datos implementada en Java. No es una base de datos relacional ni utiliza un gestor externo como MySQL.

---

## 🧠 Arquitectura y funcionamiento interno

El sistema se organiza separando la información inicial de la lógica principal de la aplicación.

### 1. Modelo de datos: clase Animal

La clase `Animal` representa cada elemento del catálogo.

Sus atributos son:

| Atributo | Tipo | Descripción |
|---|---|---|
| id | int | Identificador del animal. |
| nombre | String | Nombre del animal. |
| especie | String | Tipo de animal. |
| raza | String | Raza o clasificación. |
| edad | int | Edad en años. |
| tamano | String | Tamaño del animal. |
| caracteristicas | String | Descripción de su comportamiento. |
| salud | String | Estado de salud. |
| disponibilidad | String | Estado de adopción. |
| rutaImagen | String | Ubicación de la fotografía. |

Cada registro se crea como un objeto independiente de esta clase.

### 2. Estructuras de datos

El sistema utiliza dos estructuras principales:

**ArrayList**

```java
private final List<Animal> animales = new ArrayList<>();
```

Almacena la colección completa de animales. Permite agregar, eliminar, recorrer y consultar sus elementos.

**HashMap**

```java
private final Map<Integer, Animal> indiceAnimales = new HashMap<>();
```

Organiza los animales utilizando su ID como clave y el objeto correspondiente como valor.

Por ejemplo:

```java
Animal a = indiceAnimales.get(3);
```

Esta instrucción permite recuperar el animal cuyo identificador es 3.

El uso de ambas estructuras facilita la administración de los registros y la búsqueda directa por identificador.

### 3. Carga de datos iniciales

Al iniciar la aplicación se ejecuta:

```java
private void cargarDatosIniciales() {
    animales.addAll(BaseDatos.cargarAnimales());

    for (Animal a : animales) {
        indiceAnimales.put(a.id, a);
    }

    siguienteId = animales.size() + 1;
}
```

Este procedimiento:

1. Obtiene los registros iniciales desde `BaseDatos.java`.
2. Los incorpora al `ArrayList`.
3. Recorre la colección y registra cada animal en el `HashMap`.
4. Establece el siguiente identificador disponible.

### 4. Organización de las pantallas

Se utiliza `CardLayout` para administrar las diferentes vistas de la aplicación.

Las pantallas principales son:

- `LOGIN`: inicio de sesión.
- `INICIO`: catálogo y búsqueda de animales.

Esto permite cambiar de una pantalla a otra sin necesidad de abrir una ventana independiente para cada sección.

### 5. Actualización de la galería

El método `actualizarGaleria()` procesa los criterios seleccionados por el usuario.

Su funcionamiento consiste en:

1. Obtener el texto de búsqueda.
2. Leer los filtros seleccionados.
3. Recorrer la colección de animales.
4. Comprobar qué registros cumplen los criterios.
5. Aplicar el ordenamiento seleccionado.
6. Generar nuevamente las tarjetas.
7. Actualizar el contador de resultados.

### 6. Gestión CRUD

El módulo administrativo trabaja directamente con las estructuras de datos principales.

- El registro crea un nuevo objeto `Animal`.
- La consulta muestra los registros en una tabla.
- La modificación actualiza los atributos del objeto seleccionado.
- La eliminación retira el objeto del `ArrayList` y del `HashMap`.

También se utiliza `validarFormulario()` para comprobar que los campos obligatorios estén completos y que la edad sea un número entero válido entre 0 y 100.

---

## ▶️ Instalación y ejecución

### Requisitos

- Tener instalado Java JDK.
- Contar con Visual Studio Code u otro entorno compatible.
- Tener los dos archivos `.java` en el mismo directorio.

### 1. Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

### 2. Entrar al directorio

```bash
cd ADOPTAME
```

### 3. Compilar el proyecto

```bash
javac -encoding UTF-8 Adoptame.java BaseDatos.java
```

### 4. Ejecutar la aplicación

```bash
java Adoptame
```

**Nota:** Es importante mantener ambos archivos en el mismo directorio para que `Adoptame.java` pueda utilizar la clase `BaseDatos`.

---

## 📸 Interfaz del sistema

En esta sección se pueden incorporar capturas de pantalla de las principales funcionalidades.

Se recomienda agregar imágenes de:

1. Pantalla de inicio de sesión.
2. Catálogo principal.
3. Filtros de búsqueda.
4. Ficha individual de un animal.
5. Módulo de gestión.
6. Formulario de registro y modificación.

Para agregar una captura al README, primero sube la imagen al repositorio y utiliza:

```markdown
![Pantalla principal](imagenes/catalogo.png)
```

---

## ⚠️ Limitaciones actuales

El proyecto corresponde a un prototipo funcional de escritorio y presenta algunas limitaciones:

- Los registros iniciales están definidos directamente en `BaseDatos.java`.
- No existe conexión con un gestor de bases de datos externo.
- Los cambios realizados durante la ejecución se almacenan en memoria.
- Los nuevos registros, modificaciones y eliminaciones no se conservan al cerrar el programa.
- Las fotografías se asocian mediante rutas de archivos locales, por lo que deben permanecer accesibles desde el equipo donde se ejecuta la aplicación.
- El acceso administrativo utiliza credenciales de demostración definidas en el código.

---

## 🚀 Posibles mejoras futuras

- Implementar una base de datos real mediante MySQL o SQLite.
- Incorporar persistencia para conservar los cambios realizados.
- Implementar gestión de usuarios y autenticación segura.
- Mejorar la administración de fotografías.
- Incorporar perfiles de refugios y responsables de adopción.
- Agregar un módulo para registrar solicitudes de adopción.
- Implementar mapas de veterinarias, refugios y tiendas de mascotas.
- Incorporar un sistema de seguimiento del proceso de adopción.

---

## 📚 Aprendizajes obtenidos

Durante el desarrollo de ADÓPTAME se aplicaron conocimientos de:

- Programación orientada a objetos.
- Creación y utilización de clases y objetos.
- Encapsulamiento y organización del código.
- Manejo de colecciones mediante `ArrayList`.
- Uso de mapas mediante `HashMap`.
- Implementación de operaciones CRUD.
- Desarrollo de interfaces gráficas con Java Swing.
- Manejo de eventos y componentes gráficos.
- Validación de datos.
- Separación de responsabilidades entre archivos.
- Organización y documentación de proyectos mediante GitHub.

---

## 👩‍💻 Autoría

**Proyecto académico: ADÓPTAME**

Desarrollado como proyecto de Ingeniería en Sistemas.

**Tecnología principal:** Java.

**Entorno de desarrollo:** Visual Studio Code.

---

## 📄 Licencia

Este proyecto fue desarrollado con fines académicos y educativos.
Todos los derechos reservados a JennyKCP.
