package com.mygdx.game.util;

public enum Resolution {

    HD(1366, 768),
    FULL_HD(1920, 1080);

    private Integer height;
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    Resolution(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }
}
