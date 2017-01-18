# springJdbc

Sencillo tutorial de [spring-jdbc](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html).

# Tabla de contenidos
-----
1. [General](#general)
1. [Aproximación JDBC sin usar spring](#aproximación-jdbc-sin-usar-spring)
   * [Proyecto JdbcPlain](#proyecto-jdbcplain)
1. [Usando Spring JDBC](#usando-spring-jdbc)
   * [Proyecto JdbcSpring](#proyecto-jdbcspring)
   * [Modificando 1](#modificando-1)
   * [Modificando 2](#modificando-2)
   * [Reflexión 1](#reflexión-1)
   * [Propuesta 1](#propuesta-1)

# General
-----

Hay dos proyectos, ambos trabajan con datos de una BD MySQL

*En el primer proyecto* verás en el código Java JdbcPlainTest.java que los parámetros de la BD viene dados en la misma codificación. Cuando compiles este primer proyecto, tendrás que tener en cuenta indicar a la JVM mediante opción -cp el camino del conector MySQL, ya que es una dependencia (de otra forma el intérprete java no encontrará dicho file jar). Más abajo se describe como deberías crear la 'tabla user', necesitada en el proyecto.     

*El segundo proyecto es maven* por ello en el pom.xml verás la dependencia sobre MySQL, ya que spring-jdbc lo necesita, el componente que termina accediendo al servidor es el conector MySQL. Este proyecto, tal como se describe en otro apartado es un proyecto spring, por ello, hay varias dependencias en el pom.xml y alguna de ellas podría resultarte nueva.    
Tendrás que atender el contenido del ficheo src/main/resources/META-INF/spring/database.properties, adaptándolo con los parámetros de la BD existente en tu sistema. Tendrás que crear una BD en tu servidor MySQL, en nuestro caso su nombre db1, y necesitarán una tabla 'user'. La tabla user debe tener tres campos o columnas: id de tipo serial, first_name de tipo text y age de tipo int    

# Aproximación JDBC sin usar spring
-----

## Proyecto JdbcPlain
-----

Construimos el proyecto con

    mvn clean dependency:copy-dependencies package
    
Ejecutamos el proyecto mediante:

    java -cp target/spring-user-jdbc-0.1.0.BUILD-SNAPSHOT.jar:target/dependency/*:. aula114.spring.app.UserApp


# Usando Spring JDBC
-----

## Proyecto JdbcSpring
-----

_**Descripción**_: Proyecto que introduce como trabajar con la clase JdbcTemplate y concretamente realizando una [consulta](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html#jdbc-JdbcTemplate-examples) y posteriormente una insercción en la BD (grabar un objeto).

##### *Para jugar*

*Estamos en un proyecto spring*: tienes una configuración, en este caso el fichero applicationContext.xml en la carpeta META-INF, vemos que spring creará un objeto jdbcTemplate y un objeto dataSource. Estos objetos son los que necesitas en el método main.      

*Analizando la clase UserDAO*: También spring instancia un objeto de esta clase, viene llamado userDAO, está vez no se indica en XML en el ficheo de configuración, se ha utilizado la notación @Repository. Este objeto es utilizado en el método main, tal como puedes comprobar en app/UserApp

## Modificando 1
-----

*método main*: puedes comentar el uso del DAO, y realizar todo lo necesario manualmente, prescidiendo de la clase UserDAO.java


## Modificando 2
-----

*ampliando la clase UserDAO*: puedes codificar otros métodos, por el momento estaría resuelto la inserción de filas en una tabla de la BD y una consulta del tipo select sobre la tabla User.

## Reflexión 1
-----

¿Qué nos ofrece por lo que hemos visto, spring-jdbc?

## Propuesta 1
-----

Puedes trabajar en un proyecto web, usando spring-webmvc, teniendo en cuenta una estructura similar. En concreto podrías modificar el [proyecto spring 4 fast tutorial](https://github.com/jeromejaglale/spring4-tutorial) consiguiendo persistencia, en una BD MySQL y teniendo en cuenta el uso de Jdbc Template de Spring Framework, cuyo estudio estás iniciando aquí.



