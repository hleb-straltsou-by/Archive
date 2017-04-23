package com.gv.archive.services.implementations;

import com.gv.archive.models.Dossier;
import com.gv.archive.models.Role;
import com.gv.archive.services.interfaces.DossierService;
import org.junit.Assert;
import org.junit.Test;

public class BasicDossierServiceTest {

    private DossierService service = new BasicDossierService();

    private final static String DOM_PARSER = "DOM";

    @Test
    public void getDossierWithDomParser() throws Exception {
        String login = "vi4477";
        Dossier dossier = service.getDossier(login, DOM_PARSER);
        if(dossier != null) {
            Assert.assertEquals(dossier.getRole(), Role.ADMIN);
            Assert.assertEquals(dossier.getExperience(), "none");
            Assert.assertEquals(dossier.getAddress().getCity(), "Minsk");
            Assert.assertEquals(dossier.getAddress().getCountry(), "Belarus");
            Assert.assertEquals(dossier.getAddress().getStreet(), "Gerasimenko 7");
            Assert.assertEquals(dossier.getName(), "Veronika Sanko");
            Assert.assertEquals(dossier.getMobile(), "+375291239671");
            Assert.assertEquals(dossier.getSkype(), "vivi_sanko");
        }
    }
}