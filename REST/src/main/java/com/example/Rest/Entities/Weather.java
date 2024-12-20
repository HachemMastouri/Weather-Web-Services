package com.example.Rest.Entities;

public class Weather {
    private String city;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String description;

    public Weather(String city, double temperature, int humidity, double windSpeed, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.description = description;
    }

    public String getCity() { return city; }
    public double getTemperature() { return temperature; }
    public int getHumidity() { return humidity; }
    public double getWindSpeed() { return windSpeed; }
    public String getDescription() { return description; }

    public void setCity(String city) { this.city = city; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setHumidity(int humidity) { this.humidity = humidity; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }
    public void setDescription(String description) { this.description = description; }
}
