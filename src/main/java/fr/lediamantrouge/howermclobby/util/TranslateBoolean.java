package fr.lediamantrouge.howermclobby.util;

public class TranslateBoolean {

    public static String EnableOrDisable(boolean bool) {
        if(bool) {
            return "§2§lActivé";
        } else {
            return "§c§lDésactivé";
        }
    }
}
