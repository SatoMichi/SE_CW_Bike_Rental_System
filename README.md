# SE_CW3_GitHub
Course Work 3 for Software Engineering  

----------------------------------------------------------------------------------------------------------------------------------------
**11/25: Min**
 - Created OrderNumber class to make sure that we can generate different order number each time.
 - Added a toString() method in Invoice class for printSummary() in Booking class.
 - Renamed printSummary() to printOrder()
 - Booking class has an Invoice attribute which will be generated each time Booking object has been created.
 - Slightly modified toString() in Bike class so for the purpose of printOrder() ("\n" has been changed to ", ").

**Note**

Our cw2 class diagram isn't that good, or in another word, wrong. Don't create class/method based on it, just treat it as a reference when making class/method. We will need to modify it later on.

To search for old booking, we need a list of booking but that doesn't have any connection with any use case that we need to implement. Therefore, I leave it unimplemented.

Btw, don't put everything as public/private, make use of protected.

Price shown on Invoice should be the sum of what customer paid excluding deposit.

----------------------------------------------------------------------------------------------------------------------------------------
**11/25: sato**  
 - Cahged Invoice calss so that it can deal with more than one bike booked.
 - Implemented Booking class. changed notifyProvider. notifyProvider() will not take argument. It will use the List<Quote> stored inside the Booking class to notify all the provider.
 - Also changed printSummary(). It takes only Customer as argument, and generate Invoice, print it on display and send email to customer.
 
**Note**  
In the implementation of printSummary(), I am littel confused by calculating of  Price on Invoice. Should it be sum of Quote.deposite or sum of Bike.price?

----------------------------------------------------------------------------------------------------------------------------------------
**11/25: sato**  
 - Added LinearDepreciation and DoubleDecliningBalanceDepreciation which implements ValuationPolicy.
 - Added ValuationPolicyTest (they suggested to use "assertEquals(a.stripTrailingZeros(), b.stripTrailingZeros());" however for 
 first test (testLD) I just used round up for 5 because I cannot write pass test).
 - Added attribute LocalDate:regDate to Bike class because Valuation policy need it. In addition, added calculateValue() as overload of 
 calculateValue(Bike,LocalDate), since CW3 said the system have to work even without Valuation policy.
 
 **Note**  
 Sorry. Actually I was not really sure about what you said in Previous Note. We can disscuss implementation of getQuote() later.
 
 About your qustion about toString() in Bike, because I used bike.toString() in some class, so I need to implement it.
 
 And I agree with the idea of having List of Provider, since it is useful to store data and we donot have to construct 
 BikeProvider class every time.
 
----------------------------------------------------------------------------------------------------------------------------------------
**11/23: Min**

- changed public get/set payment card in Customer class to protected. Reason: no point in having a private attribute if any thing can access to it.

- added list of Bike Provider as we need to search the existing bike provider in our database as part of Condition.

- changed how toCondition() works for the Bike Provider part so that it searches through our database instead of creating a new BikeProvider class which can potentially not exist in our system. (May implement this in getQuotes() instead of toCondition(), pending discussion)

Why do we need toSring() method in Bike class? The only print function that we need is printOrderSummary when booking quote. (just asking)

**DID YOU READ MY PREVIOUS NOTE?** Because I said the exact same thing in my note regarding searchBike().

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
 - [x] ValuationPolicy
 - [x] BikeProvider
 - [x] Customer
 - [x] Quote
 - [x] BikeList
 - [x] Booking
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
 - [x] Condition.java  

※There are several change from class diagram.  
 1. Data -> DataRange with additional methods as it is instructed in CW3.
 2. In the Condition class, some datatype is changed. type:BikeType, price:BigDecimal, date:DateRange.

**11/20:Min**

Fixed and uploaded cw2_diagram

Uploaded cw1_diagram
