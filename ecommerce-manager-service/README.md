**Versión:** V1.0
**Fecha publicación:** 08 de Febrero del 2022

# **CONTEXTO**

Actualmente en Carvajal está incursionando en el modelo e-commerce y dentro de sus productos B2C quiere agregar la opción Lista de deseos, donde agregará los productos que le gustaría comprar en un futuro.


# Ecommerce-Management-Service

# ALCANCE

implementar una prueba de concepto, generando una aplicación web que cumpla con los siguientes requisitos funcionales:

 1. Cuando el cliente ingrese, debe ver el catálogo de productos que ofrece Carvajal, indicando las cantidades existentes del mismo.
 2. El cliente podrá listar, agregar, eliminar o actualizar los
    productos de su lista de deseos.
 3. Sí cuando el cliente consulte su lista, alguno de sus deseos ya no
    se encuentra en stock, debe notificarle.
 4. Debe almacenarse el histórico de registros que hayan llegado a la
    lista de deseos.

**Modelo de datos:**

![Diagrama de datos](https://github.com/capolanco10/ecommerce_carvajal/blob/main/resources/diagrama_datos.png)

---
# PRERREQUISITOS
 **Instalación de Tecnologías**
- JDK 11
- Docker
- Spring boot
- Lombok.jar

---
# CAPACIDADES

[Documentación capacidades con swagger](http://localhost:9000/api/v1/ecommercemanager/swagger-ui.html "Documentación capacidades con swagger")

---
# CONFIGURACIÓN 
 - Compilar el proyecto **ecommerce-manager-service**
 1. Ubicarse en la raíz del **Proyecto** y correr el comando.
        > `./gradlew clean build`

 - Configuración Imagen y contenedor **DOCKER** para **postgresql y ecommerce-manager-service**
 1. Ubicarse en la raíz del **repositorio** y correr el comando.
	> `docker-compose up`

---
