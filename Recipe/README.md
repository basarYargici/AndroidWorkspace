# Recipe app

This app demonstrates `Multiple Fragments in an Activity`, `View Binding`, `LiveData`
,`Jetpack Navigation Component`, `Retrofit` for network requests, `GSON` for JSON parcing, `Dagger` for
Dependency Injection

**To work with those:**

- Go to app-module level gradle file
- Add followings:

```   
// For view binding  
-> (app level gradle)
android {  
 buildFeatures {     
	 viewBinding true    
   }  
}  
  
// For navigation component
-> (app level gradle)  
def nav_version = "x.x.x" 
implementation "androidx.navigation:navigation-fragment-ktx:$nav_version" 
implementation "androidx.navigation:navigation-ui-ktx:$nav_version"  
  
// For navigation args 
-> (root level gradle)  
classpath "androidx.navigation:navigation-safe-args-gradle-plugin:x.x.x" 
 
// Kotlin  
-> (app level gradle)
implementation("androidx.navigation:navigation-fragment-ktx:2.4.0")  
implementation("androidx.navigation:navigation-ui-ktx:2.4.0")  
  
// Jetpack Compose Integration  
-> (app level gradle)
implementation("androidx.navigation:navigation-compose:2.5.0-alpha01")  
  
// To annotate the class is parcelable  
-> (app level gradle)
plugins {  
	id 'kotlin-parcelize'
}  
  
// HTTP request library
-> (app level gradle)  
implementation 'com.squareup.retrofit2:retrofit:2.9.0'  
  
// JSON parser  
-> (app level gradle)
implementation 'com.google.code.gson:gson:2.8.9'  
  
// For livedata  
-> (app level gradle)
def lifecycle_version = "x.x.x"  
implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version" 
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version" 
implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"  

// For Hilt Dependency Injection 
-> (root level gradle)  
classpath "com.google.dagger:hilt-android-gradle-plugin:2.38.1"
-> (app level gradle)
plugins {
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
dependencies {
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
}
kapt {
 correctErrorTypes = true
}
```   

***Personal Note:***

- generally use DTO prefix for network model, entity prefix for database model namings

![project output](assets/img.png)