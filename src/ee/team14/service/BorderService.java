package ee.team14.service;


import ee.team14.dao.BorderDAO;
import ee.team14.entity.Auaste;
import ee.team14.entity.AuasteTyyp;
import ee.team14.entity.Piirivalvur;
import ee.team14.entity.PiirivalvurAuaste;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BorderService {

    @Autowired
    private BorderDAO borderDAO;

    public void addOrUpdateNewPiirivalvur(String eesnimi, String perekonnanimi, String isikukood, String email, String aadress, String sodurikood,
                                  String sugu, String telefon, String kommentaar, Long id){
        Piirivalvur p = new Piirivalvur();
        p.setEesnimi(eesnimi);
        p.setPerekonnanimi(perekonnanimi);
        p.setIsikukood(isikukood);
        p.setEmail(email);
        p.setAadress(aadress);
        p.setSodurikood(sodurikood);
        p.setSugu(sugu);
        p.setTelefon(telefon);
        p.setKommentaar(kommentaar);
        if(id != null)
            p.setId(id);
        borderDAO.saveOrUpdateEntity(p);
    }

    public void addNewAuasteTyyp(String kood, String nimetus, String kommentaar){
        AuasteTyyp a = new AuasteTyyp();
        a.setKood(kood);
        a.setNimetus(nimetus);
        a.setKommentaar(kommentaar);

        borderDAO.saveOrUpdateEntity(a);
    }

    public void addNewAuaste(String kood, String nimetus, int tyyp){
        Auaste a = new Auaste();
        a.setKood(kood);
        a.setNimetus(nimetus);
        a.setTyyp(tyyp);

        borderDAO.saveOrUpdateEntity(a);
    }

    public void addNewPiirivalvurAuaste(String alates, String kuni, long auasteId, long piirivalvurId, String kommentaatr){
        PiirivalvurAuaste a = new PiirivalvurAuaste();
        a.convertAndSetAlates(alates);
        //a.setAuaste_id(auasteId);
        a.setKommentaar(kommentaatr);
        a.convertAndSetKuni(kuni);
        a.setPiirivalvur_id(piirivalvurId);

        borderDAO.saveOrUpdateEntity(a);
    }

    public List<Piirivalvur> getAllPiirivalvur(){
        List<Piirivalvur> piirivalvurList =  borderDAO.getAllPiirivalvur();
        return piirivalvurList;
    }

    public List<AuasteTyyp> getAllAuasteTyyp(){
        List<AuasteTyyp> auasteTyypList =  borderDAO.getAllAuasteTyyp();
        return auasteTyypList;
    }

    public List<Auaste> getAllAuaste(){
        List<Auaste> auasteTyypList =  borderDAO.getAllAuaste();
        return auasteTyypList;
    }

    public List<PiirivalvurAuaste> getAllPiirivalvurAuaste(){
        List<PiirivalvurAuaste> piirivalvurAuasteList =  borderDAO.getAllPiirivalvurAuaste();
        return piirivalvurAuasteList;
    }

    public void updateAuasteTyyp(Long id, String kood, String nimetus, String kommentaar){
        AuasteTyyp auasteTyyp = new AuasteTyyp();
        auasteTyyp.setId(id);
        auasteTyyp.setKood(kood);
        auasteTyyp.setNimetus(nimetus);
        auasteTyyp.setKommentaar(kommentaar);
        borderDAO.saveOrUpdateEntity(auasteTyyp);
    }

    public void updateAuaste(Long id, String kood, String nimetus, int tyyp){
        Auaste auaste = new Auaste();
        auaste.setId(id);
        auaste.setKood(kood);
        auaste.setNimetus(nimetus);
        auaste.setTyyp(tyyp);
        borderDAO.saveOrUpdateEntity(auaste);
    }

    public void updatePiirivalvurAuaste(Long id, String kommentaar, long auasteId, long piirivalvurId, String alates, String kuni){
        PiirivalvurAuaste pva = new PiirivalvurAuaste();
        pva.setId(id);
        pva.convertAndSetAlates(alates);
        pva.convertAndSetKuni(kuni);
        pva.setPiirivalvur_id(piirivalvurId);
        //pva.setAuaste_id(auasteId);
        pva.setKommentaar(kommentaar);
        borderDAO.saveOrUpdateEntity(pva);
    }

    public void addOrUpdatePiirivalvur(HttpServletRequest request){
        String eesnimi = request.getParameter("new.piirivalvur.eesnimi");
        String perekonnanimi = request.getParameter("new.piirivalvur.perekonnanimi");
        String isikukood = request.getParameter("new.piirivalvur.isikukood");
        String email = request.getParameter("new.piirivalvur.email");
        String aadress = request.getParameter("new.piirivalvur.aadress");
        String sodurikood = request.getParameter("new.piirivalvur.sodurikood");
        String kommentaar = request.getParameter("new.piirivalvur.kommentaar");
        String sugu = request.getParameter("new.piirivalvur.sugu");
        String telefon = request.getParameter("new.piirivalvur.telefon");
        if (isikukood != null && !"".equals(isikukood))
            addOrUpdateNewPiirivalvur(eesnimi, perekonnanimi, isikukood, email, aadress, sodurikood, sugu, telefon, kommentaar, null);

        int i=0;
        while (request.getParameter("existing.piirivalvur["+i+"]") != null
                && !"".equals(request.getParameter("existing.piirivalvur[" + i + "]"))){
            if("changed".equals(request.getParameter("existing.piirivalvur[" + i + "]"))){
                String existingPiirivalvurEesnimi = request.getParameter("existing.piirivalvur[" + i + "].eesnimi");
                String existingPiirivalvurPerekonnaNimi = request.getParameter("existing.piirivalvur[" + i + "].perekonnanimi");
                String existingPiirivalvurIsikukood = request.getParameter("existing.piirivalvur[" + i + "].isikukood");
                String existingPiirivalvurAadress = request.getParameter("existing.piirivalvur[" + i + "].aadress");
                String existingPiirivalvurEmail = request.getParameter("existing.piirivalvur[" + i + "].email");
                String existingPiirivalvurSodurikood = request.getParameter("existing.piirivalvur[" + i + "].sodurikood");
                String existingPiirivalvurKommentaar = request.getParameter("existing.piirivalvur[" + i + "].kommentaar");
                String existingPiirivalvurSugu = request.getParameter("existing.piirivalvur[" + i + "].sugu");
                String existingPiirivalvurTelefon = request.getParameter("existing.piirivalvur[" + i + "].telefon");
                Long existingPiirivalvurId = Long.valueOf(request.getParameter("existing.piirivalvur[" + i + "].id"));
                addOrUpdateNewPiirivalvur(existingPiirivalvurEesnimi, existingPiirivalvurPerekonnaNimi, existingPiirivalvurIsikukood,
                        existingPiirivalvurEmail, existingPiirivalvurAadress, existingPiirivalvurSodurikood, existingPiirivalvurSugu,
                        existingPiirivalvurTelefon, existingPiirivalvurKommentaar, existingPiirivalvurId);
            }

            i++;
        }
    }

    public void addOrUpdateAuasteTyyp(HttpServletRequest request) {
        String kood = request.getParameter("new.tyyp.kood");
        String nimetus = request.getParameter("new.tyyp.nimetus");
        String kommentaar = request.getParameter("new.tyyp.kommentaar");
        if (kood != null && !"".equals(kood)
                && nimetus != null && !"".equals(nimetus)
                )
            addNewAuasteTyyp(kood, nimetus, kommentaar);

        int i=0;
        while (request.getParameter("existing.tyyp["+i+"]") != null
                && !"".equals(request.getParameter("existing.tyyp[" + i + "]"))){
            if("changed".equals(request.getParameter("existing.tyyp[" + i + "]"))){
                String existingAuasteTyypNimetus = request.getParameter("existing.tyyp[" + i + "].nimetus");
                String existingAuasteTyypKood = request.getParameter("existing.tyyp[" + i + "].kood");
                String existingAuasteTyypKommentaar = request.getParameter("existing.tyyp[" + i + "].kommentaar");
                String existingAuasteTyypId = request.getParameter("existing.tyyp[" + i + "].id");
                updateAuasteTyyp(Long.valueOf(existingAuasteTyypId), existingAuasteTyypKood, existingAuasteTyypNimetus,
                        existingAuasteTyypKommentaar);
            }

            i++;
        }
    }

    public void addOrUpdateAuaste(HttpServletRequest request) {
        String kood = request.getParameter("new.auaste.kood");
        String nimetus = request.getParameter("new.auaste.nimetus");
        String tyyp = request.getParameter("new.auaste.tyyp");
        if (kood != null && !"".equals(kood)
                && nimetus != null && !"".equals(nimetus)
                && tyyp != null && !"".equals(tyyp))
            addNewAuaste(kood, nimetus, Integer.valueOf(tyyp));

        int i=0;
        while (request.getParameter("existing.auaste["+i+"]") != null
                && !"".equals(request.getParameter("existing.auaste[" + i + "]"))){
            if("changed".equals(request.getParameter("existing.auaste[" + i + "]"))){
                String existingAuasteNimetus = request.getParameter("existing.auaste[" + i + "].nimetus");
                String existingAuasteKood = request.getParameter("existing.auaste[" + i + "].kood");
                String existingAuasteTyyp = request.getParameter("existing.auaste[" + i + "].tyyp");
                String existingAuasteId = request.getParameter("existing.auaste[" + i + "].id");
                updateAuaste(Long.valueOf(existingAuasteId), existingAuasteKood, existingAuasteNimetus,
                        Integer.valueOf(existingAuasteTyyp));
            }

            i++;
        }
    }

    public void addOrUpdatePiirivalvurAuaste(HttpServletRequest request) {
        Long piirivalvurId = Long.valueOf(request.getParameter("new.piirivalvurAuaste.kood"));
        Long auasteId = Long.valueOf(request.getParameter("new.piirivalvurAuaste.nimetus"));
        String kommentaar = request.getParameter("new.piirivalvurAuaste.tyyp");
        String alates = request.getParameter("new.piirivalvurAuaste.alates");
        String kuni = request.getParameter("new.piirivalvurAuaste.alates");
        if (piirivalvurId != null && auasteId != null)
            addNewPiirivalvurAuaste(alates, kuni, auasteId, piirivalvurId, kommentaar);

        int i=0;
        while (request.getParameter("existing.auaste["+i+"]") != null
                && !"".equals(request.getParameter("existing.auaste[" + i + "]"))){
            if("changed".equals(request.getParameter("existing.auaste[" + i + "]"))){
                String existingAuasteId = request.getParameter("existing.auaste[" + i + "].auasteId");
                String existingPiirivalvurId = request.getParameter("existing.auaste[" + i + "].piirivalvurId");
                String existingKommentaar = request.getParameter("existing.auaste[" + i + "].kommentaar");
                String existingAlates = request.getParameter("existing.auaste[" + i + "].alates");
                String existingKuni = request.getParameter("existing.auaste[" + i + "].kuni");
                long existingId = Long.valueOf(request.getParameter("existing.auaste[" + i + "].id"));
                updatePiirivalvurAuaste(existingId, kommentaar, Long.valueOf(existingAuasteId), Long.valueOf(existingPiirivalvurId),
                        existingAlates, existingKuni);
            }

            i++;
        }
    }

    public BorderDAO getBorderDAO() {
        return borderDAO;
    }

    public void setBorderDAO(BorderDAO borderDAO) {
        this.borderDAO = borderDAO;
    }
}
