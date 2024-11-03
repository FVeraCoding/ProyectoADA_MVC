# Gestión de Concesionario de Coches

**Descripción**: Aplicación para la gestión de coches y empleados en un concesionario. Utiliza JAXB para el procesamiento de archivos XML, facilitando la persistencia y manipulación de datos sobre vehículos y empleados.

## Índice

- [Descripción](#descripción)
- [Características](#características)
- [Instalación](#instalación)

## Descripción

Esta aplicación permite gestionar el inventario de coches y el registro de empleados de un concesionario. Utiliza **JAXB (Java Architecture for XML Binding)** para realizar el mapeo de datos entre objetos Java y documentos XML, lo que facilita el almacenamiento, carga y actualización de la información del concesionario en formato XML.

## Características

- **Gestión de coches**: Agrega, elimina y actualiza los detalles de los coches disponibles en el concesionario, como marca, modelo, año y precio.
- **Gestión de empleados**: Registra, actualiza y elimina empleados, manteniendo información como nombre, cargo y fecha de contratación.
- **Persistencia en XML**: Guarda y carga todos los datos en archivos XML para facilitar la manipulación y el almacenamiento estructurado.
- **Interfaz amigable**: Aplicación de consola que permite a los usuarios interactuar fácilmente con las funciones de gestión.

## Instalación

Asegúrate de tener [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado. Luego, clona el repositorio y compila el proyecto.

```bash
# Clona este repositorio
git clone https://github.com/usuario/gestion-concesionario.git

# Entra en el directorio del proyecto
cd gestion-concesionario

# Compila el proyecto
javac -d bin -sourcepath src src/Main.java

# Ejecuta la aplicación
java -cp bin Main
