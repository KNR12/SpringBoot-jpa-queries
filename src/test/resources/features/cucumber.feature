Feature: Evaluate percentage

  Scenario: Verify 10% offer
    Given Execute DiscountService Business
    When if i will enter 5001
    Then we should get ten percentage discount

  Scenario: Verify 15% offer
    Given Execute DiscountService Business
    When if i will enter 11
    Then we should get ten percentage discount



