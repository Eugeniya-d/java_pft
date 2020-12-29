Feature: Groups


  Scenario: Group Creation
    Given a set of groups
    When I create a new group with name xxx, with header yyy and footer zzz
    Then the new set of groups is equal to the old set with added group