package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoitureTest {

    @Test
    void creerVoiture() {
        // Correction ici : constructeur à 2 arguments (Marque, Prix)
        Voiture voiture = new Voiture("Tesla", 45000);

        assertNotNull(voiture);
        assertEquals("Tesla", voiture.getMarque());
        assertEquals(45000, voiture.getPrix()); // On teste le prix à la place
    }
}