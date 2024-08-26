package common;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		// mappings.put("/board.do", new Controller());
	}
	
	public Controller getController(String path) {
        return mappings.get(path);
    }
}
