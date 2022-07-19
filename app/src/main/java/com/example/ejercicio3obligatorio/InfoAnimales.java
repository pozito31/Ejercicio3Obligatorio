package com.example.ejercicio3obligatorio;

public class InfoAnimales {
    /**
     * {
     *     "message": "https://images.dog.ceo/breeds/puggle/IMG_124524.jpg",
     *     "status": "success"
     * }
     */
    private String message;
    private String status;

    public InfoAnimales() {
    }

    public InfoAnimales(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InfoAnimales{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
