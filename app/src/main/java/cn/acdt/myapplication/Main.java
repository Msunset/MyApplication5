package cn.acdt.myapplication;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class Main extends Activity {
    /**
     * 3.屏幕适配工作实施
     * 创建Info接口
     * 增加游戏界面区域（rect）
     */

    //1.10创建画布GameController的对象
    private GameController gamecontroller;

    //3.1创建一个区域块Rect
    public static final Rect RECT_GAMESCREEN = new Rect();
    public static final Rect RECT_GAMESCREEN2 =new Rect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除任务栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //获取显示器
        Display display = getWindowManager().getDefaultDisplay();
        //获取宽度像素
        int niScreenWidth = display.getWidth();
        //获取高度像素
        int niScreenHeight = display.getHeight();

        //3.2 计算游戏界面位置区域
        RECT_GAMESCREEN.left = (niScreenWidth - Info.NI_GAMESCREEN_WIDTH)/2;
        RECT_GAMESCREEN2.top = (niScreenHeight - Info.NI_GAMESCREEN_HEIGHT)/2;

        //1.11创建Gamecontroller对象
        gamecontroller = new GameController(this);

        //1.12修改setController方法参数为gamecontroller
        setContentView(gamecontroller);
    }
    //2.1重写触屏操作OntouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gamecontroller.onTouch(event);
        return super.onTouchEvent(event);
    }
    //2.2重写按键操作Onkeydown
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        gamecontroller.onKeyDown();
        return super.onKeyDown(keyCode, event);
    }



}
