#language: es
@InicioDeSesion
Característica: Funcionalidad de poder iniciar sesion

@Parametros
Esquema del escenario: Inicio de sesion con parametros
Dado en la pagina de inicio
Cuando ingreso el <User_Name> y <User_Pass>
Entonces me redirige a mi cuenta
Ejemplos:
| User_Name | User_Pass |
| "SheldonCooper" | "123456789" |