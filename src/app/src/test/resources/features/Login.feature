Feature: Avaluador de Login
  Com usuari del sistema
  Necessitio accedir d una manera segura
  Per poder treballar

 Scenario Outline: Entrada correcta al sistema
    Given   Donat l avaluador de login
    When    Quan l usuari introdueix les dades correctament <usuari> <password>
    Then    L usuari accedeix al sistema

    Examples:
      |usuari |password|
      |bgates |  pass  |
      |pnorton|  pass  |
      |emusk  |  pass  |


  Scenario Outline: Entrada incorrecta al sistema
    Given   Donat l avaluador de login
    When    Quan l usuari introdueix les dades malament <usuari> <password>
    Then    L usuari no accedeix al sistema

    Examples:
      |usuari    |password|
      |bgates    |  pass  |
      |pnorton   |  pass  |
      |emusk     |  pass  |
      |noexisteix|  pass  |

    Scenario Outline: Bloqueig de compte

      Given Donat l avaluador de login
      When Quan l usuari introdueix les dades malament <usuari> <password>
      Then Compte bloquejat

      Examples:
      |usuari |password|
      |bgates |  pass  |
      |pnorton|  pass  |
      |emusk  |  pass  |