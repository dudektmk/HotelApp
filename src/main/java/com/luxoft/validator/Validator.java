package com.luxoft.validator;

/**
 * Created by KGornicki on 2015-02-10.
 */
public  class Validator {

    public static boolean validateRoomId(Object obj){
        return ((String) obj).matches("^[\\w\\.]+ ?[\\w\\.]*");
}


}
