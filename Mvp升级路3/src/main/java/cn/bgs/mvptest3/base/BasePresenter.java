package cn.bgs.mvptest3.base;

/**
 * Created by ${周康} on ${Study}.
 */

public class BasePresenter<V extends BaseView> {
    private V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public V getView() {
        return mvpView;
    }
}
