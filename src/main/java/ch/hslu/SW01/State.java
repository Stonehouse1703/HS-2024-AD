package ch.hslu.SW01;

public enum State {
    FREE(0), ALLOCATED(1);

    private final int value;

    private State(final int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
