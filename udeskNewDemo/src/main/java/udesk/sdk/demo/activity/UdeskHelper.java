package udesk.sdk.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.udesk.PreferenceHelper;
import cn.udesk.UdeskSDKManager;
import cn.udesk.callback.IFunctionItemClickCallBack;
import cn.udesk.callback.ILocationMessageClickCallBack;
import cn.udesk.callback.INavigationItemClickCallBack;
import cn.udesk.callback.ITxtMessageWebonCliclk;
import cn.udesk.callback.IUdeskStructMessageCallBack;
import cn.udesk.config.UdeskConfig;
import cn.udesk.model.NavigationMode;
import cn.udesk.presenter.ChatActivityPresenter;
import udesk.core.UdeskConst;
import udesk.sdk.demo.R;
import udesk.sdk.demo.maps.LocationActivity;
import udesk.sdk.demo.maps.ShowSelectLocationActivity;

/**
 * Created by lizhifeng on 2018/9/25.
 */

public class UdeskHelper {

    public void init(Context context,
                      String domain,
                      String key,
                      String appId,
                      String sdkToken) {
        UdeskSDKManager.getInstance().initApiKey(context, domain,
                key, appId);
        UdeskConst.HTTP = "http://";
        PreferenceHelper.write(context, "init_base_name", "sdktoken", sdkToken);
        PreferenceHelper.write(context, "init_base_name", "domain", domain);
        PreferenceHelper.write(context, "init_base_name", "appkey", key);
        PreferenceHelper.write(context, "init_base_name", "appid", appId);
    }

    public void startTarget(Context context,String targetId) {
        if (targetId!=null){
            targetId="95278";
        }
        UdeskSDKManager.getInstance().entryChat(
                context,
                makeBuilder(context).setAgentId(targetId, true).build(),
                PreferenceHelper.readString(context, "init_base_name", "sdktoken"));
    }

