package edu.tiago.model;

public enum GameStatusEnum {

    NOT_STARTED("Não iniciado"),
    INCOMPLETE("Incompleto"),
    COMPLETED("Finalizado");

    private String label;

    GameStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
