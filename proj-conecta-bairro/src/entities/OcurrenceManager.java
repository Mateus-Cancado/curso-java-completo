package entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OcurrenceManager {

	private Map<User, List<Ocurrence>> geralMap = new LinkedHashMap<>();
	
	public void addOcurrenceUser(User user, Ocurrence oc) {
        if (!geralMap.containsKey(user)) {
        	geralMap.put(user, new ArrayList<>());
        }
        if (oc != null) {
        	geralMap.get(user).add(oc);
        }
    }
	
	public List<Ocurrence> getUserOcurrence(User user) {
        return geralMap.get(user);
    }
	
	public List<User> getAllKeys() {
		return new ArrayList<>(geralMap.keySet());
	}
}
