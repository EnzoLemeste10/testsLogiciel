package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StatistiqueTests {

    @Test
    void testPrixMoyenAvecSucces() {
        StatistiqueImpl statistiqueService = new StatistiqueImpl();

        // Correction ici : constructeur à 2 arguments (Marque, Prix)
        Voiture v1 = new Voiture("Peugeot", 10000);
        Voiture v2 = new Voiture("Renault", 20000);

        statistiqueService.ajouter(v1);
        statistiqueService.ajouter(v2);
        Echantillon echantillon = statistiqueService.prixMoyen();

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(15000, echantillon.getPrixMoyen());
    }

    @Test
    void testPrixMoyenLanceExceptionSiAucuneVoiture() {
        StatistiqueImpl statistiqueService = new StatistiqueImpl();

        assertThrows(ArithmeticException.class, () -> {
            statistiqueService.prixMoyen();
        });
    }
}