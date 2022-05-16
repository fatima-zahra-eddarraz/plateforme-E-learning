package learn;

import java.util.HashMap;
import java.util.Map;

public abstract class Mediateur {
	Map<String, User> map=new HashMap<>();
	public abstract void TransmettreMsg(Message m);
	public void addColl(String ref, User c) {
		map.put(ref,c);
	}
}
