Feature: Agrear un nuevo post
  Como usuario del aplicativo web
  Quiero escribir un nuevo post
  Para expresar mi opinión y compartir contenido en el aplicativo

  #autor: Daniel Chaparro

  Background:
    Given que el usuario esta autenticado en el aplicativo web

    @testpost
  Scenario: Agregar un nuevo post exitosamente
    When se hace una solicitud Post para agregar un nuevo post
    Then el código de respuesta de estado debería ser 201
    And la respuesta debería incluir y validar la información del post creado
