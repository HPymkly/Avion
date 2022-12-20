package com.main.demo.generic.convension;

import lombok.Getter;

@Getter
public enum Logic {
    Yes("1"), No("0");

    String signal;

    private Logic(String signal) {
        this.signal = signal;
    }

}
