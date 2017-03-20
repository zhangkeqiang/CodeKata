Feature: Cucumber Date
String Transformations
Cucumber provides an API that lets you take control over how strings are converted to other types. This is useful especially for dynamically typed languages, but also for statically typed languages when you need more control over the transformation.

Let’s consider a common example - turning a string into a date

Scenario: Show date diff
Given the Start date is "10-03-1971"