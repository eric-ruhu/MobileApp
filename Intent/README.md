# Intent

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%871.png?raw=true)

总体思路：第一个应用输入URL地址，然后调用我们自己创建的第二个应用Browser进行访问。

### 应用一

思路：输入一个网址，点击按钮，将发起浏览网页的行为。（应用一还没写我们自己的Browser所以运行是默认浏览器）

#### 代码

* activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal">

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/edit"
        android:textSize="20sp"
        android:hint="@string/edit_url"
        />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/btn"
        android:textSize="20sp"
        android:text="@string/btn_browse"
        />

</LinearLayout>
```

* string.xml

```
<resources>
    <string name="app_name">IntentDemo</string>
    <string name="edit_url">Please enter the URL you want to visit.</string>
    <string name="btn_browse">Visit the website</string>
</resources>
```

* MainActivity.java

```
package com.example.intentdemo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editUrl;
    Button btnBrowse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = (EditText)findViewById(R.id.edit);
        btnBrowse = (Button)findViewById(R.id.btn);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editUrl.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
```



#### **Tips**

1、按钮的单击事件代码解释：

创建一个Intent，将EditText中获取的文本转换成Uri，设置Intent的动作为Intent.ACTION_VIEW，然后利用该Intent启动Activity。这里Intent的Action设置为VIEW，而Intent的数据传递一个http协议的URI，因此系统会去寻找相关能够浏览网页的应用。

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%872.png?raw=true)



#### 应用一结果

> 当前还只是测试应用一所以目前还是默认的Chrome浏览器

* 输入一个网址，点击按钮开始浏览网页：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%873.png?raw=true)

* 当点击按钮之后，会弹出如下画面：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%874.png?raw=true)



### 应用二

思路：新建一个工程使用WebView来加载URL，跳转之后，出现选择项，选择自定义的Browser进行浏览网页。

#### 代码

* activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.browser.MainActivity">

    <WebView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/webView"
        >
    </WebView>

</LinearLayout>
```

* AndroidManifest.xml

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.browser">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:usesCleartextTraffic="true">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <data android:scheme="http" />
            </intent-filter>
        </activity>

    </application>
    <uses-permission android:name="android.permission.INTERNET" />
</manifest>
```

* MainActivity.java

```
package com.example.browser;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri data = intent.getData();
        URL url = null;

        try {
            url = new URL(data.getScheme(), data.getHost(),
                    data.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        startBrowser(url);
    }

    private void startBrowser(URL url) {
        WebView webView = (WebView) findViewById(R.id.webView);
        //WebView加载web资源
        webView.loadUrl(url.toString());
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
```



#### **Tips**

1、AndroidManifest.xml文件的这个部分会报错，但是其实不影响编译和运行。网上搜到的方法是添加这一句**<category android:name="android.intent.category.BROWSABLE“/>**代码，但是加入之后就一直显示不出自己定义的browser,所以这句就不能添加，那个虽然是红线但是不碍事所以不用管。

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%875.png?raw=true)

2、AndroidManifest.xml文件里在这个位置要加上这一句android:usesCleartextTraffic="true"代码（代码及位置如图所示）。要不然选中自己定义的browser网页无法显示（错误如图所示）。

错误：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%876.png?raw=true)

添加的代码：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%877.png?raw=true)

解释：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%878.png?raw=true)

3、AndroidManifest.xml文件里这个位置的值要和editview输入的URL的head相对应，不对应的话也会直接跳转默认浏览器。

* AndroidManifest.xml的这个位置的值

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%879.png?raw=true)

* editview的输入

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8710.png?raw=true)

4、由于Browser没有指定默认启动的Activity**（因为default activity 就是action.MAIN+category.LAUNCHER的组合，可以多写一个intent-filter解决这个问题也可以直接按下面的方法解决。）**，所以当直接运行时会提示找不到默认Activity的错误，修改方式为把Lauch改为Nothing，这样就可以运行了：

提示：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8711.png?raw=true)

修改：

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8712.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8713.png?raw=true)

5、AndroidManifest.xml文件里的intent-filter这个部分表明该Activity将能够响应action为VIEW，并且协议是http的Intent。

6、Browser的代码是重写WebView的setWebViewClient方法，这样可以避免当有浏览网页请求时直接跳转到系统默认浏览器。



#### 最终结果

> 运行顺序：应用二--->应用一，最终结果是运行完Browser工程再运行IntentDemo工程就会自动出现选择浏览器

* 输入一个网址并点击按钮

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8714.png?raw=true)

* 选择自己定义的浏览器（可以选择只是这一次还是总是为该浏览器）

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8715.png?raw=true)

* 跳转至该网页

![](https://github.com/eric-ruhu/MobileApp/blob/master/Intent/images/%E5%9B%BE%E7%89%8716.png?raw=true)

