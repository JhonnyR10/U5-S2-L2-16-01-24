package giovannilongo.U5S2L2160124.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
