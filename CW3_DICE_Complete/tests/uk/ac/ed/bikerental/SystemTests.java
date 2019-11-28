package uk.ac.ed.bikerental;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// these test is according to our class sequence and communication diagram for each use case

public class SystemTests {
 // prepare BikeProviders
    BikeProvider p1 = new BikeProvider("Provider1", "p1@email", 123123123, new Location("EH91NK","A-street"), "11:00-18::00", 0.1);
    BikeProvider p2 = new BikeProvider("Provider2", "p2@email", 123123122, new Location("EH89NK","B-street"), "11:00-19::00", 0.2);
    BikeProvider p3 = new BikeProvider("Provider3", "p3@email", 123123121, new Location("EH127NK","C-street"), "11:00-18::00", 0.3);
    // prepare BikeType
    BikeType mtb = new BikeType("MTB", new BigDecimal(700));
    BikeType roadb = new BikeType("RoadBike", new BigDecimal(800));
    BikeType crossb = new BikeType("CrossBike", new BigDecimal(500));
    // prepare Bikes
    Bike b1 = new Bike(mtb,     new BigDecimal(20), p1, LocalDate.of(2014, 9, 8));
    Bike b2 = new Bike(roadb,   new BigDecimal(30), p1, LocalDate.of(2014, 9, 8));
    Bike b3 = new Bike(crossb,  new BigDecimal(20), p1, LocalDate.of(2014, 9, 8));
    Bike b4 = new Bike(mtb,     new BigDecimal(30), p2, LocalDate.of(2017, 8, 1));
    Bike b5 = new Bike(roadb,   new BigDecimal(20), p2, LocalDate.of(2017, 8, 1));
    Bike b6 = new Bike(crossb,  new BigDecimal(10), p2, LocalDate.of(2017, 8, 1));
    Bike b7 = new Bike(mtb,     new BigDecimal(30), p3, LocalDate.of(2019, 11, 26));
    Bike b8 = new Bike(roadb,   new BigDecimal(30), p3, LocalDate.of(2014, 11, 26));
    Bike b9 = new Bike(crossb,  new BigDecimal(30), p3, LocalDate.of(2014, 11, 26));
    Bike b10 = new Bike(crossb, new BigDecimal(30), p3, LocalDate.of(2014, 11, 26));
    Bike b11 = new Bike(mtb,    new BigDecimal(40), p1, LocalDate.of(2015, 9, 8));
    Bike b12 = new Bike(roadb,  new BigDecimal(30), p1, LocalDate.of(2015, 9, 8));
    Bike b13 = new Bike(crossb, new BigDecimal(10), p1, LocalDate.of(2009, 9, 8));
    Bike b14 = new Bike(mtb,    new BigDecimal(30), p2, LocalDate.of(2018, 8, 1));
    Bike b15 = new Bike(roadb,  new BigDecimal(20), p2, LocalDate.of(2018, 8, 1));
    Bike b16 = new Bike(crossb, new BigDecimal(10), p2, LocalDate.of(2018, 8, 1));
    Bike b17 = new Bike(mtb,    new BigDecimal(30), p3, LocalDate.of(2019, 11, 29));
    Bike b18 = new Bike(roadb,  new BigDecimal(30), p3, LocalDate.of(2014, 11, 26));
    Bike b19 = new Bike(crossb, new BigDecimal(30), p3, LocalDate.of(2014, 11, 26));
    Bike b20 = new Bike(mtb,    new BigDecimal(30), p1, LocalDate.of(2014, 9, 8));

    @BeforeEach
    void setUpClass() throws Exception {
    //put these in to ProviderList
        BikeProvider[] providertest = {p1,p2,p3};
        ProviderList.providers.clear();
        for (BikeProvider p: providertest) {
            ProviderList.providers.add(p);
        }

     // add bikes to BikeList
        Bike[] biketest = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20};
        BikeList.bikes.clear();
        for (Bike b: biketest) {
            BikeList.bikes.put(b, 1);
        }

