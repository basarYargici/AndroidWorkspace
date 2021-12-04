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
  
// JSON Parsing  
implementation 'com.google.code.gson:gson:2.8.7'  
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
``` 