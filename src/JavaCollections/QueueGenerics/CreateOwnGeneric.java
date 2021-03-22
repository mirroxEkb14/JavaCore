package JavaCollections.QueueGenerics;

public class CreateOwnGeneric<T> {
    private T contents;
    public CreateOwnGeneric(T contents) {
        this.contents = contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public T getContents() {
        return contents;
    }
}