     // Setup mock delivery service before each tests
        DeliveryServiceFactory.setupMockDeliveryService();
    }


    // TODO: Write system tests covering the three main use cases
    @Test
    void getQuoteTest() {
        // Initialize customer
        Customer customer
            = new Customer("Customer1", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);
        // Searching requirement
        String[] search = {"MTB", "0", "100", "EH91NJ", "Somewhaere", "2019/01/01", "2019/01/05", "Provider1", "3"};

        // customer called getQuote()
        List <Quote> quotes = (List<Quote>) customer.getQuote(search);

        // creating expected quote list returned by getQuote() called above
        List <Quote> expect = new ArrayList<>();
        Bike[] expectedBike = {b1,b11,b20};
        for (Bike b: expectedBike) {
            expect.add(new Quote(b));
        }

        /*System.out.println("expect");
        System.out.println(expect.size());
        for (Quote q: expect) {
            System.out.println(q.hashCode());
            System.out.println(q.getBike().toString());
        }
        System.out.println("result");
        System.out.println(quotes.size());
        for (Quote q: quotes) {
            System.out.println(q.hashCode());
            System.out.println(q.getBike().toString());
        }*/

        // if the length of the returned quote and expected quote is same,
        // and every element in one quote list is contained in other,
        // which means they are same.
        boolean same = quotes.size() == expect.size();
        for (Quote q: quotes) {
            same = same && expect.contains(q);
        }
        // searched result is equal to expected result
        assert(same);
    }

    @Test
    void bookQuoteTest1() {
        // initialized customer
        Customer customer
            = new Customer("Customer1", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);

        //DateRange which is inputed by customer in searching process
        DateRange date = new DateRange(LocalDate.of(2019, 01, 01), LocalDate.of(2019,01,05));

        // creating list of quote for test
        List<Quote> quotes = new ArrayList<>();
        Bike[] bookedBike = {b1,b5,b10};
        for (Bike b: bookedBike) {
            quotes.add(new Quote(b));
        }

        // customer called bookQuote()
        // it will notify to both provider and customer
        // in this case delivery is not required
        Booking book = customer.bookQuote(quotes, false, date);

        // check Booking is successfully added to List of Booking
        assert(ListofBooking.bookings.contains(book));

        // check non-available date range of each bike is updated.
        for (Quote q: book.getbookedQuotes()) {
            assertEquals(q.getBike().isAvail(date), false);
        }

    }

    @Test
    void bookQuoteTest2() {
        // initialize customer
        Customer customer
            = new Customer("Customer1", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);

        //DateRange which is inputed by customer in searching process
        DateRange date = new DateRange(LocalDate.of(2019, 01, 01), LocalDate.of(2019,01,02));

        // creating list of quote for test
        List<Quote> quotes = new ArrayList<>();
        Bike[] bookedBike = {b1,b5,b10};
        for (Bike b: bookedBike) {
            quotes.add(new Quote(b));
        }

        // customer called bookQuote()
        // it will notify to both provider and customer
        // in this case delivery is required so booking will schedule delivery
        Booking book = customer.bookQuote(quotes, true, date);

        // check Booking is successfully added to List of Booking
        assert(ListofBooking.bookings.contains(book));

        // check non-available date range of each bike is updated.
        for (Quote q: book.getbookedQuotes()) {
            assertEquals(q.getBike().isAvail(date), false);
        }

        // check all the bike is scheduled for delivery
        MockDeliveryService delivery = (MockDeliveryService) DeliveryServiceFactory.getDeliveryService();
        for (Quote q: book.getbookedQuotes()) {
            assert(delivery.getPickupsOn(date.getEnd()).contains(q.getBike()));
        }

    }

    @Test
    void returnBikeTest() {
        // preparation for getting orderNumber
        Customer customer
            = new Customer("Customer", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);

        DateRange date = new DateRange(LocalDate.of(2019, 01, 01), LocalDate.of(2019,01,05));

        List<Quote> quotes = new ArrayList<>();
        // all p1's bikes
        Bike[] bookedBike = {b1,b2,b3};
        for (Bike b: bookedBike) {
            quotes.add(new Quote(b));
        }
        // create Booking for test.
        Booking bookpre = customer.bookQuote(quotes, false, date);

        // got orderNumber
        int orderNumber = bookpre.getOrderNumber();

        // test start: get booking
        Booking book = null;
        for (Booking b: ListofBooking.bookings) {
            if (b.getOrderNumber() == orderNumber) {
                book = b;
            }
        }
        //return all bikes to p1
        p1.returnBike(orderNumber, book.getDate().getEnd());

        // check status of bike
        for (Quote q: book.getbookedQuotes()) {
            assert(q.getBike().getAvailability() == true);
            assert(q.getBike().isAvail(new DateRange(LocalDate.now(), LocalDate.now().plusDays(1))));
        }
    }

    @Test
    void returnBikePatnerTest() {
        // add partner
        p1.addPartner(p2);
        // preparation for getting orderNumber
        Customer customer
            = new Customer("Customer", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);

        DateRange datepre = new DateRange(LocalDate.of(2019, 01, 01), LocalDate.of(2019,01,05));

        List<Quote> quotes = new ArrayList<>();
        Bike[] bookedBike = {b1,b5,b10};
        for (Bike b: bookedBike) {
            quotes.add(new Quote(b));
        }

        Booking bookpre = customer.bookQuote(quotes, false, datepre);

        // got orderNumber
        int orderNumber = bookpre.getOrderNumber();

        // test start: get booking
        Booking book = null;
        for (Booking b: ListofBooking.bookings) {
            if (b.getOrderNumber() == orderNumber) {
                book = b;
            }
        }
        // from booking extract partners bike
        ArrayList<Bike> partnerBike = new ArrayList<>();
        for (Quote q: book.getbookedQuotes()) {
            if (p1.isPartner(q.getBike().getProvider())) {
                partnerBike.add(q.getBike());
            }
        }

        LocalDate date = LocalDate.now();
        // return Bikes
        p1.returnBike(orderNumber,date);

        // check all partner bike is scheduled for delivery
        MockDeliveryService delivery = (MockDeliveryService) DeliveryServiceFactory.getDeliveryService();
        for (Bike bk: partnerBike) {
            assert(delivery.getPickupsOn(date.plusDays(1)).contains(bk));
        }

    }

    @Test
    void IntegrationTest() {
        // using extension of ValuationPolicy
        p1.setDepositPolicy("LinearDepreciation");
        p2.setDepositPolicy("DoubleDecliningBalanceDepreciation");


        // User get quote
        Customer customer
            = new Customer("Customer1", new Location("EH91NJ", "Somewhere"), 12345689, "email", 0000000000000000);

        String[] search = {"MTB", "0", "100", "EH91NJ", "Somewhaere", "2019/01/01", "2019/01/05", "Provider1", "3"};

        List <Quote> quotes = (List<Quote>) customer.getQuote(search);

        // check policy working
        for (Quote q: quotes) {
            if (q.getBike().getProvider() != p3 ) {
                assert(q.getDeposit() != q.getBike().getProvider().getRate().multiply(q.getBike().getType().getReplacementValue()));
            }
        }

        List <Quote> expect = new ArrayList<>();
        Bike[] expectedBike = {b1,b11,b20};
        for (Bike b: expectedBike) {
            expect.add(new Quote(b));
        }

        boolean same = quotes.size() == expect.size();
        for (Quote q: quotes) {
            same = same && expect.contains(q);
        }
        // searched result is equal to expected result
        assert(same);


        // User book quote
        DateRange date = new DateRange(LocalDate.of(2019, 01, 01), LocalDate.of(2019,01,02));

        Booking book = customer.bookQuote(quotes, true, date);

        // Booking is successfully added to List of Booking
        assert(ListofBooking.bookings.contains(book));

        // non-available date range of each bike is updated.
        for (Quote q: book.getbookedQuotes()) {
            assertEquals(q.getBike().isAvail(date), false);
        }

        // all the bike is scheduled for delivery
        MockDeliveryService delivery = (MockDeliveryService) DeliveryServiceFactory.getDeliveryService();
        for (Quote q: book.getbookedQuotes()) {
            assert(delivery.getPickupsOn(date.getEnd()).contains(q.getBike()));
        }


        // Partner get bikes
        p2.addPartner(p1);
        // from booking extract partners bike
        int orderNumber = book.getOrderNumber();
        // searching booking
        Booking book1 = null;
        for (Booking b: ListofBooking.bookings) {
            if (b.getOrderNumber() == orderNumber) {
                book1 = b;
            }
        }
        // pick out partners bike
        ArrayList<Bike> partnerBike = new ArrayList<>();
        for (Quote q: book1.getbookedQuotes()) {
            if (p1.isPartner(q.getBike().getProvider())) {
                partnerBike.add(q.getBike());
            }
        }
        LocalDate date1 = LocalDate.now();

        p2.returnBike(orderNumber,date1);

        // all partner bike is scheduled for delivery
        MockDeliveryService delivery1 = (MockDeliveryService) DeliveryServiceFactory.getDeliveryService();
        for (Bike b: partnerBike) {
            assert(delivery1.getPickupsOn(date1.plusDays(1)).contains(b));
        }


        // Original Bike Provider get bikes with order number
        Booking book2 = null;
        for (Booking b: ListofBooking.bookings) {
            if (b.getOrderNumber() == orderNumber) {
                book2 = b;
            }
        }
        // check status of bike
        for (Quote q: book2.getbookedQuotes()) {
            assert(q.getBike().getAvailability());
            assert(q.getBike().isAvail(new DateRange(LocalDate.now(), LocalDate.now().plusDays(1))));
        }
    }
}
