package com.company;

import java.util.*;

class UnluckyVassal {

    public UnluckyVassal parent;
    public String name;
    public List<UnluckyVassal> vassals;

    public UnluckyVassal(String name) {
        this.name = name;
    }

    public UnluckyVassal() {
    }

    public UnluckyVassal getParent() {
        return parent;
    }

    public void setParent(UnluckyVassal parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnluckyVassal> getVassals() {
        return vassals;
    }

    public void setVassals(List<UnluckyVassal> vassals) {
        this.vassals = vassals;
    }
}