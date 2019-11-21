# SE_CW3_GitHub
Course Work 3 for Software Engineering

**11/21:Min**

simplify overlap() in class DateRange

added price range in class Condition

updated class diagram

comment:

Definition of isNearTo() method in class Location has doubtful correctness. Eg: Edinburgh uses EH* *** to classify district, If two places are in the same area, they still might have different numerical postcode. And different country uses different system for postcode. How do you tell if their numerical postcodes are the same, then they must be near to each other.
Grammer error in the comment of Location, one of them:  `<p>This class include the method to check whether two lacation is near or not `

**11/21:Sato**  
Uploaded in "Class and Test".
 - [x] Location.java, 
 - [x] TestLocation.java, 
 - [x] DateRange.java, 
 - [x] TestDateRange.java, 
 - [ ] Condition.java  

※There are several change from class diagram.  
 1. Data -> DataRange with additional methods as it is instructed in CW3.
 2. In the Condition class, some datatype is changed. type:BikeType, price:BigDecimal, date:DateRange.

**11/20:Min**

Fixed and uploaded cw2_diagram

Uploaded cw1_diagram
