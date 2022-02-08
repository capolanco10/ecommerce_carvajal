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

![modeloDatos_User-management-services.png](/.attachments/modeloDatos_User-management-services-88e7a41a-11aa-4e18-82ad-46cea535f250.png)


**Modelo de Interacción de componentes**

![user-management-services-diagrama de componente.png](/.attachments/user-management-services-diagrama%20de%20componente-e7060d17-a8e1-4d78-870b-804b7377f342.png)


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

 - Configuración Imagen y contenedor **DOCKER** para **postgresql**
 1. Ubicarse en la raíz del proyecto y correr el comando.
	> `docker build -t ecommerce_manager_postgresql .`
	> 
	> `docker run -d -p 5432:5432 ecommerce_manager_postgresql`

---
