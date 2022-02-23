# Coroutine Workspace

Aim of this project is having hands on experience on usage of `Coroutines` and `Coroutines with Retrofit`.

**To work with Coroutines and Retrofit:**

- Go to app-module level gradle file
- Add followings:

``` 
// Coroutines  
def coroutines_version = "1.3.5"  
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"  
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"  
  
def arch_version = '2.4.0'  
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"  
implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"  
  
// Retrofit  
implementation "com.squareup.retrofit2:retrofit:2.9.0"  
implementation "com.squareup.retrofit2:converter-gson:2.9.0"
``` 