Información general 1.0

Hemos elegido un concesionario para este proyecto, ya que permite gestionar de manera eficiente un inventario de coches, facilitando la organización y manipulación de datos relevantes como modelos, precios, y características, lo que es ideal para aplicar el patrón MVC con JAXB para manejar la información de forma estructurada en un documento XML.

Se entregará la siguiente documentación: Explicación del documento XML creado.
Explicación del reparto de las tareas entre los miembros del grupo y justificación de este reparto.


Arquitectura del Proyecto 2.0

Vista
Menú (“Interfaz si nos da tiempo)
Consultas
Leer el documento.
Añadir un elemento al documento.
Borrar un elemento del documento.
Modificar un elemento del documento.
(Se añadirán varias más)

Modelo
XML
(archivo adjunto xml)
 Clases de Java
Concesionario
String nombre
String CEO
List<Sucursal> listaSucursal
Sucursal
int id
Empleado jefe
String localizacion
int telefono 
List<Empleado>
List<Coche>
Empleado
(Atributo solo de Java) int idSucursal = sucursal.id
int id
String nombre
String apellidos
String DNI
Puesto enum
int telefono
String correo
double sueldo
Date f_contrato 
Coches
(Atributo solo de Java) int idSucursal = sucursal.id
int id
Marca enum
String modelo
Date fchFabricacion
precio double
String color
int num_puertas
Combustible enum 
Controlador
Crear
coche
empleado
(Si da tiempo sucursal)
Leer
concesionario
todo
sucursal
información general
por id
cantidad de coches
cantidad de empleados
empleado
id
Puesto
saldo [rango <>=]
sucursal
coche
marca
id
stock ->  contador búsqueda por nombre modelo y idSucursal
puertas
combustible
fecha (fchFabricacion)
precio [rango <>=]


Actualizar
empleados
coches
editar atributos sucursal
Eliminar

