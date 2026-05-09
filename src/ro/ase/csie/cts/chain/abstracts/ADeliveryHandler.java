package ro.ase.csie.cts.chain.abstracts;

public abstract class ADeliveryHandler {
    protected ADeliveryHandler nextHandler;

    public void setNextHandler(ADeliveryHandler handler) { this.nextHandler = handler; }

    public abstract void getDelivery(float weight);
}
