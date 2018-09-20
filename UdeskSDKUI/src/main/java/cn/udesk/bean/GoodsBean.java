package cn.udesk.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lizhifeng on 2018/9/20.
 */

public class GoodsBean {
    //基础属性
    private Integer pdSpuId;
    private Integer pdSkuId;
    private String name;
    private String spuName;//收藏专用
    private BigDecimal price;//商品价格(BigDecimal) 指定规格的价格
    private List<String> pic;//商品图片
    private String mainPicUrl;
    private String pdBrand;//商品品牌
    private String region;//商品地区
    private Integer stockStatus;//大于0  有货
    private String productTypeName;
    private String displayName;
    private BigDecimal maxCPrice;//商品价格(BigDecimal)
    private BigDecimal minCPrice;//商品价格(BigDecimal)  展示最小价格  首页 和 分类
    private String shareUrl;
    private Integer qty;
    private Integer qtyLeft;
    private Integer favoritesFlg;//0/1 没收藏/已收藏
    private Integer shopCartCount;

    private Integer cartId;

    //会员卡价格
    private BigDecimal currentPrice;//当前价格

    private BigDecimal goldCardPrice;//            金卡价格
    private BigDecimal silverCardPrice;//            银卡价格
    private Integer goldIconDisplay;//            金卡图标是否显示  是否能显示金卡图标 0 否 1能
    private Integer silverIconDisplay;//            银卡图标是否显示 是否能显示金卡图标 0 否 1能
    private BigDecimal goldCrosslinePrice;//            金卡划线价格
    private BigDecimal silverCrosslinePrice;//            银卡划线价格

    public Integer getPdSpuId() {
        return pdSpuId;
    }

    public void setPdSpuId(Integer pdSpuId) {
        this.pdSpuId = pdSpuId;
    }

    public Integer getPdSkuId() {
        return pdSkuId;
    }

    public void setPdSkuId(Integer pdSkuId) {
        this.pdSkuId = pdSkuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }

    public String getPdBrand() {
        return pdBrand;
    }

    public void setPdBrand(String pdBrand) {
        this.pdBrand = pdBrand;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BigDecimal getMaxCPrice() {
        return maxCPrice;
    }

    public void setMaxCPrice(BigDecimal maxCPrice) {
        this.maxCPrice = maxCPrice;
    }

    public BigDecimal getMinCPrice() {
        return minCPrice;
    }

    public void setMinCPrice(BigDecimal minCPrice) {
        this.minCPrice = minCPrice;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQtyLeft() {
        return qtyLeft;
    }

    public void setQtyLeft(Integer qtyLeft) {
        this.qtyLeft = qtyLeft;
    }

    public Integer getFavoritesFlg() {
        return favoritesFlg;
    }

    public void setFavoritesFlg(Integer favoritesFlg) {
        this.favoritesFlg = favoritesFlg;
    }

    public Integer getShopCartCount() {
        return shopCartCount;
    }

    public void setShopCartCount(Integer shopCartCount) {
        this.shopCartCount = shopCartCount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getGoldCardPrice() {
        return goldCardPrice;
    }

    public void setGoldCardPrice(BigDecimal goldCardPrice) {
        this.goldCardPrice = goldCardPrice;
    }

    public BigDecimal getSilverCardPrice() {
        return silverCardPrice;
    }

    public void setSilverCardPrice(BigDecimal silverCardPrice) {
        this.silverCardPrice = silverCardPrice;
    }

    public Integer getGoldIconDisplay() {
        return goldIconDisplay;
    }

    public void setGoldIconDisplay(Integer goldIconDisplay) {
        this.goldIconDisplay = goldIconDisplay;
    }

    public Integer getSilverIconDisplay() {
        return silverIconDisplay;
    }

    public void setSilverIconDisplay(Integer silverIconDisplay) {
        this.silverIconDisplay = silverIconDisplay;
    }

    public BigDecimal getGoldCrosslinePrice() {
        return goldCrosslinePrice;
    }

    public void setGoldCrosslinePrice(BigDecimal goldCrosslinePrice) {
        this.goldCrosslinePrice = goldCrosslinePrice;
    }

    public BigDecimal getSilverCrosslinePrice() {
        return silverCrosslinePrice;
    }

    public void setSilverCrosslinePrice(BigDecimal silverCrosslinePrice) {
        this.silverCrosslinePrice = silverCrosslinePrice;
    }
}
