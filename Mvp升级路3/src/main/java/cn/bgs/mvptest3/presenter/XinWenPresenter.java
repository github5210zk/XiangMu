package cn.bgs.mvptest3.presenter;

import java.util.Map;

import cn.bgs.mvptest3.base.BaseCallBack;
import cn.bgs.mvptest3.base.BasePresenter;
import cn.bgs.mvptest3.model.DataModel;
import cn.bgs.mvptest3.model.Token;
import cn.bgs.mvptest3.view.XinWenView;

/**
 * Created by ${周康} on ${Study}.
 */

public class XinWenPresenter extends BasePresenter<XinWenView> {
    public XinWenPresenter() {
        //构造方法不再需要View参数
    }

    public void getData(String url, Map map) {
        final XinWenView view = getView ();
        view.showLoading ();
        DataModel.request ( Token.API_XINWEN_DATA )
                .requestPostAPI ( url, map, new BaseCallBack<String> () {
                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        if (isViewAttached ()) {
                            if (data != null)
                                view.showData ( data );
                        }
                    }

                    @Override
                    public void onFailuer(String msg) {
                        if (isViewAttached ()) {
                            view.showToast ( msg );
                        }
                    }

                    @Override
                    public void onError() {
                        if (isViewAttached ()) {
                            view.showErr ();
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached ()) {
                            view.hideLoading ();
                        }
                    }
                } );


    }
}
