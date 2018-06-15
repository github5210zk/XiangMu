package cn.bgs.mvptest3.model;


import cn.bgs.mvptest3.base.BaseModel;

/**
 * Created by ${周康} on ${Study}.
 */

public class DataModel {
    public static BaseModel request(String token) {
        //声明一个空的BaseModel
        BaseModel model = null;

        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel) Class.forName ( token ).newInstance ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        return model;
    }
}
