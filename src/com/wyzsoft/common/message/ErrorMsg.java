package com.wyzsoft.common.message;

/**
 * Subject :
 * User: lke
 * Date: 12. 4. 17
 */
public enum ErrorMsg {
    //주문완료, 배송계획, 배송완료
    PASS(1), DUPLICATE(2), WRONG_DATA(3), FAIL(100), NONE(-1);

    private final int value;

    ErrorMsg(int value) {
        this.value = value;
    }

    public int intValue(){
        return value;
    }

    public static ErrorMsg valueOf(int value){
        switch (value){
            case 1:return PASS;
            case 2:return DUPLICATE;
            case 3:return WRONG_DATA;
            case 100:return FAIL;
            default:return NONE;
        }
    }

    public static String message(int value){
        switch (value){
            case 1:return "";
            case 2:return "중복된 데이터입니다";
            case 3:return "잘못된 데이터입니다.";
            case 100:return "실패했습니다.";
            default:return "";
        }
    }

}
