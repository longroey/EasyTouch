LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under, java)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res

LOCAL_STATIC_JAVA_LIBRARIES += gson butterknife

LOCAL_STATIC_ANDROID_LIBRARIES := \
        android-support-annotations \
        android-support-core-ui \
        android-support-v4 \
        android-support-v7-appcompat \
        android-support-compat \
        android-support-v13 \
        android-support-transition \
        android-support-v7-gridlayout \
        android-support-v7-recyclerview \
        android-support-v7-cardview \
        android-support-design

LOCAL_USE_AAPT2 := true
LOCAL_PACKAGE_NAME := EasyTouch
LOCAL_PRIVATE_PLATFORM_APIS := true
LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_DEX_PREOPT := false
include $(BUILD_PACKAGE)


####################################################
include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := gson:libs/gson-2.2.4.jar \
                                        butterknife:libs/butterknife-7.0.1.jar

include $(BUILD_MULTI_PREBUILT)