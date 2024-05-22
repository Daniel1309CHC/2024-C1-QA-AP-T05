Feature: Consultar usuarios Api Rest
  Como administrador del aplicativo web
  Quiero consultar la información de los usuarios
  Para gestionar sus perfiles y datos

  #autor: Daniel Chaparro

  Background:
    Given que el administrador tiene acceso al sistema

  @getUsers
  Scenario Outline: Consultar usuarios existentes por ID
    When hace una solicitud GET para buscar el usuario con <id>
    Then la respuesta debería tener el código de estado 200
    And la respuesta debería incluir la información del usuario con ID <id>
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |

  @getUser
  Scenario: Consultar un usuario existente por ID
    When hace una solicitud GET para buscar el usuario con id 1
    Then la respuesta debería tener el código de estado 200
    And la respuesta debería incluir la información del usuario
      | id | name            | username | email             | phone                  | website         |
      | 1  | Leanne Graham   | Bret     | Sincere@april.biz | 1-770-736-8031 x56442  | hildegard.org   |
