Feature: Visit web

  Scenario: visit localhost Examples
    Given I visit "http://localhost:8080"
    When I click on "Examples"
    Then I see "Apache Tomcat Examples"
    
  Scenario: visit localhost BBB
    Given I visit "http://localhost:8080"
    When I click on "JDBC DataSources"
    Then I see "Apache Tomcat 8 (8.5.13) - JNDI Datasource HOW-TO"