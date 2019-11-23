# SE_CW3_GitHub
Course Work 3 for Software Engineering

**11/22:Min**
added Account class

updated BikeProvider so that it extends Account class as shown in our class diagram

Note: Each Quote should contain a Bike class and getQuotes() in Customer class should return a list of Quote, as stated in CW3_instruction. Our searchBike() method in Quote class might be wrong, we might need to do what searchBike does in getQuotes(), and then wrap the list of Bike as list of Quote.

**11/22:sato**  
CW3 said **"Do not alter the provided DeliveryService, Deliverable interfaces, or the DeliveryService-
Factory and MockDeliveryService classes."** so marked them as completed.

In addition we need usecase test for each usecase in CW3.

**11/21:sato**  
completed 

class  
 - [x] Bike
 - [x] BikeType
 - [x] DataRange
 - [x] Delivable
 - [x] DeliveryService
 - [x] DeliveryServiceFactory
 - [x] Location
 - [x] MockDeliveryService
 - [ ] ValuationPolicy
 - [x] BikeProvider
 - [ ] Customer
 - [x] Quote
 - [x] BikeList
 - [ ] Booking
 - [x] Condition
 - [x] Invoice  

test
 - [ ] ValuationPolicyTest
 - [ ] systemTest
 - [x] TestLocation
 - [x] TestDateRange

**11/21:Min**

simplify overlap() in class DateRange

added price range in class Condition

updated class diagram

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
