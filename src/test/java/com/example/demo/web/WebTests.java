ppackage com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    // Le MockBean permet de simuler le service pour ne tester que le Controller
    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCreerVoiture() throws Exception {
        // Le JSON correspondant à la commande curl donnée dans l'énoncé
        String voitureJson = "{\"marque\":\"f\",\"prix\":100}";

        // On simule une requête POST et on attend un statut HTTP 200 (OK)
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(voitureJson))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStatistiquesSuccess() throws Exception {
        // On configure notre faux service pour qu'il renvoie un résultat prévisible
        Echantillon echantillonSimule = new Echantillon(2, 15000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillonSimule);

        // On simule un GET et on vérifie le contenu du JSON renvoyé
        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(15000));
    }

    @Test
    void testGetStatistiquesLancePasDeVoitureException() throws Exception {
        // On configure le mock pour qu'il lève une ArithmeticException (division par zéro)
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());

        // On s'attend à ce que le Controller l'attrape et lève une PasDeVoitureException
        mockMvc.perform(get("/statistique"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof PasDeVoitureException));
    }
}
