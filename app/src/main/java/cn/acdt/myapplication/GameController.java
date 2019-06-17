package cn.acdt.myapplication;
/**
 * 画布类
 */

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
//1.6创建Gamecontroller画布类.继承View
public class GameController extends View {
    //1.7添加构造方法
    public GameController(Context context) {
        super(context);
    }
    //1.8触屏操作
    public Boolean onTouch(MotionEvent event){
        return super.onTouchEvent(event);
    }
    //1.9测试按键操作
    public void onKeyDown(){

    }
}
