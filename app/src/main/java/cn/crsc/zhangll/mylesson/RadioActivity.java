package cn.crsc.zhangll.mylesson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.x;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by zhangll on 2018/5/28.
 */

public class RadioActivity extends Activity {
    private ListView mListView = findViewById(R.id.lv);
    final public String name = "张三";
    final public String tel = "1391234567";
    final public double salary = 8000.0;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_layout);
        //x.view().inject(this);

        //此处模拟后台数据存储的listview
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 15;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                View v = null;
                if (convertView == null) {
                    v = View.inflate(RadioActivity.this, R.layout.list_item_xml, null);
                } else {
                    v = convertView;
                }

                TextView tv_name = v.findViewById(R.id.txt_name);
                TextView tv_tel = v.findViewById(R.id.txt_tel);
                TextView tv_salary = v.findViewById(R.id.txt_salary);

                tv_name.setText(name + i);
                tv_tel.setText(tel + i);
                tv_salary.setText(salary + "");
                return v;
            }


        });
    }


}
