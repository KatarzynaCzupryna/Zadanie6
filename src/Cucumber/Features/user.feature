@registration
Feature: Create many users

  Scenario Outline: Register new users
    Given I'm on the shop page
    When I click on "Sign in" button
    Then I click "No account" button
    And I fill in new account form using data Social Title "<SocialTitle>" First name "<FirstName>" Last Name "<LastName>" email "<Email>" Password "<Password>" Birthdate "<Birthdate>"
    Then I check on "Customer data privacy" box and "Agreement" box
    And I can click on "Save" button
    When I enter my account and I click "Add first address"
    And  I enter new: alias "<alias>" Address "<Address>" City "<City>" PostalCode "<PostalCode>" Country "<Country>" Phone "<Phone>"
    Then I save
    Then I quit


    Examples:
      | SocialTitle | FirstName | LastName | Email | Password | Birthdate|  alias | Address | City | PostalCode | Country | Phone|
    | Mrs | Bździągwa | Pierdołka | pierdolka@test.pl | pierdolkaB123 | 03/24/2016 | Bździągwa | Zielistki | Rybnik | 00-000 | United Kingdom | 0987654321 |
    | Mrs | Kraken    | Cholerka  | cholerka@test.pl  | cholerka123   | 08/24/2019 | Kraken    | Kwitnąca  | Kraków | 34-645 | United Kingdom | 8642390129 |
    | Mr  | Rudy      | Rydz      | rydz@test.pl      | rydz123       | 06/14/2000 | Rudy      | Zielona   | Tarnów | 08-396 | United Kingdom | 0484745038 |
    | Mrs | Maskotka  | Cudo      | cudo@test.pl      | cudo123       | 09/05/2013 | Maskotka  | Fiołkowa  | Warszawa | 03-984 | United Kingdom | 4565282383 |


