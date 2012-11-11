package ee.team14;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: taivo Date: 11/11/12 Time: 12:11 PM To
 * change this template use File | Settings | File Templates.
 */
public class IncidentSimulatorServiceImpl implements IncidentService {
	private Date generateDate(int pos = 0) {
		int day, month, year = 2000;
		
		Random kp = new Random();
		month = call.nextInt(12)+1;
		if(pos == 0){
			year = call.nextInt(6) + 2000;
		} else {
			year = call.nextInt(6) + 2006;
		}
		day = call.nextInt(30);

		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		return calendar.getTime();
	}

	@Override
	public List<Incident> getUnresolvedIncidents() {
		List<Incident> incidents = new List<Incident>();

		private static String[] DESCRIPTION = { "Tulistamine",
				"Pommiplahvatus", "Autoõnnetus", "Chuck Norris",
				"Mitte midagi ei juhtunud" };

		private static String[] LOCATIONS = { "Tallinn", "Tartu", "Narva",
				"Kohtla-Järve", "Pärnu", "Viljandi", "Rakvere", "Maardu",
				"Sillamäe", "Kuressaare" };
		
		private static String[] STATUS = { "Pooleli", "Lõpetatud" };

		Random random = new Random();
		int incidentCount = random.nextInt(10) + 1;

		for (int i = 0; i < incidentCount; i++) {

			int locationRandom = random.nextInt(LOCATIONS.length);
			int guardsRandom = random.nextInt(50) + 1;
			int descriptionRandom = random.nextInt(DESCRIPTION.length);
			int statusRandom = random.nextInt(STATUS.length);

			Incident incident = new Incident();
			incident.setEnd(generateDate(1));
			incident.setLocation(locationRandom);
			incident.setDescription(descriptionRandom);
			incident.setInvolvedGuardCount(guardsRandom);
			incident.setStatus(statusRandom);
			incident.setStart(generateDate(0));

			incidents.add(incident);
		}

		return incidents;
	}
}
