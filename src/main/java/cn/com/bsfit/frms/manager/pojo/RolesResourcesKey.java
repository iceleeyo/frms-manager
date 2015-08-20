package cn.com.bsfit.frms.manager.pojo;

import java.io.Serializable;

public class RolesResourcesKey implements Serializable {
    private Integer resourcesId;

    private Integer rolesId;

    private static final long serialVersionUID = 1L;

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RolesResourcesKey other = (RolesResourcesKey) that;
        return (this.getResourcesId() == null ? other.getResourcesId() == null : this.getResourcesId().equals(other.getResourcesId()))
            && (this.getRolesId() == null ? other.getRolesId() == null : this.getRolesId().equals(other.getRolesId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResourcesId() == null) ? 0 : getResourcesId().hashCode());
        result = prime * result + ((getRolesId() == null) ? 0 : getRolesId().hashCode());
        return result;
    }
}