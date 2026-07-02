# Compatibility

![Maven Central](https://img.shields.io/maven-central/v/com.clauto.cl.compatibility/compatibility)

Helper class that helps you to check device information. For example, if the device runs MIUI.

## Download

```groovy
dependencies {
    implementation "com.clauto.cl.compatibility:compatibility:<version>"
}
```

### Dependencies included (If you have concerns about file size)

- `androidx.annotation:annotation`
- `com.clauto.cl.lazy:lazy`

## Usage

This library contains only one class `com.clauto.compatibility.DeviceCompatibility`.

```java
// Check if the device runs MIUI, other methods are as simple as this
boolean isMiui = DeviceCompatibility.isMiui();
```
