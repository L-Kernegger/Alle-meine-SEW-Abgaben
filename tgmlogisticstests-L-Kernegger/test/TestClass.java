import TGMLogistics.Exceptions.*;
import TGMLogistics.Helper.Address;
import TGMLogistics.Item.ClothingSize;
import TGMLogistics.Item.Item;
import TGMLogistics.Item.Shirt;
import TGMLogistics.OrderLogistics.LogisticsSystem;
import TGMLogistics.OrderLogistics.Order;
import TGMLogistics.OrderLogistics.OrderStatus;
import TGMLogistics.Store.Store;
import TGMLogistics.User.PaymentMethod;
import TGMLogistics.User.UserPrivilege;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TGMLogistics.User.User;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    @Test
    @DisplayName("EinE BenutzerIn wird korrekt angelegt")
    void UO1() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        User x = new User(UserPrivilege.ADMIN,"Max","Muster","+4367712341234","maxmuster@tgm.ac.at"
                ,"XA#*<TGM>b34y",new Address("Musterstrasse",1,"Wien","Austria",1010));
        assertEquals("Max", x.getFirstName());
        assertEquals("Muster", x.getLastName());
        assertEquals("+4367712341234", x.getPhone());
    }
    @Test
    @DisplayName("KeinE BenutzerIn wird angelegt, wenn die Tel.Nr. nicht korrekt ist")
    void U02() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        assertThrows(NoValidPhoneNumberException.class, () ->{User x = new User(UserPrivilege.ADMIN,"Max","Muster","01234ABC123","maxmuster@tgm.ac.at"
                ,"XA#*<TGM>b34y",new Address("Musterstrasse",1,"Wien","Austria",1010));});
    }

    @Test
    @DisplayName("KeinE BenutzerIn wird angelegt, wenn die eMail-Adresse nicht passt")
    void U03() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        assertThrows(NoValidEmailException.class, () ->{User x = new User(UserPrivilege.ADMIN,"Max","Muster","+4367712341234","max@muster@tgm.ac.at"
                ,"XA#*<TGM>b34y",new Address("Musterstrasse",1,"Wien","Austria",1010));});
    }
    @Test
    @DisplayName("Eine Zahlungsmethode wird korrekt angelegt")
    void U04() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        assertDoesNotThrow(() ->{User x = new User(UserPrivilege.ADMIN,"Max","Muster","+4367712341234","maxmuster@tgm.ac.at"
                ,"XA#*<TGM>b34y",new Address("Musterstrasse",1,"Wien","Austria",1010));
            long y = 5425233430109903L;
            x.addPaymentOption(x,new PaymentMethod(y));});
        assertThrows(NoValidCreditCardException.class, () -> {User x = new User(UserPrivilege.ADMIN,"Max","Muster","+4367712341234","maxmuster@tgm.ac.at"
                ,"XA#*<TGM>b34y",new Address("Musterstrasse",1,"Wien","Austria",1010));
            long y = 1;
            x.addPaymentOption(x,new PaymentMethod(y));});
    }
    @Test
    @DisplayName("Eine Zahlungsmethode kann einem/r UserIn korrekt hinzugefügt werden")
    void U05() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        assertDoesNotThrow(() -> {
            User x = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User y = new User(UserPrivilege.CUSTOMER, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            long t = 5425233430109903L;
            x.addPaymentOption(y, new PaymentMethod(t));
        });
        assertDoesNotThrow(() -> {
            User x = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User y = new User(UserPrivilege.CUSTOMER, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            long t = 5425233430109903L;
            x.addPaymentOption(y, t, "XA#*<TGM>b34y");
        });
        assertDoesNotThrow(() -> {
            User x = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User y = new User(UserPrivilege.CUSTOMER, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            long t = 5425233430109903L;
            y.addPaymentOption(y,new PaymentMethod(t));
        });
        assertThrows(OperationNotAllowedException.class, () -> {
            User x = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User y = new User(null, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34yt", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            long t = 1;
            System.out.println(y.verifyPassword("XA#*<TGM>b34yt") && (y.getPrivilege().contains(UserPrivilege.ADMIN) || y == x));
            y.addPaymentOption(x, t, "XA#*<TGM>b34yt");

        });}
        @Test
        @DisplayName("Eine Bestellung kann korrekt hinzugefügt werden")
        void U06() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
            User x = new User(UserPrivilege.CUSTOMER, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            ArrayList<Item> z = new ArrayList<>();
            z.add(new Shirt("wow",ClothingSize.S));
            Order y = new Order(x,OrderStatus.PROCESSING,z);

            LogisticsSystem i = new LogisticsSystem();
            i.addOrder(y);
            i.addOrder(y);

            assertEquals(1,i.getOrders().size());
        }
        @Test
        @DisplayName("Eine Bestellung wird nur verschickt, wenn genug vorhanden ist")
        void U07() throws ItemNotAvailableException, NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException{
            Store a = new Store(new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User b = new User(UserPrivilege.CUSTOMER, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 2, "Wien", "Austria", 1010));
            Shirt c = new Shirt("wow",ClothingSize.S);
            Shirt d = new Shirt("Oh Yeah",ClothingSize.XL);
            Shirt e = new Shirt("Wow yeah",ClothingSize.L);
            a.addShirt(c);
            a.addShirt(d);

            ArrayList<Item> z = new ArrayList<>();
            z.add(new Shirt("wow",ClothingSize.S));
            z.add(new Shirt("Oh Yeah",ClothingSize.XL));

            ArrayList<Item> x = new ArrayList<>();
            z.add(c);
            z.add(e);

            Order o1 = new Order(b,OrderStatus.PROCESSING,z);
            Order o2 = new Order(b,OrderStatus.PROCESSING,x);

            LogisticsSystem t = new LogisticsSystem();
            t.addOrder(o1);
            t.addOrder(o2);
            t.registerNewStore(a);
            t.registerNewUser(b);
            t.processOrders();

            assertEquals(OrderStatus.DISPATCHED,o1.getCurrentStatus());
            assertEquals(OrderStatus.CANCELLED,o2.getCurrentStatus());
        }
    @Test
    @DisplayName("Bestellungen sind nur von authorisierten NutzerInnen löschbar")
    void UO8() throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException{
        assertDoesNotThrow(() -> {
            User u1 = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User u2 = new User(UserPrivilege.COWORKER, "Franz-Joseph", "Lohtringen-Habsburg", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User c1 = new User(UserPrivilege.CUSTOMER, "Rocky", "Balboa", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 2, "Wien", "Austria", 1010));

            ArrayList<Item> z = new ArrayList<>();
            z.add(new Shirt("wow",ClothingSize.S));
            z.add(new Shirt("Oh Yeah",ClothingSize.XL));
            Order o1 = new Order(c1,OrderStatus.PROCESSING,z);

            LogisticsSystem l1 = new LogisticsSystem();
            l1.addOrder(o1);
            l1.registerNewUser(u1);
            l1.registerNewUser(u2);

            l1.removeOrder(o1,u1,"XA#*<TGM>b34y");
        });
        assertThrows(OperationNotAllowedException.class, ()->{
            User u1 = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User u2 = new User(UserPrivilege.COWORKER, "Franz-Joseph", "Lohtringen-Habsburg", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User c1 = new User(UserPrivilege.CUSTOMER, "Rocky", "Balboa", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 2, "Wien", "Austria", 1010));

            ArrayList<Item> z = new ArrayList<>();
            z.add(new Shirt("wow",ClothingSize.S));
            z.add(new Shirt("Oh Yeah",ClothingSize.XL));
            Order o1 = new Order(c1,OrderStatus.PROCESSING,z);

            LogisticsSystem l1 = new LogisticsSystem();
            l1.addOrder(o1);
            l1.registerNewUser(u1);
            l1.registerNewUser(u2);

            l1.removeOrder(o1,u1,"bruh");
        });
        assertThrows(OperationNotAllowedException.class, () -> {
            User u1 = new User(UserPrivilege.ADMIN, "Max", "Muster", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User u2 = new User(UserPrivilege.COWORKER, "Franz-Joseph", "Lohtringen-Habsburg", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 1, "Wien", "Austria", 1010));
            User c1 = new User(UserPrivilege.CUSTOMER, "Rocky", "Balboa", "+4367712341234", "maxmuster@tgm.ac.at"
                    , "XA#*<TGM>b34y", new Address("Musterstrasse", 2, "Wien", "Austria", 1010));

            ArrayList<Item> z = new ArrayList<>();
            z.add(new Shirt("wow",ClothingSize.S));
            z.add(new Shirt("Oh Yeah",ClothingSize.XL));
            Order o1 = new Order(c1,OrderStatus.PROCESSING,z);

            LogisticsSystem l1 = new LogisticsSystem();
            l1.addOrder(o1);
            l1.registerNewUser(u1);
            l1.registerNewUser(u2);

            l1.removeOrder(o1,u2,"XA#*<TGM>b34y");
        });
    }


}

