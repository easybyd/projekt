package pl.easybud.backend.data.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("VEHICLE")
public class Vehicle extends Tool {

  private String regNumber;

  private LocalDate insurance;

  private LocalDate inspection;

  private String seats;

  public Vehicle() {
  }

  public String getRegNumber() {
    return regNumber;
  }

  public void setRegNumber(String regNumber) {
    this.regNumber = regNumber;
  }

  public LocalDate getInsurance() {
    return insurance;
  }

  public void setInsurance(LocalDate insurance) {
    this.insurance = insurance;
  }

  public LocalDate getInspection() {
    return inspection;
  }

  public void setInspection(LocalDate inspection) {
    this.inspection = inspection;
  }

  public String getSeats() {
    return seats;
  }

  public void setSeats(String seats) {
    this.seats = seats;
  }

}

