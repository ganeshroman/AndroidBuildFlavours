
# Android Build Flavours

While developing an Android application, we generally need various types of APKs or you can say different versions of APK during the development and release phase. For example, you may need one debug APK without having proguard or one debug APK with proguard or you may need one APK for your free users and one APK for your paid users or you may need one APK for Android version 6 and above and one APK for Android version below 6 and there are many other possibilities. But the question is, how you are going to create these many versions of your App. Are you going to have different projects for these versions or just one project is enough? Because the code is going to remain almost the same and just some APIs or some build configurations are going to change? So, how to achieve this? This can be achieved by using Build Variants i.e. the topic of this blog.



## Build Types and Build Variants
While building any Android application, ***we create various build types such as "debug" and "release"***. At the same time, ***we can create various product flavors for the same app***, for example, the free product flavor for free users and the paid product flavor for the paid users. So, Android Studio provides a feature of Build Variants which can be thought of as a cartesian product of all your build types and all your product flavors.

All you need to do is add various build types in your module-level build.gradle file and during development or production, you can simply choose the Build Variant you want to test or release.

***NOTE:*** By default, the Android Studio will generate "debug" and "release" Build Types for your project.


```


android {
    ...
    defaultConfig {...}
    buildTypes {
        debug{...}
        release{...}
    }
    
    flavorDimensions "version"
    productFlavors {
        uat {
            dimension "version"
            versionNameSuffix ".uat"
        }
        production {
            dimension "version"
            versionNameSuffix ".prod"
        }
    }
}

```

## Abi filters 



```

android {
    compileSdkVersion 30
    defaultConfig {
        applicationId "com.example.abichecking"
        minSdkVersion 15
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    flavorDimensions "version"
    productFlavors {
        fat {
            ndk {
                abiFilters "armeabi", "armeabi-v7a", "x86", "mips", "x86_64", "arm64-v8a"
            }
        }

        armeabi {
            ndk {
                abiFilter "armeabi"
            }
        }

        armeabi_v7a {
            ndk {
                abiFilter "armeabi-v7a"
            }
        }

        x86 {
            ndk {
                abiFilter "x86"
            }
        }

        mips {
            ndk {
                abiFilter "mips"
            }
        }

        x86_64 {
            ndk {
                abiFilter "x86_64"
            }
        }

        arm64_v8a {
            ndk {
                abiFilter "arm64-v8a"
            }
        }
    }
}


```















