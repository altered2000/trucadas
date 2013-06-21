package net.hg.trucadas.model.domain;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * This class controls the execution flow (a very simple FSM)
 * 
 * @author hgeraldino
 * 
 */
public class EventController implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String controllerName;

	/**
	 * 
	 */
	private int currentStep = 0;

	/**
	 * {@link EventStep}
	 */
	private Map<Integer, EventStep> steps;

	/**
	 * Builds a {@link EventController} from an XML definition
	 * 
	 * @param is
	 * @return
	 */
	public static EventController buildFromXml(InputStream is) {
		return null;
	}

	/**
	 * Builds an {@link EventController} instance from an JSON (JavaScript Object
	 * Notation) definition.
	 * 
	 * @param is
	 * @return
	 */
	public static EventController buildFromJson(InputStream is) {
		return null;
	}

}
