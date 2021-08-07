#language:es

@CompraDeMascota
Característica: Funcionalidad de comprar mascota

  @Parametros
  Esquema del escenario: Compra de mascotas
    Dado en la main page
    Cuando incio sesion con <User_Name> y <User_Pass> y luego ingresar <nombreMascota>
    Entonces la compra se realizo con exito
    Ejemplos:
      | User_Name | User_Pass | nombreMascota |
      | "testserenity" | "123456" | "Fish" |