package com.company;

import nl.jqno.equalsverifier.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    void testToFrom(){
        //
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}