package io.github.rainbyte.testspring.utils;

import java.util.Collection;

public class Validation {
    public static <T> T checkNull(T o, String error) throws AppException {
        if (o == null) {
            throw new AppException(error);
        }
        return o;
    }

    public static Boolean checkString(String s, String error) throws AppException {
        if(s == null || s.isEmpty()){
            throw new AppException(error);
        }
        return true;
    }

    public static <T> Boolean checkCollection(Collection<T> c, String error) throws AppException {
        if(c == null || c.isEmpty()){
            throw new AppException(error);
        }
        return true;
    }

    public static void checkIf(Boolean exp, String error) throws AppException {
        if (exp) throw new AppException(error);
    }

    public static void checkIf(Boolean exp, AppException e) throws AppException {
        if (exp) throw e;
    }
}
