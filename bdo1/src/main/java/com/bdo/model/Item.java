package com.bdo.model;

import com.bdo.enums.CraftType;

public class Item {

    private final long id;
    private final long name;
    private final CraftType craftType;
    private final long exp;
    private final SkillLevel skillLevel;

    public Item(long id, long name, CraftType craftType, long exp, SkillLevel skillLevel) {
        this.id = id;
        this.name = name;
        this.craftType = craftType;
        this.exp = exp;
        this.skillLevel = skillLevel;
    }
}

