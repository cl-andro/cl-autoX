-keep class com.clauto.annotation.KeepAllowObfuscation

-keep,allowobfuscation @com.clauto.annotation.KeepAllowObfuscation class * {*;}

-keepclasseswithmembers,allowobfuscation class * {
    @com.clauto.annotation.KeepAllowObfuscation <methods>;
}

-keepclasseswithmembers,allowobfuscation class * {
    @com.clauto.annotation.KeepAllowObfuscation <fields>;
}

-keepclasseswithmembers,allowobfuscation class * {
    @com.clauto.annotation.KeepAllowObfuscation <init>(...);
}