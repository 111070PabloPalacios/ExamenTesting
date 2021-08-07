#language:es

@Busqueda
Característica: Funcionalidad de poder buscar un pez

  @Parametros
  Esquema del escenario: Busqueda de mascota con parametros
    Dado en la pagina principal
    Cuando ingreso el <tipo_mascota>
    Entonces me redirige a los resultados
    Ejemplos:
      | tipo_mascota |
      | "Fish" |