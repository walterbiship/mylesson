package cn.crsc.zhangll.mylesson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by zhangll on 2018/5/28.
 */

public class RadioActivity extends Activity {
    private ListView mListView = findViewById(R.id.lv);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_layout);
    }


}
