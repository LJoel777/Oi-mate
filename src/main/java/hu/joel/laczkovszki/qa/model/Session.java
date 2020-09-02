package hu.joel.laczkovszki.qa.model;

public class Session {
    private boolean isValid;
    private int id;

    public boolean isValid() {
        return isValid;
    }

    public Session(boolean isValid, int id) {
        this.isValid = isValid;
        this.id = id;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
