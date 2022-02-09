# **Prueba técnica caso de estudio Carvajal -ebusiness**
Actualmente en Carvajal está incursionando en el modelo e-commerce y dentro de sus productos B2C quiere agregar la opción Lista de deseos, donde agregará los productos que le gustaría comprar en un futuro.

Usted debe implementar una prueba de concepto, generando una aplicación web que cumpla con los siguientes requisitos funcionales:
1. Cuando el cliente ingrese, debe ver el catálogo de productos que ofrece Carvajal, indicando las cantidades existentes del mismo.
2. El cliente podrá listar, agregar, eliminar o actualizar los productos de su lista de deseos.
3. Sí cuando el cliente consulte su lista, alguno de sus deseos ya no se encuentra en stock, debe notificarle.
4. Debe almacenarse el histórico de registros que hayan llegado a la lista de deseos.

**Precondiciones**
- Asuma que el usuario ya existe y se encuentra autenticado en el sistema.
- Los productos deben contener: 

        ➢ Id
        ➢ Nombre
        ➢ Precio
        ➢ Cantidad en stock.
- Usted debe simular la información de los productos.

**Requisitos de la prueba de concepto:**

Es necesario implementar sobre el motor de base de datos relacional postgresql una base de datos que permita gestionar la información en referencia.

- La prueba debe ser realizada utilizando SpringBoot, gradle y Java 11
- La lógica de negocio se debe implementar mediante API-REST
- Debe crear la capa de persistencia mediante uso de ORM.
- Debe crear la interfaz gráfica en Angular. (no es necesario profundizar en UX)
- Crear un documento con el modelo entidad relación, diagrama de clases, diagrama de secuencia y pruebas unitarias.
- Es un plus agregar login.
- Es un plus agregar autenticación mediante username token al proyecto
- Es un plus manejar la arquitectura del proyecto basado en microservicios.
- Es un plus manejar un filtro de búsqueda sobre el listado de productos contemplando buenas prácticas para consultar información.
