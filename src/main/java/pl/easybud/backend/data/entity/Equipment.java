package pl.easybud.backend.data.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("EQUIPMENT")
public class Equipment extends Tool {

  private String serialNumber;

  private LocalDate quarantee;

  public Equipment() {
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public LocalDate getQuarantee() {
    return quarantee;
  }

  public void setQuarantee(LocalDate quarantee) {
    this.quarantee = quarantee;
  }
}
