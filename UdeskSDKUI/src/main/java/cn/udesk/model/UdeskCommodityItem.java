package cn.udesk.model;import java.util.List;import java.util.Map;import udesk.core.model.MessageInfo;public class UdeskCommodityItem extends MessageInfo {   /**    * 图像的url    */   private String thumbHttpUrl = "";   private String title = "";   private String subTitle = "";   /**    * 商品链接的url    */   private String commodityUrl = "";   private List<Map<String,String>> param;   public List<Map<String, String>> getParam() {      return param;   }   public void setParam(List<Map<String, String>> param) {      this.param = param;   }   public UdeskCommodityItem(){   }   public UdeskCommodityItem(String commodityUrl, String subTitle, String thumbHttpUrl, String title) {      this.commodityUrl = commodityUrl;      this.subTitle = subTitle;      this.thumbHttpUrl = thumbHttpUrl;      this.title = title;   }   public String getCommodityUrl() {      return commodityUrl;   }   public void setCommodityUrl(String commodityUrl) {      this.commodityUrl = commodityUrl;   }   public String getSubTitle() {      return subTitle;   }   public void setSubTitle(String subTitle) {      this.subTitle = subTitle;   }   public String getThumbHttpUrl() {      return thumbHttpUrl;   }   public void setThumbHttpUrl(String thumbHttpUrl) {      this.thumbHttpUrl = thumbHttpUrl;   }   public String getTitle() {      return title;   }   public void setTitle(String title) {      this.title = title;   }}