    private UdeskConfig.Builder makeBuilder(final Context context) {
        UdeskConfig.Builder builder = new UdeskConfig.Builder();
        builder.setUdeskTitlebarBgResId(R.color.udesk_titlebar_bg1) //设置标题栏TitleBar的背景色
                .setUdeskTitlebarTextLeftRightResId(R.color.udesk_color_navi_text1) //设置标题栏TitleBar，左右两侧文字的颜色
                .setUdeskIMLeftTextColorResId(R.color.udesk_color_im_text_left1) //设置IM界面，左侧文字的字体颜色
                .setUdeskIMRightTextColorResId(R.color.udesk_color_im_text_right1) // 设置IM界面，右侧文字的字体颜色
                .setUdeskIMAgentNickNameColorResId(R.color.udesk_color_im_left_nickname1) //设置IM界面，左侧客服昵称文字的字体颜色
                .setUdeskIMTimeTextColorResId(R.color.udesk_color_im_time_text1) // 设置IM界面，时间文字的字体颜色
                .setUdeskIMTipTextColorResId(R.color.udesk_color_im_tip_text1) //设置IM界面，提示语文字的字体颜色，比如客服转移
                .setUdeskbackArrowIconResId(R.drawable.udesk_titlebar_back) // 设置返回箭头图标资源id
                .setUdeskCommityBgResId(R.color.udesk_color_im_commondity_bg1) //咨询商品item的背景颜色
                .setUdeskCommityTitleColorResId(R.color.udesk_color_im_commondity_title1) // 商品介绍Title的字样颜色
                .setUdeskCommitysubtitleColorResId(R.color.udesk_color_im_commondity_subtitle1)// 商品咨询页面中，商品介绍子Title的字样颜色
                .setUdeskCommityLinkColorResId(R.color.udesk_color_im_commondity_link1) //商品咨询页面中，发送链接的字样颜色
                .setUserSDkPush(true) // 配置 是否使用推送服务  true 表示使用  false表示不使用
                .setOnlyUseRobot(false)//配置是否只使用机器人功能 只使用机器人功能,只使用机器人功能;  其它功能不使用。
//        force_quit.isChecked() ? UdeskConfig.UdeskQuenuFlag.FORCE_QUIT : UdeskConfig.UdeskQuenuFlag.Mark
                .setUdeskQuenuMode(UdeskConfig.UdeskQuenuFlag.FORCE_QUIT)  //  配置放弃排队的策略
                .setUseVoice(true) // 是否使用录音功能  true表示使用 false表示不使用
                .setUsephoto(true) //是否使用发送图片的功能  true表示使用 false表示不使用
                .setUsecamera(true) //是否使用拍照的功能  true表示使用 false表示不使用
                .setUsefile(true) //是否使用上传文件功能  true表示使用 false表示不使用
                .setUseMap(true) //是否使用发送位置功能  true表示使用 false表示不使用
                .setUseMapSetting(UdeskConfig.UdeskMapType.GaoDe, LocationActivity.class, new ILocationMessageClickCallBack() {
                    @Override
                    public void luanchMap(Context context, double latitude, double longitude, String selctLoactionValue) {
                        Intent intent = new Intent();
                        intent.putExtra(UdeskConfig.UdeskMapIntentName.Position, selctLoactionValue);
                        intent.putExtra(UdeskConfig.UdeskMapIntentName.Latitude, latitude);
                        intent.putExtra(UdeskConfig.UdeskMapIntentName.Longitude, longitude);
                        intent.setClass(context, ShowSelectLocationActivity.class);
                        context.startActivity(intent);
                    }
                })
                .setUseEmotion(true) //是否使用表情 true表示使用 false表示不使用
                .setUseMore(true) // 是否使用更多控件 展示出更多功能选项 true表示使用 false表示不使用
                .setUseNavigationSurvy(true) //设置是否使用导航UI中的满意度评价UI rue表示使用 false表示不使用
                .setUseSmallVideo(true)  //设置是否需要小视频的功能 rue表示使用 false表示不使用
                .setScaleImg(false) //上传图片是否使用原图 还是缩率图
                .setScaleMax(1024) // 缩放图 设置最大值，如果超出则压缩，否则不压缩
                .setOrientation(UdeskConfig.OrientationValue.portrait) //设置默认屏幕显示习惯
                .setUserForm(true) //在没有请求到管理员在后端对sdk使用配置下，在默认的情况下，是否需要表单留言，true需要， false 不需要
                .setDefualtUserInfo(getUserInfo(new UdeskUserInfo(
                        "",
                        "李志峰",
                        "13162137315",
                        "174@qq.com",
                        "我就是测试一下"))) // 创建用户基本信息
//                .setDefinedUserTextField(getDefinedUserTextField()) //创建用户自定义的文本信息
//                .setDefinedUserRoplist(getDefinedUserRoplist()) //创建用户自定义的列表信息
                .setUpdateDefualtUserInfo(updateUserInfo(new UdeskUserInfo(
                        "",
                        "李志峰",
                        "13162137315",
                        "174@qq.com",
                        "我就是测试一下"))) // 设置更新用户的基本信息
//                .setUpdatedefinedUserTextField(getUpdateDefinedTextField()) //设置用户更新自定义字段文本信息
//                .setUpdatedefinedUserRoplist(getUpdateDefinedRoplist()) //设置用户更新自定义列表字段信息
                .setFirstMessage("我是第一条信息") //设置带入一条消息  会话分配就发送给客服
                .setCustomerUrl("https://www.baidu.com/img/bd_logo1.png?qua=high") //设置客户的头像地址
//                .setRobot_modelKey(robot_modelKey.getText().toString()) // udesk 机器人配置插件 对应的Id值
//                .setConcatRobotUrlWithCustomerInfo(robpt_customer_info.getText().toString())
//                .setCommodity(set_use_commodity.isChecked() ? createCommodity() : null)//配置发送商品链接的mode
//                .setProduct(set_use_prouct.isChecked() ? createProduct() : null)//配置发送商品链接的mode
//                .setExtreFunctions(getExtraFunctions(), new IFunctionItemClickCallBack() {
//                    @Override
//                    public void callBack(Context context, ChatActivityPresenter mPresenter, int id, String name) {
//                        if (id == 21) {
//                            UdeskSDKManager.getInstance().toLanuchHelperAcitivty(getApplicationContext(), UdeskSDKManager.getInstance().getUdeskConfig());
//                            mPresenter.sendTxtMessage("打开帮助中心");
//                        } else if (id == 22) {
//                            mPresenter.sendTxtMessage("打开表单留言");
//                            UdeskSDKManager.getInstance().goToForm(getApplicationContext(), UdeskSDKManager.getInstance().getUdeskConfig());
//                        }
//                    }
//                })//在more 展开面板中设置额外的功能按钮
//                .setNavigations(set_use_navigation_view.isChecked(), getNavigations(), new INavigationItemClickCallBack() {
//                    @Override
//                    public void callBack(Context context, ChatActivityPresenter mPresenter, NavigationMode navigationMode) {
//                        if (navigationMode.getId() == 1) {
//                            mPresenter.sendProductMessage(createProduct());
//                        } else if (navigationMode.getId() == 2) {
//                            mPresenter.sendTxtMessage(UUID.randomUUID().toString());
//                            mPresenter.sendTxtMessage("www.baidu.com");
//                        }
//                    }
//                })
                //设置是否使用导航UI rue表示使用 false表示不使用
                .setTxtMessageClick(new ITxtMessageWebonCliclk() {
                    @Override
                    public void txtMsgOnclick(String url) {
                        Toast.makeText(context, "对文本消息中的链接消息处理设置回调", Toast.LENGTH_SHORT).show();
                    }
                })   //如果需要对文本消息中的链接消息处理可以设置该回调，点击事件的拦截回调。 包含表情的不会拦截回调。
//                .setFormCallBack(new IUdeskFormCallBack() {
//                    @Override
//                    public void toLuachForm(Context context) {
//                        Toast.makeText(getApplicationContext(), "不用udesk系统提供的留言功能", Toast.LENGTH_SHORT).show();
//                    }
//                })//离线留言表单的回调接口：  如果不用udesk系统提供的留言功能，可以设置该接口  回调使用自己的处理流程
                .setStructMessageCallBack(new IUdeskStructMessageCallBack() {

                    @Override
                    public void structMsgCallBack(Context context, String josnValue) {
                        Toast.makeText(context, "结构化消息控件点击事件回调", Toast.LENGTH_SHORT).show();
                    }
                })//设置结构化消息控件点击事件回调接口.
        ;
        return builder;
    }

