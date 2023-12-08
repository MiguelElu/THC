# THC
Resumen ejecutivo:
El software es desarrollado como una solucion para llevar el registro de los pacientes en un hospital veterinario. Al conectar un software con la base de datos permite el poder introducir y modificar informacion. El software requiere de uso de contraseña para poder acceder y una vez dentro se puede ejecutar todos los siguientes comandos: agregar usuario, agregar paciente, agregar registro,  modificar usuario, modificar paciente, modificar nota, desplegar pacientes, desplegar registros o cerrar session. 
Contenidos del README: 
1- Requerimientos
2- Instalación
3- Configuración
4- Uso
5- Contribución
6- Roadmap

Requerimientos:

Base de datos MYSQL 8.0

JDK 11

Intelij IDEA IDE

Adicional: mysql-connector-j-8.2.0.tar.gz"

Instalacion: 

Intelij : https://www.jetbrains.com/help/idea/installation-guide.html

MySQL: https://dev.mysql.com/downloads/installer/


Instalar tanto intelij como MYSQL siguiendo ya sea los pasos de la pagina web o del software de instalacion. una vez Innstalado Intelij se puede abrir el proyecto y este ya contiene el connector en su libreria. EN la parte del MYSQL es importante durante el proceso de isntalacion anotar los puertos utilizados porque seran neccesarios apra la configuracion del programa. para poder probar el progrmama dentro del ambiente de programacion sera neccesario adaptar las conexiones a la base de datos.

Configuración:

![image](https://github.com/MiguelElu/THC/assets/134980475/50184848-3e05-48b0-83b7-f59f17f47193)
Como muestra la imagen es neccesario que el puerto coincida con el codigo en la definicion de la clase de SQL. iguelmente al instalas MYSQL debe existir un usuario con nombre y contraseña test o sera neccesario ajustar los otros 2 parametros para que coincida con la base de datos a utilizar. La base de datos entonces debe ser construida con las sigiuentes tablas. Es importante mantener los formatos de column y nombres de tablas y base de datos en general. De lo contrario se tendra que alterar multiples partes del codigo.
![image](https://github.com/MiguelElu/THC/assets/134980475/4bc4a2b8-80d3-4fcf-804c-5ebf07ff37f0)
![image](https://github.com/MiguelElu/THC/assets/134980475/f6f1cbb5-4492-41d9-8faa-8bfa06a1a2bf)
![image](https://github.com/MiguelElu/THC/assets/134980475/a8d11b6b-06b3-453b-92a9-9c87b03355ee)


Uso

Para el administrador, antes de empezar a usar el software es neccesario agregar como minimo 1 registro a la tabla de users para poder iniciar session. Los registros de pacientes y registros puedes ser llenados desde el software y otros usuarios pueden ser agregados sin emabrgo para esto debe ya existir un usuario con el cual iniciar session. Ademas, si se hacen cambios al codigo sera neccesario hacer un nuevo build del JAR siguiendo estas instrucciones: https://www.jetbrains.com/help/idea/compiling-applications.html#compilation_output_folders

Para el usuario, el programa se puede inicializar desde el CDM al usar el comando java -jar + el nombre del .jar estando en la carpeta que contiene el file.

Contribucion:

En caso de desear contribuir, por favor usar la funcion de fork para crear la copia y crear una nueva branch contribuidor desde developer.

Roadmap:

Los siguientes pasos a tomar para seguir dessarrollando el programa sera agregar funciones de remover registros y pacientes.

