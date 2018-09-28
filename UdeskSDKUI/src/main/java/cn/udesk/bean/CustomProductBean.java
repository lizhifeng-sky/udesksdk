package cn.udesk.bean;

import java.util.List;
import java.util.Map;

import udesk.core.model.Product;

/**
 * Created by lizhifeng on 2018/9/21.
 */

public class CustomProductBean {
    private String name;
    private String url;
    private String imgUrl;
    private List<CustomParamsBean> params;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CustomParamsBean> getParams() {
        return params;
    }

    public void setParams(List<CustomParamsBean> params) {
        this.params = params;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
