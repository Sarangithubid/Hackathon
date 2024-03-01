Feature: IdentifyCourses

  Scenario: Coursera
    
    Given Search web development courses
    When Selecting Beginner level and English Language
    Then Extract the course details
    And Search Language Learning
    And Extract all languages in different level
    And Navigate to Courses for Campus
    And fill the invalid inputs
    And Capture and Display the error message
