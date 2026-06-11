package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoitureTest {

    @Test
    void creerVoiture() {
        // 1. Instancier l'objet avec 3 arguments (Marque, Modèle, Prix)
        // car la classe Voiture du projet intègre la gestion du prix.
        Voiture voiture = new Voiture("Tesla", "Model 3", 45000);

        // 2. Vérifier que l'objet a bien été créé
        assertNotNull(voiture);

        // 3. Vérifier que les getters retournent les bonnes valeurs
        assertEquals("Tesla", voiture.getMarque());
        assertEquals("Model 3", voiture.getModele());
    }
}