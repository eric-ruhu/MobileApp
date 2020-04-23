package com.example.actionmode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"One", "Two", "Three", "Four", "Five"};
    private int[] imagesIds = new int[]{R.drawable.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            //键值对
            listitem.put("imageview", imagesIds[0]);
            listitem.put("textview", names[i]);
            listitems.add(listitem);
        }
        //item的list对象
        final List<Item> list1= new ArrayList<Item>();
        //定义item并且加入list中
        for(int i = 0; i < names.length; i++){
            list1.add(new Item(names[i], false));
        }
         //创建一个SimpleAdapter
         final SimpleAdapter simpleAdapter = new SimpleAdapter(this, listitems, R.layout.app, new String[]{"textview","imageview" }, new int[]{R.id.text, R.id.image});
         final ListView list = findViewById(R.id.myList);
         // 为ListView设置Adapter
         list.setAdapter(simpleAdapter);
         list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
         list.setMultiChoiceModeListener(new MultiChoiceModeListener() {
         //选中数量
         int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                // 调整选定条目
                if (checked == true) {
                    list1.get(position).setBo(true);
                    //实时刷新
                    simpleAdapter.notifyDataSetChanged();
                    num++;
                } else {
                    list1.get(position).setBo(false);
                    //实时刷新
                    simpleAdapter.notifyDataSetChanged();
                    num--;
                }
                // 用TextView显示
                mode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        simpleAdapter.notifyDataSetChanged();
                        num = 0;
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                num = 0;
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.main_menu, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
    }
}
