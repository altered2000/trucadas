package net.hg.trucadas.model.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author hgeraldino
 * 
 */
public class EventStep implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private int stepNumber;

	/**
	 * 
	 */
	private String beanHandlerName;

	/**
	 * 
	 */
	private Map<EventActionResult, EventStep> nextSteps;

	/**
	 * 
	 */
	private Map<String, String> properties;

	/**
	 * 
	 */
	private Map<String, String> stepData;

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	public String getBeanHandlerName() {
		return beanHandlerName;
	}

	public void setBeanHandlerName(String beanHandlerName) {
		this.beanHandlerName = beanHandlerName;
	}

	public Map<EventActionResult, EventStep> getNextSteps() {
		return nextSteps;
	}

	public void setNextSteps(Map<EventActionResult, EventStep> nextSteps) {
		this.nextSteps = nextSteps;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, String> getStepData() {
		return stepData;
	}

	public void setStepData(Map<String, String> stepData) {
		this.stepData = stepData;
	}

}