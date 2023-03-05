Feature: Calculate delivery

  Scenario: Calculate delivery without all required fields
    Given I am on the main page
    When I click on Вартість доставки
    Then I redirected to page with title Вартість доставки
    When I select Місто-відправник as 'Київ'
    And I select Місто-отримувач as Київ
    And I click on Розрахувати вартість button
    Then Input field Оголошена вартість highlighted in red
    And Input field Вага highlighted in red
    And Input field Довжина highlighted in red
    And Input field Ширина highlighted in red
    And Input field Висота highlighted in red

  Scenario Outline: Calculate delivery without all required fields
    Given I am on the main page
    When I click on Вартість доставки
    Then I redirected to page with title Вартість доставки
    When I select Місто-відправник as '<senderCity>'
    And I select Місто-отримувач as '<deliveryCity>'
    And I enter Оголошена вартість as '1000'
    And I enter Вага as '<weight>'
    And I enter Довжина as '1'
    And I enter Ширина as '1'
    And I enter Висота as '1'
    And I click on Розрахувати вартість button
    Then I get Разом: '<expected_result>'

    Examples:
      | senderCity | deliveryCity | weight | expected_result      |
      | Вінниця    | Київ         | 3      | 105.00 ... 175.00грн |
      | Київ       | Львів        | 60     | 425.00 ... 625.00грн |
      | Дніпро     | Вінниця      | 20     | 145.00 ... 215.00грн |
