package net.hg.trucadas.model.domain.event;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * This class controls the execution flow (a very simple FSM)
 * 
 * @author hgeraldino
 * 
 */
public class EventFlow implements Serializable {

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

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public Map<Integer, EventStep> getSteps() {
        return steps;
    }

    public void setSteps(Map<Integer, EventStep> steps) {
        this.steps = steps;
    }

    /**
     * Builds a {@link EventFlow} from an XML definition
     * 
     * @param is
     * @return
     */
    public static EventFlow buildFromXml(InputStream is) {
        return null;
    }

    /**
     * Builds an {@link EventFlow} instance from an JSON (JavaScript Object
     * Notation) definition.
     * 
     * @param is
     * @return
     */
    public static EventFlow buildFromJson(InputStream is) {
        return null;
    }

}
