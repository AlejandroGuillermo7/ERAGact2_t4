<div align="center">

# Instituto Tecnológico Nacional de México

### Instituto Tecnológico de Oaxaca

**Carrera:** Ingeniería en Sistemas Computacionales <br><br>
**Materia:** Programación Web<br><br>
**Actividad:** Act1. Introducción a Spring Boot — Configuración y Primeros Controladores <br><br>
**Docente:** Adelina Martínez Nieto<br><br>
**Integrante:** Enríquez Rodríguez Alejandro Guillermo<br><br>
**Fecha de entrega:** 16 de julio del 2026<br><br>

</div>

# Act1 T4 — Primeros controladores con Spring Boot

## Descripción del proyecto

Proyecto individual construido con **Java + Spring Boot**, que consiste en configurar el entorno de desarrollo, crear un proyecto base desde Spring Initializr, desarrollar controladores propios para atender peticiones web, y desplegarlo funcionando tanto en local como en el VPS del equipo.

## Endpoints

| Método | Ruta | Descripción | Controlador |
|---|---|---|---|
| GET | `/identificacion` | Regresa el nombre del proyecto y del autor | `InfoController` |
| GET | `/materias` | Regresa una lista simulada de materias cursadas | `InfoController` |
| GET | `/alumno` | Regresa un objeto con datos del estudiante (nombre, edad, semestre, carrera) | `DatosController` |

## Documentación técnica

### `@Controller` vs `@RestController`

Ambas anotaciones le indican a Spring que una clase maneja peticiones web, pero difieren en qué hacen con el valor que regresa el método:

- **`@Controller`**: el `String` que regresa el método se interpreta como el nombre de una vista (por ejemplo un HTML con Thymeleaf), y Spring busca esa plantilla para renderizarla.
- **`@RestController`**: lo que regrese el método (texto, `Map`, `List`, objetos) se envía directo como cuerpo de la respuesta HTTP. Si es un objeto o colección, Spring lo convierte automáticamente a JSON.

Este proyecto usa **`@RestController`** en ambos controladores, ya que los endpoints solo necesitan regresar texto y datos, no vistas HTML.

### Mapeo de rutas

Se usa la anotación `@GetMapping("/ruta")` sobre cada método, indicando la ruta como parámetro entre paréntesis. Por ejemplo:

```java
@GetMapping("/alumno")
public Map<String, Object> alumno() {
    ...
}
```

### Configuración del puerto

Por defecto, Spring Boot corre en el puerto 8080. Como el VPS es compartido con otro compañero de equipo, fue necesario asignar un puerto distinto para evitar que ambos proyectos chocaran al intentar usar el mismo puerto al mismo tiempo.

El puerto se configuró en `src/main/resources/application.properties`:

```properties
server.port=8082
```

Y se reforzó al ejecutar el `.jar` en el VPS:

```bash
nohup java -jar act1t4-0.0.1-SNAPSHOT.jar --server.port=8082 &
```

---

## Estructura del proyecto

```
ERAGact1_t4/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
├── .gitattributes
├── HELP.md
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/enriquez/act1t4/
    │   │       ├── Act1t4Application.java
    │   │       └── controllers/
    │   │           ├── InfoController.java
    │   │           └── DatosController.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/enriquez/act1t4/
            └── Act1t4ApplicationTests.java
```

---

## Cómo correr el proyecto localmente

1. Clonar el repositorio:
```bash
git clone https://github.com/AlejandroGuillermo7/ERAGact1_t4.git
cd ERAGact1_t4
```

2. Ejecutar con el wrapper de Maven:
```bash
./mvnw spring-boot:run
```

3. Probar los endpoints en el navegador:
```
http://localhost:8082/identificacion
http://localhost:8082/materias
http://localhost:8082/alumno
```

---

## Despliegue en el VPS

1. Compilar el proyecto en un `.jar`:
```bash
./mvnw clean package
```

2. Subir el `.jar` al VPS:
```bash
scp target/act1t4-0.0.1-SNAPSHOT.jar root@67.207.87.232:/root/
```

3. Ejecutar en el servidor con `nohup` (para que quede corriendo en segundo plano):
```bash
nohup java -jar act1t4-0.0.1-SNAPSHOT.jar --server.port=8082 &
```

4. Abrir el puerto en el firewall:
```bash
sudo ufw allow 8082
```

---

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot** — framework para construir la aplicación web
- **Maven** — gestión de dependencias y build del proyecto
- **Visual Studio Code** — entorno de desarrollo, con Extension Pack for Java y Spring Boot Extension Pack
- **Git / GitHub** — control de versiones

---

## Ver en vivo

🔗 **Repositorio:** https://github.com/AlejandroGuillermo7/ERAGact1_t4

🔗 **Proyecto corriendo en el VPS:**
- http://67.207.87.232:8082/identificacion
- http://67.207.87.232:8082/materias
- http://67.207.87.232:8082/alumno

---

## Autor

**Alejandro Guillermo Enríquez Rodríguez**
Estudiante de Ingeniería en Sistemas Computacionales — Instituto Tecnológico de Oaxaca