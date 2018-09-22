package pl.easybud.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "T_TOOLS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("TOOL")
public class Tool extends AbstractEntity {

  @NotNull
  @Column(nullable = false)
  private String name;

  @Column
  private String label;

  @Column
  private String description;

  @NotNull
  @Column(nullable = false)
  private String status;

  @Column(name = "purchase_date")
  private LocalDate purchase;

  //  @Enumerated(EnumType.STRING)
  //  @Column(name = "TYPE", updatable = false, insertable = false)
  //  private ToolType toolType;

  public Tool() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getPurchase() {
    return purchase;
  }

  public void setPurchase(LocalDate purchase) {
    this.purchase = purchase;
  }

}
