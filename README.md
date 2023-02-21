# Android Reverse Engineering From Scratch


## Intro to Android Architecture


Android is an open source, Linux-based sofwaer stack crated for a wide array of devices and form factors. The following diagrams shows the major components of the Android platform.

	Android es una pila de software de código abierto basado en Linux creada para una variedad amplia de dispositivos y factores de forma. En el siguiente diagrama, se muestran los componentes principales de la plataforma Android.

![](https://developer.android.com/static/guide/platform/images/android-stack_2x.png?hl=es-419)


##Security: App Sandboxing

The Android platform takes advantage of the Linux user-based protection to identify and isolate app resources.

![](https://www.researchgate.net/publication/307984756/figure/fig5/AS:668459469926415@1536384565370/Two-sandboxed-Android-apps-and-their-interaction-with-one-another-and-with-the-Android.png)


To do this, Android assigns a unique user ID (UID) to each Android application and runs it in its own process

![](https://www.android.com/static/2016/img/enterprise/security/vpnapp_1x.png)

##Security:Permissions

![](https://www.researchgate.net/profile/Mauro-Conti/publication/307984756/figure/fig5/AS:668459469926415@1536384565370/Two-sandboxed-Android-apps-and-their-interaction-with-one-another-and-with-the-Android.png)

##Android platform security model

2019 while paper by google

> The Android security model has previously not been formally pulished. This paper aims to both document the abstract model and discuss its implicaations.

[PDF - The Android Platform Security Model](https://arxiv.org/pdf/1904.05572.pdf)

##App stores: Google Play Protect

![](https://www.howtogeek.com/wp-content/uploads/2018/06/2018-06-11_12h46_33.png?trim=1,1&bg-color=000&pad=1,1)


##App stores: Sideloading

When you allow any application to be sideloaded on your phone, you are bypassing the recusiry protocols that are enabled in the play Store.

##Fragmentation

![](https://9to5google.com/wp-content/uploads/sites/4/2020/04/android-studio-cumulative-distribution.png)

#Lab Setup

###Bytecode Viewer

[Link](https://github.com/Konloch/bytecode-viewer)

###Apk Tool

[Link](https://ibotpeaches.github.io/Apktool/)

###JD GUI

[Link](http://java-decompiler.github.io/)

###Enjarify

[Link](https://github.com/google/enjarify)

###Objection

[Link](https://github.com/sensepost/objection/wiki/Installation)

###Androguard

[Link](https://androguard.readthedocs.io/en/latest/)

###Tamer

[Link](https://androguard.readthedocs.io/en/latest/)



##Analysing Android Apps

Static vs Dynamic Malware Analysis

* Static analysis relies on features extracted whithout executing ode
* Dinamyc analysis extracs features based on execution (or emulation)
* In general, static analysis is more efficient
* Dynamic analysis can be more informative, particulary on cases where the code is obfuscated
* Automated de analysis usually involves running the malware sample inside a malware sandbox, ehile running a number of scripts that perform a combination of static and dynamic analysis



