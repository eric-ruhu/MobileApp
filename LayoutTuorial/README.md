# Android界面布局

## 实验一

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/1.png?raw=true)

#### 代码解释：

* 第1、3、4个LinearLayout的第1、3、4列被Android系统按照设置的layout_width值wrap_content给分配好宽度，第2列通过android:layout_weight="1"和android:layout_width="0dp"这两句代码来实现把剩下的屏幕空间分配给第2列的文本框。

* 第2个LinearLayout的每一列的文本框都通过android:layout_weight="1"和android:layout_width="0dp"这两句代码来分配空间，意思是每一个文本框占父布局的宽的1/4。

#### 代码：

* linearlayout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/one_one"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"
            />

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/one_two"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/one_three"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/one_four"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/two_one"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/two_two"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/two_three"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/two_four"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_margin="5dp"
            android:text="@string/three_one"
            android:textSize="15sp"
            android:gravity="center"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/three_two"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_margin="5dp"
            android:text="@string/three_three"
            android:gravity="center"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_margin="5dp"
            android:text="@string/three_four"
            android:gravity="center"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/four_one"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/four_two"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/four_three"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="@string/four_four"
            android:textSize="15sp"
            android:background="#000"
            android:textColor="#fff"/>
    </LinearLayout>
</LinearLayout>
```

* strings.xml

```
<resources>
    <string name="app_name">LayoutTuorial</string>
    <string name="one_one">One,One</string>
    <string name="one_two">One,Two</string>
    <string name="one_three">One,Three</string>
    <string name="one_four">One,Four</string>
    <string name="two_one">Two,One</string>
    <string name="two_two">Two,Two</string>
    <string name="two_three">Two,Three</string>
    <string name="two_four">Two,Four</string>
    <string name="three_one">Three,One</string>
    <string name="three_two">Three,Two</string>
    <string name="three_three">Three,Three</string>
    <string name="three_four">Three,Four</string>
    <string name="four_one">Four,One</string>
    <string name="four_two">Four,Two</string>
    <string name="four_three">Four,Three</string>
    <string name="four_four">Four,Four</string>
</resources>
```

#### 结果：

> 要将MainActivity.java的SetContentView中的activity_main改为linear_layout。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/2.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/3.png?raw=true)



## 实验二

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/4.png?raw=true)

#### 代码解释：

* **约束布局的每个组件一定要有id。**
* ConstraintLayout里直接使用Design是很方便的，也可以直接全部自己编写代码，这会比较复杂一点。但是单纯使用Design是很难达到我们想要的效果的，所以这里我采用Design＋手动修改代码的方式来完成实验。
* 创建完两个文本框后，点击如图，让系统先自动推断出约束。当然！这个肯定和我们想要的约束是有差别的，所以我们还要手动修改代码。这样做只是为了给元素一个约束而不报错。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/5.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/6.png?raw=true)

* 关于组件的top,bottom,start(left),end(right)如图所示：

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/7.png?raw=true)

* RED：RED的start和top与parent约束。
* ORANGE:ORANGE的start,top及end与parent约束。
* YELLOW:YELLOW的top和end与parent约束。
* GREEN:GREEN的top和bottom与parent约束。GREEN的right与BLUE的left约束。边距设置为30dp。
* BLUE:BLUE的start,top,end及bottom与parent约束。对于父布局是水平和垂直居中的。
* INDIGO:INDIGO的top和bottom与parent约束。INDIGO的left与BLUE的right约束。边距设置为30dp。
* VIOLET:VIOLET的start,bottom及end与parent约束。

#### 代码：

* constraint_layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/View1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ff0000"
        android:padding="20dp"
        android:text="@string/red"
        android:textColor="#000"
        android:textSize="20sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/View2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffa500"
        android:padding="20dp"
        android:text="@string/orange"
        android:textColor="#000"
        android:textSize="20sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/View3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffff00"
        android:padding="20dp"
        android:text="@string/yellow"
        android:textColor="#000"
        android:textSize="20sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/View4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#000"
        android:background="#008000"
        android:padding="20dp"
        android:textSize="20sp"
        android:text="@string/green"
        app:layout_constraintRight_toLeftOf="@+id/View5"
        android:layout_marginEnd="30dp"
        android:layout_marginRight="30dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        />

    <TextView
        android:id="@+id/View5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#000fff"
        android:padding="20dp"
        android:text="@string/blue"
        android:textColor="#fff"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintVertical_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/View6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:textColor="#fff"
        android:background="#800080"
        android:padding="20dp"
        android:text="@string/indigo"
        app:layout_constraintLeft_toRightOf="@+id/View5"
        android:layout_marginStart="30dp"
        android:layout_marginLeft="30dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/View7"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ff1493"
        android:gravity="center"
        android:padding="20dp"
        android:text="@string/violet"
        android:textColor="#000"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

* strings.xml

```
<resources>

    <string name="red">Red</string>
    <string name="orange">ORANGE</string>
    <string name="yellow">YELLOW</string>
    <string name="green">GREEN</string>
    <string name="blue">BLUE</string>
    <string name="indigo">INDIGO</string>
    <string name="violet">VIOLET</string>

