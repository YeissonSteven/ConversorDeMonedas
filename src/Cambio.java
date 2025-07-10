public record Cambio(Double conversion_rate) {
    @Override
    public String toString() {
        return "la taza de conversion es de: " + conversion_rate;
    }
}
