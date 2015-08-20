package cn.com.bsfit.frms.manager.pojo;

import java.io.Serializable;

public class UsersRolesKey implements Serializable {
    private Integer rolesId;

    private Integer usersId;

    private static final long serialVersionUID = 1L;

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
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
        UsersRolesKey other = (UsersRolesKey) that;
        return (this.getRolesId() == null ? other.getRolesId() == null : this.getRolesId().equals(other.getRolesId()))
            && (this.getUsersId() == null ? other.getUsersId() == null : this.getUsersId().equals(other.getUsersId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRolesId() == null) ? 0 : getRolesId().hashCode());
        result = prime * result + ((getUsersId() == null) ? 0 : getUsersId().hashCode());
        return result;
    }
}