</resources>
```

#### 结果：

> 要将MainActivity.java的SetContentView中的activity_main改为constraint_layout。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/8.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/9.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/10.png?raw=true)

> 注：因为这里有如图提示，所以多加了android:layout_marginLeft="30dp"和android:layout_marginRight="30dp"。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/11.png?raw=true)



## 实验三

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/12.png?raw=true)

#### 代码解释：

* 通过在TableLayout设置android:stretchColumns="1"来实现整个布局中第2列的拉伸。
* 根据TableRow来划分行。再将组件写在TableRow里。
* 一共有6行，有六个TableRow。

* 每一个组件通过android:layout_column设置该组件内容在该行的哪一列显示。

* 通过View来设置分割线。

#### 代码：

* table_layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="1">
    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/open"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>

        <TextView
            android:text="@string/ctrl_o"
            android:gravity="right"
            android:textSize="20sp"
            android:layout_column="2">
        </TextView>
    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/save"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>

        <TextView
            android:text="@string/ctrl_s"
            android:gravity="right"
            android:textSize="20sp"
            android:layout_column="2">
        </TextView>
    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/save_as"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>

        <TextView
            android:text="@string/ctrl_shift_s"
            android:gravity="right"
            android:textSize="20sp"
            android:layout_column="2">
        </TextView>
    </TableRow>

    <View
        android:layout_height="2dp"
        android:background="#FF909090">
    </View>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/x1"
            android:layout_column="0"
            android:textSize="15sp">
        </TextView>

        <TextView
            android:text="@string/import1"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>

    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/x2"
            android:layout_column="0"
            android:textSize="15sp">
        </TextView>

        <TextView
            android:text="@string/export"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>

        <TextView
            android:text="@string/ctrl_e"
            android:gravity="right"
            android:textSize="20sp"
            android:layout_column="2">
        </TextView>
    </TableRow>

    <View
        android:layout_height="2dp"
        android:background="#FF909090">
    </View>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:text="@string/quit"
            android:layout_column="1"
            android:textSize="20sp">
        </TextView>
    </TableRow>

</TableLayout>
```

* strings.xml

```
<resources>

    <string name="open">Open...</string>
    <string name="ctrl_o">Ctrl-O</string>
    <string name="save">Save...</string>
    <string name="ctrl_s">Ctrl-S</string>
    <string name="save_as">Save As...</string>
    <string name="ctrl_shift_s">Ctrl-Shift-S</string>
    <string name="x1">X</string>
    <string name="import1">Import...</string>
    <string name="x2">X</string>
    <string name="export">Export...</string>
    <string name="ctrl_e">Ctrl-E</string>
    <string name="quit">Quit</string>
    
</resources>
```

#### 结果：

> 要将MainActivity.java的SetContentView中的activity_main改为table_layout。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/13.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/14.png?raw=true)



## 部分代码功能简介：

实验一：

* android:layout_margin=“5dp”：本组件离上下左右间的距离。（用dp）
* android:gravity="center"：限定它里面的内容要居中显示。
* android:textSize="15sp"：设置组件里的字体的大小。（用sp)
* android:background="#000"：设置一个元素里的背景颜色。
* android:textColor="#fff"：设置一个元素里的字体颜色。
* android:orientation="vertical"：布局管理器内组件的排列方式为垂直布局。
* android:layout_weight="1" **+** android:layout_width="0dp"：填充剩余空间。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/15.png?raw=true)

实验二：

* app:layout_constraintStart_toStartOf="parent"：将组件开始面约束到（值）的开始面。
* app:layout_constraintTop_toTopOf="parent"：将组件顶部约束到（值）的顶部。
* app:layout_constraintEnd_toEndOf="parent"：将组件结束面约束到（值）的结束面。
* app:layout_constraintRight_toLeftOf="@+id/View5"：将组件结束面约束到（值）的开始面。
* app:layout_constraintBottom_toBottomOf="parent"：将组件底部约束到（值）的底部。
* app:layout_constraintLeft_toRightOf="@+id/View5"：将组件开始面约束到（值）的结束面。
* android:layout_marginEnd(Right)="30dp"：设置边距。
* android:layout_marginStart(Left)="30dp"：设置边距。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/16.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/17.png?raw=true)

* app:layout_constraintHorizontal_bias="0.5"：设置组件相对约束的水平偏移量（范围0~1），需同时设置了start和end属性。

* app:layout_constraintVertical_bias="0.5" ：设置组件相对约束的垂直偏移量（范围0~1），需同时设置了top和bottom属性。

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/18.png?raw=true)

> 注：layout_constraintHorizontal_bias 、layout_constraintHorizontal_bias 与margin结合使用能更精确的控制组件的位置。

实验三：

* android:stretchColumns="1"：要拉伸的列的从零开始的索引。（要拉伸哪一列，从0开始）

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/19.png?raw=true)

* android:layout_column="1"：该子项所在的列的索引。（组件在哪一列，从0开始）

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/20.png?raw=true)

* android:gravity="right"：限定它里面的内容要显示在右边。

* 分割线。

```
<View
    android:layout_height="2dp"
    android:background="#FF909090">
</View>
```

![](https://github.com/eric-ruhu/MobileApp/blob/master/LayoutTuorial/images/21.png?raw=true)

