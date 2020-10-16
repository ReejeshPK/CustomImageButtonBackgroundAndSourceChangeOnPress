# **Custom ImageButton Background And Source Change OnPress**
If you need to change both the background and the Image source (srcCompat or src) at the same time during button press, this will help.

_Normal State vs Button Pressed State_

![Normal View](https://i.ibb.co/4phYBZz/Webp-net-resizeimage-1.png)
![Pressed State](https://i.ibb.co/TbFdX9s/Webp-net-resizeimage-2.png)

Steps to try:

1. Add the maven url to your Project Level Gradle File build.gradle(Project:).
```gradle
allprojects {
 repositories {
	...
	maven { url 'https://jitpack.io' }
 }
}
```

1.1. Add the implementation to your App Level Gradle File build.gradle(app:) :

```gradle 
implementation 'com.github.ReejeshPK:CustomImageButtonBackgroundAndSourceChangeOnPress:1.0'
```

2. Use the ImageButtonView

```xml
<com.blogspot.cavemanbacktocave.buttonpressbgsrc.MyImageButton
        android:layout_width="100dp"
        android:layout_height="100dp"        
        app:normalBackground="@drawable/my_background_normal_state"
        app:normalSrc="@drawable/ic_arrow_forward_normal"
        app:pressedBackground="@drawable/my_background_pressed_state"
        app:pressedSrc="@drawable/ic_arrow_forward_pressed" />
```

_Left Screen Shot (Normal State):_

`app:normalSrc` is the image source which is normally visible. In our screen shot, it is the right arrow > .

`app:normalBackground` is the background which is normally visible for that image button. In our screen shot, it is the round background 

_Right Screen Shot (Pressed State):_

`app:pressedBackground` is the Background which you want to show when the button is pressed. In our screen shot, it is the green background.

`app:pressedSrc` is the image or icon which you want to show when the button is pressed. 


