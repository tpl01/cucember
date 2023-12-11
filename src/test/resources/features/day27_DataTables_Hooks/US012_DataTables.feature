Feature: US012 BluRentalCar sayfasina login islemi

  Scenario: TC01 verilen email ve password bilgileri ile login olunur
    Given kullanici blueRentalCar sayfasina gider
    Then login butonuna tiklar
    But kullanici 2 saniye bekler
    And verilen kullanici bilgileri ile login olur

      | email                          | password |
      | raj.khan@bluerentalcars.com    | v7Hg_va^ |
      | pam.raymond@bluerentalcars.com | Nga^g6!  |

    And sayfayi kapatir