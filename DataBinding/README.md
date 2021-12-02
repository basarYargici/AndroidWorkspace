# Data Binding Workspace  
  
Aim of this project is using and understanding how to work with `Data Binding`


**To work with Synthetic Binding:**

- Go to app-module level gradle file
- Add followings:
``` 
id 'kotlin-kapt'
``` 
``` 
android {
	   ... 
	   buildFeatures {
        dataBinding true    
       }
}
```