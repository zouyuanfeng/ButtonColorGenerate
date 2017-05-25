### 使用教程

```
java -jar ButtonColorGenerate.jar #ff479af8  -p 10 -r 5 -n btn_blue
```
执行命令后在当前目录中自动生成按钮的selector文件：btn_blue.xml
```
<?xml version="1.0" encoding="UTF-8"?>

<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item  android:state_pressed="false">
        <shape>
            <solid android:color="#ff479af8"/>
            <stroke android:color="#ff4596f1" android:width="1dp"/>
            <corners android:radius="5dp"/>
            <padding android:bottom="10dp" android:left="10dp" android:right="10dp" android:top="10dp"/>
        </shape>
    </item >
    <item  android:state_pressed="true">
        <shape>
            <solid android:color="#ff3e86d9"/>
            <stroke android:color="#ff3c82d2" android:width="1dp"/>
            <corners android:radius="5dp"/>
            <padding android:bottom="10dp" android:left="10dp" android:right="10dp" android:top="10dp"/>
        </shape>
    </item >
    <item  android:state_enabled="false">
        <shape>
            <solid android:color="#a5479af8"/>
            <stroke android:color="#e7479af8" android:width="1dp"/>
            <corners android:radius="5dp"/>
            <padding android:bottom="10dp" android:left="10dp" android:right="10dp" android:top="10dp"/>
        </shape>
    </item >
</selector>


```
* 无参或者-h输出帮助
* 第一个参数为十六进制的颜色值（argb或者rgb）
* -r 参数为圆角半径值
* -p 参数为内边距的值
* -n 参数为生成的文件名称

### 参考
ColorUtils.java参考了Android-Bootstrap中的[ColorUtils.java](https://github.com/Bearded-Hen/Android-Bootstrap/blob/master/AndroidBootstrap/src/main/java/com/beardedhen/androidbootstrap/utils/ColorUtils.java)
