# Retrofit Workspace

Aim of this project is sharing elements between two fragments. Navigation Component and View Binding is used  
in this project.

**To work with Navigation Component and View Binding:**

- Go to app-module level gradle file
- Add followings:

```   
 buildFeatures {  
    viewBinding true
 }      
 // navigation component  
 def nav_version = "2.4.1" 
 implementation "androidx.navigation:navigation-fragment-ktx:$nav_version" 
 implementation "androidx.navigation:navigation-ui-ktx:$nav_version"  
```

<p align="center">
 <img src="https://github.com/basarYargici/AndroidWorkspace/blob/main/SharedElement/assets/SharedElement.gif" width="450" height="975">
</p>

