package com.example.sportclub.model.requests;

public class DeletePlayerRequest {

    private String email;

    public DeletePlayerRequest() {
    }

    public DeletePlayerRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeletePlayerRequest that = (DeletePlayerRequest) o;

        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DeletePlayerRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
