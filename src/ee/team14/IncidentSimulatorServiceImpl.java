package ee.team14;

import java.util.*;

/**
 * Created with IntelliJ IDEA. User: taivo Date: 11/11/12 Time: 12:11 PM To
 * change this template use File | Settings | File Templates.
 */
public class IncidentSimulatorServiceImpl implements IncidentService {

    private static String[] DESCRIPTION = { "Tulistamine",
            "Pommiplahvatus", "Autoõnnetus", "Chuck Norris",
            "Mitte midagi ei juhtunud" };

    private static String[] LOCATIONS = { "Tallinn", "Tartu", "Narva",
            "Kohtla-Järve", "Pärnu", "Viljandi", "Rakvere", "Maardu",
            "Sillamäe", "Kuressaare" };

    private static String[] STATUS = { "Pooleli", "Lõpetatud" };

    private Date generateDate(int pos) {
		int day, month, year = 2000;
		
		Random kp = new Random();
		month = kp.nextInt(12)+1;
		if(pos == 0){
			year = kp.nextInt(6) + 2000;
		} else {
			year = kp.nextInt(6) + 2006;
		}
		day = kp.nextInt(30);

		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		return calendar.getTime();
	}

	@Override
	public List<Incident> getUnresolvedIncidents() {
		List<Incident> incidents = new ArrayList<Incident>();

		Random random = new Random();
		int incidentCount = random.nextInt(10) + 1;

		for (int i = 0; i < incidentCount; i++) {

			int locationRandom = random.nextInt(LOCATIONS.length);
			int guardsRandom = random.nextInt(50) + 1;
			int descriptionRandom = random.nextInt(DESCRIPTION.length);
			int statusRandom = random.nextInt(STATUS.length);

			Incident incident = new Incident();
			incident.setEnd(generateDate(1));
			incident.setLocation(locationRandom+"");
			incident.setDescription(descriptionRandom+"");
			incident.setInvolvedGuardCount(guardsRandom);
			incident.setStatus(statusRandom+"");
			incident.setStart(generateDate(0));
			incidents.add(incident);
		}

		return incidents;
	}

    public Incident getUnresolvedIncident(String end, String location, String description, String status, String start){
        Incident incident = new Incident();
        incident.setEnd(stringToDate(end));
        incident.setLocation(location);
        incident.setDescription(description);
        Random random = new Random();
        int guardsRandom = random.nextInt(50) + 1;
        incident.setInvolvedGuardCount(guardsRandom);
        incident.setStatus(status);
        incident.setStart(stringToDate(start));
        return incident;
    }

    private Date stringToDate(String input){
        String[] pieces = input.split("\\.");
        int day = Integer.parseInt(pieces[0]);
        int month = Integer.parseInt(pieces[1]);
        int year = Integer.parseInt(pieces[2]);

        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}
