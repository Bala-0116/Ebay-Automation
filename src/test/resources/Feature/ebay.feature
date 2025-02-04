Feature: Ebay web browser Automation

  @ebay
Scenario: Ebay book add to cart flow
  Given a user opens a ebay website
  When he search the book
  And adds the book to cart
  Then checks whether it's added to the cart