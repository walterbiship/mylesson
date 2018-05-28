package cn.crsc.zhangll.mylesson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangll on 2018/5/28.
 */

public class RadioActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout负责布局,activty负责代码实现(事件处理)
        setContentView(R.layout.radio_layout);

        listView = (ListView)this.findViewById(R.id.lv);
        // 在android 组件只有两种: 容器组件、组件   View是所有可视化组件的父类
        // 继承AdapterView子组件不能够直接使用addView方法
//        listView.addView(null);
        final List<Person> perList=new ArrayList<Person>();
        // 此处模拟后台数据存储到ListView中
        for(int i=1;i<=15;i++) {
            perList.add(new Person("姓名" + i, "1831234567" + i, 20000.00));
        }

        listView.setAdapter(new BaseAdapter() {
            @Override  // 返回当前集合的大小
            public int getCount() {
                return perList.size();
            }

            @Override  // 根据下标,获取某个Person对象
            public Object getItem(int position) {
                return perList.get(position);
            }

            @Override // 获取当前Item的主键(如果有可以实现此功能)
            public long getItemId(int position) {
                return 0;
            }

            @Override  // 返回View,此View就会添加到ListView
            public View getView(int position, View convertView, ViewGroup parent) {
                Person person = perList.get(position);
                Log.i("zp","position;" + position + ",convertView:" + convertView + ",parent:" + parent);
                // 1: 如果convertView不为null,则说明之前已创建过List_Item,直接拿来用即可
                View view = null;
                if(convertView==null){
                    // 2: 首先要获取List_Item布局文件
                    // findViewById(); 只能查找布局文件里面的组件,但是Item并不在其中
                    view = View.inflate(RadioActivity.this,R.layout.list_item_xml,null);
                }else{
                    // 使用之前创建过的List_Item
                    view = convertView;
                }
                // 3: 给List _Item添加数据
                TextView txt_name =  (TextView)view.findViewById(R.id.txt_name);
                TextView txt_tel =  (TextView)view.findViewById(R.id.txt_tel);
                TextView txt_salary =  (TextView)view.findViewById(R.id.txt_salary);
                txt_name.setText(person.name);
                txt_tel.setText(person.tel);
                txt_salary.setText(person.salary + "");
                // 4: 返回View组
                return view;
            }
        });

    }
}


