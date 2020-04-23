# UI组件

## 实验一

![]()

#### 代码解释：

* drawable目录下：

![]()

* 放入键、值

> ```
> listitem.put("textview", names[i]);
> ```

* 

> ```
> android:listSelector="#600"
> ```

* 使用SimpleAdapter创建ListView：

![]()

* ListView点击事件的监听实现的代码参考：

![]()

* Toast显示提示信息框

![]()

#### 代码：

* main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <!-- 定义一个ListView
        android:divider="#000"设置分割线颜色
        android:dividerHeight="2dp"设置分割线宽度
        ListView条目单击显示颜色可以指定其listSelector属性
        android:listSelector="#600"
        -->

    <ListView
        android:id="@+id/mylist"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="#000"
        android:dividerHeight="2dp"
        android:listSelector="#600" />

</LinearLayout>
```

* simpleadapter.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <!-- 定义一个TextView -->
    <TextView
        android:id="@+id/text"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        android:padding="25dp"
        android:textSize="20sp"
        android:textColor="#000" />

    <!-- 定义一个ImageView -->
    <ImageView
        android:id="@+id/image"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:padding="10dp" />

</LinearLayout>
```

* Mainactivity.java

```
package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imagesIds = new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            //键值对
            listitem.put("textview", names[i]);
            listitem.put("imageview", imagesIds[i]);
            listitems.add(listitem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listitems, R.layout.simpleadapter, new String[]{"textview", "imageview"}, new int[]{R.id.text, R.id.image});
        ListView list = findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        // 为ListView的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 创建一个Toast提示信息
                Toast toast = Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT); // 设置该Toast提示信息的持续时间
                toast.show();
            }
        });
    }
}
```

#### 结果：

> 点击列表项Toast显示选中的列表项信息。

![]()



## 实验二

![]()

#### 代码解释：

* 

> android:onClick="customView"

* 

> android:inputType="text"

* 

> android:typeface="serif"

* 

> android:selectAllOnFocus="true"

* 

> android:inputType="textPassword"

* 创建AlertDialog的步骤：

![]()

#### 代码：

* main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <!-- 定义一个普通的按钮组件 -->
    <Button
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:onClick="customView"
        android:text="@string/view"
        android:layout_marginTop="20dp"
        android:layout_marginLeft="100dp"
        android:layout_marginBottom="50dp"/>

    <!-- 显示一个普通的文本编辑框组件 -->
    <TextView
        android:id="@+id/show"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="35dp"
        android:inputType="text" />

</LinearLayout>
```

* strings.xml

```
<resources>
    <string name="app_name">AlertDialog</string>
    <string name="android_app">ANDROID APP</string>
    <string name="password">Password</string>
    <string name="username">Username</string>
    <string name="view">自定义View对话框</string>
</resources>
```

* login.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:textSize="30sp"
        android:text="@string/android_app"
        android:gravity="center"
        android:typeface="serif"
        android:background="#FFFFBB33"
        />

    <EditText
        android:id="@+id/username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/username"
        android:selectAllOnFocus="true"
        android:layout_marginTop="20dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginBottom="5dp" />

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/password"
        android:inputType="textPassword"
        android:layout_marginTop="5dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginBottom="20dp" />

</LinearLayout>
```

* MainActivity.java

```
package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = findViewById(R.id.show);
    }
    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder)
    {
        // 调用setPositiveButton方法添加“Sign in”按钮
        return builder.setPositiveButton("Sign in", (dialog, which) -> show.setText("Sign in ！"));
    }
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
    {
        // 调用setNegativeButton方法添加“Cancel”按钮
        return builder.setNegativeButton("Cancel", (dialog, which) -> show.setText("Cancel ！"));
    }
    public void customView(View source)
    {
        // 加载\res\layout\login.xml界面布局文件
        LinearLayout loginForm = (LinearLayout) getLayoutInflater().inflate(R.layout.login, null);
        // 设置对话框显示的View对象
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(loginForm);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder).create().show();
    }
}
```

#### 结果：

![]()

> 点击按钮后显示

![]()

> 点击Sign in后文本框显示

![]()

> 点击Cancel后文本框显示

![]()



## 实验三

![]()

#### 代码解释：

* 用16进制整数进行id标识

![]()

* 当用户单击MENU键时触发onCreateOptionsMenu方法
* 选项菜单的菜单项被单击后的onOptionsItemSelected回调方法
* 视图加载器，将第一个XML变为View加载到第二个父视图中

> LinearLayout loginForm = (LinearLayout)getLayoutInflater().inflate(R.layout.login, null);

* OptionMenu

