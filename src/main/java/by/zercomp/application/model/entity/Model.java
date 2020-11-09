package by.zercomp.application.model.entity;

public class Model extends Identifiable {

    private String name;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;

        Model model = (Model) o;

        return getName() != null ? getName().equals(model.getName()) : model.getName() == null;
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = super.hashCode();
        result = prime * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Model{");
        builder.append("name='").append(this.name).append("'\n}");
        return builder.toString();
    }
}
