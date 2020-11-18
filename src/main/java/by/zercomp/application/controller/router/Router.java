package by.zercomp.application.controller.router;

public class Router {
    private String page;
    private RouterType type = RouterType.FORWARD;

    public Router() {}

    public Router(String page) {
        this.page = page;
    }

    public Router(String page, RouterType type) {
        this.page = page;
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public RouterType getType() {
        return type;
    }

    public void setType(RouterType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Router router = (Router) o;

        if (getPage() != null ? !getPage().equals(router.getPage()) : router.getPage() != null) return false;
        return getType() == router.getType();
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = getPage() != null ? getPage().hashCode() : 0;
        result = prime * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