![]()

#### 代码：

* main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/txt"
        android:padding="15dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="用于测试的内容" />

</LinearLayout>
```

* MainActivity.xml

```
package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 定义“字体大小”菜单项的标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x112;
    private static final int FONT_20 = 0x113;
    // 定义“普通菜单项”的标识
    private static final int PLAIN_ITEM = 0x11b;
    // 定义“字体颜色”菜单项的标识
    private static final int FONT_RED = 0x114;
    private static final int FONT_BLACK = 0x115;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = findViewById(R.id.txt);
    }
    // 当用户单击MENU键时触发该方法
    @Override 
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加“字体大小”的子菜单-------------
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_20, 0, "20号字体");
        // -------------向menu中添加“普通菜单项”-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        // -------------向menu中添加“字体颜色”的子菜单-------------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLACK, 0, "黑色");
        return super.onCreateOptionsMenu(menu);
    }
    // 选项菜单的菜单项被单击后的回调方法
    @Override 
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case FONT_10: text.setTextSize(10 * 2);	break;
            case FONT_16: text.setTextSize(16 * 2); break;
            case FONT_20: text.setTextSize(20 * 2); break;
            case FONT_RED: text.setTextColor(Color.RED); break;
            case FONT_BLACK: text.setTextColor(Color.BLACK); break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,
                        "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
```

#### 结果：

![]()

> 点击菜单

![]()

> 点击字体大小

![]()

> 选择字体大小—>10号字体

![]()

> 选择字体大小—>16号字体

![]()

> 选择字体大小—>20号字体

![]()

> 点击字体颜色

![]()

> 选择字体颜色—>红色

![]()

> 选择字体颜色—>黑色

![]()

> 选择普通菜单项

![]()



## 实验四

![]()

#### 代码解释：

* drawable目录下：

![]()

* java.com.example.actionmode目录下：

![]()

* menu目录下：

![]()

* main_menu设置menu布局来规定长按后标题栏显示的内容，这里包括删除。
* Item类，也就是每个选项对应的类。其中bo属性就是用来记录该选项是否被选中，选中值就为true，当初始化是都会传入false，也就是默认不选择。

* 

> ```
> app:showAsAction="always"
> ```

* 

> ```
> android:divider="#808080"
> android:dividerHeight="2dp"
> ```

* 设置多选模式

> ```
> list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
> ```

* MenuInflater是用来解析定义在menu 目录下的菜单布局文件的，类似于LayoutInflater 是用来解析定义在layout 下的布局文件。在Activity类中有一个getMenuInflater()的函数用来返回这个Activity的MenuInflater，并通过MenuInflater对象来设置menu XML里的menu作为该Activity的菜单。

> ```
> MenuInflater inflater = mode.getMenuInflater();
> inflater.inflate(R.menu.main_menu, menu);
> ```

* 在使用simpleAdapter作为listView的适配器做分页和刷新的时候，当simpleAdapter的数据源数量减少或增加时调用notifyDataSetChanged（）方法可以刷新界面。

> ```
> simpleAdapter.notifyDataSetChanged();
> ```

* ContextMenu

![]()

#### 代码：

* main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <!-- 定义一个ListView
        android:divider="#000"设置分割线颜色
        android:dividerHeight="2dp"设置分割线宽度
        ListView条目单击显示颜色可以指定其listSelector属性
        android:listSelector="#600"
        -->
    <ListView
        android:id="@+id/myList"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="#808080"
        android:dividerHeight="2dp"
        android:listSelector="#600"/>
        <!--android:listSelector="@drawable/color" -->

</LinearLayout>
```

* app.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <!-- 定义一个ImageView -->
    <ImageView
        android:id="@+id/image"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:padding="10dp" />

    <!-- 定义一个TextView -->
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="30dp"
        android:textSize="25sp"
        android:textColor="#000" />

</LinearLayout>
```

* main_menu.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!--删除-->
    <item
        android:id="@+id/menu_delete"
        app:showAsAction="always"
        android:icon="@drawable/dustbin"
        android:title="item_delete" />

</menu>
```

* Item.java

```
package com.example.actionmode;

public class Item {
    private String name;//显示的选项名
    private boolean bo;//记录是否被选中

    //构造函数
    public Item(){
        super();
    }

    //带两个参数的构造函数
    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    //相应的set、get和toString方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}
```

* MainActivity.java

```
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
```

#### 结果：

![]()

> 长按列表项并进行选择

![]()



## 实验未涉及知识点：

![]()

![]()

![]()

![]()

![]()

![]()

* 普通菜单

![]()

* 弹出菜单

![]()





