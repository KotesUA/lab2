package com.company;

import nl.jqno.equalsverifier.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    void testToFrom(){
        //we use this to test the class with all non-final fields
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}