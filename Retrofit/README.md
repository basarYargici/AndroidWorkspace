# Retrofit Workspace  
  
Aim of this project is making network request with `Volley` and using `Glide`, `Recyclerview` and  `ViewBinding` 


**To work with Retrofit:**
- Go to manifest.xml
- - Add followings:
``` 
// To make network requests
<uses-permission android:name="android.permission.INTERNET" />
``` 
- Go to app-module level gradle file
- Add followings:
``` 
    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:4.9.0"

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'

    // Coroutine Lifecycle Scopes
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
``` 