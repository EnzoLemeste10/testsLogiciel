package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

package packmain;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VoitureTest {

    private Voiture tuture;

    @BeforeEach
    void setUp(){
        tuture = new Voiture("Ferrari", 200000);
    }


    @Test
    void testGetters(){
        Assertions.assertEquals(200000, tuture.getPrix(), "Le prix doit être 200000");
        Assertions.assertEquals("Ferrari", tuture.getMarque(), "La marque doit être Ferrari");
    }
}
