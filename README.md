# springJdbc

Sencillo tutorial de [spring-jdbc](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html).

# Tabla de contenidos
-----
1. [Aproximación JDBC sin usar spring](#aproximaciónJDBCsinusarspring)
   * [Proyecto JdbcPlain](#proyectojdbcplain)
1. [Usando Spring JDBC](#usandospringjdbc)
   * [Proyecto JdbcSpring](#proyectojdbcspring)
   * [Modificando 1](#modificando1)
   * [Modificando 2](#modificando2)
   * [Reflexión 1](#reflexion1)
   * [Propuesta 1](#propuesta1)

-----

# Aproximación JDBC sin usar spring
-----

Nuestro poryecto trabaja con datos de una BD MySQL, por ello en el POM.xml verás la dependencia sobre la misma, ya que spring-jdbc lo necesita, el componente que termina accediendo al servidor es el conector MySQL.

Tendrás que atender el contenido del ficheo src/main/resources/META-INF/spring/database.properties, adáptalo con los parámetros de la BD existente en tu sistema. Tendrás que crear una BD en tu servidor MySQL, en nuestro caso su nombre db1, y necesitarán una tabla 'user'. La tabla user debe tener tres campos o columnas: id de tipo serial, first_name de tipo text y age de tipo int 

Construimos el proyecto con

    mvn clean dependency:copy-dependencies package
    
Ejecutamos el proyecto mediante:

    java -cp target/spring-user-jdbc-0.1.0.BUILD-SNAPSHOT.jar:target/dependency/*:. aula114.spring.app.UserApp


# Usando Spring JDBC
-----

## Proyeco JdbcSpring
-----

_**Descripción**_: Proyecto que introduce como trabajar con la clase JdbcTemplate y concretamente realizando una [consulta](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html#jdbc-JdbcTemplate-examples) y psoteriormente una insercción en la BD (grabar un objeto).

##### *Para jugar*

*Estamos en un proyecto spring*: tienes una configuración, en este caso el fichero applicationContext.xml en la carpeta META-INF, vemos que spring creará un objeto jdbcTemplate y un objeto dataSource. Estos objetos son los que necesitas en el método main.      

*Analizando la clase UserDAO*: También spring instancia un objeto de esta clase, viene llamado userDAO, está vez no se indica en XML en el ficheo de configuración, se ha utilizado la notación @Repository. Este objeto es utilizado en el método main, tal como puedes comprobar en app/UserApp.java

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



