# 创建一个Android工程并同步GitHub

## 前期准备

1、[Android Studio](http://android-studio.org/)

2、[Git](https://git-scm.com/downloads)

## 创建Android工程

* 点击Create New Project，选择要创建的project。

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/1.png?raw=true)

* 修改project的名字，并将Language选择为Java。点击Finish完成创建。

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/2.png?raw=true)

* 配置Git路径

File-----Setting-----Version Control-----Git

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/3.png?raw=true)

* 登录GitHub账号

File-----Setting-----Version Control-----GitHub

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/4.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/5.png?raw=true)

## 同步工程到GitHub

> 注：安装完Git后，需要创建SSH Key和配置GitHub的用户名和邮箱。这里已经做过了就不过多说明了。可参考：https://blog.csdn.net/llfjfz/article/details/99747385

* 创建新代码仓库

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/6.png?raw=true)

* 创建本地代码仓库

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/7.png?raw=true)

* 将本地仓库和GitHub代码仓库相关联

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/8.png?raw=true)

* 初始化本地仓库并创建README.md文件

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/9.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/10.png?raw=true)

* 将文件夹的文件提交到本地仓库

> 这里出现一个警告，用git config core.autocrlf false命令解决

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/11.png?raw=true)

* 将本地仓库的内容推送到GitHub仓库

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/12.png?raw=true)

* 可以看到README.md文件被推到了GitHub上

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/13.png?raw=true)

* 将Android工程推到GitHub代码仓库

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/14.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/15.png?raw=true)

* 成功！！！！!

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/16.png?raw=true)

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/17.png?raw=true)

> 注：因为Android工程本身就有.gitignore文件（如下图所示），所以只要直接推就好了！会根据.gitignore文件自动忽略。

![](https://github.com/eric-ruhu/MobileApp/blob/master/TestApp/images/18.png?raw=true)