    private Map<String, String> updateUserInfo(UdeskUserInfo udeskUserInfo) {
        Map<String, String> userInfo = new HashMap<>();
        if (!TextUtils.isEmpty(udeskUserInfo.getNick_name())) {
            userInfo.put(UdeskConst.UdeskUserInfo.NICK_NAME, udeskUserInfo.getNick_name());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getCellphone())) {
            userInfo.put(UdeskConst.UdeskUserInfo.CELLPHONE, udeskUserInfo.getCellphone());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getEmail())) {
            userInfo.put(UdeskConst.UdeskUserInfo.EMAIL, udeskUserInfo.getEmail());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getDescription())) {
            userInfo.put(UdeskConst.UdeskUserInfo.DESCRIPTION, udeskUserInfo.getDescription());
        }
        return userInfo;
    }

    private Map<String, String> getUserInfo(UdeskUserInfo udeskUserInfo) {
        Map<String, String> userInfo = new HashMap<>();
        if (!TextUtils.isEmpty(udeskUserInfo.getNick_name())) {
            userInfo.put(UdeskConst.UdeskUserInfo.NICK_NAME, udeskUserInfo.getNick_name());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getCellphone())) {
            userInfo.put(UdeskConst.UdeskUserInfo.CELLPHONE, udeskUserInfo.getCellphone());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getEmail())) {
            userInfo.put(UdeskConst.UdeskUserInfo.EMAIL, udeskUserInfo.getEmail());
        }
        if (!TextUtils.isEmpty(udeskUserInfo.getDescription())) {
            userInfo.put(UdeskConst.UdeskUserInfo.DESCRIPTION, udeskUserInfo.getDescription());
        }
        return userInfo;
    }
}
