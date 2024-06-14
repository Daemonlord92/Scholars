package org.blitmatthew.classes;

import java.util.Objects;

public class RnMCharacters {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;

    public RnMCharacters() {
    }

    public RnMCharacters(Integer id, String name, String status, String species, String type, String gender) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RnMCharacters that = (RnMCharacters) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getSpecies(), that.getSpecies()) && Objects.equals(getType(), that.getType()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStatus(), getSpecies(), getType(), getGender());
    }

    @Override
    public String toString() {
        return "RnMCharacters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
