package com.lpache.mtgbinder.Entity;

/**
 * Created by luis on 10/07/15.
 */
public enum Language {
    English,
    French,
    German,
    Spanish,
    Italian;

    public int getValue(){
        switch (this)
        {
            case English:   return 1;
            case French:    return 2;
            case German:    return 3;
            case Spanish:   return 4;
            case Italian:   return 5;
            default: return 0;
        }
    }
}
