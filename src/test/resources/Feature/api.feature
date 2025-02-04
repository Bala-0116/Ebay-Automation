Feature: Validate CoinDesk API Response

  Background:
    * url 'https://api.coindesk.com/v1/bpi/currentprice.json'

  @get
  Scenario: Validate BPI currencies and GBP description
    Given url 'https://api.coindesk.com/v1/bpi/currentprice.json'
    When method GET
    Then status 200
    And match response.bpi contains { USD: '#present', GBP: '#present', EUR: '#present' }
    And match response.bpi.GBP.description == 'British Pound Sterling'