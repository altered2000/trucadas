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

    public static EventFlow buildFromXml(InputStream is) {
        return null;
    }

    public static EventFlowBuilder builder() {
        return EventFlowBuilder.builder();
    }

    static class EventFlowBuilder {

        private enum InputFormat {
            XML, JSON
        };

        private InputStream inputStream;

        private InputFormat format;

        public static EventFlowBuilder builder() {
            return new EventFlowBuilder();
        }

        public EventFlowBuilder setXmlDefinition(InputStream in) {
            this.format = InputFormat.XML;
            this.inputStream = in;
            return this;
        }

        public EventFlowBuilder setJsonDefinition(InputStream in) {
            this.format = InputFormat.JSON;
            this.inputStream = in;
            return this;
        }

        /**
         * Builds a {@link EventFlow} from an XML/JSON definition.
         * 
         * The definition must be set by calling the
         * {@link EventFlowBuilder#setXmlDefinition(InputStream)} or
         * {@link EventFlowBuilder#setJsonDefinition(InputStream)} methods
         * before calling the {@link EventFlowBuilder#build()} method
         * 
         * @return
         */

        public EventFlow build() {
            return new EventFlow();
        }

    }

}
