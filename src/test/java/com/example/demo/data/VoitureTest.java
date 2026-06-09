package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

package packmain;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoitureTest {

    @Test
    void creerVoiture() {
        // 1. Instancier l'objet (adapte les paramètres selon le constructeur de Voiture.java)
        Voiture voiture = new Voiture("Tesla", "Model 3");

        // 2. Vérifier que l'objet n'est pas nul
        assertNotNull(voiture);

        // 3. Vérifier que les getters retournent les bonnes valeurs
        assertEquals("Tesla", voiture.getMarque());
        assertEquals("Model 3", voiture.getModele());
    }
}