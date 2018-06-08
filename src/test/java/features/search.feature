Feature: Search
  As non'registered user
  I want to be able to search for items,
  So that I can find required item

Scenario: Search for an item
  Given I navigate to search page
  When I search for "audi"
  Then each of results displayed contains "audi"

Scenario: Search for an item via Search Button
  Given I navigate to search page
  And I get current search items on the page
  When I search for "audi" using Search Button
  Then search items on page are updated

Scenario: Search for an irrelevant item
  Given I navigate to search page
  When I search for "skdbvsjv"
  Then I get "¡UPS! NO HAY RESULTADOS CERCA DE TI" result

Scenario: Search for item in relevant Category
  Given I navigate to search page
  When I search for "audi"
  And click on Cars section filter
  Then each of results displayed contains "audi"

Scenario: Search for an item in irrelevant Category
  Given I navigate to search page
  When I search for "jeans"
  And click on Cars section filter
  Then I get "¡UPS! NO HAY RESULTADOS CERCA DE TI" result

Scenario: Reset search by deleting input
  Given I navigate to search page
  And I search for "audi"
  When I clear search field
  Then search field is empty
  And search field contains "¿Qué buscas?" placeholder text

Scenario: Reset search via Cross Icon
  Given I navigate to search page
  And I search for "audi"
  When I click on Cross Icon
  Then search field is empty
  And search field contains "¿Qué buscas?" placeholder text

Scenario: Search for item via heavy query
  Given I navigate to search page
  When I search for item using heavy query
  Then I get "¡UPS! NO HAY RESULTADOS CERCA DE TI" result

Scenario: Search for the web page
  Given I navigate to search page
  When I search for "https://es.search.yahoo.com"
  Then I get "¡UPS! NO HAY RESULTADOS CERCA DE TI" result

Scenario: Reset search by refreshing page
  Given I navigate to search page
  And I search for "audi"
  When I refresh the page
  Then search field is empty
  And search field contains "¿Qué buscas?" placeholder text
