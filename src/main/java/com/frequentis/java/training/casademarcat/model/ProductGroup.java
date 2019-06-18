package com.frequentis.java.training.casademarcat.model;

import java.util.Objects;

public class ProductGroup {
    private final int id;
    private String groupName;
    private String groupDescription;

    public ProductGroup(int id, String groupName, String groupDescription) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGroup that = (ProductGroup) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
