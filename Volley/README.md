# Volley Workspace  
  
Aim of this project is making network request with `Volley` and using `Glide`, `Recyclerview` and  `ViewBinding` 


**To work with Volley and Glide:**
- Go to app-module level gradle file
- Add followings:
``` 
// To activate ViewBinding
buildFeatures {  
  viewBinding true  
}
``` 

``` 
// Volley for http requests  
implementation "com.android.volley:volley:1.2.1"  
// Glide for loading images  
implementation 'com.github.bumptech.glide:glide:4.12.0'  
annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
``` 