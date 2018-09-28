package cn.udesk.bean;

/**
 * Created by lizhifeng on 2018/9/25.
 */

public class CustomParamsBean {
    private String text;
    private String color;
    private Boolean fold;
    private Integer size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFold() {
        return fold;
    }

    public void setFold(Boolean fold) {
        this.fold = fold;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
