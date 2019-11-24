# SE_CW3_GitHub
Course Work 3 for Software Engineering

----------------------------------------------------------------------------------------------------------------------------------------
**11/23: Min**

- changed public get/set payment card in Customer class to protected. Reason: no point in having a private attribute if any thing can access to it.

- added list of Bike Provider as we need to search the existing bike provider in our database as part of Condition.

- changed how toCondition() works for the Bike Provider part so that it searches through our database instead of creating a new BikeProvider class which can potentially not exist in our system. (May implement this in getQuotes() instead of toCondition(), pending discussion)

Why do we need toSring() method in Bike class? The only print function that we need is printOrderSummary when booking quote. (just asking)

**DID YOU READ MY NOTE?** Because I said the exact same thing in my note regarding searchBike().

Btw, if you have time, we can meet up and try to finish all the works on Tuesday after class. Reply me on vx.

----------------------------------------------------------------------------------------------------------------------------------------
**11/23:Sato**  
 - added toString() to Bike class.
 
 - change BikeList to Static (so that other class and their methods can acsses bike list without taking BikeList as argument or 
call constructor for BikeList).

 - minor change in BikeProvider class because BikeList become static (register method has no BikeList argument, some "list bike" instance is replaced by "BikeList.getBikes").
 
 - changed searchBike() to static method for Quote class, and argument "Bikelist bikes" is removed because 
 now it can directly access to BikeList. In addition, it will return List<Bike> which size is <= Condition.getNumber().
                                                                                                                      
 - Added partially implemented Customer class (**bookQuote method is not yet implemented**).
 
**Note**  
Since our getQuote() should return Collection<Quote>, I implemented getQuote() as:
 ```
 public Collection<Quote> getQuote(Condition c){
       List <Quote> quotes = new ArrayList<>();
       List <Bike> results = Quote.searchBike(c);
       for (Bike b: results) {
           quotes.add(new Quote(b,b.getPrice()));
       }
       return quotes;
    }
 ```
However, I think this is little bit weird.  
 
Personally I feel like we can remove searchBike() form Quote class and implement that process in the getQuote() in Customer class.
And use Quote class just for Wrapper Class of Bike.  

If you feel like same, we can change these part.  
                                                                                                                      

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
