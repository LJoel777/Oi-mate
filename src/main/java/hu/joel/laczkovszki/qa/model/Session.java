package hu.joel.laczkovszki.qa.model;

public class Session {
    private boolean isValid;
    private Long id;

    public boolean isValid() {
        return isValid;
    }

    public Session(boolean isValid, Long id) {
        this.isValid = isValid;
        this.id = id;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
