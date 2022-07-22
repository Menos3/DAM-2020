Feature: Avaluador de Personalitzacio
  Com usuari del sistema
  Necessito poder modificar les meves dades sempre que vulgi.


  Scenario Outline: Les dades s han modificat correctament
    Given  Donat l avaluador de personalitzacio
    When   Quan l usuari  les modifica les  dades correctament <login>
    Then   L usuari modifica les dades

    Examples:
      |login |nom |cognoms |mail |telefon |
