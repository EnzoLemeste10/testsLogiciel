package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StatistiqueTests {

    @Test
    void testPrixMoyenAvecSucces() {
        // Initialisation du service pour ce test
        StatistiqueImpl statistiqueService = new StatistiqueImpl();

        // 1. Préparation des données (Arrange)
        // ⚠️ Note : Ajuste les arguments ("Peugeot", "208", 10000) si le constructeur
        // de ta classe Voiture.java est différent (par exemple s'il ne prend que le prix).
        Voiture v1 = new Voiture("Peugeot", "208", 10000);
        Voiture v2 = new Voiture("Renault", "Clio", 20000);

        // 2. Exécution de l'action (Act)
        statistiqueService.ajouter(v1);
        statistiqueService.ajouter(v2);
        Echantillon echantillon = statistiqueService.prixMoyen();

        // 3. Vérifications (Assert) - Utilisation exclusive de assertEquals
        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(15000, echantillon.getPrixMoyen());
    }

    @Test
    void testPrixMoyenLanceExceptionSiAucuneVoiture() {
        // Initialisation du service (il est vide par défaut)
        StatistiqueImpl statistiqueService = new StatistiqueImpl();

        // Vérification (Assert) - Utilisation exclusive de assertThrows
        // On vérifie que la division par 0 lève bien l'exception attendue
        assertThrows(ArithmeticException.class, () -> {
            statistiqueService.prixMoyen();
        });
    }
}