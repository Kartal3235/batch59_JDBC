Feature: US1003 kullanici DBUtill istenen değeri test eder

  Scenario:TC02 kullanici istenen deger test edebilmeli

    Given kullanici DBUtilis ile HMC veri tabanina baglanir
    And kullanici DBUtilis ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtilis ile "Price" sutunundaki verileri okur
    Then DBUtill ile 4. "Price" in 425 oldugunu test eder