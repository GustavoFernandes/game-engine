package com.github.gustavofernandes.gameengine.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Win {

    private WinLocation location;
    private int index;

    public Win(WinLocation location) {
        this(location, -1);
    }

    public Win(WinLocation location, int index) {
        this.location = location;
        this.index = index;
    }

    // TODO check if these getters can be deleted
    public WinLocation getLocation() {
        return this.location;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        return "Win[" + this.location + " " + this.index + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Win)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Win otherWin = (Win) obj;
        return new EqualsBuilder()
                .append(this.location, otherWin.location)
                .append(this.index, otherWin.index)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(this.location)
                .append(this.index)
                .toHashCode();
    }
}
