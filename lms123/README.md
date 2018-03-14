# Library-System
Library Book Checkout and Return System for Android. The library system database uses SQLite. Features include book reservation, book inventory lookup, transaction logging of book items, and a native login system for users to sign-in with on their Android devices.

Library system Main UI.
![screenshot_20161211-150421](https://user-images.githubusercontent.com/18353476/27512675-ee979acc-58fd-11e7-810c-8741189ee9ad.png)
A list of book's reservation transactions in the Library system inventory.
![screenshot_20161211-142042](https://user-images.githubusercontent.com/18353476/27513111-5d7d803a-590f-11e7-98c1-0670fd5336b2.png)
Adding a book to the current Library system inventory.
![screenshot_20161211-142439](https://user-images.githubusercontent.com/18353476/27513112-5d945210-590f-11e7-9631-d226a6be1d37.png)

# SQLite and Android Studio
![thumbnail225-1024x450](https://user-images.githubusercontent.com/18353476/28508972-9882d432-6ff3-11e7-966b-af08a68beb33.png)

SQLite is an Open Source database. SQLite supports standard relational database features like SQL syntax, transactions and prepared statements. The database requires limited memory at runtime (approx. 250 KB) which makes it a good choice for being embedded into other runtimes. 

SQLite is embedded into every Android device. Using an SQLite database in Android does not require a setup procedure or administration of the database. You only have to define the SQL statements for creating and updating the database. Afterwards the database is automatically managed for you by the Android platform. Accessing an SQLite database involves accessing the file system which can be slow. Therefore, for good performance it is recommended to perform database operations asynchronously.

If your application creates a database, this database is by default saved in the directory DATA/data/APP_NAME/databases/FILENAME. The parts of the above directory are constructed based on the following rules. DATA is the path which the Environment.getDataDirectory() method returns. APP_NAME is your application name. FILENAME is the name you specify in your application code for the database.

# Getting Started with Android NDK
The [Native Development Kit (NDK)](https://developer.android.com/ndk/guides/index.html) is a set of tools that allows you to use C and C++ code with Android, and provides platform libraries you can use to manage native activities and access physical device components, such as sensors and touch input. The NDK may not be appropriate for most novice Android programmers who need to use only Java code and framework APIs to develop their apps. However, the NDK can be useful for cases in which you need to do one or more of the following:

  Squeeze extra performance out of a device to achieve low latency or run computationally intensive applications, such as games or  physics simulations.

  Reuse your own or other developers' C or C++ libraries.

Using Android Studio 2.2 and higher, you can use the NDK to compile C and C++ code into a native library and package it into your APK using Gradle, the IDE's integrated build system. Your Java code can then call functions in your native library through the Java Native Interface (JNI) framework. To learn more about Gradle and the Android build system, read Configure Your Build.

# Setting up Android Studio
You can run this application using Android Studio's Android device emulator which is heavy on system resources especially the CPU. For best performance build and run the application on your own Android phone.
https://developer.android.com/studio/index.html

A good tutorial for Android Studio Setup(Windows, Mac, and Linux): https://www.tutorialspoint.com/android/android_studio.htm

![as](https://user-images.githubusercontent.com/18353476/28494127-6da78c40-6eda-11e7-8fa0-d77a5294b193.png)
![creat project](https://user-images.githubusercontent.com/18353476/28494097-63a0df68-6ed9-11e7-929e-3eba9a3f6700.png)
![instant-apps_2x](https://user-images.githubusercontent.com/18353476/28494126-680f3a4e-6eda-11e7-9235-0cd1b4bdf408.png)
![update-channel_2x](https://user-images.githubusercontent.com/18353476/28494098-68114d94-6ed9-11e7-87d2-3c0c30e866ac.png)

# Android Studio's Device Emulator
Creating & Configuring Android Device Emulator
![create virutal device](https://user-images.githubusercontent.com/18353476/28558055-f8d720b4-70c4-11e7-9b68-aadde703aedf.gif)
<p align="center">
  <img alt="[android emulator2" src="https://user-images.githubusercontent.com/18353476/28433670-58d94f64-6d41-11e7-908c-c6a48d7b75a1.gif">
</p>
