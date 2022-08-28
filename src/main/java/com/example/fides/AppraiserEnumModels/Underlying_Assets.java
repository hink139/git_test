package com.example.fides.AppraiserEnumModels;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Underlying_Assets {

    @Getter
    @AllArgsConstructor
    public enum SelectList {
        LISTED(0),
        UNLISTED(1);
        private int code;
    }



}
