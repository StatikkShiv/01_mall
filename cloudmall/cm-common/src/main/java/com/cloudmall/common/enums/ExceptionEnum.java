package com.cloudmall.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@NoArgsConstructor//自动生成无参数构造函数。
//@AllArgsConstructor//自动生成全参数构造函数。
public enum ExceptionEnum {

    //private  static final ExceptionEnum ff=new ExceptionEnum(400,"价格不能为空");//老写法
    //枚举必须定义在最前面
    PRICE_CANNOT_BE_NULL(400,"价格不能为空!"),
    PRODUCT_CANNOT_BE_NULL(400,"商品不能为空!"),
    CATEGORY_NOT_FOUND(404,"没有查询到商品分类"),
    BRAND_NOT_FOUND(404,"品牌不存在"),
    BRAND_SAVE_EROOR(500,"新增品牌失败"),
    BRAND_INTERMEDIDATE_SAVE_EROOR(500,"新增品牌分类中间表失败"),
    UPLOAD_FILE_ERROR(500,"文件上传失败!"),
    INVALID_FILE_TYPE(500,"无效的文件类型")
    ;
    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
