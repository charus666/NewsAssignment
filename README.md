# NewsAssignment
Approach Followed- BDD Using Cucumber 

Scenario 1 - User should be able to select any topic (E.g “Business and Economy”) and filter news using Apply button
==========
Scenraio 2 - When filter (one or more) is being applied to news items and user clicks on “Reset” button, all applied filters should be removed 
==========

For Scenarios Feature File Goto Path - 
====================================
src/test/resources/features.math/News.Feature

How to Run-
==========
1. Right Click on the feature file "News.feature" and run 
2. I have commented the @After hook intentionally to not close the three browsers so that you can verify the execution results 


Results Verification-
========================
Scenario 1 - Runs the same scenario for two different topics 
==========
Browser 1 shows that user filtered using "Arts & Culture"  - PASS
Browser 2 shows that user filtered using "Awards"  - PASS

-------------------------------------------------------------------
Sceanrio 2 - Applies filter and then removes filters 
===========
Browser 3 shows that user filtered using "Arts & Culture"  & the used reset to remove filter. 
