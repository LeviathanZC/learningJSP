package by.zercomp.application.model.entity;

import java.io.Serializable;

public class Identifiable implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Identifiable that = (Identifiable) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Identifiable{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
