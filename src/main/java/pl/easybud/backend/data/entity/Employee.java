package pl.easybud.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Employee extends AbstractEntity {

  @NotNull
  @Column(nullable = false)
  private String name;

  private String label;

  //  private String phone;
  //
  //  @NotNull
  //  @Enumerated(EnumType.STRING)
  //  @Column(nullable = false)
  //  private UserType userType;

  @NotNull
  @Column(nullable = false)
  private String status;

  private String description;
  //  @OneToMany(cascade = CascadeType.ALL)
  //  private Set<Note> notes = new HashSet<>();

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
