package ExecuteQueries;

public class pinCodeDetails {
	

	public static String pinCodeCities(Integer pinCode) {
		String city = null;
		if (pinCode.equals("632521")) {
			city = "villapakkam";
		} else if (pinCode.equals("632523")) {
			city = "arcot";
		} else {
			city = "vellore";
		}
		return city;
	}
}
