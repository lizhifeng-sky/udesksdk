package udesk.sdk.demo.activity;

/**
 * Created by lizhifeng on 2018/9/25.
 */

public class UdeskUserInfo {
    private String sdk_token;
    private String nick_name;
    private String cellphone;
    private String email;
    private String description;

    public UdeskUserInfo(String sdk_token, String nick_name, String cellphone, String email, String description) {
        this.sdk_token = sdk_token;
        this.nick_name = nick_name;
        this.cellphone = cellphone;
        this.email = email;
        this.description = description;
    }

    public String getSdk_token() {
        return sdk_token;
    }

    public void setSdk_token(String sdk_token) {
        this.sdk_token = sdk_token;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
